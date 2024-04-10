package mg.inclusiv.repository;

import mg.inclusiv.entity.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TacheRepository extends JpaRepository<Tache,Long> {
    List<Tache> findByUtilisateurid(Long userId);
}
