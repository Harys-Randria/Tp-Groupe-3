package mg.inclusiv.service;

import mg.inclusiv.entity.Utilisateur;
import mg.inclusiv.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    UtilisateurRepository utilisateurRepository;
    public Utilisateur addUtilisateur (Utilisateur utilisateur){
        return utilisateurRepository.save(utilisateur);
    }

    public Long utilisateurIdByUsername(String username) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findByUsername(username);
        Utilisateur result = utilisateur.get();
        return result.getId();
    }
}
