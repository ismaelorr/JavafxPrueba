package firstExample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ej7_noBinary {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Elige el departamento que borrar");
		Integer dept = sc.nextInt();
		File f1 = new File("C:\\Users\\ismaelor\\Desktop\\DAM\\ACDA Pruebas\\Departamentos_nobinary.txt");
		BufferedReader bufIn = new BufferedReader(new FileReader(f1));
		File f2 = new File("C:\\Users\\ismaelor\\Desktop\\DAM\\ACDA Pruebas\\Dept_sustitucion.txt");
		int count = 0;
		BufferedWriter bufOut = new BufferedWriter(new FileWriter("C:\\Users\\ismaelor\\Desktop\\DAM\\ACDA Pruebas\\Dept_sustitucion.txt"));
		if(f1.exists()) {
		try {
		while(true) {
			String line = bufIn.readLine();
			System.out.println(line);
			if(!line.contains(dept.toString())) {
				bufOut.write(line+"\n");
				count++;
			}
			else {
				System.out.println("Departamento borrado");
			}
		}
		}catch(Exception e){
			
		}
		bufIn.close();
		bufOut.close();
		f1.delete();
		f2.renameTo(f1);
		System.out.println("Número de departamentos "+count);
	}
	}
}
