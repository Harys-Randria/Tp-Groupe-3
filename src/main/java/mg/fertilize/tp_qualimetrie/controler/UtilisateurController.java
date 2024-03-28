package mg.fertilize.tp_qualimetrie.controler;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UtilisateurController {
    @GetMapping
    String utilisateur(Model model) {
        return "utilisateur";
    }
}
