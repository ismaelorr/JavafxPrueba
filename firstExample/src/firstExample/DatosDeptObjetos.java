package firstExample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DatosDeptObjetos {

	public static void main(String[] args) throws IOException {
		
		String nombres[]= {"Ana","Luis","Miguel","Alicia","Pedro","Manuel","Andrés","Julio","Antonio","María","Jesús"};
		String location [] = {"Ana","Luis","Miguel","Alicia","Pedro","Manuel","Andrés","Julio","Antonio","María","Jesús"};
		int depts[]={1,15,13,11,16,12,17,14,18};
		
		File f1 = new File("C:\\Users\\ismaelor\\Desktop\\DAM\\ACDA Pruebas\\dept_object.dat");
		FileOutputStream fileOut = new FileOutputStream(f1);
		FileInputStream fileIn = new FileInputStream(f1);
		Departamentos dept;
		if(f1.exists()) {
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
			for(int i=0;i<depts.length;i++) {
				dept = new Departamentos(depts[i],nombres[i],location[i]);
				objOut.writeObject(dept);
			}
			objOut.close();
			fileOut.close();
		}
		try {
			ObjectInputStream objIn = new ObjectInputStream(fileIn);
			while(true) {
				dept = (Departamentos) objIn.readObject();
				System.out.println(dept.getDept_no()+" "+dept.getName());
				
			}
		}catch(Exception e) {
			
		}
		

	}

}
