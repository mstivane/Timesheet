package fr.afpa.imputation.timesheet.managedbeans;

import java.io.Serializable;
import java.util.List;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import fr.stivane.entities.Employe;
import fr.stivane.enumeration.Role;
import fr.stivane.services.EmployeService;

@ManagedBean(name = "employeBean")
@SessionScoped
public class EmployeBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String login;
	private String password;
	private String email;
	private Boolean isActif = true;
	private Role role;
	private long employeIdToBeUpdated;

	
	
	// EmployeBean
	private List<Employe> employes;
	@EJB
	EmployeService employeService;

	public void addEmploye() {
		employeService.ajouterEmploye(new Employe( login, password, email, isActif, role));
	}
	// getters & setters

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

	public List<Employe> getEmployes() {
		employes = employeService.getAllEmployes();
		return employes;
	}

	public Boolean getIsActif() {
		return isActif;
	}

	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}

	public EmployeService getEmployeService() {
		return employeService;
	}

	public void setEmployeService(EmployeService employeService) {
		this.employeService = employeService;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}
	
	

	public long getEmployeIdToBeUpdated() {
		return employeIdToBeUpdated;
	}

	public void setEmployeIdToBeUpdated(long employeIdToBeUpdated) {
		this.employeIdToBeUpdated = employeIdToBeUpdated;
	}

	public void removeEmploye(long employeId)
	{ 
		
		employeService.deleteEmployeById(employeId);
	}
	
	public void modifierEmploye(Employe employe) {
		this.setEmail(employe.getEmail());  //remplit les champs manquants du formulaire
		this.setIsActif(employe.getisActif());
		this.setLogin(employe.getLogin()); //
		this.setPassword(employe.getPassword());
		this.setRole(employe.getRole());
		this.setEmployeIdToBeUpdated(employe.getId());
		
	}
	
	public void majEmploye() {
		
		employeService.updateEmploye(new Employe(employeIdToBeUpdated,login, password, email, isActif, role));
		
	}

	
	

}