package sv.edu.udb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.edu.udb.model.Avion;

import java.util.List;

public interface AvionRepository extends JpaRepository<Avion, Long> {
    List<Avion> findAllByAerolinea_Id(Long id);
}
