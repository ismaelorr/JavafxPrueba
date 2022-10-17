package firstExample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class probandoBuffers {

	public static void main(String[] args) throws IOException {
			File fichero=new File("C:\\Users\\ismaelor\\Desktop\\DAM\\ACDA Pruebas\\aña.dat");
			FileOutputStream fileout=new FileOutputStream(fichero);
			 //crea flujo de lectura del fichero
			 FileInputStream filein=new FileInputStream(fichero);
			 int i;
			 for (i=1;i<100;i++) fileout.write(i); //escribe datos en el flujo de salida
			 fileout.close(); //cerrar stream de salida
			 //visualizar los datos del fichero
			 while((i=filein.read())!=-1) //lee datos del flujo de entrada
			 System.out.println(i);
			 filein.close(); //cerrar stream de entrada
			 


	}

}
