package metier.Session;

import java.util.List;

import javax.ejb.Remote;

import metier.Entity.Vacataire;

@Remote
public interface VacataireRemote{

	public Vacataire addVacataire(Vacataire vacataire);
	public Vacataire updateVacataire(Vacataire vacataire);
	public List<Vacataire> allVacataire();
	public void deleteVacataire(long id);
	public Vacataire getVacataire(long id);
}
