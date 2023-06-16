import java.io.*;
import java.util.Scanner;

public class Ficheros {
	public static void main(String[] args) throws IOException {
		final String RUTA_FICHERO = "prueba.txt";
		
		FileWriter fw = new FileWriter(RUTA_FICHERO);
		PrintWriter pw = new PrintWriter(fw);
		
		pw.println("Hola desde el fichero");
		pw.println("Qué tal");
		
		System.out.println("Se ha escrito el fichero");
		
		pw.close();
		
		FileReader fr = new FileReader(RUTA_FICHERO);
		Scanner sc = new Scanner(fr);
		
		String linea;
		
		while(sc.hasNextLine()) {
			linea = sc.nextLine();
			
			System.out.println(linea);
		}
		
		sc.close();
	}
}
