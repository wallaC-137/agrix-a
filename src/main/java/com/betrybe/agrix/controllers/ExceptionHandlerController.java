package com.betrybe.agrix.controllers;

import com.betrybe.agrix.exception.FarmNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The type Exception handler controller.
 */
@ControllerAdvice
public class ExceptionHandlerController {

  /**
   * Handler farm not found response entity.
   *
   * @return the response entity
   */
  @ExceptionHandler(FarmNotFoundException.class)
  public ResponseEntity<String> handlerFarmNotFound() {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fazenda não encontrada!");
  }
}
