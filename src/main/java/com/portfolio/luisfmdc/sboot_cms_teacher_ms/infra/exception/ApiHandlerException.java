package com.portfolio.luisfmdc.sboot_cms_teacher_ms.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ApiHandlerException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<DadosErro>> handleInvalidArgument(MethodArgumentNotValidException ex) {
        var error = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(error.stream().map(DadosErro::new).toList());
    }

    @ExceptionHandler(InvalidRequestArgumentException.class)
    public ResponseEntity<List<DadosErro>> handleInvalidRequestArgumentException(InvalidRequestArgumentException ex) {
        DadosErro erro = new DadosErro(extractFieldFromMessage(ex.getMessage()), ex.getMessage());
        return ResponseEntity.badRequest().body(List.of(erro));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleEntityNotFound(EntityNotFoundException ex) {
        return ResponseEntity.status(404).body(new DadosErro("idInstrutor", "Professor informado inválido."));
    }

    private String extractFieldFromMessage(String message) {
        if (message.contains("Gênero")) {
            return "genero";
        } else if (message.contains("nome")) {
            return "nome";
        } else if (message.contains("sobrenome")) {
            return "sobrenome";
        } else if (message.contains("e-mail")) {
            return "email";
        } else {
            return "campo desconhecido";
        }
    }

    private record DadosErro(String campo, String mensagem) {
        DadosErro(FieldError fieldError) {
            this(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }

}
