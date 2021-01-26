package View;

import Control.ControlFiltros;

import java.util.Scanner;

public class Menu {

    public void show() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        ControlFiltros controlFiltros = new ControlFiltros();
        controlFiltros.descargarDatos();

        int opcion=0;

        while (opcion != 3){
            System.out.println("Cargando los datos...");
            Thread.sleep(Long.parseLong("1500"));

            System.out.println("Datos Cargados.");
            System.out.println();

            System.out.println("Iniciando menu...");
            System.out.println();
            Thread.sleep(Long.parseLong("1500"));

            System.out.println("1.Visualizar todos los datos");
            System.out.println("2.Filtrar");
            System.out.println("3.Salir");

            opcion = sc.nextInt();

            switch(opcion){
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
        System.out.println("Menu Filtres");

    }

    private void visualizador() {

    }

}
