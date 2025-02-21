package com.portfolio.luisfmdc.sboot_cms_teacher_ms.domain;

import com.portfolio.luisfmdc.sboot_cms_teacher_ms.infra.exception.InvalidRequestArgumentException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table
public class Instrutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String sobrenome;
    @Enumerated(EnumType.STRING)
    private Genero genero;
    private String email;
    private LocalDateTime dataCadastro = LocalDateTime.now();
    private Boolean ativo = Boolean.TRUE;

    public Instrutor(InstrutorRequest request) {
        this.nome = request.nome();
        this.sobrenome = request.sobrenome();
        this.genero = request.genero();
        this.email = request.email();
    }

    public void atualizarInstrutor(UpdateInstrutorRequest request) {

        if (request.nome() != null && !request.nome().isEmpty()) {
            if (request.nome().length() < 3 || request.nome().length() > 50) {
                throw new InvalidRequestArgumentException("O nome deve ter entre 3 e 50 caracteres");
            }
            this.nome = request.nome();
        }

        if (request.sobrenome() != null && !request.sobrenome().isEmpty()) {
            if (request.sobrenome().length() < 3 || request.sobrenome().length() > 50) {
                throw new InvalidRequestArgumentException("O sobrenome deve ter entre 3 e 50 caracteres");
            }
            this.sobrenome = request.sobrenome();
        }

        if(request.genero() != null) {
            this.genero = request.genero();
        }

        if (request.email() != null && !request.email().isEmpty()) {
            if (request.email().length() < 10 || request.email().length() > 75) {
                throw new InvalidRequestArgumentException("O e-mail deve ter entre 3 e 75 caracteres");
            }
            this.email = request.email();
        }

        if (request.ativo() != null) {
            this.ativo = Boolean.TRUE;
        }
    }
}
