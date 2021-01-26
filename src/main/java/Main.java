import Model.Registre;
import View.Menu;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;

public class Main {

    public static void main(String[] args){

        Menu menu = new Menu();

        try {
            menu.show();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
