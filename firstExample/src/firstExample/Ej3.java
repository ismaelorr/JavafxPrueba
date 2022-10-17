package firstExample;

import java.io.File;
import java.util.Scanner;

public class Ej3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe el directorio");
		String dir = sc.nextLine();
		File f1 = new File(dir);
		removeFiles(f1,dir);
	}

	private static void removeFiles(File f1, String dir) {
		if(f1.exists()) {
			try {
			System.out.println(f1.getName()+ "existe");
			if(f1.isDirectory()) {
				File f2 = new File(f1,dir);
				deleteFillesIn(f1,f1.getParent());
				System.out.println("directorio "+f1.getName()+" borrado");
				f1.delete();
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static void deleteFillesIn(File f1, String dir2) {
		String list [] = f1.list();
		for(int i=0;i<list.length;i++) {
			File f2 = new File(f1,list[i]);
			if(!f2.isDirectory()) {
			System.out.println(list[i]+ " borrado");
			f2.delete();
			}
			else {
				deleteFillesIn(f2,dir2);
				
			}
			}
		if(list.length==0){
			String dir = f1.getParent();
			if(!dir.equalsIgnoreCase(dir2)) {
			f1.delete();
			deleteFillesIn(new File(dir),dir2);
			}
		}
		}
		
	}


