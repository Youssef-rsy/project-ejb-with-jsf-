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
import metier.Entity.Vacataire;
import metier.Session.CoursLocal;
import metier.Session.VacataireBean;
import metier.Session.VacataireLocal;
@Stateless
@Path("/Vacataire")
public class VacataireService2 {
	public VacataireService2() {
		super();
		// TODO Auto-generated constructor stub
	}
	@EJB
	private VacataireLocal metier;
	
	@POST
	@Path("/addVacataire")
	@Produces(MediaType.APPLICATION_JSON)
	public Vacataire addVacataire(
			@PathParam(value="nom") String nom,
			@PathParam(value="prenom") String prenom,
			@PathParam(value="rue") String rue,
			@PathParam(value="ville") String ville,
			@PathParam(value="service") String service,
			@PathParam(value="employeur") String employeur) {
		
		Vacataire vacataire = new Vacataire(null, nom, prenom,  new Adresse(null, rue, ville), service, null, employeur);
		// TODO Auto-generated method stub
		return metier.addVacataire(vacataire);
	}

	@GET
	@Path("/updateVacataire")
	@Produces(MediaType.APPLICATION_JSON)
	public Vacataire updateVacataire(@PathParam(value="id") long id,
			@PathParam(value="nom") String nom,
			@PathParam(value="prenom") String prenom,
			@PathParam(value="rue") String rue,
			@PathParam(value="ville") String ville,
			@PathParam(value="service") String service,
			@PathParam(value="grade")  String employeur) {
		// TODO Auto-generated method stub
		Vacataire vacataire= metier.getVacataire(id);
		vacataire.setNom(nom);
		vacataire.setPrenom(prenom);
		vacataire.setEmployeur(employeur);
		vacataire.setService(service);
		vacataire.getAdresse().setRue(rue);
		vacataire.getAdresse().setVille(ville);
		return metier.updateVacataire(vacataire);
	}

	@GET
	@Path("/allVacataire")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vacataire> allVacataire() {
		// TODO Auto-generated method stub
		return metier.allVacataire();
	}

	@GET
	@Path("/deleteVacataire/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteVacataire(@PathParam(value="id") long id) {
		// TODO Auto-generated method stub
		metier.deleteVacataire(id);
	}
	@GET
	@Path("/getVacataire/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Vacataire getVacataire(@PathParam(value="id") long id) {
		// TODO Auto-generated method stub
		return metier.getVacataire(id);
	}
	
}