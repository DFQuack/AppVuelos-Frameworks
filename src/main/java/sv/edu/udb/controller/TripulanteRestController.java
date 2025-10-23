package sv.edu.udb.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.controller.request.TripulanteRequest;
import sv.edu.udb.model.Tripulante;
import sv.edu.udb.service.TripulanteService;

import java.util.List;

@RestController
@RequestMapping("/api/tripulantes")
@RequiredArgsConstructor
public class TripulanteRestController {
    private final TripulanteService tripService;

    @GetMapping
    public List<Tripulante> findAll() {
        return tripService.findAll();
    }

    @GetMapping("/{id}")
    public Tripulante findById(@PathVariable final Long id) {
        return tripService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tripulante save(@RequestBody @Valid final TripulanteRequest request) {
        return tripService.save(request);
    }

    @PutMapping("/{id}")
    public Tripulante update(@PathVariable final Long id, @RequestBody @Valid final TripulanteRequest request) {
        return tripService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final Long id) {
        tripService.delete(id);
    }
}
