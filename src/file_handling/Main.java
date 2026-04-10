package file_handling;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("\nWelCome to File Handling Project");
		String ch;
		FileHandler fd=new FileHandler();
		do {
			System.out.println("\n\tMENU\n");
			System.out.println("1.Add Student\n2.View all students\n3.Search student\n4.Update student data\n5.Delete student data\n6.Export text file\n7.Exit");
			System.out.print("Enter your choice: ");
			int chh=sc.nextInt();
			switch(chh) {
			case 1:	fd.addStudent();
					break;
			case 2:	fd.viewStudents();
					break;
			case 3: fd.searchStudent();
					break;
			case 4: fd.updateStudent();
					break;
			case 5: fd.deleteStudent();
					break;
			case 6:	fd.txtExport();
					break;
			case 7: System.out.println("Exiting...");
					System.exit(0);
					break;
			default: System.out.println("Invalid Choice..!");
			}

			
			System.out.print("Do you want to continue? (y/n)");
			ch=sc.next();
		}while(ch.equals("y"));
	}

}
