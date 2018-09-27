package metier.Session;

import java.util.List;

import javax.ejb.Local;

import metier.Entity.Permanent;

@Local
public interface PermanentLocal {
	public Permanent addPermanent(Permanent permanent);
	public Permanent updatePermanent(Permanent permanent);
	public List<Permanent> allPermanent();
	public void deletePermanent(long id);
	public Permanent getPermanent(long id);
}
