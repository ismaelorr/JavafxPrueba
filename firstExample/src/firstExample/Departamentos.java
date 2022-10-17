package firstExample;

import java.io.Serializable;

public class Departamentos implements Serializable{
	
	int dept_no;
	String name;
	String location;
	
	public Departamentos(int dept_no,String name, String location) {
		this.dept_no=dept_no;
		this.name=name;
		this.location=location;
	}

	public int getDept_no() {
		return dept_no;
	}

	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	

}
