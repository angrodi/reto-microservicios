package com.intercorp.junior.reto.model.dto.mapper;

import com.intercorp.junior.reto.model.dto.ClienteDto;
import com.intercorp.junior.reto.model.entity.ClienteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteDto entityToApi(ClienteEntity entity);
    ClienteEntity apiToEntity(ClienteDto api);
    List<ClienteDto> entityListToApiList(List<ClienteEntity> entity);
    List<ClienteEntity> apiListToEntityList(List<ClienteDto> api);

}
