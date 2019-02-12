package com.cbaeza.dto;

/**
 * Simple Response Dto
 */
public class ResponseDto {

  private final String message;
  private final Long timestamp;

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
