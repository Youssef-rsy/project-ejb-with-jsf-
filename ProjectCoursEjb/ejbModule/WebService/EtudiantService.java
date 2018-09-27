package WebService;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.PathParam;

import metier.Entity.Adresse;
import metier.Entity.Etudiant;
import metier.Session.CoursLocal;
import metier.Session.EtudiantLocal;
@Stateless  
@WebService
public class EtudiantService  {
	@EJB
	private EtudiantLocal metier;
	
	@WebMethod
	public Etudiant addEtudiant(@WebParam  String nom,
			@WebParam String prenom,
			@WebParam String rue,
			@WebParam String ville,
			@WebParam String specialite ){
		// TODO Auto-generated method stub
		
		Etudiant etudiant= new Etudiant(null, nom, prenom, new Adresse(null, rue, ville), specialite, null);
		// TODO Auto-generated method stub
		return metier.addEtudiant(etudiant);
	}

	@WebMethod
	public Etudiant updateEtudiant(@WebParam  long id,
			@WebParam  String nom,
			@WebParam String prenom,
			@WebParam String rue,
			@WebParam String ville,
			@WebParam String specialite ){
		Etudiant etudiant= metier.getEtudiant(id);
		etudiant.setNom(nom);
		etudiant.setPrenom(prenom);
		etudiant.setSpecialite(specialite);
		etudiant.getAdresse().setRue(rue);
		etudiant.getAdresse().setVille(ville);
		return metier.updateEtudiant(etudiant);
	}

	@WebMethod
	public List<Etudiant> allEtudiant() {
		// TODO Auto-generated method stub
		return metier.allEtudiant();
	}

	@WebMethod
	public void deleteEtudiant(@WebParam long id) {
		// TODO Auto-generated method stub
		metier.deleteEtudiant(id);
	}

	@WebMethod
	public Etudiant getEtudiant(@WebParam long id) {
		// TODO Auto-generated method stub
		return metier.getEtudiant(id);
	}
	
}