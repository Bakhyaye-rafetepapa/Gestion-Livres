package sn.isep.dbe.livre.Gestion.Livre.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AcceuilController {

    @GetMapping("/")
    public String accueil() {
        return "index";
    }
}
