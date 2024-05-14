package com.bancolombia.backend.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {

    @NotNull
    @Size(min = 4, message = "El nombre del producto no cumple con el mínimo requerido.")
    private String name;

    @Min(value = 1, message = "El stock no puede ser negativo.")
    private int stock;

    @FutureOrPresent(message = "La fecha de creación debe ser igual o mayor a la de hoy.")
    private LocalDateTime createAt;
}
