package fr.stivane.entities;

import fr.stivane.enumeration.Role;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Employe implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long id;
	private String login;
	private String password;
	private String email;
	@Enumerated(EnumType.STRING)
	private Role role;
	
	private String nom;
	private String prenom;
	private boolean isActif=true;

	
	//les constructeurs & getters/setters
	public Employe() {}


	public Employe(String string, String string2, String string3,Boolean isActif ,Role role2) {
		// TODO Auto-generated constructor stub
		this.login=string;
		this.password=string2;
		this.email=string3;
		this.isActif=isActif;
		this.role=role2;
	}
	
	public Employe(long id, String string, String string2, String string3,Boolean isActif ,Role role2) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.login=string;
		this.password=string2;
		this.email=string3;
		this.isActif=isActif;
		this.role=role2;
	}


	public long getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}




	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}



	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}



	

	


	@Override
	public String toString() {
		return "Employe [id=" + id + ", login=" + login + ", password=" + password + ", email=" + email + ", role="
				+ role + ", nom=" + nom + ", prenom=" + prenom + ", isActif=" + isActif + "]";
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public boolean getisActif() {
		return isActif;
	}


	public void setActif(boolean isActif) {
		this.isActif = isActif;
	}


	
	

	
	
	
	
	
	

}
