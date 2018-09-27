package web;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import metier.Entity.Adresse;
import metier.Entity.Cours;
import metier.Entity.Enseignant;
import metier.Entity.Etudiant;
import metier.Session.CoursLocal;
import metier.Session.EtudiantLocal;

@ManagedBean
@RequestScoped
public class EtudiantBean {

	@EJB
	private EtudiantLocal metieretudiant;
	@EJB
	private CoursLocal metiercours;
	private Cours cour;
	private long id;
	private String nom;
	private String prenom;
	private String rue;
	private String ville;
	private String specialite;
	private Etudiant etudiant;
	private List<Cours> listCours;
	private List<Cours> lstCours;
	private List<Etudiant> listEtudiant;
	private Enseignant enseignant;
	
	
	public String addEtudiant(){
		metieretudiant.addEtudiant(new Etudiant(null, nom, prenom, new Adresse(null, rue, ville), specialite, null));
		return "successe";
	}
	
	public String deleteEtudiant(Etudiant etudiant){
		metieretudiant.deleteEtudiant(etudiant.getId());
		return "successe";
	}
	

	
	public void listDCourEtudiant(Etudiant etudiant){
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		try {
			context.redirect(context.getRequestContextPath() + "/faces/etudiantcours.xhtml?etudiantid="+etudiant.getId()+"&nom="+etudiant.getNom());
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.lstCours = null;
	}
	
	
	public void affichercoursetudiant(){
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String nometu =  (String) facesContext.getExternalContext().getRequestParameterMap().get("nom") ;
		this.nom = nometu;
		
		long etudiantid = Long.parseLong( (String) facesContext.getExternalContext().getRequestParameterMap().get("etudiantid") );
		this.etudiant=metieretudiant.getEtudiant(etudiantid);
		System.out.println("--------------------------------------------------------");
		System.out.println(this.etudiant.getNom());
		System.out.println(this.etudiant.getCours().size());
		this.lstCours = this.etudiant.getCours();
		System.out.println(this.lstCours.size());
		System.out.println("--------------------------------------------------------");
	}
	
	

	
	
	

	public Cours getCour() {
		return cour;
	}

	public void setCour(Cours cour) {
		this.cour = cour;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public List<Cours> getListCours() {
		return metiercours.allCours();
	}

	public void setListCours(List<Cours> listCours) {
		this.listCours = listCours;
	}

	public List<Etudiant> getListEtudiant() {
		return metieretudiant.allEtudiant();
	}

	public void setListEtudiant(List<Etudiant> listEtudiant) {
		this.listEtudiant = listEtudiant;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
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

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public List<Cours> getLstCours() {
		return lstCours;
	}

	public void setLstCours(List<Cours> lstCours) {
		this.lstCours = lstCours;
	}
	
	
	
}
