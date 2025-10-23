package sv.edu.udb.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.udb.controller.request.AerolineaRequest;
import sv.edu.udb.model.Aerolinea;
import sv.edu.udb.repository.AerolineaRepository;
import sv.edu.udb.service.mapper.AerolineaMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AerolineaService {
    private final AerolineaRepository aerolineaRepo;
    private final AerolineaMapper aerolineaMapper;

    public List<Aerolinea> findAll() {
        return aerolineaRepo.findAll();
    }

    public Aerolinea findById(Long id) {
        return aerolineaRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Aerolínea no encontrada; id: " + id));
    }

    public Aerolinea save(AerolineaRequest request) {
        return aerolineaRepo.save(aerolineaMapper.toAerolinea(request));
    }

    public Aerolinea update(Long id, AerolineaRequest request) {
        final Aerolinea oldAerolinea = findById(id);
        final Aerolinea newAerolinea = aerolineaMapper.toAerolinea(request);

        oldAerolinea.setNombre(newAerolinea.getNombre());
        oldAerolinea.setPaisOrigen(newAerolinea.getPaisOrigen());
        return aerolineaRepo.save(oldAerolinea);
    }

    public void delete(Long id) {
        aerolineaRepo.deleteById(id);
    }
}
