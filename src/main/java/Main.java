import Model.Registre;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;

public class Main {

    static final String pathCSV="https://analisi.transparenciacatalunya.cat/api/views/tb2m-m33b/rows.csv?accessType=DOWNLOAD&sorting=true";

    public static void main(String[] args){

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
