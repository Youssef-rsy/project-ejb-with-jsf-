package WebService;


import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import metier.Entity.Cours;
import metier.Session.CoursLocal;
@Stateless  
@WebService 
public class CoursService  {
	@EJB
	private CoursLocal metier;
	
	@WebMethod 
	
	public Cours addCours(@WebParam(name="nom") String nom  
			) {
		// TODO Auto-generated method stub
		Cours cour =new Cours(nom);
		return metier.addCours(cour);
	}
	
	@WebMethod
	public Cours updateCours(@WebParam(name="id") long id , @WebParam(name="nom") String nom) {
		// TODO Auto-generated method stub
		Cours cour = metier.getCours(id) ;
		cour.setNom(nom);
		return metier.updateCours(cour);
	}
	
	@WebMethod
	public List<Cours> allCours() {
		// TODO Auto-generated method stub
		return metier.allCours();
	}
	
	@WebMethod
	public List<Cours> listOfNonAssignedCours() {
		// TODO Auto-generated method stub
		return metier.listOfNonAssignedCours();
	}
	
	@WebMethod
	public void deleteCours(@WebParam long id) {
		// TODO Auto-generated method 
		metier.deleteCours(id);
	}
	
	@WebMethod
	public Cours getCours(@WebParam long id) {
		// TODO Auto-generated method stub
		return metier.getCours(id);
	}
	
	@WebMethod
	public Cours getCoursByNom(@WebParam String nom) {
		// TODO Auto-generated method stub
		return metier.getCoursByNom(nom);
	}
	
	
	
}
