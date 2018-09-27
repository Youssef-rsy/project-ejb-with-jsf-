package metier.Session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.Entity.Permanent;
@Stateless

public class PermanentBean implements PermanentLocal ,  PermanentRemote {

	@PersistenceContext(unitName="ProjectCoursEjb")
	private EntityManager em;
	
	@Override
	public Permanent addPermanent(Permanent permanent) {
		// TODO Auto-generated method stub
		em.persist(permanent);
		System.out.println(permanent.getNom() +" "+ permanent.getPrenom() +" "+permanent.getAdresse().getRue()+" "+permanent.getAdresse().getVille()+" " );
		return permanent;
	}

	@Override
	public Permanent updatePermanent(Permanent permanent) {
		// TODO Auto-generated method stub
		System.out.println(permanent.getNom() +" "+ permanent.getPrenom() +" "+permanent.getAdresse().getRue()+" "+permanent.getAdresse().getVille()+" " );
		for(int i =0; i<permanent.getCours().size() ;i++){
			System.out.println(permanent.getCours().get(0).getNom()); 
		}
		em.merge(permanent);
		return permanent;
	}

	@Override
	public List<Permanent> allPermanent() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("from Permanent");
		return q.getResultList();
	}

	@Override
	public void deletePermanent(long id) {
		// TODO Auto-generated method stub
		em.remove(getPermanent(id));
	}

	@Override
	public Permanent getPermanent(long id) {
		// TODO Auto-generated method stub
		return em.find(Permanent.class, id);
	}


}
