package com.portfolio.luisfmdc.sboot_cms_teacher_ms.infra.exception;

public class InvalidRequestArgumentException extends IllegalArgumentException {
    public InvalidRequestArgumentException(String message) {
        super(message);
    }
}
