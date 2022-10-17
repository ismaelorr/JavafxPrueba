package firstExample;


import java.io.File;

import javax.naming.spi.DirStateFactory.Result;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;


public class UniversidadEscribir {
	
	public static String dept1 [] = {"112233","A","IFC1","Informática"};
	public static String empleadosDept1 [] = {"2000","Asociado","Juan Parra","2300","Profesor","Alicia Martín"};
	public static String dept2 [] = {"990033","A","MAT1","Matemáticas"};
	public static String empleadosDept2[] = {"1900","Técnico","Juan Parra","2100","Profesor","Mª Jesús Ramos","2300","Profesor","Pedro Paniagua","2500","Tutor","Antonia González"};
	public static String dept3 [] = {"880833","B","MAT2","Análisis"};
	public static String empleadosDept3 [] = {"1900","Asociado","Laura Ruiz","2200","Asociado","Mario García"};
	
	
	public static void main(String [] args) throws ParserConfigurationException,TransformerFactoryConfigurationError,
	TransformerException {
		
		DOMImplementation implementation = DocumentBuilderFactory.newInstance().newDocumentBuilder().getDOMImplementation();
		Document myDocument = implementation.createDocument(null, "universidad" , null);
		myDocument.setXmlVersion("1.0");
		
		insert(dept1,2,empleadosDept1,myDocument);
		insert(dept2,4,empleadosDept2,myDocument);
		insert(dept3,2,empleadosDept3,myDocument);
		
		 Source source = new DOMSource(myDocument);
		 StreamResult resultado = new StreamResult(new File("C:\\Users\\ismaelor\\Desktop\\DAM\\ACDA Pruebas\\universidad.xml"));
		 Transformer miTransformer = TransformerFactory.newInstance().newTransformer();
		 miTransformer.transform(source, resultado);
		 System.out.println("Creado");
		
	}
	
		public static void insert(String names[],int numEmp,String empDate[],Document myDocument) {
			Element depart = myDocument.createElement("departamento");
			depart.setAttribute("telefono", names[0]);
			depart.setAttribute("tipo", names[1]);
			Element codigo = myDocument.createElement("codigo");
			Text text = myDocument.createTextNode(names[2]);
			codigo.appendChild(text);
			Element nombre= myDocument.createElement("nombre");
			Text nombretext = myDocument.createTextNode(names[3]);
			nombre.appendChild(nombretext);
			depart.appendChild(codigo);
			depart.appendChild(nombre);
			int x = 0;
			for(int i=0;i<numEmp;i++) {
				Element empleado = myDocument.createElement("empleado");
				empleado.setAttribute("salario", empDate[x++]);
				Element puesto = myDocument.createElement("puesto");
				Text puestoText = myDocument.createTextNode(empDate[x++]);
				puesto.appendChild(puestoText);
				Element nombreEmp = myDocument.createElement("nombre");
				Text nombreEmpText = myDocument.createTextNode(empDate[x++]);
				nombreEmp.appendChild(nombreEmpText);
				empleado.appendChild(puesto);
				empleado.appendChild(nombreEmp);
				depart.appendChild(empleado);
			}
			myDocument.getDocumentElement().appendChild(depart);
			
	}
	
}
