package tpe;

public class Main {

	public static void main(String[] args) {
		

		Servicios s = new Servicios("/home/agus/Escritorio/Camiones.csv","/home/agus/Escritorio/Paquetes.csv");
		
		System.out.println(s.servicio1("P001"));
	}

}
