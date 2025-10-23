package sv.edu.udb.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.udb.controller.request.AvionRequest;
import sv.edu.udb.model.Avion;
import sv.edu.udb.repository.AvionRepository;
import sv.edu.udb.service.mapper.AvionMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvionService {
    private final AvionRepository avionRepo;
    private final AvionMapper avionMapper;

    public List<Avion> findAll() {
        return avionRepo.findAll();
    }

    public List<Avion> findAllByAerolinea(Long id) {
        return avionRepo.findAllByAerolinea_Id(id);
    }

    public Avion findById(Long id) {
        return avionRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Avión no encontrado; id: " + id));
    }

    public Avion save(AvionRequest request) {
        return avionRepo.save(avionMapper.toAvion(request));
    }

    public Avion update(Long id, AvionRequest request) {
        final Avion oldAvion = findById(id);
        final Avion newAvion = avionMapper.toAvion(request);

        oldAvion.setModelo(newAvion.getModelo());
        oldAvion.setCapacidad(newAvion.getCapacidad());
        oldAvion.setAerolinea(newAvion.getAerolinea());

        return avionRepo.save(oldAvion);
    }

    public void delete(Long id) {
        avionRepo.deleteById(id);
    }
}
