package firstExample;

import java.io.*;

public class Ej5_nobinary {

	public static void main(String[] args) throws IOException {
		
		File directory = new File("C:\\Users\\ismaelor\\Desktop\\DAM\\ACDA Pruebas\\Departamentos_nobinary.txt");
		if(directory.createNewFile()) {
			FileWriter fic = new FileWriter(directory);
			int [] dept_no = {19,22,23,25,28};
			String [] names = {"Pepe","Ismael","Pachi","Moke","Dani"};
			String [] location = {"Malaga","Madrid","Barcelona","Francia","Venezuela"};
			for(int i=0;i<dept_no.length;i++) {
				fic.write(dept_no[i]+"\t");
				fic.write(names[i]+"\t");
				fic.write(location[i]+"\n");
			}
			fic.close();
			System.out.println("Datos introducidos correctamente");
		}
	}

}
