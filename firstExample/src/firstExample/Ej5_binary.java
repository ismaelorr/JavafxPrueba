package firstExample;

import java.io.*;

public class Ej5_binary {

	public static void main(String[] args) throws IOException{
		File departamentos = new File("C:\\Users\\ismaelor\\Desktop\\DAM\\ACDA Pruebas\\Departamentos_binary.dat");
		if(departamentos.createNewFile()) {
			System.out.println("Fichero "+departamentos.getName()+" creado");
			DataOutputStream dataOut = new DataOutputStream(new FileOutputStream(departamentos));
			int [] dept_no = {19,22,23,25,28};
			String [] names = {"Pepe","Ismael","Pachi","Moke","Dani"};
			String [] location = {"Malaga","Madrid","Barcelona","Francia","Venezuela"};
			for(int i=0;i<dept_no.length;i++) {
				dataOut.writeInt(dept_no[i]);
				dataOut.writeUTF(names[i]);
				dataOut.writeUTF(location[i]);
			}
			dataOut.close();
			System.out.println("Datos introducidos correctamente");
		}
			
		
	}

}
