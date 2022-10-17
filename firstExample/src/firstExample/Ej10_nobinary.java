package firstExample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ej10_nobinary {

	public static void main(String[] args) throws IOException {
		File f1 = createFile("C:\\Users\\ismaelor\\Desktop\\DAM\\ACDA Pruebas\\ej10\\Ej10_nobinary.txt");
		if(!f1.exists()) {
		if(f1.createNewFile()) {
			setInfo(f1);
		}
		}
		File f2 = createFile("C:\\Users\\ismaelor\\Desktop\\DAM\\ACDA Pruebas\\ej10\\provisional.txt");
		modifyFiles(f1,f2);
	}

	private static void modifyFiles(File f1, File f2) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nombre");
		String name = sc.next();
		System.out.println("Salario a sumar");
		int newSalary = sc.nextInt();
		BufferedReader bufOut = new BufferedReader(new FileReader(f1));
		BufferedWriter bufIn = new BufferedWriter(new FileWriter(f2));
		try {
			while(true) {
				String compare = bufOut.readLine();
				if(compare.toLowerCase().contains(name.toLowerCase())) {
					String num ="";
					for(int i=0;i<compare.length();i++) {
						if(!Character.isLetter(compare.charAt(i))) {
							num+=compare.charAt(i);
						}
					}
					String result = num.replaceAll("\\s+","");
					String number = result.substring(0, result.indexOf("."));
					int sum = Integer.parseInt(number)+newSalary;
				    bufIn.write(name+"\t"+sum+"\n");
				}else {
					bufIn.write(compare+"\n");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		bufIn.close();
		bufOut.close();
		f1.delete();
		f2.renameTo(f1);
	}

	private static void setInfo(File f1) throws IOException {
		BufferedWriter bufIn = new BufferedWriter(new FileWriter(f1));
		String [] names = {"Ismael","Pachi","Moke","Dani","MA","Enrique"};
		for(int i=0;i<names.length;i++) {
			bufIn.write(names[i]+"\t"+Math.floor(Math.random()*(0-2000+1)+2000)+"\n");
		}
		bufIn.close();
	}

	private static File createFile(String dir) {
		File f1 = new File(dir);
		return f1;
	}

}
