package mg.fertilize.tp_qualimetrie.controler;

import ch.qos.logback.core.model.Model;
import mg.fertilize.tp_qualimetrie.entity.UsersRepository;
import mg.fertilize.tp_qualimetrie.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UtilisateurController {

    @Autowired
    UsersRepository usersRepository;

    @PostMapping("/index")
    public Utilisateur addUsers(@RequestBody Utilisateur utilisateur) {
        return usersRepository.save(utilisateur);
    }


}
