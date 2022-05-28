package br.com.julioneto.desafiocrud.controllers;

import br.com.julioneto.desafiocrud.utils.Messages;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<Messages> healthTest() {
        return ResponseEntity.ok().body(new Messages(200, "API Ok!"));
    }
}
