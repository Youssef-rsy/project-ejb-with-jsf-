package metier.Session;

import java.util.List;

import javax.ejb.Remote;

import metier.Entity.Permanent;

@Remote
public interface PermanentRemote {
	public Permanent addPermanent(Permanent permanent);
	public Permanent updatePermanent(Permanent permanent);
	public List<Permanent> allPermanent();
	public void deletePermanent(long id);
	public Permanent getPermanent(long id);
}
