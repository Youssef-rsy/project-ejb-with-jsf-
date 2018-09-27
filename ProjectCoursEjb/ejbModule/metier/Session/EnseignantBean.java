package metier.Session;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.Entity.Enseignant;



@Stateless
public class EnseignantBean implements EnseignantLocal {

	@PersistenceContext(unitName="ProjectCoursEjb")
	private EntityManager em;
	
	@Override
	public Enseignant addEnseignant(Enseignant enseignant) {
		// TODO Auto-generated method stub
		em.persist(enseignant);
		return enseignant;
	}

	@Override
	public Enseignant updateEnseignant(Enseignant enseignant) {
		// TODO Auto-generated method stub
		 em.merge(enseignant);
		return enseignant;
	}

	@Override
	public List<Enseignant> allEnseignant() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("from Enseignant");
		return q.getResultList();
	}

	@Override
	public void deleteEnseignant(long id) {
		// TODO Auto-generated method stub
		em.remove(getEnseignant(id));
	}

	@Override
	public Enseignant getEnseignant(long id) {
		// TODO Auto-generated method stub
		return em.find(Enseignant.class, id);
	}

}
