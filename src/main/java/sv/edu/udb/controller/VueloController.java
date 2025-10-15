package sv.edu.udb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sv.edu.udb.service.VueloService;

@Controller
@RequestMapping("/vuelos")
@RequiredArgsConstructor
public class VueloController {
    private final VueloService vueloService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("vuelos", vueloService.findAll());
        return "vuelos";
    }
}
