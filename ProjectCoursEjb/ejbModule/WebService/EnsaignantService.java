package WebService; 

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.PathParam;

import metier.Entity.Adresse;
import metier.Entity.Enseignant;
import metier.Session.EnseignantLocal;
@Stateless  
@WebService
public class EnsaignantService  {

	@EJB
	private EnseignantLocal metier;
	
	 @WebMethod
	public Enseignant addEnseignant(@WebParam  String nom,
			@WebParam String prenom,
			@WebParam String rue,
			@WebParam String ville,
			@WebParam String service) {
		// TODO Auto-generated method stub
		 Enseignant enseignant = new Enseignant(null, nom, prenom, new Adresse(null, rue, ville), service, null);
			return metier.addEnseignant(enseignant);
	}

	 @WebMethod
	public Enseignant updateEnseignant(
			@WebParam  long id,
			@WebParam  String nom,
			@WebParam String prenom,
			@WebParam String rue,
			@WebParam String ville,
			@WebParam String service) {
		// TODO Auto-generated method stub
		 Enseignant enseignant= metier.getEnseignant(id);
			enseignant.setNom(nom);
			enseignant.setPrenom(prenom);
			enseignant.setService(service);
			enseignant.getAdresse().setRue(rue);
			enseignant.getAdresse().setVille(ville);
			// TODO Auto-generated method stub
			return metier.updateEnseignant(enseignant);
	}

	 @WebMethod
	public List<Enseignant> allEnseignant() {
		// TODO Auto-generated method stub
		return metier.allEnseignant();
	}

	 @WebMethod
	public void deleteEnseignant(@WebParam long id) {
		// TODO Auto-generated method stub
		metier.deleteEnseignant(id);
	}

	 @WebMethod
	public Enseignant getEnseignant(@WebParam long id) {
		// TODO Auto-generated method stub
		return metier.getEnseignant(id);
	}
	
}