package sv.edu.udb.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.controller.request.PagoRequest;
import sv.edu.udb.model.Pago;
import sv.edu.udb.service.PagoService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/pagos")
@RequiredArgsConstructor
public class PagoRestController {
    private final PagoService pagoService;

    @GetMapping
    public List<Pago> findAll() {
        return pagoService.findAll();
    }

    @GetMapping("/{id}")
    public Pago findById(@PathVariable final UUID id) {
        return pagoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pago save(@RequestBody @Valid final PagoRequest request) {
        return pagoService.save(request);
    }

    @PutMapping("/{id}")
    public Pago update(@PathVariable final UUID id, @RequestBody @Valid final PagoRequest request) {
        return pagoService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final UUID id) {
        pagoService.delete(id);
    }
}
