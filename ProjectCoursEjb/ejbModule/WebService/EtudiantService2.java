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
import metier.Entity.Etudiant;
import metier.Session.CoursLocal;
import metier.Session.EtudiantLocal;
@Stateless
@Path("/Etudiant")
public class EtudiantService2  {
	public EtudiantService2() {
		super();
		// TODO Auto-generated constructor stub
	}

	@EJB
	private EtudiantLocal metier;
	
	@POST
	@Path("/addEtudiant/{nom}/{prenom}/{rue}/{ville}/{specialite}")
	@Produces(MediaType.APPLICATION_JSON)
	public Etudiant addEtudiant(@PathParam(value="nom") String nom,
			@PathParam(value="prenom") String prenom,
			@PathParam(value="rue") String rue,
			@PathParam(value="ville") String ville,
			@PathParam(value="specialite") String specialite
			) {
		Etudiant etudiant= new Etudiant(null, nom, prenom, new Adresse(null, rue, ville), specialite, null);
		// TODO Auto-generated method stub
		return metier.addEtudiant(etudiant);
	}

	@GET
	@Path("/updateEtudiant/{id}/{nom}/{prenom}/{rue}/{ville}/{specialite}")
	@Produces(MediaType.APPLICATION_JSON)
	public Etudiant updateEtudiant(@PathParam(value="id") long id,
			@PathParam(value="nom") String nom,
			@PathParam(value="prenom") String prenom,
			@PathParam(value="rue") String rue,
			@PathParam(value="ville") String ville,
			@PathParam(value="specialite") String specialite) {
		// TODO Auto-generated method stub
		Etudiant etudiant= metier.getEtudiant(id);
		etudiant.setNom(nom);
		etudiant.setPrenom(prenom);
		etudiant.setSpecialite(specialite);
		etudiant.getAdresse().setRue(rue);
		etudiant.getAdresse().setVille(ville);
		return metier.updateEtudiant(etudiant);
	}

	@GET
	@Path("/allEtudiant")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Etudiant> allEtudiant() {
		// TODO Auto-generated method stub
		return metier.allEtudiant();
	}

	@GET
	@Path("/deleteEtudiant/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteEtudiant(@PathParam(value="id") long id) {
		// TODO Auto-generated method stub
		metier.deleteEtudiant(id);
	}

	@GET
	@Path("/getEtudiant/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Etudiant getEtudiant(@PathParam(value="id") long id) {
		// TODO Auto-generated method stub
		return metier.getEtudiant(id);
	}
	
}