package firstExample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ej10_binary {

	public static void main(String[] args) throws IOException {
		File f1 = new File("C:\\Users\\ismaelor\\Desktop\\\\DAM\\ACDA Pruebas\\ej10\\Ej10_binary.dat");
		if(!f1.exists()) {
			if(f1.createNewFile()) {
				setInfo(f1);
			}
		}
		File f2 = new File("C:\\Users\\ismaelor\\Desktop\\\\DAM\\ACDA Pruebas\\ej10\\provisional.dat");
		modifyFiles(f1,f2);
	}

	private static void modifyFiles(File f1, File f2) throws IOException{
		Scanner sc = new Scanner(System.in);
		System.out.println("Nombre");
		String name = sc.next();
		System.out.println("Salario a sumar");
		int newSalary = sc.nextInt();
		DataOutputStream dataOut = new DataOutputStream(new FileOutputStream(f2));
		DataInputStream dataIn = new DataInputStream(new FileInputStream(f1));
		try {
			while(true) {
				String compare = dataIn.readUTF();
				int salary = dataIn.readInt();
				System.out.println(salary);
				if(compare.equalsIgnoreCase(name)) {
					salary+=newSalary;
				}
				System.out.println(compare+" "+salary);
					dataOut.writeUTF(compare);
					dataOut.writeInt(salary);
				
			}
		}catch(Exception e) {
			
		}
		dataOut.close();
		dataIn.close();
		f1.delete();
		f2.renameTo(f1);
	}

	private static void setInfo(File f1) throws IOException {
		DataOutputStream dataOut = new DataOutputStream(new FileOutputStream(f1));
		String names [] = {"Ismael","Pachi","Moke","Dani","MA","Enrique"};
		for(int i=0;i<names.length;i++) {
			dataOut.writeUTF(names[i]);
			dataOut.writeInt((int)Math.floor(Math.random()*(0-2000+1)+2000));
		}
		dataOut.close();
	}

}
