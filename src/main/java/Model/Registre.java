package Model;


import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class Registre {

    @CsvBindByName
    String promotor_gestor;

    @CsvBindByName
    String ACCES;

    @CsvBindByName
    String tipus_velocitat;

    @CsvBindByName
    String CONNEXIO;

    @CsvBindByName
    float LATITUD;

    @CsvBindByName
    float LONGITUD;

    @CsvBindByName
    int POTENCIA;

    @CsvBindByName
    String TIPUS_DE_CORRENT;
}
