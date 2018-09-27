package web;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import metier.Entity.Cours;
import metier.Entity.Enseignant;
import metier.Entity.Etudiant;
import metier.Session.CoursLocal;
import metier.Session.EtudiantLocal;

@ManagedBean(name="coursBean")
@RequestScoped
public class CoursBean {

	
	@EJB
	private CoursLocal metiercours;
	@EJB
	private EtudiantLocal metieretudiant;
	private Cours cour;
	private long id;
	private String nom;
	private List<Cours> listCours;
	private List<Etudiant> listEtudiant;
	private Enseignant enseignant;
	 

	public String addCours(){
		System.out.println(this.nom);
		  metiercours.addCours(new Cours(nom));
		return "success" ;
		
	}
	
	public String deleteCour(Cours cour){//ok
		//System.out.println("----------------DANS DELETE -------------------" +cour.getId()+"***********");
		metiercours.deleteCours(cour.getId());
		return "success" ;
	}
	
	
	public void findCour(Cours cour){
		this.cour = cour;
		this.nom = cour.getNom();
		this.id = cour.getId();
		System.out.println("---------------------------"+this.cour.getNom());
	}


	public void listOfEtudiant(Cours cour) throws IOException{
		System.out.println("---------------------------"+cour.getId()+"---------------------------");
		
		this.cour=metiercours.getCours(cour.getId());
		
		System.out.println(this.cour.getNom());
		if(this.cour.getEtudiants().size()!= 0){
			this.listEtudiant = this.cour.getEtudiants() ;
		}
		this.nom = "youssef";
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		context.redirect(context.getRequestContextPath() + "/faces/listDesEtudiant.xhtml?courid="+cour.getId());
		
	}
	 
	public void onloadList(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		long courid = Long.parseLong( (String) facesContext.getExternalContext().getRequestParameterMap().get("courid") );
		this.cour=metiercours.getCours(courid);
		this.nom = this.cour.getNom();
		if(this.cour.getEtudiants().size()!= 0){
			this.listEtudiant = this.cour.getEtudiants() ;
		}
		System.out.println();
	}
	
	public void affecter(Cours cour) throws IOException{
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		context.redirect(context.getRequestContextPath() + "/faces/affecterEtudiantCour.xhtml?courid="+cour.getId());
	}
	
	
	
	public void chargerAffecter(){
			
		FacesContext facesContext = FacesContext.getCurrentInstance();
		long courid = Long.parseLong( (String) facesContext.getExternalContext().getRequestParameterMap().get("courid") );
		this.cour=metiercours.getCours(courid);
		System.out.println(this.cour.getNom());
		listEtudiant=metieretudiant.allEtudiant();
		System.out.println(listEtudiant.size());
		
	}
	
	public void affecterEtudiantCour(){
		Cours c = metiercours.getCours(this.cour.getId());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Cours getCour() {
		return cour;
	}
	
	public void setCour(Cours cour) {
		this.cour = cour;
	}


	public List<Cours> getListCours() {
		return metiercours.allCours();
	}


	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	public List<Etudiant> getListEtudiant() {
		return listEtudiant;
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



	public void setListCours(List<Cours> listCours) {
		this.listCours = listCours;
	}
	
	
	
}
