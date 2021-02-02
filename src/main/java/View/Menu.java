package View;

import Control.ControlFiltros;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    private int opcionMenuFiltrar;
    ControlFiltros controlFiltros;


    public void show() throws InterruptedException {

        controlFiltros = new ControlFiltros();
        controlFiltros.descargarDatos();
        int opcion = 0;

        System.out.println("Cargando los datos...");
        Thread.sleep(Long.parseLong("1000"));

        System.out.println("Datos Cargados.");
        System.out.println();

        System.out.println("Iniciando menu...");
        System.out.println();
        Thread.sleep(Long.parseLong("1000"));

        while (opcion != 3) {
            System.out.println("1.Visualizar todos los datos");
            System.out.println("2.Filtrar");
            System.out.println("3.Salir");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    visualizador();
                    break;

                case 2:
                    menuFiltrar();
                    break;

                case 3:
                    break;

                default:
                    System.out.println("Opciones validas 1,2 o 3");
                    opcion = sc.nextInt();
            }

        }
    }

    private void menuFiltrar() {
        System.out.println();
        System.out.println(" Menu Filtres");
        System.out.println("<------------>");
        System.out.println("1.Por Barrios");
        System.out.println("2.Por Distritos");
        System.out.println("3.Por Tipo de vehiculo");
        System.out.println("4.Por Antiguedad");
        System.out.println("5.Registros de barrios tienen e en el nombre");
        System.out.println("6.Vehiculos totales por barrios");
        System.out.println("7.Numero de vehiculos totales en BCN");
        System.out.println("8.Barrio con mas Turismos");
        System.out.println("9.Barrio con menos Turismos");
        System.out.println("0.Atras");
        System.out.println();
        System.out.println("seleccione una opcion: ");
        opcionMenuFiltrar = sc.nextInt();
        switch (opcionMenuFiltrar) {
            case 1:
                filtroBarrios();
                break;

            case 2:
                filtroDistritos();
                break;

            case 3:
                filtroTipoVehiculo();
                break;

            case 4:
                filtroAntiguedadV();
                break;

            case 5:
                filtroRegistrosE();
                break;

            case 6:
                filtroVehiculosBarrios();
                break;

            case 7:
                filtroVehiculosTotalesBcn();
                break;

            case 8:
                filtroBarrioMasTurismos();
                break;

            case 9:
                filtroBarrioMenosTurismos();
                break;

            case 0:
                break;

            default:
                System.out.println("Las opciones validas son: 1, 2, 3, 4, 5, 6, 7 u 8");
                System.out.println("Seleccione una opción: ");
                opcionMenuFiltrar = sc.nextInt();
        }
    }

    private void filtroBarrioMenosTurismos() {
        System.out.println(" Filtro Barrio con menos turismos");
        System.out.println("<------------------------------>");
        System.out.println(controlFiltros.filtroMenosTurismosBarrio());
        System.out.println();
    }

    private void filtroBarrioMasTurismos() {
        System.out.println(" Filtro Barrio con mas turismos");
        System.out.println("<------------------------------>");
        System.out.println(controlFiltros.filtroMasTurismosBarrio());
        System.out.println();
    }

    private void filtroVehiculosTotalesBcn() {
        System.out.println(" Filtro coches totales en Bcn");
        System.out.println("<---------------------------->");
        System.out.println("En barcelona hay: " + controlFiltros.vehiculosTotales() + " vehiculos.");
        System.out.println();

    }

    private void filtroVehiculosBarrios() {
        System.out.println(" Filtro coches totales Por barrios");
        System.out.println("<--------------------------------->");
        System.out.println("Introduzca el codigo del barrio:");
        int codigoBarrio = sc.nextInt();
        System.out.println(controlFiltros.vehiculosTotalesBarrios(codigoBarrio));
        System.out.println();


    }

    private void filtroRegistrosE() {
        System.out.println(" Filtro Registros de barrios que contienen e en el nombre");
        System.out.println("<-------------------------------------------------------->");
        System.out.println(controlFiltros.registrosE());
        System.out.println();

    }

    private void filtroAntiguedadV() {
        System.out.println(" Filtro por Antiguedad");
        System.out.println("<--------------------->");
        System.out.println("1.Menos de 1 año");
        System.out.println("2.1 año");
        System.out.println("3.2 año");
        System.out.println("4.3 año");
        System.out.println("5.4 año");
        System.out.println("6.5 año");
        System.out.println("7.6 año");
        System.out.println("8.7 año");
        System.out.println("9.8 año");
        System.out.println("10.9 año");
        System.out.println("11.10 año");
        System.out.println("12.De 11 a 20 años");
        System.out.println("13.Mas de 20 años");
        System.out.println("Seleccione la edad:");
        int opcionAntiguedad = sc.nextInt();
        System.out.println(controlFiltros.filtroAntiguedad(opcionAntiguedad));


    }

    private void filtroTipoVehiculo() {
        System.out.println(" Filtro por Tipo de vehiculo");
        System.out.println("<-------------------->");
        System.out.println("1.Turismos.");
        System.out.println("2.Motos.");
        System.out.println("3.Ciclomotores.");
        System.out.println("4.Furgonetas.");
        System.out.println("5.Camiones.");
        System.out.println("6.Otros.");
        System.out.println("7.Atras");
        System.out.println();
        System.out.println("Seleccione el tipo de vehiculo:");
        int tipoVehiculo = sc.nextInt();
        switch (tipoVehiculo) {
            case 1:
                filtroTurismo();
                break;

            case 2:
                filtroMoto();
                break;

            case 3:
                filtroCiclomotores();
                break;

            case 4:
                filtroFurgonetas();
                break;

            case 5:
                filtroCamiones();
                break;

            case 6:
                filtroOtros();
                break;

            case 7:
                break;
        }
    }

    private void filtroOtros() {
        System.out.println(" Filtro Otros");
        System.out.println("<--------------->");
        System.out.println();
        System.out.println(controlFiltros.totalOtros());
        System.out.println();
    }

    private void filtroCamiones() {
        System.out.println(" Filtro Camiones");
        System.out.println("<--------------->");
        System.out.println();
        System.out.println(controlFiltros.totalCamiones());
        System.out.println();
    }

    private void filtroFurgonetas() {
        System.out.println(" Filtro Furgonetas");
        System.out.println("<--------------->");
        System.out.println();
        System.out.println(controlFiltros.totalFurgonetas());
        System.out.println();
    }

    private void filtroCiclomotores() {
        System.out.println(" Filtro Ciclomotor");
        System.out.println("<--------------->");
        System.out.println();
        System.out.println(controlFiltros.totalCiclomotores());
        System.out.println();
    }

    private void filtroMoto() {
        System.out.println(" Filtro Moto");
        System.out.println("<--------------->");
        System.out.println();
        System.out.println(controlFiltros.totalMotos());
        System.out.println();
    }

    private void filtroTurismo() {
        System.out.println(" Filtro Turismos");
        System.out.println("<--------------->");
        System.out.println();
        System.out.println(controlFiltros.totalturismos());
        System.out.println();
    }

    private void filtroDistritos() {
        System.out.println(" Filtro por Distritos");
        System.out.println("<-------------------->");
        System.out.println("1.Filtrar por Id de distrito.");
        System.out.println("2.Filtrar por Nombre de distrito.");
        System.out.println("3.Atras");
        int opcionesFiltroDistritos = sc.nextInt();
        switch (opcionesFiltroDistritos) {
            case 1:
                System.out.println();
                System.out.println("Introduzca la id del distrito(1-10): ");
                int id_distrito = sc.nextInt();
                System.out.println();
                System.out.println(controlFiltros.filtroDistritosID(id_distrito));
                System.out.println();
                break;

            case 2:
                System.out.println();
                System.out.println("Introduzca el nombre del distrito(Ex: Gràcia, Les Corts): ");
                sc.nextLine();
                String nombre_distrito = sc.nextLine();
                System.out.println();
                System.out.println(controlFiltros.filtroDistritosNombre(nombre_distrito));
                System.out.println();
                break;
        }
    }

    private void filtroBarrios() {
        System.out.println(" Filtro por barrios");
        System.out.println("<------------------>");
        System.out.println("1.Filtrar por Id de barrio.");
        System.out.println("2.Filtrar por Nombre de barrio.");
        System.out.println("3.Atras");
        int opcionesFiltroDBarrioss = sc.nextInt();
        switch (opcionesFiltroDBarrioss) {
            case 1:
                System.out.println();
                System.out.println("Introduzca la id del barrio(1-10): ");
                int id_barrio = sc.nextInt();
                System.out.println();
                System.out.println(controlFiltros.filtroBarrioID(id_barrio));
                System.out.println();
                break;

            case 2:
                System.out.println();
                System.out.println("Introduzca el nombre del barrio(Ex: Pedralbes, la Sagrada Família): ");
                sc.nextLine();
                String nombre_barrio = sc.nextLine();
                System.out.println();
                System.out.println(controlFiltros.filtroBarrioNombre(nombre_barrio));
                System.out.println();
                break;
        }
    }
    private void visualizador(){
        System.out.println(controlFiltros.todasLasEntradas());
        System.out.println();
    }
}
