package sv.edu.udb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.edu.udb.model.Reclamo;

public interface ReclamoRepository extends JpaRepository<Reclamo, Long> {
}
