package mg.inclusiv.controller;

import mg.inclusiv.entity.Tache;
import mg.inclusiv.entity.Utilisateur;
import mg.inclusiv.service.TacheService;
import mg.inclusiv.service.UserDetailsImpl;
import mg.inclusiv.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/tache")
public class TacheController {

    @Autowired
    TacheService tacheService;

    @Autowired
    UtilisateurService utilisateurService;

    @PostMapping("/save")
    public String saveTache(String description) {

        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Utilisateur user = userDetails.getUser();
        tacheService.addTache(description, user.getId());
        return "redirect:/";
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteTache(@PathVariable(name = "id") long id) {
        tacheService.deleteTache(id);
        return "redirect:/";
    }

    @PostMapping(path = "/update/{id}")
    public String updateTache(@PathVariable(name = "id") long id, @ModelAttribute Tache tache){

        tacheService.updateTache(id,tache);
        return "redirect:/";
    }

    @RequestMapping(path = "/changeStatus/{id}")
    public String changeStatus(@PathVariable(name = "id") long id , @ModelAttribute Tache tache) {
        tacheService.changeStatus(id,tache);
        return "redirect:/";
    }



}
