package sv.edu.udb.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.udb.controller.request.CancelacionRequest;
import sv.edu.udb.model.Cancelacion;
import sv.edu.udb.model.EstadoReserva;
import sv.edu.udb.model.Reservacion;
import sv.edu.udb.repository.CancelacionRepository;
import sv.edu.udb.repository.ReservacionRepository;
import sv.edu.udb.service.mapper.CancelacionMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CancelacionService {
    private final CancelacionRepository cancelRepo;
    private final ReservacionRepository reservaRepo;
    private final CancelacionMapper cancelMapper;

    public List<Cancelacion> findAll() {
        return cancelRepo.findAll();
    }

    public Cancelacion findById(Long id) {
        return cancelRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Cancelación no encontrada; id: " + id));
    }

    public Cancelacion save(CancelacionRequest request) {
        final Cancelacion cancel = cancelMapper.toCancelacion(request);
        final Reservacion reserva = reservaRepo.findById(cancel.getReservacion().getId()).orElse(null);
        if (reserva != null) {
            cancel.setReservacion(reserva);
            reserva.setEstado(EstadoReserva.CANCELADA);
            return cancelRepo.save(cancel);
        }
        return cancel;
    }

    public Cancelacion update(Long id, CancelacionRequest request) {
        final Cancelacion oldCancel = findById(id);
        final Cancelacion newCancel = cancelMapper.toCancelacion(request);

        oldCancel.setFecha(newCancel.getFecha());
        oldCancel.setReservacion(newCancel.getReservacion());

        return cancelRepo.save(oldCancel);
    }

    public void delete(Long id) {
        cancelRepo.deleteById(id);
    }
}
