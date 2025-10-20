package sv.edu.udb.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.udb.controller.request.PasajeroRequest;
import sv.edu.udb.model.Pasajero;
import sv.edu.udb.repository.PasajeroRepository;
import sv.edu.udb.service.mapper.PasajeroMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PasajeroService {
    private final PasajeroRepository pasajeroRepo;
    private final PasajeroMapper pasajeroMapper;

    public List<Pasajero> findAll() {
        return pasajeroRepo.findAll();
    }

    public Pasajero findById(Long id) {
        return pasajeroRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Pasajero no encontrado; id: " + id));
    }

    public Pasajero save(PasajeroRequest pasajeroRequest) {
        return pasajeroRepo.save(pasajeroMapper.toPasajero(pasajeroRequest));
    }

    public Pasajero update(Long id, PasajeroRequest pasajeroRequest) {
        final Pasajero oldPasajero = findById(id);
        final Pasajero newPasajero = pasajeroMapper.toPasajero(pasajeroRequest);

        oldPasajero.setNombres(newPasajero.getNombres());
        oldPasajero.setApellidos(newPasajero.getApellidos());
        oldPasajero.setGenero(newPasajero.getGenero());
        oldPasajero.setGrupoEtario(newPasajero.getGrupoEtario());
        oldPasajero.setFechaNacimiento(newPasajero.getFechaNacimiento());
        oldPasajero.setPasaporte(newPasajero.getPasaporte());
        oldPasajero.setPasaporte(newPasajero.getPasaporte());

        return pasajeroRepo.save(oldPasajero);
    }

    public void delete(Long id) {
        pasajeroRepo.deleteById(id);
    }
}
