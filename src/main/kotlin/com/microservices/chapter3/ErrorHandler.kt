package com.microservices.chapter3

import com.fasterxml.jackson.core.JsonParseException
import org.apache.coyote.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.multipart.support.AbstractMultipartHttpServletRequest
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class ErrorHandler {
    @ExceptionHandler(CustomerNotFoundException::class)
    fun CustomerNotFoundExceptionHandler(servletRequest: HttpServletRequest, exception: Exception): ResponseEntity<ErrorResponse> {
        return ResponseEntity(ErrorResponse("Customer Not Found", exception.message!!), HttpStatus.NOT_FOUND)
    }
}