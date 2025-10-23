package sv.edu.udb.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.controller.request.ReclamoRequest;
import sv.edu.udb.model.Reclamo;
import sv.edu.udb.service.ReclamoService;

import java.util.List;

@RestController
@RequestMapping("/api/reclamos")
@RequiredArgsConstructor
public class ReclamoRestController {
    private final ReclamoService reclamoService;

    @GetMapping
    public List<Reclamo> findAll() {
        return reclamoService.findAll();
    }

    @GetMapping("/{id}")
    public Reclamo findById(@PathVariable final Long id) {
        return reclamoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reclamo save(@RequestBody @Valid final ReclamoRequest request) {
        return reclamoService.save(request);
    }

    @PutMapping("/{id}")
    public Reclamo update(@PathVariable final Long id, @RequestBody @Valid final ReclamoRequest request) {
        return reclamoService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final Long id) {
        reclamoService.delete(id);
    }
}
