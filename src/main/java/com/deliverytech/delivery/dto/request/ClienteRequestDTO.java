package com.deliverytech.delivery.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClienteRequestDTO {

    @NotBlank(message = "o nome é obrigatório")
    private String nome;

    @NotBlank(message = "o email é obrigatório")
    @Email(message = "o email deve ser válido")
    private String email;

    @NotBlank(message = "o telefone é obrigatório")
    private String telefone;

    @NotBlank(message = "o endereço é obrigatório")
    private String endereco;

    public ClienteRequestDTO(String nome, String email, String telefone, String endereco) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public ClienteRequestDTO() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
