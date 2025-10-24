package sv.edu.udb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.edu.udb.model.Reservacion;

import java.util.List;
import java.util.UUID;

public interface ReservacionRepository extends JpaRepository<Reservacion, UUID> {
    List<Reservacion> findAllByUsuario_Id(Long id);
}
