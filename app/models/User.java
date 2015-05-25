package models;

import java.awt.List;

import javax.persistence.*;

import play.data.validation.Constraints.*;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class User extends Model {
	
	@Id
	public int id;
	
	//@OneToMany
	//public List<Message> msgs;
	
	@Required
	@Column(unique = true)
	@Email
	public String email;
	
	@Required
	@MinLength(5)
	@MaxLength(50)
	public String password;
	
	@Required
	@MinLength(6)
	@MaxLength(15)
	public String username;
	
	public boolean admin;

	public boolean verification = false;

	public String confirmation;
	
	public static Finder<Integer, User> find = new Finder<Integer, User>(Integer.class, User.class);

	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.admin = false;
	}
	
	public User(String username, String email, String password, String confirmation) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.confirmation = confirmation;
	}
	
//	public static User create(String username, String email, String password) {
//		if(existsEmail(email))
//			return null;
//		if(existsUsername(username))
//			return null;
//		
//	}
	
	public static boolean existsEmail(String email) {
		if(find.where().eq("email", email).findList().isEmpty())
			return false;
		return true;
	}
	
	public static boolean existsUsername(String username) {
		if(find.where().eq("username", username).findList().isEmpty())
			return false;
		return true;
	}

	

}
