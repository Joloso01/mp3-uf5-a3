package Model;


import com.opencsv.bean.CsvBindByName;
import lombok.Data;

import java.io.Serial;

@Data
public class Registre {

    @CsvBindByName
    String Any;

    @CsvBindByName
    String Codi_Districte;

    @CsvBindByName
    String Nom_Districte;

    @CsvBindByName
    String Codi_Barri;

    @CsvBindByName
    String Nom_Barri;

    @CsvBindByName
    String Tipus_Vehicles;

    @CsvBindByName
    String Antiguitat;

    @CsvBindByName
    String  Nombre;
}
