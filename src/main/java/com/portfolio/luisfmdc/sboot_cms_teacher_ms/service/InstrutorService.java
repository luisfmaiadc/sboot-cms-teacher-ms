package com.portfolio.luisfmdc.sboot_cms_teacher_ms.service;

import com.portfolio.luisfmdc.sboot_cms_teacher_ms.domain.Instrutor;
import com.portfolio.luisfmdc.sboot_cms_teacher_ms.domain.InstrutorRequest;
import com.portfolio.luisfmdc.sboot_cms_teacher_ms.domain.InstrutorResponse;
import com.portfolio.luisfmdc.sboot_cms_teacher_ms.domain.UpdateInstrutorRequest;
import com.portfolio.luisfmdc.sboot_cms_teacher_ms.repository.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class InstrutorService {

    @Autowired
    private InstrutorRepository repository;

    public ResponseEntity<InstrutorResponse> cadastrarInstrutor(InstrutorRequest request, UriComponentsBuilder uriComponentsBuilder) {
        Instrutor instrutor = new Instrutor(request);
        repository.save(instrutor);
        URI uri = uriComponentsBuilder.path("/cadastrar/{id}").buildAndExpand(instrutor.getAtivo()).toUri();
        return ResponseEntity.created(uri).body(new InstrutorResponse(instrutor));
    }

    public ResponseEntity<InstrutorResponse> atualizarInstrutor(Integer idProfessor, UpdateInstrutorRequest request) {
        Instrutor instrutor = repository.getReferenceById(idProfessor);
        instrutor.atualizarInstrutor(request);
        repository.save(instrutor);
        return ResponseEntity.ok(new InstrutorResponse(instrutor));
    }

    public ResponseEntity inativarInstrutor(Integer idProfessor) {
        Instrutor instrutor = repository.getReferenceById(idProfessor);
        instrutor.setAtivo(Boolean.FALSE);
        repository.save(instrutor);
        return ResponseEntity.noContent().build();
    }
}
