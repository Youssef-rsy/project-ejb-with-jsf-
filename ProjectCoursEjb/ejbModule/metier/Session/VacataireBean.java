package metier.Session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.Entity.Vacataire;
@Stateless

public class VacataireBean implements VacataireLocal , VacataireRemote {

	@PersistenceContext(unitName="ProjectCoursEjb")
	private EntityManager em;
	
	@Override
	public Vacataire addVacataire(Vacataire vacataire) {
		// TODO Auto-generated method stub
		em.persist(vacataire);
		return vacataire;
	}

	@Override
	public Vacataire updateVacataire(Vacataire vacataire) {
		// TODO Auto-generated method stub
		 em.merge(vacataire);
		return vacataire;
	}

	@Override
	public List<Vacataire> allVacataire() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("from Vacataire");
		return q.getResultList();
	}

	@Override
	public void deleteVacataire(long id) {
		// TODO Auto-generated method stub
		em.remove(getVacataire(id));
	}

	@Override
	public Vacataire getVacataire(long id) {
		// TODO Auto-generated method stub
		return em.find(Vacataire.class, id);
	}


}
