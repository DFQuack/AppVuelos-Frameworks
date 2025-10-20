package sv.edu.udb.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.udb.controller.request.VueloRequest;
import sv.edu.udb.model.Vuelo;
import sv.edu.udb.repository.VueloRepository;
import sv.edu.udb.service.mapper.VueloMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VueloService {
    private final VueloRepository vueloRepo;
    private final VueloMapper vueloMapper;

    public List<Vuelo> findAll() {
        return vueloRepo.findAll();
    }

    public Vuelo findById(Long id) {
        return vueloRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Vuelo no encontrado; id: " + id));
    }

    public Vuelo save(VueloRequest vueloRequest) {
        return vueloRepo.save(vueloMapper.toVuelo(vueloRequest));
    }

    public Vuelo update(Long id, VueloRequest vueloRequest) {
        final Vuelo oldVuelo = findById(id);
        final Vuelo newVuelo = vueloMapper.toVuelo(vueloRequest);

        oldVuelo.setCiudadOrigen(newVuelo.getCiudadOrigen());
        oldVuelo.setCiudadDestino(newVuelo.getCiudadDestino());
        oldVuelo.setDuracion(newVuelo.getDuracion());
        oldVuelo.setHoraSalida(newVuelo.getHoraSalida());
        oldVuelo.setTarifa(newVuelo.getTarifa());
        oldVuelo.setEstado(newVuelo.getEstado());

        return vueloRepo.save(oldVuelo);
    }

    public void delete(Long id) {
        vueloRepo.deleteById(id);
    }
}
