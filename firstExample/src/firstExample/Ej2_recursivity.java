package firstExample;
import java.io.*;
public class Ej2_recursivity {
		
	public static void main(String[] args) {
		
		File f1 = new File("C:\\Users\\ismaelor\\Desktop\\DAM\\Acda pruebas");
		System.out.println(f1.getName());
		recursivitymethod(f1);
	}

	private static void recursivitymethod(File f1) {
		String [] list = f1.list();
		if(list.length>0) {
		for(int i=0;i<list.length;i++) {
			File f2 = new File(f1,list[i]);
			if(f2.isDirectory()) {
				System.out.println(f2.getName());
				recursivitymethod(f2);
			}
			else {
				System.out.println(list[i]);
			}
		}
		}
	}
}
