package web;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import metier.Entity.Adresse;
import metier.Entity.Cours;
import metier.Entity.Enseignant;
import metier.Entity.Etudiant;
import metier.Entity.Permanent;
import metier.Session.EnseignantLocal;
import metier.Session.PermanentLocal;

@ManagedBean
@RequestScoped
public class PermanentBean {

	
	@EJB
	private PermanentLocal metierpermanent;
	@EJB
	private EnseignantLocal metierenseignant;
	private Enseignant enseignant;
	private Permanent permanent;
	private List<Permanent> listpermanent;
	private String nom ;
	private String  prenom;
	private String rue;
	private String ville;
	private String service;
	private String grade;
	private List<Cours> mesCours;
	
	public void addPermanent(){
		System.out.println( nom+" "+ prenom+" " +rue+" "+ ville+" "+service+" "+ grade);
		metierpermanent.addPermanent(new Permanent(null, nom, prenom, new Adresse(null, rue, ville), service, null, grade));
	}
	/*public void listCour(Permanent permanent) throws IOException{
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		context.redirect(context.getRequestContextPath() + "/faces/listDesCoursEnseignant.xhtml?permanantid="+permanent.getId());
	}
*/	
	public String deletePpermanant(Permanent permanent){
			metierpermanent.deletePermanent(permanent.getId());
		return "successe";
	}

	
	
	
	
	
	public void listDCour(Enseignant ensaignant){
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		try {
			context.redirect(context.getRequestContextPath() + "/faces/enseignantcours.xhtml?id="+ensaignant.getId()+"&nom="+ensaignant.getNom());
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.mesCours = null;
	}
	
	
	public void affichercoursenseignant(){
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String nometu =  (String) facesContext.getExternalContext().getRequestParameterMap().get("nom") ;
		this.nom = nometu;
		
		long etudiantid = Long.parseLong( (String) facesContext.getExternalContext().getRequestParameterMap().get("id") );
		this.enseignant =metierenseignant.getEnseignant(etudiantid);
		System.out.println("--------------------------------------------------------");
		System.out.println(this.enseignant.getNom());
		System.out.println(this.enseignant.getCours().size());
		this.mesCours = this.enseignant.getCours();
		
		System.out.println(this.mesCours.size());
		System.out.println("--------------------------------------------------------");
	}
	
	
	/*public int nbretudiant(){
		return 
	}*/
	public List<Cours> getMesCours() {
		return mesCours;
	}
	public void setMesCours(List<Cours> mesCours) {
		this.mesCours = mesCours;
	}
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	public Permanent getPermanent() {
		return permanent;
	}

	public void setPermanent(Permanent permanent) {
		this.permanent = permanent;
	}

	

	public List<Permanent> getListpermanent() {
		return metierpermanent.allPermanent();
	}

	public void setListpermanent(List<Permanent> listpermanent) {
		this.listpermanent = listpermanent;
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

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
}
