package file_handling;

import java.io.*;

public class Student implements Serializable{

	private int id;
	private String name;
	private double marks;
	
	public Student(int id,String name,double marks){
		this.id=id;
		this.name=name;
		this.marks=marks;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getMarks() {
		return this.marks;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setMarks(double marks) {
		this.marks=marks;
	}
	
	public void display() {
		System.out.println("ID: "+id+"Name: "+name+"Marks: ");
	}

}
