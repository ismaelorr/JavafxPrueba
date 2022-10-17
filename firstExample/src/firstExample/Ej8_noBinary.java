package firstExample;

import java.io.*;
import java.util.Scanner;

public class Ej8_noBinary {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		File f1 = new File("C:\\Users\\ismaelor\\Desktop\\DAM\\ACDA Pruebas\\hola.docx");
		if(f1.exists()) {
		BufferedReader bufIn = new BufferedReader(new FileReader(f1));
		try {
			while(true) {
				System.out.println(bufIn.readLine()+" \n");
			}
		}catch(Exception e) {
			
		}
		bufIn.close();
		}
			
	}

}
