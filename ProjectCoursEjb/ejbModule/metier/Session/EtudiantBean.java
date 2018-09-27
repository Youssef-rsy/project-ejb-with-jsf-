package metier.Session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import metier.Entity.Enseignant;
import metier.Entity.Etudiant;
@Stateless

public class EtudiantBean implements EtudiantLocal  , EtudiantRemote  {
	@PersistenceContext(unitName="ProjectCoursEjb")
	private EntityManager em;
	
	@Override
	public Etudiant addEtudiant(Etudiant etudiant) {
		// TODO Auto-generated method stub
		em.persist(etudiant);
		return etudiant;
	}

    @Transactional
	@Override
	public Etudiant updateEtudiant(Etudiant etudiant) {
		// TODO Auto-generated method stub
		Etudiant et = em.find(Etudiant.class, etudiant.getId());
		System.out.println(et.getNom());
		em.merge(et);
		
		return etudiant;
	}

	@Override
	public List<Etudiant> allEtudiant() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("from Etudiant");
		return q.getResultList();
	}

	@Override
	public void deleteEtudiant(long id) {
		// TODO Auto-generated method stub
		em.remove(getEtudiant(id));
	}

	@Override
	public Etudiant getEtudiant(long id) {
		// TODO Auto-generated method stub
		return em.find(Etudiant.class, id);
	}


}
