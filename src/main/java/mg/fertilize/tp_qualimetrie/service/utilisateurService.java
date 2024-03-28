package mg.fertilize.tp_qualimetrie.service;

import mg.fertilize.tp_qualimetrie.entity.Utilisateur;

public interface utilisateurService {
    public Utilisateur findByIdUtilisateur(long id);
    void addUtilisateur(Utilisateur utilisateur);
    void updateUtilisateur(Utilisateur utilisateur);
    void deleteUtilisateur(Utilisateur utilisateur);
}
