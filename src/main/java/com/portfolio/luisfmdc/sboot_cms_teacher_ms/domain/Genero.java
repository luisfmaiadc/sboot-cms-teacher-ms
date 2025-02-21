package com.portfolio.luisfmdc.sboot_cms_teacher_ms.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.portfolio.luisfmdc.sboot_cms_teacher_ms.infra.exception.InvalidRequestArgumentException;

import java.util.stream.Stream;

public enum Genero {
    M,
    F,
    O;

    @JsonCreator
    public static Genero fromString(String value) {
        return Stream.of(Genero.values())
                .filter(c -> c.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new InvalidRequestArgumentException(
                        "Gênero inválido. Valores permitidos: " + Stream.of(Genero.values()).map(Enum::name).toList()
                ));
    }
}
