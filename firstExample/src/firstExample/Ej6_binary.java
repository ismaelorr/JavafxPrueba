package firstExample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ej6_binary {

	public static void main(String[] args) throws IOException {
		DataInputStream dataIn = new DataInputStream(
				new FileInputStream("C:\\Users\\ismaelor\\Desktop\\DAM\\ACDA Pruebas\\Departamentos_binary.dat"));
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe el departamento a modificar");
		String modificacion = "";
		ArrayList <Integer> depts = new ArrayList<>();
		ArrayList <String> names = new ArrayList<>();
		ArrayList <String> locations = new ArrayList<>();
		boolean condition = false;
		int dept = sc.nextInt();
		try {
			while (true) {
				int dept_no = dataIn.readInt();
				String name = dataIn.readUTF();
				String location = dataIn.readUTF();
				if (dept_no == dept) {
					System.out.println("Introduce el nuevo departamento");
					int nuevoDept = nuevoDept = sc.nextInt();
					System.out.println("Introduce el nuevo nombre");
					String nuevoNombre = nuevoNombre = sc.next();
					System.out.println("Introduce la nueva localidad");
					String nuevaLocalidad = nuevaLocalidad = sc.next();
					depts.add(nuevoDept);
					names.add(nuevoNombre);
					locations.add(nuevaLocalidad);
					condition = true;
				} else {
					depts.add(dept_no);
					names.add(name);
					locations.add(location);
				}

			}
		} catch (Exception e) {
			System.out.println("Modificado correctamente");
		}
		dataIn.close();
		if(condition) {
			//depts.toArray();
			DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("C:\\Users\\ismaelor\\Desktop\\DAM\\ACDA Pruebas\\Departamentos_nobinary.txt"));
			for(int i=0;i<depts.size();i++) {
			System.out.println(depts.get(i));
			dataOut.writeInt(depts.get(i));
			dataOut.writeUTF(names.get(i));
			dataOut.writeUTF(locations.get(i));
			}
			System.out.println("Añadido");
			dataOut.close();
		}
		else {
			System.out.println("Departamento no existente");
		}
	}

}
