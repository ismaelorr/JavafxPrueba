package firstExample;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class UniversidadLeer {

	public static void main(String[] args) throws Exception, Throwable {
		 
		 DocumentBuilderFactory miFactoria = DocumentBuilderFactory.newInstance(); 
		 DocumentBuilder miConstructor = miFactoria.newDocumentBuilder(); 
		 Document miDocumento = miConstructor.parse(new File("C:\\Users\\ismaelor\\Desktop\\DAM\\ACDA Pruebas\\universidad.xml")); 
		 NodeList depts = miDocumento.getElementsByTagName("departamento");
		 for(int i=0;i<depts.getLength();i++) {
			 Node nodo = depts.item(i);
			 if(nodo.getNodeType() == Node.ELEMENT_NODE) {
				 Element e = (Element) nodo;
				 System.out.println(e.getNodeName()+" "+(i+1)+": Teléfono: "+e.getAttribute("telefono")+" Tipo: "+e.getAttribute("tipo"));
				 NodeList listaHijos = e.getChildNodes();
				 for(int x=0;x<listaHijos.getLength();x++) {
					 Node nodoHijo = listaHijos.item(x);
					 if(nodoHijo.getNodeType() == Node.ELEMENT_NODE) {
						 Element e2 = (Element) nodoHijo;
						 if(!e2.getNodeName().equals("empleado")) {
							 System.out.println(e2.getNodeName()+" "+e2.getTextContent());
						 }
						 else {
							 System.out.println(e2.getNodeName()+": salario: "+e2.getAttribute("salario"));
							 NodeList listaNietos = e2.getChildNodes();
							 for(int z=0;z<listaNietos.getLength();z++) {
								 Node nodoNieto = listaNietos.item(z);
								 if(nodoNieto.getNodeType() == Node.ELEMENT_NODE) {
									 Element e3 = (Element) nodoNieto;
										 System.out.println(e3.getNodeName()+": "+e3.getTextContent());

									 }
								 }
							 }
						 }
						
					 }
					 
				 }
				 
			 }
		 }

	}


