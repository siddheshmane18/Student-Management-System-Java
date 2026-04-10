package file_handling;

import java.io.*;
import java.util.*;

public class FileHandler {
	
	String file="C:\\\\Users\\\\siddh\\\\OneDrive\\\\Documents\\\\File_Handling_Project.dat";
	Scanner sc=new Scanner(System.in);

	public void addStudent() {
		int id;
		String name;
		double marks;
		System.out.print("Enter Student id: ");
		id=sc.nextInt();
		System.out.print("Enter Student name: ");
		name=sc.next();
		System.out.print("Enter Student marks: ");
		marks=sc.nextDouble();
		Student s1=new Student(id,name,marks);
		
		try {
			ArrayList<Student>list=new ArrayList<>();
					//(ArrayList<Student>)ois.readObject();
			File f = new File(file);

			if (f.exists() && f.length() > 0) {
			    try {
			        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			        list = (ArrayList<Student>) ois.readObject();
			        ois.close();
			    }
			    catch (EOFException e) {
			    }catch (Exception e) {
			        System.out.println(e);
			    }		//
			}
			list.add(s1);
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(list);
			oos.close();
			
			System.out.println("Student data of id ("+id+") entered in file successfully..!");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void viewStudents() {
		
		try {
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));
			ArrayList<Student>list=(ArrayList<Student>)ois.readObject();
			ois.close();
			
			System.out.println("ID\tName\tMarks");
			
			for(Student s:list) {
				System.out.println(s.getId()+"\t"+s.getName()+"\t"+s.getMarks());
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void searchStudent() {
		int id;
		System.out.print("Enter the student id to search: ");
		id=sc.nextInt();
		try {
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));
			ArrayList<Student>list=(ArrayList<Student>)ois.readObject();
			ois.close();
			
			for(Student s:list) {
				if(s.getId()==id) {
					System.out.println("\nStudent details found in file.!");
					System.out.println("ID\tName\tMarks");
					System.out.println(s.getId()+"\t"+s.getName()+"\t"+s.getMarks());
					return;
				}
				else continue;
			}
			System.out.println("\nStudent not found in file.!");
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void updateStudent() {
		System.out.print("Enter student id to update: ");
		int id=sc.nextInt();
		try {
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));
			ArrayList<Student>list=(ArrayList<Student>)ois.readObject();
			ois.close();
			
			for(Student s:list) {
				if(s.getId()==id) {
					System.out.println("\nDo you want to update name? (y/n)");
					String ch=sc.next();
					if(ch.equals("y")) {
						System.out.print("Enter new Name: ");
						String newName=sc.next();
						s.setName(newName);
					}
					System.out.println("\nDo you want to update marks? (y/n)");
					String chh=sc.next();
					if(chh.equals("y")) {
						System.out.print("Enter new marks: ");
						double newMarks=sc.nextDouble();
						s.setMarks(newMarks);
					}
					System.out.println("\nStudent details updated successfully.!");
					ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));
					oos.writeObject(list);
					oos.close();
					return;
				}
				else continue;
			}
			System.out.println("\nStudent not found in file.!");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void deleteStudent() {
		int id,flag=0;
		System.out.print("Enter the student id to delete: ");
		id=sc.nextInt();
		try {
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));
			ArrayList<Student>list=(ArrayList<Student>)ois.readObject();
			ArrayList<Student>listd=new ArrayList<>();
			ois.close();
			
			for(Student s:list) {
				if(s.getId()==id) {
					flag=1;
					continue;
				}
				else {
					listd.add(s);
				}
			}
			if(flag==0)
			System.out.println("\nStudent not found in file.!");
			else System.out.println("\nStudent details deleted successfully.!!");
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(listd);
			oos.close();
	}catch(Exception e) {
		System.out.println(e);
	}

	}
	
	public void txtExport() {
		try {
			ArrayList<Student>list=new ArrayList<>();
			File f = new File("C:\\\\Users\\\\siddh\\\\OneDrive\\\\Documents\\\\File_Handling_Project.dat");
		
			if (f.exists() && f.length() > 0) {
			    try {
			        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			        list = (ArrayList<Student>) ois.readObject();
			        ois.close();
			        
			        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\\\Users\\\\siddh\\\\OneDrive\\\\Documents\\\\FileHandling.txt"));			        
			        for(Student s:list) {
			        	bw.write("ID: "+s.getId()+"\tNAME: "+s.getName()+"\tMARKS: "+s.getMarks());
			        	bw.newLine();
			        }
			        bw.close();
			        System.out.println("\nFile successfully exported..!");
			    }
			    catch (Exception e) {
			        System.out.println(e);
			    }	
	}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
