package firstExample;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Ej7_binary {
	
	ArrayList <Integer> depts = new ArrayList<>();
	ArrayList <String> names = new ArrayList<>();
	ArrayList <String> locations = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el departamento a borrar");
		int dept = sc.nextInt();
		File f1 = new File("C:\\Users\\ismaelor\\Desktop\\DAM\\ACDA Pruebas\\Departamentos_binary.dat");
		File f2 = new File("C:\\Users\\ismaelor\\Desktop\\DAM\\ACDA Pruebas\\Departamentos_provisional.dat");
		DataInputStream dataIn = new DataInputStream(new FileInputStream(f1));
		DataOutputStream dataOut = new DataOutputStream(new FileOutputStream(f2));
		int count = 0;
		if(f2.exists()) {
			try {
				while(true) {
					int dept_no = dataIn.readInt();
					String name = dataIn.readUTF();
					String location = dataIn.readUTF();
					if(dept!=dept_no) {
						dataOut.writeInt(dept_no);
						dataOut.writeUTF(name);
						dataOut.writeUTF(location);
						count++;
					}
					else {
						System.out.println("Departamento borrado");
					}
				}
			}catch(Exception e) {
				System.out.println("Número de departamentos: "+count);
			}
		}
		dataIn.close();
		dataOut.close();
		f1.delete();
		f2.renameTo(f1);
	}

}
