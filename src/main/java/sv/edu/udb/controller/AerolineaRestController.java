package sv.edu.udb.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.controller.request.AerolineaRequest;
import sv.edu.udb.model.Aerolinea;
import sv.edu.udb.service.AerolineaService;

import java.util.List;

@RestController
@RequestMapping("/api/aerolineas")
@RequiredArgsConstructor
public class AerolineaRestController {
    private final AerolineaService aerolineaService;

    @GetMapping
    public List<Aerolinea> findAll() {
        return aerolineaService.findAll();
    }

    @GetMapping("/{id}")
    public Aerolinea findById(@PathVariable final Long id) {
        return aerolineaService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aerolinea save(@RequestBody @Valid final AerolineaRequest request) {
        return aerolineaService.save(request);
    }

    @PutMapping("/{id}")
    public Aerolinea update(@PathVariable final Long id, @RequestBody @Valid final AerolineaRequest request) {
        return aerolineaService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final Long id) {
        aerolineaService.delete(id);
    }
}
