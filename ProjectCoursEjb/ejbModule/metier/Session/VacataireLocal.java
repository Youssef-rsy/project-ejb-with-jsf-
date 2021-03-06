package metier.Session;

import java.util.List;

import javax.ejb.Local;

import metier.Entity.Vacataire;

@Local
public interface VacataireLocal{

	public Vacataire addVacataire(Vacataire vacataire);
	public Vacataire updateVacataire(Vacataire vacataire);
	public List<Vacataire> allVacataire();
	public void deleteVacataire(long id);
	public Vacataire getVacataire(long id);
}
