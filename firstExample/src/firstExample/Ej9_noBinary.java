package firstExample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ej9_noBinary {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el nombre del empleado");
		String name = sc.next();
		boolean condition = false;
		BufferedReader bufIn = new BufferedReader(
				new FileReader("C:\\Users\\ismaelor\\Desktop\\DAM\\ACDA Pruebas\\Departamentos_nobinary.txt"));
		try {
			while(true) {
				String line = bufIn.readLine();
				if(line.toLowerCase().contains(name.toLowerCase())) {
					System.out.println("Datos del empleado: "+name+" "+line);
					condition = true;
				}
			}
		}catch(Exception e) {
			
		}
		bufIn.close();
		if(!condition) {
			System.out.println("El empleado "+name+" no existe");
		}
	}

}
