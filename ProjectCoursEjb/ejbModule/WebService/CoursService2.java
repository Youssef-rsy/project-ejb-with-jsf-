package WebService;


import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.naming.Name;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import metier.Entity.Cours;
import metier.Session.CoursLocal;
@Stateless
@Path("/cours")
@Consumes(MediaType.APPLICATION_JSON)
public class CoursService2  {
	
	@EJB
	private CoursLocal metier;
	
	public CoursService2() {
		super();
		// TODO Auto-generated constructor stub
	}

	@POST
	@Path("/addCours/{nom}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cours addCours(@PathParam(value="nom") String nom
			) {
		// TODO Auto-generated method stub
		Cours cour =new Cours(nom);
		return metier.addCours(cour);
	}
	
	@GET
	@Path("/updateCours/{id}/{nom}")
	@Produces(MediaType.APPLICATION_JSON )
	public Cours updateCours(@PathParam(value="id") long id ,@PathParam(value="nom") String nom) {
		// TODO Auto-generated method stub
		Cours cour = metier.getCours(id) ;
		cour.setNom(nom);
		return metier.updateCours(cour);
	}
	
	@GET
	@Path("/allCours")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cours> allCours() {
		// TODO Auto-generated method stub
		return metier.allCours();
	}
	
	@GET
	@Path("/listOfNonAssignedCours")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cours> listOfNonAssignedCours() {
		// TODO Auto-generated method stub
		return metier.listOfNonAssignedCours();
	}
	
	@GET
	@Path("/listOfNonAssignedCours/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteCours(@PathParam(value="id") long id) {
		// TODO Auto-generated method stub
		metier.deleteCours(id);
	}
	
	@GET
	@Path("/getCours/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cours getCours(@PathParam(value="id") long id) {
		// TODO Auto-generated method stub
		return metier.getCours(id);
	}
	
	@GET
	@Path("/listOfNonAssignedCours/{nom}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cours getCoursByNom(@PathParam(value="nom") String nom) {
		// TODO Auto-generated method stub
		return metier.getCoursByNom(nom);
	}
	
	
	
}
