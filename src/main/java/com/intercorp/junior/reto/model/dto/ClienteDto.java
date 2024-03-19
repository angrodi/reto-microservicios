package com.intercorp.junior.reto.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class ClienteDto {

    private String id;

    @NotBlank(message = "Nombre es requerido")
    private String nombre;

    @NotBlank(message = "Apellido es requerido")
    private String apellido;

    @NotNull(message = "Edad es requerido")
    @Min(0)
    private Integer edad;

    @NotBlank(message = "Fecha de Nacimiento es requerido")
    private String fechaNacimiento;

}
