package firstExample;

import java.io.File;

public class Ej2 {

	public static void main(String[] args) {
		String dir = "C:\\Users\\ismaelor\\Desktop\\DAM\\Acda pruebas";
		boolean condition = true;
		while(condition) {
			File f1 = new File(dir);
			String[] list = f1.list();
			if(list.length>0) {
			for (int i = 0; i < list.length; i++) {
				System.out.println(dir);
				File f2 = new File(f1, list[i]);
				if (f2.isDirectory()) {
					dir=f2.getPath();
					System.out.println(f2.getName());
				} else {
					System.out.println(list[i]);
				}
			}
		}
			else {
				condition=false;
			}
		}
		
	}
}
