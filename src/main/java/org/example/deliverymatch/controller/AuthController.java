package org.example.deliverymatch.controller;

import org.example.deliverymatch.DTO.AuthResponseDTO;
import org.example.deliverymatch.DTO.LoginRequest;
import org.example.deliverymatch.DTO.RegisterRequest;
import org.example.deliverymatch.entity.Administrateur;
import org.example.deliverymatch.entity.Conducteur;
import org.example.deliverymatch.entity.Expediteur;
import org.example.deliverymatch.entity.Role;
import org.example.deliverymatch.entity.User;
import org.example.deliverymatch.repository.AdministrateurRepository;
import org.example.deliverymatch.repository.ConducteurRepository;
import org.example.deliverymatch.repository.ExpediteurRepository;
import org.example.deliverymatch.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AdministrateurRepository adminRepo;
    @Autowired
    private ConducteurRepository conducteurRepo;
    @Autowired
    private ExpediteurRepository expediteurRepo;
    @Autowired
    private JWTService jwtService;

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            // Authentifier l'utilisateur
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.email, request.password)
            );

            // Trouver l'utilisateur dans la base de données
            User user = findUserByEmail(request.email);
            if (user == null) {
                return ResponseEntity.badRequest().body("Utilisateur non trouvé");
            }

            // Générer le token JWT avec les informations utilisateur
            String token = jwtService.generateTokenWithUserInfo(
                    user.getEmail(),
                    user.getRole().name(),
                    user.getId(),
                    user.getNomComplet()
            );

            // Créer la réponse avec le token et les informations utilisateur
            AuthResponseDTO response = new AuthResponseDTO(
                    token,
                    user.getId(),
                    user.getEmail(),
                    user.getNomComplet(),
                    user.getRole().name()
            );

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Identifiants invalides");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        // Vérifier si l'email existe déjà
        if (emailExists(request.email)) {
            return ResponseEntity.badRequest().body("Cet email est déjà utilisé");
        }

        String encodedPassword = passwordEncoder.encode(request.password);
        User savedUser = null;

        try {
            switch (request.role.toLowerCase()) {
                case "administrateur":
                    Administrateur admin = new Administrateur();
                    admin.setNomComplet(request.nomComplet);
                    admin.setEmail(request.email);
                    admin.setPassword(encodedPassword);
                    admin.setRole(Role.Administrateur);
                    savedUser = adminRepo.save(admin);
                    break;

                case "conducteur":
                    Conducteur conducteur = new Conducteur();
                    conducteur.setNomComplet(request.nomComplet);
                    conducteur.setEmail(request.email);
                    conducteur.setPassword(encodedPassword);
                    conducteur.setRole(Role.Conducteur);
                    savedUser = conducteurRepo.save(conducteur);
                    break;

                case "expediteur":
                    Expediteur expediteur = new Expediteur();
                    expediteur.setNomComplet(request.nomComplet);
                    expediteur.setEmail(request.email);
                    expediteur.setPassword(encodedPassword);
                    expediteur.setRole(Role.Expediteur);
                    savedUser = expediteurRepo.save(expediteur);
                    break;

                default:
                    return ResponseEntity.badRequest().body("Rôle invalide");
            }

            // Générer le token JWT pour le nouvel utilisateur
            String token = jwtService.generateTokenWithUserInfo(
                    savedUser.getEmail(),
                    savedUser.getRole().name(),
                    savedUser.getId(),
                    savedUser.getNomComplet()
            );

            // Créer la réponse avec le token et les informations utilisateur
            AuthResponseDTO response = new AuthResponseDTO(
                    token,
                    savedUser.getId(),
                    savedUser.getEmail(),
                    savedUser.getNomComplet(),
                    savedUser.getRole().name()
            );

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur lors de l'enregistrement: " + e.getMessage());
        }
    }

    // Endpoint pour valider le token
    @GetMapping("/validate")
    public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String authHeader) {
        try {
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                return ResponseEntity.badRequest().body("Token manquant ou invalide");
            }

            String token = authHeader.substring(7);
            String email = jwtService.extractUsername(token);

            if (email == null) {
                return ResponseEntity.badRequest().body("Token invalide");
            }

            // Extraire les informations du token
            String role = jwtService.extractRole(token);
            Long userId = jwtService.extractUserId(token);
            String nomComplet = jwtService.extractNomComplet(token);

            AuthResponseDTO response = new AuthResponseDTO(token, userId, email, nomComplet, role);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Token invalide");
        }
    }

    // Méthode privée pour trouver un utilisateur par email
    private User findUserByEmail(String email) {
        Optional<Administrateur> admin = adminRepo.findByEmail(email);
        if (admin.isPresent()) return admin.get();

        Optional<Conducteur> conducteur = conducteurRepo.findByEmail(email);
        if (conducteur.isPresent()) return conducteur.get();

        return expediteurRepo.findByEmail(email).orElse(null);
    }

    // Méthode privée pour vérifier si un email existe déjà
    private boolean emailExists(String email) {
        return adminRepo.findByEmail(email).isPresent() ||
                conducteurRepo.findByEmail(email).isPresent() ||
                expediteurRepo.findByEmail(email).isPresent();
    }
}