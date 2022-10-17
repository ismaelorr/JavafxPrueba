package firstExample;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ej4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe el directorio");
		String dir = sc.nextLine();
		File f1 = new File(dir);
		try {
			String [] dirs = f1.list();
			for(int i=0;i<dirs.length;i++) {
			if(f1.exists()) {
				System.out.println("El fichero/directorio "+f1.getName() + " existe ");
				System.out.println(dirs[i]);
			}
			else{
				System.out.println(dir+ " no existe");
			}
			}
		}catch(Exception e) {
			
		}
		
	}

}
