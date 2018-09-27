package web;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import metier.Entity.Cours;
import metier.Entity.Enseignant;
import metier.Entity.Etudiant;
import metier.Session.CoursLocal;
import metier.Session.EnseignantLocal;
import metier.Session.EtudiantLocal;
import metier.Session.PermanentLocal;
import metier.Session.VacataireLocal;

@ManagedBean
@RequestScoped
public class AffectationBean {

	@EJB
	private EtudiantLocal metieretudiant;
	@EJB
	private CoursLocal metiercours;
	@EJB
	private EnseignantLocal metierenseignant;
	@EJB
	private PermanentLocal metierpermanant;
	@EJB
	private VacataireLocal metiervacataire;
	/***********************************/
	private List<Etudiant> lstetudiant;
	private List<Cours> lstcour;
	private List<Enseignant> lstenseignant;
	/*************************************/
	private Cours cour;
	private Enseignant enseignant;
	private Etudiant etudiant;
	/************************************/
	private List<Etudiant> listetudiant;
	private long courid;
	private long enseignantid;
	private List<String> etudiantid;
	
	
	
	public void  onload(){
		System.out.println("---------------begin----------------");
		lstetudiant=metieretudiant.allEtudiant();
		lstcour=metiercours.allCours();
		lstenseignant = metierenseignant.allEnseignant();
		System.out.println("---------------end----------------");
	}
	
	
	public String affecterEnseignantCour(){
		System.out.println("--------------------begin------------------------");
		this.cour = metiercours.getCours(courid);
		this.enseignant = metierenseignant.getEnseignant(enseignantid);
		System.out.println(this.enseignant.getNom() +"   "+ this.enseignant.getPrenom());
		this.cour.setEnseignant(enseignant);
		metiercours.updateCours(this.cour);
		return "successe";
	}
	

	public String affecterCourEtudiant(){
		System.out.println("--------------------begin------------------------");
		System.out.println(courid);
		System.out.println(etudiantid.size());
		Cours mycour = metiercours.getCours(courid);
		Set<Etudiant> lst = new HashSet<Etudiant>();
		
		for (String id : etudiantid) {
			System.out.println("id :"+id);
			etudiant = metieretudiant.getEtudiant(Long.parseLong(id));
			System.out.println(etudiant.getNom());
			lst.add(etudiant);
			System.out.println("---------> nbr :"+lst.size());
		}
		mycour.getEtudiants().addAll(lst);
		metiercours.updateCours(mycour);
		System.out.println("--------------------end------------------------");
		return "successe";
	}
	



/**********************************************************************************************************/

	public List<Etudiant> getLstetudiant() {
		return metieretudiant.allEtudiant();
	}





	public void setLstetudiant(List<Etudiant> lstetudiant) {
		this.lstetudiant = lstetudiant;
	}





	public List<Cours> getLstcour() {
		return metiercours.allCours();
	}





	public void setLstcour(List<Cours> lstcour) {
		this.lstcour = lstcour;
	}





	public List<Enseignant> getLstenseignant() {
		return metierenseignant.allEnseignant();
	}





	public void setLstenseignant(List<Enseignant> lstenseignant) {
		this.lstenseignant = lstenseignant;
	}




	public Cours getCour() {
		return cour;
	}


	public void setCour(Cours cour) {
		this.cour = cour;
	}


	public Enseignant getEnseignant() {
		return enseignant;
	}


	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}


	public Etudiant getEtudiant() {
		return etudiant;
	}


	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}


	public List<Etudiant> getListetudiant() {
		return listetudiant;
	}


	public long getCourid() {
		return courid;
	}


	public void setCourid(long courid) {
		this.courid = courid;
	}


	public void setListetudiant(List<Etudiant> listetudiant) {
		this.listetudiant = listetudiant;
	}


	public List<String> getEtudiantid() {
		return etudiantid;
	}


	public void setEtudiantid(List<String> etudiantid) {
		this.etudiantid = etudiantid;
	}


	public long getEnseignantid() {
		return enseignantid;
	}


	public void setEnseignantid(long enseignantid) {
		this.enseignantid = enseignantid;
	}



	
	
	
	/*****************************/
	

}
