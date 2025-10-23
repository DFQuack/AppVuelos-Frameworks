package sv.edu.udb.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.udb.controller.request.ReclamoRequest;
import sv.edu.udb.model.Reclamo;
import sv.edu.udb.repository.ReclamoRepository;
import sv.edu.udb.service.mapper.ReclamoMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReclamoService {
    private final ReclamoRepository reclamoRepo;
    private final ReclamoMapper reclamoMapper;

    public List<Reclamo> findAll() {
        return reclamoRepo.findAll();
    }

    public Reclamo findById(Long id) {
        return reclamoRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Reclamo no encontrado; id: " + id));
    }

    public Reclamo save(ReclamoRequest request) {
        return reclamoRepo.save(reclamoMapper.toReclamo(request));
    }

    public Reclamo update(Long id, ReclamoRequest request) {
        final Reclamo oldReclamo = findById(id);
        final Reclamo newReclamo = reclamoMapper.toReclamo(request);

        oldReclamo.setComentario(newReclamo.getComentario());
        oldReclamo.setFecha(newReclamo.getFecha());
        oldReclamo.setEstado(newReclamo.getEstado());
        oldReclamo.setReservacion(newReclamo.getReservacion());

        return reclamoRepo.save(oldReclamo);
    }

    public void delete(Long id) {
        reclamoRepo.deleteById(id);
    }
}
