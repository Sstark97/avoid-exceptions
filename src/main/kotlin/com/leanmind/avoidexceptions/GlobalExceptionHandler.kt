package com.leanmind.avoidexceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(value = [(EmptyDataNotAllowedException::class), (PasswordTooShortException::class), (UserAlreadyExistsException::class), (TooManyAdminsException::class)])
    fun handleEmptyDataNotAllowedException(ex: Exception): ResponseEntity<ErrorModel> {
        return ResponseEntity(ErrorModel("Bad request: ${ex.message}"), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler
    fun handleException(ex: Exception): ResponseEntity<ErrorModel> {
        return ResponseEntity(ErrorModel("Internal server error: ${ex.message}"), HttpStatus.INTERNAL_SERVER_ERROR)
    }
}