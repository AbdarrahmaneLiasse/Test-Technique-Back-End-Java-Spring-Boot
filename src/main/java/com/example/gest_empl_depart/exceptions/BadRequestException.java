package com.example.gest_empl_depart.exceptions;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class BadRequestException extends Exception {
    public BadRequestException(String message) {
        super(message);
    }
}
