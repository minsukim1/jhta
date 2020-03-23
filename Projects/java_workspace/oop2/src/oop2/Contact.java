package oop2;

public class Contact {

	String name;
	String tel;
	String email;
	
	Contact() {}
	
	Contact(String name, String tel) {
		this(name, tel, null);
	}
	
	Contact(String name, String tel, String email){
		this.name = name;
		this.tel = tel;
		this.email = email;
	}
	

}
