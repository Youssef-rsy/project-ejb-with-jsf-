package metier.Session;


import java.util.List;

import metier.Entity.Enseignant;


public interface EnseignantLocal {
	public Enseignant addEnseignant(Enseignant enseignant);
	public Enseignant updateEnseignant(Enseignant enseignant);
	public List<Enseignant> allEnseignant();
	public void deleteEnseignant(long id);
	public Enseignant getEnseignant(long id);
}
