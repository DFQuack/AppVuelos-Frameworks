package sv.edu.udb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.edu.udb.model.Pago;

import java.util.UUID;

public interface PagoRepository extends JpaRepository<Pago, UUID> {
}
