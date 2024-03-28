package mg.fertilize.tp_qualimetrie.controler;

import mg.fertilize.tp_qualimetrie.repository.UtilisateurRepository;
import mg.fertilize.tp_qualimetrie.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UtilisateurController {

    @Autowired
    UtilisateurRepository usersRepository;
    @PostMapping("/usersadd")
    public void add(@ModelAttribute Utilisateur utilisateur){
        usersRepository.save(utilisateur);
    }

}
