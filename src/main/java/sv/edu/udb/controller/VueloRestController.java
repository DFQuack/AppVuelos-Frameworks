package sv.edu.udb.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.controller.request.VueloRequest;
import sv.edu.udb.model.Vuelo;
import sv.edu.udb.service.VueloService;

import java.util.List;

@RestController
@RequestMapping("/api/vuelos")
@RequiredArgsConstructor
public class VueloRestController {
    private final VueloService vueloService;

    @GetMapping
    public List<Vuelo> findAll() {
        return vueloService.findAll();
    }

    @GetMapping("/{id}")
    public Vuelo findById(@PathVariable final Long id) {
        return vueloService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vuelo save(@RequestBody @Valid final VueloRequest vueloRequest) {
        return vueloService.save(vueloRequest);
    }

    @PutMapping("/{id}")
    public Vuelo update(@PathVariable final Long id, @RequestBody @Valid final VueloRequest vueloRequest) {
        return vueloService.update(id, vueloRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final Long id) {
        vueloService.delete(id);
    }
}
