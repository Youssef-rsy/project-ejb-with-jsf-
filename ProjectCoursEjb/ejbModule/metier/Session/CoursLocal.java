package metier.Session;

import java.util.List;

import javax.ejb.Local;

import metier.Entity.Cours;

@Local
public interface CoursLocal {

	public Cours addCours(Cours cours);
	public Cours updateCours(Cours cours);
	public List<Cours> allCours();
	public List<Cours> listOfNonAssignedCours();
	public void deleteCours(long id);
	public Cours getCours(long id);
	public Cours getCoursByNom(String nom);
}
