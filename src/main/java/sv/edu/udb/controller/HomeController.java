
package sv.edu.udb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Controller
public class HomeController {

    @GetMapping("/index")
    public String index() {
        return "redirect:/index.html";
    }

    @GetMapping("/vuelos")
    public String redirectToVuelos() {
        return "redirect:/Vuelo.html";
    }
    @GetMapping("/Reservaciones")
    public String redirectToReservaciones() {
        return "redirect:/ReservacionForm.html";
    }
    @GetMapping("/Pasajero")
    public String redirectToPasajero() {
        return "redirect:/PasajeroForm.html";
    }

}