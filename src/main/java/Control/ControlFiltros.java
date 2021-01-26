package Control;

import Model.Registre;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;

public class ControlFiltros {
    static final String pathCSV="https://opendata-ajuntament.barcelona.cat/data/dataset/06d31e7a-a8f2-49e6-9f1a-855b5d28ebae/resource/bdf55393-0ced-4af6-907a-96c02ec649ca/download/2019_antiguitat_tipus_vehicle.csv";

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

        Iterator<Registre> csvIterator = activitatCsvToBean.iterator();

        while(csvIterator.hasNext()) {
            Registre registre = csvIterator.next();
            System.out.println(registre);
        }
    }



}
