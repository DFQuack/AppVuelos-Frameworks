package sv.edu.udb.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.udb.model.Vuelo;
import sv.edu.udb.repository.VueloRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VueloService {
    private final VueloRepository vueloRepo;

    public List<Vuelo> findAll() {
        return vueloRepo.findAll();
    }

    public Vuelo findById(Long id) {
        return vueloRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Vuelo no encontrado; id: " + id));
    }

    public Vuelo save(Vuelo vuelo) {
        return vueloRepo.save(vuelo);
    }

    public Vuelo update(Long id, Vuelo vuelo) {
        final Vuelo oldVuelo = vueloRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Vuelo no encontrado; id: " + id));

        oldVuelo.setCiudadOrigen(vuelo.getCiudadOrigen());
        oldVuelo.setCiudadDestino(vuelo.getCiudadDestino());
        oldVuelo.setDuracionEstimada(vuelo.getDuracionEstimada());
        oldVuelo.setHoraSalida(vuelo.getHoraSalida());
        oldVuelo.setTarifa(vuelo.getTarifa());
        oldVuelo.setEstado(vuelo.getEstado());

        return vueloRepo.save(oldVuelo);
    }

    public void delete(Long id) {
        vueloRepo.deleteById(id);
    }
}
