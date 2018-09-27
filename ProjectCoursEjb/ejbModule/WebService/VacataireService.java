package WebService;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.PathParam;

import metier.Entity.Adresse;
import metier.Entity.Vacataire;
import metier.Session.CoursLocal;
import metier.Session.VacataireBean;
import metier.Session.VacataireLocal;
@Stateless  
@WebService
public class VacataireService {
	@EJB
	private VacataireLocal metier;
	
	@WebMethod
	public Vacataire addVacataire(
			@PathParam(value="nom") String nom,
			@PathParam(value="prenom") String prenom,
			@PathParam(value="rue") String rue,
			@PathParam(value="ville") String ville,
			@PathParam(value="service") String service,
			@PathParam(value="grade") String employeur) {
		Vacataire vacataire = new Vacataire(null, nom, prenom,  new Adresse(null, rue, ville), service, null, employeur);
		// TODO Auto-generated method stub
		return metier.addVacataire(vacataire);
	}

	@WebMethod
	public Vacataire updateVacataire(@PathParam(value="id") long id,
			@PathParam(value="nom") String nom,
			@PathParam(value="prenom") String prenom,
			@PathParam(value="rue") String rue,
			@PathParam(value="ville") String ville,
			@PathParam(value="service") String service,
			@PathParam(value="grade") String employeur) {
		// TODO Auto-generated method stub
		Vacataire vacataire = metier.getVacataire(id);
		vacataire.setNom(nom);
		vacataire.setPrenom(prenom);
		vacataire.setService(service);
		vacataire.getAdresse().setRue(rue);
		vacataire.getAdresse().setVille(ville);
		vacataire.setEmployeur(employeur);
		return metier.updateVacataire(vacataire);
	}

	@WebMethod
	public List<Vacataire> allVacataire() {
		// TODO Auto-generated method stub
		return metier.allVacataire();
	}

	@WebMethod
	public void deleteVacataire(@WebParam long id) {
		// TODO Auto-generated method stub
		metier.deleteVacataire(id);
	}
	@WebMethod
	public Vacataire getVacataire(@WebParam long id) {
		// TODO Auto-generated method stub
		return metier.getVacataire(id);
	}
	
}