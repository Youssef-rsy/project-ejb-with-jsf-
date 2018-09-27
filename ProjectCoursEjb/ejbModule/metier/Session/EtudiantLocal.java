package metier.Session;

import java.util.List;

import javax.ejb.Local;

import metier.Entity.Etudiant;
@Local
public interface EtudiantLocal {
	public Etudiant addEtudiant(Etudiant etudiant);
	public Etudiant updateEtudiant(Etudiant etudiant);
	public List<Etudiant> allEtudiant();
	public void deleteEtudiant(long id);
	public Etudiant getEtudiant(long id);
}
