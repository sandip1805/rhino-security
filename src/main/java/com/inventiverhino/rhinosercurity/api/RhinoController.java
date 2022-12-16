package com.inventiverhino.rhinosercurity.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RhinoController {

    @GetMapping("/")
    public String greet() {
        return "Hello Rhino!";
    }

    @GetMapping("/{name}")
    public String greetPrivately(@PathVariable String name) {
        return "Hello " + name;
    }
}
