package com.project.DigitalLibrary.dto;

import org.springframework.stereotype.Component;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Component
@Entity
@Data
public class Book {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Title cannot be empty.")
    private String title;

    @NotBlank(message = "Author cannot be empty.")
    private String author;

    @NotBlank(message = "Genre cannot be empty.")
    private String genre;

    @Pattern(regexp = "Available|Checked Out", message = "Availability must be either Available or Checked Out.")
    private String availability;

}
