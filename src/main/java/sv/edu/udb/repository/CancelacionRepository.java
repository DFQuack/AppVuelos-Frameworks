package sv.edu.udb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.edu.udb.model.Cancelacion;

public interface CancelacionRepository extends JpaRepository<Cancelacion, Long> {
}
