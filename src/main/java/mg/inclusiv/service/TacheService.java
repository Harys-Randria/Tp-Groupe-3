package mg.inclusiv.service;

import mg.inclusiv.entity.Tache;
import mg.inclusiv.repository.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
public class TacheService {
    @Autowired
    TacheRepository tacheRepository;
    public Tache addTache(String description,Long id){
        Tache tache = new Tache();
        tache.setDescription(description);
        tache.setUtilisateurid(id);
        tache.setStatus(false);

        return tacheRepository.save(tache);
    }
    public List<Tache> getAllTaches(Long id) {
        return tacheRepository.findByUtilisateurid(id);
    }

    public void deleteTache(Long id) {
        tacheRepository.deleteById(id);
    }

    public Tache updateTache(Long id, Tache tache){
        Tache ta = tacheRepository.findById(id).orElse(null);
        ta.setDescription(tache.getDescription());
        return tacheRepository.save(ta);
    }

    public Tache changeStatus(Long id, Tache tache){
        Tache ta = tacheRepository.findById(id).orElse(null);
        ta.setStatus(!ta.isStatus());
        return tacheRepository.save(ta);
    }
}
