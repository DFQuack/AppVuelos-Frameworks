package sv.edu.udb.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.controller.request.CancelacionRequest;
import sv.edu.udb.model.Cancelacion;
import sv.edu.udb.service.CancelacionService;

import java.util.List;

@RestController
@RequestMapping("/api/cancelaciones")
@RequiredArgsConstructor
public class CancelacionRestController {
    private final CancelacionService cancelService;

    @GetMapping
    public List<Cancelacion> findAll() {
        return cancelService.findAll();
    }

    @GetMapping("/{id}")
    public Cancelacion findById(@PathVariable final Long id) {
        return cancelService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cancelacion save(@RequestBody @Valid final CancelacionRequest request) {
        return cancelService.save(request);
    }

    @PutMapping("/{id}")
    public Cancelacion update(@PathVariable final Long id, @RequestBody @Valid final CancelacionRequest request) {
        return cancelService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final Long id) {
        cancelService.delete(id);
    }
}
