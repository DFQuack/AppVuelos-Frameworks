package sv.edu.udb.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.udb.controller.request.TripulanteRequest;
import sv.edu.udb.model.Tripulante;
import sv.edu.udb.repository.TripulanteRepository;
import sv.edu.udb.service.mapper.TripulanteMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TripulanteService {
    private final TripulanteRepository tripRepo;
    private final TripulanteMapper tripMapper;

    public List<Tripulante> findAll() {
        return tripRepo.findAll();
    }

    public Tripulante findById(Long id) {
        return tripRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Tripulante no encontrado; id: " + id));
    }

    public Tripulante save(TripulanteRequest request) {
        return tripRepo.save(tripMapper.toTripulante(request));
    }

    public Tripulante update(Long id, TripulanteRequest request) {
        final Tripulante oldTrip = findById(id);
        final Tripulante newTrip = tripMapper.toTripulante(request);

        oldTrip.setNombreCompleto(newTrip.getNombreCompleto());
        oldTrip.setFechaNacimiento(newTrip.getFechaNacimiento());
        oldTrip.setRol(newTrip.getRol());
        oldTrip.setAerolinea(newTrip.getAerolinea());

        return tripRepo.save(oldTrip);
    }

    public void delete(Long id) {
        tripRepo.deleteById(id);
    }
}
