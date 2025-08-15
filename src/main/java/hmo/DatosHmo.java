package hmo;

import java.io.*;
import java.util.*;

public class DatosHmo {
    public static void main(String[] args) {
        String file = "src/main/java/hmo/codigos_postales_hmo.csv";
        // aqui estamos dando la direccion del archivo csv dentro del project
        Map<String, Integer> conteoCodigos = new HashMap<>();
        //mediante el map con string e integer estamos diciendo con el string el campo de los codigos postales
        //y con el integer estoy dando los valores numericos, ósea la cantidad de asentamientos con el codigo postal

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        // aqui estoy leyendo el archivo que ya di antes en el string y mediante un try y catch
        // en caso de un error uso el printStackTrace para decirme en que fue durante la lectura del archivo
            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                //durante el while se estara leyendo cada linea de datos del archivo hasta acabar
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                // con el arreglo de Strings estoy y los row creo la columna del codigo postal para que solo
                // agarre los codigos postales
                String[] row = line.split(",");
                // el conteo va sumando 1 cada que el codigo se repite una vez termina devuelde a 0 y comienza con
                // otro codigo
                if (row.length > 0) {
                    String codigoPostal = row[0].trim();
                    conteoCodigos.put(codigoPostal,conteoCodigos.getOrDefault(codigoPostal, 0) + 1);
                }
            }
            // con el arraylist estoy ordenando los codigos postales
            List<String> codigosOrdenados = new ArrayList<>(conteoCodigos.keySet());
            Collections.sort(codigosOrdenados);

            // estamos imprimiendo los resultados con el codigo y cantidad de asentamienos
            System.out.println("\nResultados:");
            for (String codigo : codigosOrdenados) {
                System.out.printf("Código postal: %-7s - Número de asentamientos: %d%n",
                        codigo, conteoCodigos.get(codigo));
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo:");
            e.printStackTrace();
            // en caso de algun error durante la lectura del archivo imprimira Error al leer el archivo:
        }
    }
}