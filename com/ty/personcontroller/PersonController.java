package com.ty.personcontroller;

import java.util.List;
import java.util.Scanner;

import com.ty.persondao.PersonDao;
import com.ty.persondto.PersonDto;

public class PersonController {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		PersonDto dto = new PersonDto();
		PersonDao dao = new PersonDao();

		boolean value = true;
		while (value) {
			System.out.println("1.Save User");
			System.out.println("2.Get User By Id");
			System.out.println("3.Delete User");
			System.out.println("4.Get All Users");
			System.out.println("5.Validate User(email & password)");
			System.out.println("6.Validate User(phone & password)");
			System.out.println("7.Exit");
			int choice = s.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter id.");
				dto.id = s.nextInt();

				System.out.println("Enter name.");
				dto.name = s.next();
				System.out.println();

				System.out.println("Enter phone number.");
				dto.phone = s.nextLong();
				System.out.println();

				System.out.println("Enter email.");
				dto.email = s.next();
				System.out.println();

				System.out.println("Enter password");
				dto.password = s.next();
				System.out.println();

				System.out.println("Enter age");
				dto.age = s.nextInt();
				dao.savePerson(dto);
			}
				break;
			case 2: {
				System.out.println("Enter id");
				int id = s.nextInt();
				PersonDto person = dao.findUserById(id);
				System.out.println(person);
			}
				break;

			case 3: {
				System.out.println("Enter id");
				int id = s.nextInt();
				dao.deletePerson(id);
			}
				break;
			case 4: {
				List<PersonDto> list = dao.getAllPersons();
				for (PersonDto personDto : list) {
					System.out.println(personDto);
				}
			}
			case 5 :{
				System.out.println("Enter email");
				String email = s.next();
				System.out.println("Enter password");
				String password = s.next();
				if (dao.validatePerson1(email, password)!=null) {
					System.out.println("Welcome");
				}
				else
					System.out.println("Person not present");
			}
				
				break;
			case 7: {
				value = false;
				System.out.println("ThankYou");
			}
			}
		}
	}

}
