
package sv.edu.udb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Controller
public class HomeController {


    @GetMapping("/vuelos")
    public String redirectToVuelos() {
        return "redirect:/Vuelo.html";
    }


}