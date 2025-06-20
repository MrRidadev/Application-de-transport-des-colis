package org.example.deliverymatch.controller;


import org.example.deliverymatch.DTO.LoginRequest;
import org.example.deliverymatch.DTO.RegisterRequest;
import org.example.deliverymatch.entity.Administrateur;
import org.example.deliverymatch.entity.Conducteur;
import org.example.deliverymatch.entity.Expediteur;
import org.example.deliverymatch.entity.Role;
import org.example.deliverymatch.repository.AdministrateurRepository;
import org.example.deliverymatch.repository.ConducteurRepository;
import org.example.deliverymatch.repository.ExpediteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private AdministrateurRepository adminRepo;
    @Autowired private ConducteurRepository conducteurRepo;
    @Autowired private ExpediteurRepository expediteurRepo;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        try {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.email, request.password)
            );
            return ResponseEntity.ok("Login successful");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        String encodedPassword = passwordEncoder.encode(request.password);

        switch (request.role.toLowerCase()) {
            case "administrateur":
                Administrateur admin = new Administrateur();
                admin.setNomComplet(request.nomComplet);
                admin.setEmail(request.email);
                admin.setPassword(encodedPassword);
                admin.setRole(Role.Administrateur);
                adminRepo.save(admin);
                break;

            case "conducteur":
                Conducteur conducteur = new Conducteur();
                conducteur.setNomComplet(request.nomComplet);
                conducteur.setEmail(request.email);
                conducteur.setPassword(encodedPassword);
                conducteur.setRole(Role.Conducteur);
                conducteurRepo.save(conducteur);
                break;

            case "expediteur":
                Expediteur expediteur = new Expediteur();
                expediteur.setNomComplet(request.nomComplet);
                expediteur.setEmail(request.email);
                expediteur.setPassword(encodedPassword);
                expediteur.setRole(Role.Expediteur);
                expediteurRepo.save(expediteur);
                break;

            default:
                return ResponseEntity.badRequest().body("Invalid role");
        }

        return ResponseEntity.ok("User registered successfully");
    }
}
