package com.inventiverhino.rhinosercurity.api;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RhinoController {

    @GetMapping("/")
    public String greet() {
        return "Hello Rhino!";
    }

    @GetMapping("/private")
    public String greetPrivately(Authentication authentication) {
        return "Hello " + getName(authentication) + ",from Secret Alien planet...";
    }

    private String getName(Authentication authentication) {
        return Optional.of(authentication.getPrincipal())
                .filter(OidcUser.class::isInstance)
                .map(OidcUser.class::cast)
                .map(OidcUser::getEmail)
                .orElseGet(authentication::getName);
    }
}
