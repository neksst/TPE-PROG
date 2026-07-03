package tpe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;


public class CamionLoader {

	public static LinkedList<Camion> loadCamiones(String path) {
	    String linea;

	    LinkedList<Camion>  camiones = new LinkedList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
        br.readLine(); // saltar la primera linea con el total de camiones
        while ((linea = br.readLine()) != null) {
        	 String[] datos = linea.split(";");

             Integer id = Integer.parseInt(datos[0]);
             String patente = datos[1];
             boolean refrigerado = datos[2].equals("1");
             Integer capacidad = Integer.parseInt(datos[3]);

             camiones.add(new Camion(id,patente,refrigerado,capacidad));
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
    return camiones;
}
}
