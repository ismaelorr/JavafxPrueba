package firstExample;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ej9_binary {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		DataInputStream dataIn = new DataInputStream(
				new FileInputStream("C:\\Users\\ismaelor\\Desktop\\DAM\\ACDA Pruebas\\Departamentos_binary.dat"));
		System.out.println("Introduce el nombre del empleado");
		String name = sc.next();
		boolean condition = false;
		try {
			while(true) {
				int dept = dataIn.readInt();
				String employee = dataIn.readUTF();
				String location = dataIn.readUTF();
				if(name.equalsIgnoreCase(employee)) {
					System.out.println("Datos del empleado: "+dept+"\t"+employee+"\t"+location);
					condition=true;
				}
			}
		}catch(Exception e) {

		}
		dataIn.close();
		if(!condition) {
			System.out.println("El empleado no existe");
		}
	}

}
