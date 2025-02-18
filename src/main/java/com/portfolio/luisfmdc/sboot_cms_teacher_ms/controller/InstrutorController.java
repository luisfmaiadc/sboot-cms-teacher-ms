package com.portfolio.luisfmdc.sboot_cms_teacher_ms.controller;

import com.portfolio.luisfmdc.sboot_cms_teacher_ms.domain.InstrutorRequest;
import com.portfolio.luisfmdc.sboot_cms_teacher_ms.domain.InstrutorResponse;
import com.portfolio.luisfmdc.sboot_cms_teacher_ms.domain.UpdateInstrutorRequest;
import com.portfolio.luisfmdc.sboot_cms_teacher_ms.service.InstrutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/professor")
public class InstrutorController {

    @Autowired
    private InstrutorService service;

    @PostMapping("/cadastrar")
    public ResponseEntity<InstrutorResponse> cadastrarInstrutor(@RequestBody @Valid InstrutorRequest request, UriComponentsBuilder uriComponentsBuilder) {
        return service.cadastrarInstrutor(request, uriComponentsBuilder);
    }

    @PutMapping("/atualizar/{idProfessor}")
    public ResponseEntity<InstrutorResponse> atualizarInstrutor(@PathVariable Integer idProfessor, @RequestBody UpdateInstrutorRequest request) {
        return service.atualizarInstrutor(idProfessor, request);
    }

    @DeleteMapping("/deletar/{idProfessor}")
    public ResponseEntity inativarInstrutor(@PathVariable Integer idProfessor) {
        return service.inativarInstrutor(idProfessor);
    }
}
