package myjdbcpractise;

import java.util.Scanner;

public class Teacher {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		TeacherCrud crud = new TeacherCrud();
		boolean value = true;
		while (value) {
			System.out.println("1. Insert Teacher");
			System.out.println("2. Delete Teacher");
			System.out.println("3. Update Teacher");
			System.out.println("4. Exit");
			System.out.println("Enter Ur Choice");
			int choice = Integer.parseInt(s.nextLine());
			
			switch (choice) {
			case 1:{
			System.out.println("Enter id for Teacher");
			int id = Integer.parseInt(s.nextLine());
			System.out.println("Enter Name for Teacher");
			String name = s.nextLine();
			System.out.println("Enter Subject being handled");
			String subject = s.nextLine();
			crud.addTeacher(id, name, subject);
			}
			break;
			case 2 :{
				System.out.println("Enter id to delete");
				int id = Integer.parseInt(s.nextLine());
				crud.deleteTeacher(id);
			}
			break;
			case 3 :{
				System.out.println("Enter id");
				int id = s.nextInt();
				System.out.println("Enter Name");
				String name = s.next();
				System.out.println("Enter age");
				int age = s.nextInt();
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
