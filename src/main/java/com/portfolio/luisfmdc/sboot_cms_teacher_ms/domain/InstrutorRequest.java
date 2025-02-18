package com.portfolio.luisfmdc.sboot_cms_teacher_ms.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InstrutorRequest(@NotBlank String nome, @NotBlank String sobrenome, @NotNull Genero genero, @NotBlank String email) {
}