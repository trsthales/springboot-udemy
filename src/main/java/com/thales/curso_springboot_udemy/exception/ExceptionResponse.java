package com.thales.curso_springboot_udemy.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {}
