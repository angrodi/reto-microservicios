package com.intercorp.junior.reto.controller;

import com.intercorp.junior.reto.error.exceptions.InvalidInputException;
import com.intercorp.junior.reto.model.dto.ClienteDto;
import com.intercorp.junior.reto.model.dto.KpiClienteDto;
import com.intercorp.junior.reto.model.dto.mapper.ClienteMapper;
import com.intercorp.junior.reto.model.entity.ClienteEntity;
import com.intercorp.junior.reto.service.ClienteService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;
    private final ClienteMapper clienteMapper;

    @PostMapping(
            value = "/creacliente",
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<ClienteDto> createCliente(@Valid @RequestBody ClienteDto body) {
        try {
            ClienteEntity entity = clienteMapper.apiToEntity(body);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(clienteMapper.entityToApi(clienteService.createCliente(entity)));
        } catch (DateTimeParseException ex) {
            throw new InvalidInputException("Formato de fechaNacimiento invalido: yyyy-MM-dd");
        }
    }

    @GetMapping(
            value = "/kpideclientes",
            produces = "application/json"
    )
    public ResponseEntity<KpiClienteDto> getKpiClientes() {
        Double avgEdad = clienteService.getPromedioEdad();
        Double stdDevEdad = clienteService.getDesviacionEstandarEdad();

        KpiClienteDto kpiClienteDto = KpiClienteDto.builder()
                .avgEdad(avgEdad)
                .stdevEdad(stdDevEdad)
                .build();

        return ResponseEntity.ok(kpiClienteDto);
    }

    @GetMapping(
            value = "/listclientes",
            produces = "application/json"
    )
    public ResponseEntity<List<ClienteDto>> listClientes() {
        return ResponseEntity.ok(clienteMapper.entityListToApiList(clienteService.getAll()));
    }
}
