package myjdbcpractise;

import java.util.Scanner;

public class Student {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		StudentCrud crud = new StudentCrud();
		boolean value = true;
		while (value) {
			System.out.println("1. Insert Student");
			System.out.println("2. Delete Student");
			System.out.println("3. Update Student");
			System.out.println("4. Exit");
			System.out.println("Enter Ur Choice");
			int choice = s.nextInt();
			
			switch (choice) {
			case 1:{
			System.out.println("Enter id for Student");
			int id = s.nextInt();
			System.out.println("Enter Name for Student");
			String name = s.next();
			System.out.println("Enter age");
			int age = s.nextInt();
			crud.saveStudent(id, name, age);
			}
			break;
			case 2 :{
				System.out.println("Enter id to delete");
				int id = s.nextInt();
				crud.deleteStudent(id);
			}
			break;
			case 3 :{
				System.out.println("Enter id");
				int id = s.nextInt();
				System.out.println("Enter Name");
				String name = s.next();
				System.out.println("Enter age");
				int age = s.nextInt();
				crud.updateStudent(id, name, age);
			}
			break;
			case 4:{
				value = false;
				System.out.println("ThankYou");
			}
			}
			
		}
	}
}
