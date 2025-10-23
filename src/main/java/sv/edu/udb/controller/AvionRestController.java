package sv.edu.udb.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.controller.request.AvionRequest;
import sv.edu.udb.model.Avion;
import sv.edu.udb.service.AvionService;

import java.util.List;

@RestController
@RequestMapping("/api/aviones")
@RequiredArgsConstructor
public class AvionRestController {
    private final AvionService avionService;

    @GetMapping
    public List<Avion> findAll() {
        return avionService.findAll();
    }

    @GetMapping("/aerolinea/{id}")
    public List<Avion> findAllByAerolinea(@PathVariable final Long id) {
        return avionService.findAllByAerolinea(id);
    }

    @GetMapping("/{id}")
    public Avion findById(@PathVariable final Long id) {
        return avionService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Avion save(@RequestBody @Valid final AvionRequest request) {
        return avionService.save(request);
    }

    @PutMapping("/{id}")
    public Avion update(@PathVariable final Long id, @RequestBody @Valid final AvionRequest request) {
        return avionService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final Long id) {
        avionService.delete(id);
    }
}
