package com.intercorp.junior.reto.service;

import com.intercorp.junior.reto.model.entity.ClienteEntity;

import java.util.List;

public interface ClienteService {

    ClienteEntity createCliente(ClienteEntity cliente);
    List<ClienteEntity> getAll();
    Double getPromedioEdad();
    Double getDesviacionEstandarEdad();

}
