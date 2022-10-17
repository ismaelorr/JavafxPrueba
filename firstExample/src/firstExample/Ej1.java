package firstExample;

import java.io.File;
import java.io.IOException;

public class Ej1 {

	public static void main(String[] args) {
		String dir ="C:\\Users\\ismaelor\\Desktop\\2DAM";
		File f1 = new File(dir);
		System.out.printf("%s",f1.listFiles());
	}

}

