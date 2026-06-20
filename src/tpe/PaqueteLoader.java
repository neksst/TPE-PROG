package tpe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class PaqueteLoader {


	
	
	public static LinkedList<Paquete> loadPaquete(String path) {
		    String linea;

		    LinkedList<Paquete>  paquetes = new LinkedList<>();
	    try (BufferedReader br = new BufferedReader(new FileReader(path))) {

	        while ((linea = br.readLine()) != null) {
	        	 String[] datos = linea.split(";");

	             Integer id = Integer.parseInt(datos[0]);
	             String codigo = datos[1];
	             Integer peso = Integer.parseInt(datos[2]);
	             boolean contieneAlimentos = datos[3].equals("1");
	             Integer nivelUrgencia = Integer.parseInt(datos[4]);

	             paquetes.add(new Paquete(id,codigo,peso,contieneAlimentos,nivelUrgencia));
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return paquetes;
	}
	
}
