package com.cbaeza.dto;

/**
 * Simple Response Dto
 */
public class ResponseDto {

  private String message;
  private Long timestamp;

  public ResponseDto() {

  }

  public ResponseDto(String message) {
    this.message = message;
    this.timestamp = System.currentTimeMillis();
  }

  public ResponseDto(String message, Long timestamp) {
    this.message = message;
    this.timestamp = timestamp;
  }

  public String getMessage() {
    return message;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  @Override
  public String toString() {
    return "ResponseDto{" +
        "message='" + message + '\'' +
        ", timestamp=" + timestamp +
        '}';
  }
}
