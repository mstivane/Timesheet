package fr.stivane.interfaces;

import java.util.List;

import javax.ejb.Remote;

import fr.stivane.entities.*;

@Remote
public interface EmployeServiceRemote {

	long ajouterEmploye(Employe e);
	public Employe getEmployeByEmailAndPassword(String login, String password);
	public List<Employe> getAllEmployes();
	public void deleteEmployeById(long employeId);
	public void updateEmploye(Employe e);
	
}
