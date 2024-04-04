package mg.inclusiv.service;

import lombok.AllArgsConstructor;
import mg.inclusiv.entity.Utilisateur;
import mg.inclusiv.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {

    @Autowired
    UtilisateurRepository utilisateurRepository;
    public Utilisateur addUtilisateur (Utilisateur utilisateur){
      return utilisateurRepository.save(utilisateur);
    }
}
