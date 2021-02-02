package Control;

import Model.Registre;
import Model.RegistreVehicles;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class ControlFiltros {
    static final String pathCSV="https://opendata-ajuntament.barcelona.cat/data/dataset/06d31e7a-a8f2-49e6-9f1a-855b5d28ebae/resource/bdf55393-0ced-4af6-907a-96c02ec649ca/download/2019_antiguitat_tipus_vehicle.csv";
    private Iterator<Registre> csvIterator;
    List<Registre> listaRegistros = new ArrayList<>();
    List<Registre> listaBusquedas;

    public void descargarDatos(){
        URL url;
        BufferedReader br;
        CSVReader reader = null;
        try {
            url = new URL(pathCSV);
            br= new BufferedReader(new InputStreamReader(url.openStream()));
            reader = new CSVReader(br);

        } catch (IOException e) {
            e.printStackTrace();
        }

        CsvToBean<Registre> activitatCsvToBean = new CsvToBeanBuilder(reader)
                .withType(Registre.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        csvIterator = activitatCsvToBean.iterator();

        while(csvIterator.hasNext()) {
            Registre registre = csvIterator.next();
            listaRegistros.add(registre);
        }
    }

    public String todasLasEntradas(){
        Long entradas= listaRegistros.stream().count();
        listaRegistros.forEach(System.out::println);
        return "El fichero descargado contiene "+ entradas+ " registros.";
    }

    public Long  vehiculosTotales(){
        Long totalVehiculos= 0L;
        listaBusquedas= listaRegistros.stream().filter(registre -> registre.getNombre() !=0).collect(Collectors.toList());
       for (Registre registre:listaBusquedas){
           totalVehiculos += registre.getNombre();
       }

        return totalVehiculos;
    }

    public String vehiculosTotalesBarrios(int codigoBarrio){
        Long totalVehiculos= 0L;
        String codigo_barrio = String.valueOf(codigoBarrio);
        listaBusquedas = listaRegistros.stream().filter(registre -> registre.getCodi_Barri().equals(codigo_barrio)).collect(Collectors.toList());
        String nombreBarrio = listaBusquedas.get(0).getNom_Barri();
        for (Registre registre: listaBusquedas){
            totalVehiculos += registre.getNombre();
        }
        return "El barrio: "+ nombreBarrio+" Tiene "+totalVehiculos+" vehiculos.";
    }

    public String  registrosE() {
        listaBusquedas = listaRegistros.stream().filter(registre -> registre.getNom_Barri().toUpperCase().contains("E")).collect(Collectors.toList());
        listaBusquedas.forEach(System.out::println);


        return "";
    }

    public String  totalturismos() {
        Long totalVehiculos= 0L;
        List<Registre> list = listaRegistros.stream().filter(registre ->  registre.getTipus_Vehicles().equals("Turismes")).collect(Collectors.toList());
        for (Registre registre: list){
            totalVehiculos += registre.getNombre();
        }
        return "En Barcelona hay: "+totalVehiculos+" Turismos.";
    }


    public String totalMotos() {
        Long totalVehiculos= 0L;
        listaBusquedas = listaRegistros.stream().filter(registre ->  registre.getTipus_Vehicles().equals("Motos")).collect(Collectors.toList());
        for (Registre registre: listaBusquedas){
            totalVehiculos += registre.getNombre();
        }
        return "En Barcelona hay: "+totalVehiculos+" Motos.";
    }

    public String totalCiclomotores() {
        Long totalVehiculos= 0L;
        listaBusquedas = listaRegistros.stream().filter(registre ->  registre.getTipus_Vehicles().equals("Ciclomotors")).collect(Collectors.toList());
        for (Registre registre: listaBusquedas){
            totalVehiculos += registre.getNombre();
        }
        return "En Barcelona hay: "+totalVehiculos+" Ciclomotors.";
    }

    public String totalFurgonetas() {
        Long totalVehiculos= 0L;
        listaBusquedas = listaRegistros.stream().filter(registre ->  registre.getTipus_Vehicles().equals("Furgonetes")).collect(Collectors.toList());
        for (Registre registre: listaBusquedas){
            totalVehiculos += registre.getNombre();
        }
        return "En Barcelona hay: "+totalVehiculos+" Furgonetes.";
    }

    public String totalCamiones() {
        Long totalVehiculos= 0L;
        listaBusquedas = listaRegistros.stream().filter(registre ->  registre.getTipus_Vehicles().equals("Camions")).collect(Collectors.toList());
        for (Registre registre: listaBusquedas){
           totalVehiculos += registre.getNombre();
        }
        return "En Barcelona hay: "+totalVehiculos+" Camions.";
    }

    public String totalOtros() {
        Long totalVehiculos= 0L;
        listaBusquedas = listaRegistros.stream().filter(registre ->  registre.getTipus_Vehicles().equals("Altres vehicles")).collect(Collectors.toList());
        for (Registre registre: listaBusquedas){
            totalVehiculos += registre.getNombre();
        }
        return "En Barcelona hay: "+totalVehiculos+" Altres vehicles.";
    }


    public String filtroAntiguedad(int antiguedad) {
        Long totalVehiculos= 0L;
        List<Registre> list;

        switch (antiguedad){

            case 1:

                list = listaRegistros.stream().filter(registre ->  registre.getAntiguitat().equals("Menys d'un any d'antiguitat")).collect(Collectors.toList());
                for (Registre registre: list){
                    totalVehiculos += registre.getNombre();
                }
                return "En Barcelona hi ha: "+totalVehiculos+" Amb Menys d'un any d'antiguitat.";

            case 2:
                list= listaRegistros.stream().filter(registre ->  registre.getAntiguitat().equals("1 any")).collect(Collectors.toList());
                for (Registre registre: list){
                    totalVehiculos += registre.getNombre();
                }
                return "En Barcelona hi ha: "+totalVehiculos+" Amb 1 any d'antiguitat.";

            case 3:
                list= listaRegistros.stream().filter(registre ->  registre.getAntiguitat().equals("2 anys")).collect(Collectors.toList());
                for (Registre registre: list){
                    totalVehiculos += registre.getNombre();
                }
                return "En Barcelona hi ha: "+totalVehiculos+" Amb 2 anys d'antiguitat.";

            case 4:
                list= listaRegistros.stream().filter(registre ->  registre.getAntiguitat().equals("3 anys")).collect(Collectors.toList());
                for (Registre registre: list){
                    totalVehiculos += registre.getNombre();
                }
                return "En Barcelona hi ha: "+totalVehiculos+" Amb 3 anys d'antiguitat.";

            case 5:
                list= listaRegistros.stream().filter(registre ->  registre.getAntiguitat().equals("4 anys")).collect(Collectors.toList());
                for (Registre registre: list){
                    totalVehiculos += registre.getNombre();
                }
                return "En Barcelona hi ha: "+totalVehiculos+" Amb 4 anys d'antiguitat.";

            case 6:
                list= listaRegistros.stream().filter(registre ->  registre.getAntiguitat().equals("5 anys")).collect(Collectors.toList());
                for (Registre registre: list){
                    totalVehiculos += registre.getNombre();
                }
                return "En Barcelona hi ha: "+totalVehiculos+" Amb 5 anys d'antiguitat.";

            case 7:
                list= listaRegistros.stream().filter(registre ->  registre.getAntiguitat().equals("6 anys")).collect(Collectors.toList());
                for (Registre registre: list){
                    totalVehiculos += registre.getNombre();
                }
                return "En Barcelona hi ha: "+totalVehiculos+" Amb 6 anys d'antiguitat.";

            case 8:
                list= listaRegistros.stream().filter(registre ->  registre.getAntiguitat().equals("7 anys")).collect(Collectors.toList());
                for (Registre registre: list){
                    totalVehiculos += registre.getNombre();
                }
                return "En Barcelona hi ha: "+totalVehiculos+" Amb 7 anys d'antiguitat.";

            case 9:
                list= listaRegistros.stream().filter(registre ->  registre.getAntiguitat().equals("8 anys")).collect(Collectors.toList());
                for (Registre registre: list){
                    totalVehiculos += registre.getNombre();
                }
                return "En Barcelona hi ha: "+totalVehiculos+" Amb 8 anys d'antiguitat.";

            case 10:
                list= listaRegistros.stream().filter(registre ->  registre.getAntiguitat().equals("9 anys")).collect(Collectors.toList());
                for (Registre registre: list){
                    totalVehiculos += registre.getNombre();
                }
                return "En Barcelona hi ha: "+totalVehiculos+" Amb 9 anys d'antiguitat.";

            case 11:
                list= listaRegistros.stream().filter(registre ->  registre.getAntiguitat().equals("10 anys")).collect(Collectors.toList());
                for (Registre registre: list){
                    totalVehiculos += registre.getNombre();
                }
                return "En Barcelona hi ha: "+totalVehiculos+" Amb 10 anys d'antiguitat.";

            case 12:
                list= listaRegistros.stream().filter(registre ->  registre.getAntiguitat().equals("D'11 a 20 anys")).collect(Collectors.toList());
                for (Registre registre: list){
                    totalVehiculos += registre.getNombre();                }
                return "En Barcelona hi ha: "+totalVehiculos+" d'11 a 20 anys d'antiguitat.";

            case 13:
                list= listaRegistros.stream().filter(registre ->  registre.getAntiguitat().equals("Més de 20 anys")).collect(Collectors.toList());
                for (Registre registre: list){
                    totalVehiculos += registre.getNombre();                }
                return "En Barcelona hi ha: "+totalVehiculos+" amb més de 20 anys d'antiguitat.";
            default:
                return "error";
        }

    }

    public String filtroDistritosID(int id_distrito) {

        String codigo_Distrito = String.valueOf(id_distrito);
        listaBusquedas = listaRegistros.stream().filter(registre -> registre.getCodi_Districte().equals(codigo_Distrito))
                .sorted(Comparator.comparing(Registre::getNombre))
                .collect(Collectors.toList());
        String nombreDistrito = listaBusquedas.get(0).getNom_Districte();
        for (Registre registre: listaBusquedas){
            System.out.println(registre.toString());
        }
        return "Distrito: "+nombreDistrito;
    }

    public String filtroDistritosNombre(String nombre_distrito) {
        listaBusquedas = listaRegistros.stream().filter(registre -> registre.getNom_Districte().equals(nombre_distrito))
                .sorted(Comparator.comparing(Registre::getNombre))
                .collect(Collectors.toList());
        for (Registre registre: listaBusquedas){
            System.out.println(registre.toString());
        }
        return "";
    }

    public String filtroBarrioID(int id_barrio) {
        String codigo_barrio = String.valueOf(id_barrio);
        listaBusquedas = listaRegistros.stream().filter(registre -> registre.getCodi_Barri().equals(codigo_barrio))
                .sorted(Comparator.comparing(Registre::getNombre))
                .collect(Collectors.toList());
        String nombreBarrio = listaBusquedas.get(0).getNom_Barri();
        for (Registre registre: listaBusquedas){
            System.out.println(registre.toString());
        }
        return "Distrito: "+nombreBarrio;
    }

    public String filtroBarrioNombre(String nombre_barrio) {
        listaBusquedas = listaRegistros.stream().filter(registre -> registre.getNom_Barri().equals(nombre_barrio))
                .sorted(Comparator.comparing(Registre::getNombre))
                .collect(Collectors.toList());
        for (Registre registre: listaBusquedas){
            System.out.println(registre.toString());
        }
        return "";
    }

    public String filtroMasTurismosBarrio() {
        Optional<Registre> barrioConMasTurismos = listaRegistros.stream().filter(registre -> registre.getTipus_Vehicles().equals("Turismes")).max(Comparator.comparing(Registre::getNombre));

        return barrioConMasTurismos.toString();
    }

    public String filtroMenosTurismosBarrio() {
        Optional<Registre> barrioConMenosTurismos = listaRegistros.stream().filter(registre -> registre.getTipus_Vehicles().equals("Turismes")).min(Comparator.comparing(Registre::getNombre));
        return barrioConMenosTurismos.toString();
    }
}
