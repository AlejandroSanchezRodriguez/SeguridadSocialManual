package Models;

import java.util.ArrayList;

public class Model_es {
    ArrayList<String>listVSpanish;
    public Model_es(){
        listVSpanish= new ArrayList<>();
        listVSpanish.add("Cambiar idioma");
        listVSpanish.add("1. Login");
        listVSpanish.add("2. Menu de Opciones");
        listVSpanish.add("3. Subir Ficheros");
        listVSpanish.add("4. Renombrar Ficheros");
        listVSpanish.add("5. Borrar Fichero o Directorio");
        listVSpanish.add("6. Crear Directorio");
        listVSpanish.add("7. Enviar E-mail");
        listVSpanish.add("8. Recibir E-mail");
        listVSpanish.add("9. Acerca de");
    }

    public ArrayList<String> getListVSpanish() {
        return listVSpanish;
    }
}
