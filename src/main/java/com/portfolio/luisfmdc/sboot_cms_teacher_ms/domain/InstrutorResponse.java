package com.portfolio.luisfmdc.sboot_cms_teacher_ms.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InstrutorResponse(@NotBlank String nome, @NotBlank String sobrenome, @NotNull Genero genero, @NotBlank String email, @NotNull Boolean ativo) {

    public InstrutorResponse(Instrutor instrutor) {
        this(instrutor.getNome(), instrutor.getSobrenome(), instrutor.getGenero(), instrutor.getEmail(), instrutor.getAtivo());
    }
}
