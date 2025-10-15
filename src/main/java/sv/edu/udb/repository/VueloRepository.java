package sv.edu.udb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.edu.udb.model.Vuelo;

public interface VueloRepository extends JpaRepository<Vuelo, Long> {
}
