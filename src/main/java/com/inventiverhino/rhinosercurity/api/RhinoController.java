package com.inventiverhino.rhinosercurity.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RhinoController {

    @GetMapping("/")
    public String greet() {
        return "Hello Rhino!";
    }

    @GetMapping("/private")
    public String greetPrivately() {
        return "Hello from Secret Alien planet...";
    }
}
