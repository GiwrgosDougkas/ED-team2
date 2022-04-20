package com.eurodyn.team2.transfer;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.UUID;

@Value
@Builder
public class ApiResponse<T> implements Serializable {
	String transactionId = UUID.randomUUID().toString().toUpperCase(Locale.ROOT);
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss.SS")
	LocalDateTime createdAt = LocalDateTime.now();
	T data;
	ApiError apiError;
}