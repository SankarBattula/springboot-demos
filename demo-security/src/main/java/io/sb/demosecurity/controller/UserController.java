package io.sb.demosecurity.controller;

import io.sb.demosecurity.entity.User;
import io.sb.demosecurity.model.JwtTokenRequest;
import io.sb.demosecurity.model.UserPrincipal;
import io.sb.demosecurity.service.TokenProvider;
import io.sb.demosecurity.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/security")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    private UserService userService;

    @PostMapping("/generate-token")
    public ResponseEntity generateToken(@RequestBody JwtTokenRequest tokenRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(tokenRequest.getUsername(), tokenRequest.getPassword())
        );
        String token = tokenProvider.generateToken((UserPrincipal)authentication.getPrincipal());
        LOGGER.info("Token generated {}", token);
        return ResponseEntity.ok(token);
    }

    @GetMapping("/user/all")
    public ResponseEntity getAllUsers() {
        List<User> userList = userService.getAllUsers();
        return ResponseEntity.ok(userList);
    }
}