package sv.edu.udb.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.controller.request.ReservacionRequest;
import sv.edu.udb.model.Reservacion;
import sv.edu.udb.service.ReservacionService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/reservaciones")
@RequiredArgsConstructor
public class ReservacionRestController {
    private final ReservacionService reservacionService;

    @GetMapping
    public List<Reservacion> findAll() {
        return reservacionService.findAll();
    }

    @GetMapping("/usuario/{id}")
    public List<Reservacion> findAllByUsuario(@PathVariable final Long id) {
        return reservacionService.findAllByUsuario(id);
    }

    @GetMapping("/{id}")
    public Reservacion findById(@PathVariable final UUID id) {
        return reservacionService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reservacion save(@RequestBody @Valid final ReservacionRequest request) {
        return reservacionService.save(request);
    }

    @PutMapping("/{id}")
    public Reservacion update(@PathVariable final UUID id, @RequestBody @Valid final ReservacionRequest request) {
        return reservacionService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final UUID id) {
        reservacionService.delete(id);
    }
}
