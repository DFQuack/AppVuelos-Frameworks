package sv.edu.udb.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.controller.request.PasajeroRequest;
import sv.edu.udb.model.Pasajero;
import sv.edu.udb.service.PasajeroService;

import java.util.List;

@RestController
@RequestMapping("/api/pasajeros")
@RequiredArgsConstructor
public class PasajeroRestController {
    private final PasajeroService pasajeroService;

    @GetMapping
    public List<Pasajero> findAll() {
        return pasajeroService.findAll();
    }

    @GetMapping("/{id}")
    public Pasajero findById(@PathVariable final Long id) {
        return pasajeroService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pasajero save(@RequestBody @Valid final PasajeroRequest request) {
        return pasajeroService.save(request);
    }

    @PutMapping("/{id}")
    public Pasajero update(@PathVariable final Long id, @RequestBody @Valid final PasajeroRequest request) {
        return pasajeroService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final Long id) {
        pasajeroService.delete(id);
    }
}
