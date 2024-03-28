package mg.fertilize.tp_qualimetrie.repository;

import mg.fertilize.tp_qualimetrie.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

}
