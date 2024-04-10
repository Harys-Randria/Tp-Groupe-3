package mg.inclusiv.controller;

import mg.inclusiv.entity.Utilisateur;
import mg.inclusiv.repository.UtilisateurRepository;
import mg.inclusiv.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/utilisateur")
public class UtilisateurController {

    @Autowired
    UtilisateurService utilisateurService;


    @PostMapping(path = "/save")
    private String saveUser(@ModelAttribute Utilisateur utilisateur){
        utilisateurService.addUtilisateur(utilisateur);
        return "redirect:/";
    }


}
