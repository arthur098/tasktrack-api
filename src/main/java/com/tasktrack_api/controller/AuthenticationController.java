package com.tasktrack_api.controller;

import com.tasktrack_api.model.User;
import com.tasktrack_api.model.dto.AuthenticationRequest;
import com.tasktrack_api.security.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody AuthenticationRequest authenticationRequest ) {
        var usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authenticationRequest.username(), authenticationRequest.password());
        var authentication = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        String token = this.tokenService.generateToken((User) authentication.getPrincipal());

        return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + token).build();
    }
}
