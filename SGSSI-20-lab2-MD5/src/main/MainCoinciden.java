package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import main.Main;

public class MainCoinciden {

	
	private static final String FICHERO_1 = "SGSSI-20.CB.04.txt";
	private static final String FICHERO_2 = "Copia_SGSSI-20.CB.04.txt";
	
	
	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		
		if(!compararFicheros()) {
			System.out.println("False // Los ficheros no coinciden o la secuencia HEX es incorrecta.");
			return;
		}
		
		if(Main.tarea1(MessageDigest.getInstance("SHA-256"), new File(FICHERO_2)).startsWith("0"))
			System.out.println("TRUE // EL fichero "+FICHERO_2+" cumple con los parametros establecidos.");
		else
			System.out.println("False // El resumen del fichero "+FICHERO_2+" no empieza por 0.");

		
		
	}
	
	/**
	 * Comprueba si los ficheros tienen el mismo contenido y si el segundo tiene los 8 caracteres hex.
	 * @return true si el fichero cumple con los requisitos.
	 * @throws IOException
	 */
	private static boolean compararFicheros() throws IOException {

		
		BufferedReader br1 = new BufferedReader(new FileReader(FICHERO_1));
		BufferedReader br2 = new BufferedReader(new FileReader(FICHERO_2));
		
		String line1 = br1.readLine();
		String line2 = br2.readLine();
		
		while((line1 != null) && (line2 != null)) {
			if(!line1.equals(line2))
				return false;
			line1=br1.readLine();
			line2=br2.readLine();
		}
		
		if(line1 == null) {
			if(!line2.matches("-?[0-9a-fA-F]+"))
				return false;
		}
		
		br1.close();
		br2.close();
		
		return true;
		
	}
	
	

}
