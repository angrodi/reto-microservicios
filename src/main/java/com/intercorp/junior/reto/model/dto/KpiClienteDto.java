package com.intercorp.junior.reto.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class KpiClienteDto {

    Double avgEdad;
    Double stdevEdad;

}
