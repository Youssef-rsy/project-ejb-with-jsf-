package web;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import metier.Entity.Adresse;
import metier.Entity.Vacataire;
import metier.Session.VacataireLocal;

@ManagedBean
@RequestScoped
public class VacataireBean {

	@EJB
	private VacataireLocal metiervacataire;
	private Vacataire vacataire;
	private List<Vacataire> listvacataire;
	private String nom ;
	private String  prenom;
	private String rue;
	private String ville;
	private String service;
	private String employeur;
	
	public void addvacataire(){
		System.out.println( nom+" "+ prenom+" " +rue+" "+ ville+" "+service+" "+ employeur);
		metiervacataire.addVacataire(new Vacataire(null, nom, prenom, new Adresse(null, rue, ville), service, null, employeur));
	}
	/*public void listCour(vacataire vacataire) throws IOException{
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		context.redirect(context.getRequestContextPath() + "/faces/listDesCoursEnseignant.xhtml?vacataireid="+vacataire.getId());
	}
*/	
	public String deleteVacataire(Vacataire vacataire){
			metiervacataire.deleteVacataire(vacataire.getId());
		return "successe";
	}

	public Vacataire getvacataire() {
		return vacataire;
	}

	public void setvacataire(Vacataire vacataire) {
		this.vacataire = vacataire;
	}

	

	public List<Vacataire> getListvacataire() {
		return metiervacataire.allVacataire();
	}

	public void setListvacataire(List<Vacataire> listvacataire) {
		this.listvacataire = listvacataire;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getEmployeur() {
		return employeur;
	}

	public void setEmployeur(String grade) {
		this.employeur = grade;
	}
	
	
}
