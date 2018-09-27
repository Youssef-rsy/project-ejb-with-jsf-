package web;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class Menu {

	FacesContext context = FacesContext.getCurrentInstance();
	
	private String cour(){
		try {
			context.getExternalContext().redirect("ProjectCoursEjbJsf/faces/cours.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "successe";
	}
	private String etudiant(){
		try {
			context.getExternalContext().redirect("ProjectCoursEjbJsf/faces/etudiant.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "successe";
	}
	private String permanent(){
		try {
			context.getExternalContext().redirect("ProjectCoursEjbJsf/faces/permanent.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "successe";
	}
	private String vacataire(){
		try {
			context.getExternalContext().redirect("ProjectCoursEjbJsf/faces/vacataire.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "successe";
	}
}
