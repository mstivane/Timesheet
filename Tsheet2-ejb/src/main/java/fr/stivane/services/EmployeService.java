package fr.stivane.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import fr.stivane.entities.Employe;
import fr.stivane.enumeration.Role;
import fr.stivane.interfaces.EmployeServiceRemote;



@Stateless
@LocalBean
public class EmployeService implements EmployeServiceRemote{

	@PersistenceContext(unitName="timeshDS")
	EntityManager em;
	


	public long ajouterEmploye(Employe e) {
		// TODO Auto-generated method stub
		
		
		em.persist(e);
		return 1;
	}

	

	

	
	public Employe getEmployeByEmailAndPassword(String login, String password) {
		// TODO Auto-generated method stub
		TypedQuery<Employe> query = em.createQuery(" select e from Employe e where e.login=:login and e.password=:password ", Employe.class);
				
			query.setParameter("login", login); 
			query.setParameter("password", password);
				Employe employe = null;
				try { employe = query.getSingleResult(); }
				catch (Exception e) { System.out.println("Erreur : " + e); }
				return employe;

	}




	public void deleteEmployeById(long employeId)
	{
		Employe e =
		em.find(Employe.class, employeId); 
		em.remove(e);
	}




	public List<Employe> getAllEmployes() {
		// TODO Auto-generated method stub
		List<Employe> emp = em.createQuery("Select e from Employe e",  Employe.class).getResultList();
		return emp;
	}


	public void updateEmploye(Employe e) {
		
		em.merge(e);
	}



	

}