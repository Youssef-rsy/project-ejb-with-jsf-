package WebService; 

import java.util.List;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import metier.Entity.Adresse;
import metier.Entity.Enseignant;
import metier.Session.EnseignantLocal;

@Stateless
@Path("/Enseignant")
public class EnsaignantService2  {

	@EJB
	private EnseignantLocal metier;
	
	public EnsaignantService2() {
		super();
		// TODO Auto-generated constructor stub
	}

	@POST
	@Path("/addEnseignant/{nom}/{prenom}/{rue}/{ville}/{service}")
	@Produces(MediaType.APPLICATION_JSON)
	public Enseignant addEnseignant(
			@PathParam(value="nom") String nom,
			@PathParam(value="prenom") String prenom,
			@PathParam(value="rue") String rue,
			@PathParam(value="ville") String ville,
			@PathParam(value="service") String service) {
		// TODO Auto-generated method stub
		Enseignant enseignant = new Enseignant(null, nom, prenom, new Adresse(null, rue, ville), service, null);
		return metier.addEnseignant(enseignant);
	}

	@GET
	@Path("/updateEnseignant/{id}/{nom}/{prenom}/{rue}/{ville}/{service}")
	@Produces(MediaType.APPLICATION_JSON)
	public Enseignant updateEnseignant(@PathParam(value="id") long id,
			@PathParam(value="nom") String nom,
			@PathParam(value="prenom") String prenom,
			@PathParam(value="rue") String rue,
			@PathParam(value="ville") String ville,
			@PathParam(value="service") String service) {
		Enseignant enseignant= metier.getEnseignant(id);
		enseignant.setNom(nom);
		enseignant.setPrenom(prenom);
		enseignant.setService(service);
		enseignant.getAdresse().setRue(rue);
		enseignant.getAdresse().setVille(ville);
		// TODO Auto-generated method stub
		return metier.updateEnseignant(enseignant);
	}

	@GET
	@Path("/allEnseignant")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Enseignant> allEnseignant() {
		// TODO Auto-generated method stub
		return metier.allEnseignant();
	}

	@GET
	@Path("/deleteEnseignant/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteEnseignant(@PathParam(value="id") long id) {
		// TODO Auto-generated method stub
		metier.deleteEnseignant(id);
	}

	@GET
	@Path("/getEnseignant/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Enseignant getEnseignant(@PathParam(value="id") long id) {
		// TODO Auto-generated method stub
		return metier.getEnseignant(id);
	}
	
}