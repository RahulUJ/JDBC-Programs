package com.ty.persondto;

public class PersonDto {
	
	public int id;
	public String name;
	public long phone;
	public String email;
	public String password;
	public int age;
	@Override
	public String toString() {
		return "Id = " + id + ", Name = " + name + ", Phone = " + phone + ", Email=" + email + ", Password="
				+ password + ", Age= " + age ;
	}
	

}
