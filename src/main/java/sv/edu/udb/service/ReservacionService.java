package sv.edu.udb.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.udb.controller.request.ReservacionRequest;
import sv.edu.udb.model.Reservacion;
import sv.edu.udb.repository.ReservacionRepository;
import sv.edu.udb.service.mapper.ReservacionMapper;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReservacionService {
    private final ReservacionRepository reservacionRepo;
    private final ReservacionMapper reservacionMapper;

    public List<Reservacion> findAll() {
        return reservacionRepo.findAll();
    }

    public Reservacion findById(UUID id) {
        return reservacionRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Reservación no encontrada; id: " + id));
    }

    public Reservacion save(ReservacionRequest reservacionRequest) {
        return reservacionRepo.save(reservacionMapper.toReservacion(reservacionRequest));
    }

    public Reservacion update(UUID id, ReservacionRequest reservacionRequest) {
        final Reservacion oldReservacion = findById(id);
        final Reservacion newReservacion = reservacionMapper.toReservacion(reservacionRequest);

        oldReservacion.setFecha(newReservacion.getFecha());
        oldReservacion.setEstado(newReservacion.getEstado());
        oldReservacion.setVuelo(newReservacion.getVuelo());
        oldReservacion.setPasajeros(newReservacion.getPasajeros());
        oldReservacion.setUsuario(newReservacion.getUsuario());
        oldReservacion.setPago(newReservacion.getPago());

        return reservacionRepo.save(oldReservacion);
    }

    public void delete(UUID id) {
        reservacionRepo.deleteById(id);
    }
}
