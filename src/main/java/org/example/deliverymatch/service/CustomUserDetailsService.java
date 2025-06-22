package org.example.deliverymatch.service;

import org.example.deliverymatch.entity.Administrateur;
import org.example.deliverymatch.entity.Conducteur;
import org.example.deliverymatch.entity.User;
import org.example.deliverymatch.repository.AdministrateurRepository;
import org.example.deliverymatch.repository.ConducteurRepository;
import org.example.deliverymatch.repository.ExpediteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AdministrateurRepository adminRepo;
    @Autowired private ConducteurRepository conducteurRepo;
    @Autowired private ExpediteurRepository expediteurRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = findUserByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + email);
        }
        System.out.println("User: " + user.getEmail() + ", Role: ROLE_" + user.getRole().name());


        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities( user.getRole().name().toUpperCase())
                .build();

    }

    private User findUserByEmail(String email) {
        // Chercher dans admin
        Optional<Administrateur> admin = adminRepo.findByEmail(email);
        if (admin.isPresent()) return admin.get();

        // Chercher dans conducteur
        Optional<Conducteur> conducteur = conducteurRepo.findByEmail(email);
        if (conducteur.isPresent()) return conducteur.get();

        // Chercher dans expediteur
        return expediteurRepo.findByEmail(email).orElse(null);


    }


}
