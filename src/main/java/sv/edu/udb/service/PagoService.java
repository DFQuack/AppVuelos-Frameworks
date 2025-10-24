package sv.edu.udb.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.udb.controller.request.PagoRequest;
import sv.edu.udb.model.Pago;
import sv.edu.udb.model.Reservacion;
import sv.edu.udb.repository.PagoRepository;
import sv.edu.udb.repository.ReservacionRepository;
import sv.edu.udb.service.mapper.PagoMapper;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PagoService {
    private final PagoRepository pagoRepo;
    private final ReservacionRepository reservaRepo;
    private final PagoMapper pagoMapper;

    public List<Pago> findAll() {
        return pagoRepo.findAll();
    }

    public Pago findById(UUID id) {
        return pagoRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Pago no encontrado; id: " + id));
    }

    public Pago save(PagoRequest request) {
        final Pago pago = pagoMapper.toPago(request);
        final Reservacion reserva = reservaRepo.findById(pago.getReservacion().getId()).orElse(null);
        if (reserva != null) {
            pago.setReservacion(reserva);
            return pagoRepo.save(pago);
        }
        return pago;
    }

    public Pago update(UUID id, PagoRequest request) {
        final Pago oldPago = findById(id);
        final Pago newPago = pagoMapper.toPago(request);
        
        oldPago.setMonto(newPago.getMonto());
        oldPago.setFecha(newPago.getFecha());
        oldPago.setReservacion(newPago.getReservacion());
        
        return pagoRepo.save(oldPago);
    }
    
    public void delete(UUID id) {
        pagoRepo.deleteById(id);
    }
}
