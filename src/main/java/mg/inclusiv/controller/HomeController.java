package mg.inclusiv.controller;

import mg.inclusiv.entity.Tache;
import mg.inclusiv.entity.Utilisateur;
import mg.inclusiv.service.TacheService;
import mg.inclusiv.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private TacheService tacheService;

    @RequestMapping("/")
    public String home(Model model) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Utilisateur user = userDetails.getUser();

        List<Tache> taches = tacheService.getAllTaches(user.getId());

        model.addAttribute("taches", taches);
        return "index.html";
    }
}
