package com.cbaeza.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cbaeza.dto.ResponseDto;

/**
 * Just a dummy controller
 */
@RestController
public class HelloController {

  private static final Logger LOG = LoggerFactory.getLogger(HelloController.class.getName());

  public HelloController() {
    LOG.info(">>>> HelloController is here");
  }

  /**
   * Say hello!
   * 
   * @return greeting from App
   */
  @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody ResponseEntity<ResponseDto> get() {
    return new ResponseEntity<>(
        new ResponseDto("Hello from App HelloController", System.currentTimeMillis()),
        HttpStatus.OK);
  }
}
