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
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import metier.Entity.Adresse;
import metier.Entity.Permanent;
import metier.Entity.Vacataire;
import metier.Session.CoursLocal;
import metier.Session.PermanentBean;
import metier.Session.PermanentLocal;
@Stateless
@Path("/Enseignant")
public class PermanantService2  {

	@EJB
	private PermanentLocal metier;
	
	public PermanantService2() {
		super();
		// TODO Auto-generated constructor stub
	}

	@POST
	@Path("/addPermanent/{nom}/{prenom}/{rue}/{ville}/{specialite}/grade")
	@Produces(MediaType.APPLICATION_JSON)
	public Permanent addPermanent(
			@PathParam(value="nom") String nom,
			@PathParam(value="prenom") String prenom,
			@PathParam(value="rue") String rue,
			@PathParam(value="ville") String ville,
			@PathParam(value="service") String service,
			@PathParam(value="grade") String grade) {
		Permanent permanent = new Permanent(null, nom, prenom,  new Adresse(null, rue, ville), service, null, grade);
		// TODO Auto-generated method stub
		return metier.addPermanent(permanent);
	}

	@GET
	@Path("/updatePermanent/{id}/{nom}/{prenom}/{rue}/{ville}/{specialite}/grade")
	@Produces(MediaType.APPLICATION_JSON)
	public Permanent updatePermanent(@PathParam(value="id") long id,
			@PathParam(value="nom") String nom,
			@PathParam(value="prenom") String prenom,
			@PathParam(value="rue") String rue,
			@PathParam(value="ville") String ville,
			@PathParam(value="service") String service,
			@PathParam(value="grade") String grade) {
		// TODO Auto-generated method stub
		Permanent permanent = metier.getPermanent(id);
		permanent.setNom(nom);
		permanent.setPrenom(prenom);
		permanent.setGrade(grade);
		permanent.setService(service);
		permanent.getAdresse().setRue(rue);
		permanent.getAdresse().setVille(ville);
		return metier.updatePermanent(permanent);
	}

	@GET
	@Path("/allPermanent")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Permanent> allPermanent() {
		// TODO Auto-generated method stub
		return metier.allPermanent();
	}

	@GET
	@Path("/deletePermanent/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deletePermanent(@PathParam(value="id") long id) {
		// TODO Auto-generated method stub
		metier.deletePermanent(id);
	}

	@GET
	@Path("/getPermanent/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Permanent getPermanent(@PathParam(value="id") long id) {
		// TODO Auto-generated method stub
		return metier.getPermanent(id);
	}
	
	
}