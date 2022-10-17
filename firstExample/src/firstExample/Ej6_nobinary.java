package firstExample;

import java.io.*;
import java.util.Scanner;

public class Ej6_nobinary {

	public static void main(String[] args) throws IOException {
		
			Scanner sc = new Scanner(System.in);
			System.out.println("Departamento que quieres modificar");
			Integer dept = sc.nextInt();
			BufferedReader ficIn = new BufferedReader(new FileReader("C:\\Users\\ismaelor\\Desktop\\DAM\\ACDA Pruebas\\Departamentos_nobinary.txt"));
			String modificacion ="";
			boolean condition = false;
			try {
				while(true) {
				String line = ficIn.readLine();
				if(line.contains(dept.toString())) {
					System.out.println("lo contengo");
					System.out.println("Introduce el nuevo departamento");
					int nuevoDept = nuevoDept = sc.nextInt();
					System.out.println("Introduce el nuevo nombre");
					String nuevoNombre = nuevoNombre = sc.next();
					System.out.println("Introduce la nueva localidad");
					String nuevaLocalidad = nuevaLocalidad = sc.next();
					condition = true;
					modificacion+=nuevoDept+"\t"+nuevoNombre+"\t"+nuevaLocalidad+"\n";
				}
				else {
					modificacion+=line +" \n";
				}
				}
			}catch(Exception e) {
				ficIn.close();
			}
			if(condition) {
				BufferedWriter ficOut = new BufferedWriter(new FileWriter("C:\\Users\\ismaelor\\Desktop\\DAM\\ACDA Pruebas\\Departamentos_nobinary.txt"));
				ficOut.write(modificacion);
				System.out.println("Departamento modificado");
				ficOut.close();
			}
			else {
				System.out.println("El departamento introducido no existe");
			}
		
	}

}
