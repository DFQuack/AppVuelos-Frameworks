package sv.edu.udb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.edu.udb.model.Pasajero;

public interface PasajeroRepository extends JpaRepository<Pasajero, Long> {
}
