package metier.Session;

import java.util.List;

import javax.ejb.Remote;

import metier.Entity.Cours;

@Remote
public interface CoursRemote{

	public Cours addCours(Cours cours);
	public Cours updateCours(Cours cours);
	public List<Cours> allCours();
	public List<Cours> listOfNonAssignedCours();
	public void deleteCours(long id);
	public Cours getCours(long id);
	public Cours getCoursByNom(String nom);
}
