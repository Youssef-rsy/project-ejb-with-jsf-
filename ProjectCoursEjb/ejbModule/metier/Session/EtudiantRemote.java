package metier.Session;

import java.util.List;

import javax.ejb.Remote;

import metier.Entity.Etudiant;
@Remote
public interface EtudiantRemote {
	public Etudiant addEtudiant(Etudiant etudiant);
	public Etudiant updateEtudiant(Etudiant etudiant);
	public List<Etudiant> allEtudiant();
	public void deleteEtudiant(long id);
	public Etudiant getEtudiant(long id);
}
