package com.intercorp.junior.reto.service.impl;

import com.intercorp.junior.reto.model.entity.ClienteEntity;
import com.intercorp.junior.reto.model.repository.ClienteRepository;
import com.intercorp.junior.reto.service.ClienteService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;

    @Override
    public ClienteEntity createCliente(ClienteEntity cliente) {
        return this.repository.save(cliente);
    }

    @Override
    public List<ClienteEntity> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Double getPromedioEdad() {
        return this.repository.getPromedioEdad();
    }

    @Override
    public Double getDesviacionEstandarEdad() {
        return this.repository.getDesviacionEstandarEdad();
    }


}
