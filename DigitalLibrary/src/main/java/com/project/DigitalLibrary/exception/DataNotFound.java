package com.project.DigitalLibrary.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DataNotFound extends RuntimeException{
	private String msg="not found";
}
