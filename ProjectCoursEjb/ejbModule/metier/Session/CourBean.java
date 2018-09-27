package metier.Session;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.Entity.Cours;
import metier.Entity.Etudiant;

@Stateless

public class CourBean implements CoursLocal , CoursRemote {

	
	@PersistenceContext(unitName="ProjectCoursEjb")
	private EntityManager em;
	
	@Override
	public Cours addCours(Cours cours) {
		// TODO Auto-generated method stub
		em.persist(cours);
		return cours;
	}

	@Override
	public Cours updateCours(Cours cours) {
		// TODO Auto-generated method stub
		System.out.println("-------------->"+cours.getEtudiants().size());

		for (Etudiant et : cours.getEtudiants()) {
			System.out.println("-- : "+et.getNom());
		}
		em.merge(cours);
		return cours;
	}

	@Override
	public List<Cours> allCours() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("FROM Cours");
		return q.getResultList();
	}

	@Override
	public void deleteCours(long id) {
		// TODO Auto-generated method stub
		em.remove(getCours(id));
	}

	@Override
	public Cours getCours(long id) {
		// TODO Auto-generated method stub
		return em.find(Cours.class, id);
	}

	@Override
	public Cours getCoursByNom(String nom) {
		// TODO Auto-generated method stub
		Query q = em.createQuery("from Cours where nom = :nom");
		q.setParameter("nom", nom);
		return (Cours) q.getSingleResult();
	}

	@Override
	public List<Cours> listOfNonAssignedCours() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("FROM Cours c where c.enseignant IS EMPTY");
		return q.getResultList();
	}

}
