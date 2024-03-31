package mg.fertilize.tp_qualimetrie.controler;


import mg.fertilize.tp_qualimetrie.entity.UsersRepository;
import mg.fertilize.tp_qualimetrie.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/index")
public class UtilisateurController {

    @Autowired
    UsersRepository usersRepository;

    @PostMapping("/index.html")
    public Utilisateur addUsers(@RequestBody Utilisateur utilisateur) {
        return usersRepository.save(utilisateur);
    }

    @PostMapping("/Utilisateur/Authentification")
    public RedirectView connection(@RequestParam String username, @RequestParam String password) {
        System.out.println("andrana ra tonga eto");
        System.out.println(username + password);
        Utilisateur uti = usersRepository.findByUsernameAndPassword(username, password);
        System.out.println(uti);
        return new RedirectView("/dashboard.html");
    }


}
