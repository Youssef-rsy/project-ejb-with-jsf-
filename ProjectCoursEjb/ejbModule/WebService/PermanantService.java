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
import metier.Entity.Permanent;
import metier.Session.CoursLocal;
import metier.Session.PermanentBean;
import metier.Session.PermanentLocal;
@Stateless  
@WebService
public class PermanantService  {

	@EJB
	private PermanentLocal metier;
	
	@WebMethod
	public Permanent addPermanent(
			@WebParam  String nom,
			@WebParam  String prenom,
			@WebParam  String rue,
			@WebParam  String ville,
			@WebParam  String service,
			@WebParam String grade) {
		Permanent permanent = new Permanent(null, nom, prenom,  new Adresse(null, rue, ville), service, null, grade);
		// TODO Auto-generated method stub
		return metier.addPermanent(permanent);
	}

	@WebMethod
	public Permanent updatePermanent(@WebParam long id ,
			@WebParam  String nom,
			@WebParam  String prenom,
			@WebParam  String rue,
			@WebParam  String ville,
			@WebParam  String service,
			@WebParam String grade) {
		// TODO Auto-generated method stub
		Permanent permanent = new Permanent(null, nom, prenom,  new Adresse(null, rue, ville), service, null, grade);
		// TODO Auto-generated method stub
		return metier.addPermanent(permanent);
	}

	@WebMethod
	public List<Permanent> allPermanent() {
		// TODO Auto-generated method stub
		return metier.allPermanent();
	}

	@WebMethod
	public void deletePermanent(@WebParam long id) {
		// TODO Auto-generated method stub
		metier.deletePermanent(id);
	}

	@WebMethod
	public Permanent getPermanent(@WebParam long id) {
		// TODO Auto-generated method stub
		return metier.getPermanent(id);
	}
	
	
}