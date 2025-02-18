package com.portfolio.luisfmdc.sboot_cms_teacher_ms.domain;

public record UpdateInstrutorRequest(String nome, String sobrenome, Genero genero, String email, Boolean ativo) {
}
