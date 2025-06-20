package org.example.deliverymatch.DTO;

public class AuthResponseDTO {
    private String token;
    private String type = "Bearer";
    private Long userId;
    private String email;
    private String nomComplet;
    private String role;

    public AuthResponseDTO() {}

    public AuthResponseDTO(String token, Long userId, String email, String nomComplet, String role) {
        this.token = token;
        this.userId = userId;
        this.email = email;
        this.nomComplet = nomComplet;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}