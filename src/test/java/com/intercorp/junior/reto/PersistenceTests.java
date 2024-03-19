package com.intercorp.junior.reto;

import com.intercorp.junior.reto.model.entity.ClienteEntity;
import com.intercorp.junior.reto.model.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PersistenceTests {

    @Autowired
    private ClienteRepository clienteRepository;

    @BeforeEach
    public void setup() {
        clienteRepository.deleteAll();
    }

    @DisplayName("JUnit test for save cliente operation")
    @Test
    public void givenCliente_whenSave_thenReturnSavedCliente() {
        ClienteEntity cliente = ClienteEntity.builder()
                .nombre("Angel")
                .apellido("Romaní")
                .edad(26)
                .fechaNacimiento(LocalDate.of(1998, 1, 19))
                .build();

        ClienteEntity savedCliente = clienteRepository.save(cliente);

        assertThat(savedCliente).isNotNull();
        assertThat(savedCliente.getId()).isGreaterThan(0);
    }

    @DisplayName("Junit test for get all clientes operation")
    @Test
    public void givenClienteList_whenFindAll_thenReturnClienteList() {
        ClienteEntity cliente1 = ClienteEntity.builder()
                .nombre("Angel")
                .apellido("Romaní")
                .edad(26)
                .fechaNacimiento(LocalDate.of(1998, 1, 19))
                .build();

        ClienteEntity cliente2 = ClienteEntity.builder()
                .nombre("René")
                .apellido("Diaz")
                .edad(20)
                .fechaNacimiento(LocalDate.of(2004, 1, 19))
                .build();

        clienteRepository.save(cliente1);
        clienteRepository.save(cliente2);

        // when - action or the behaviour that we are going test
        List<ClienteEntity> clienteList = clienteRepository.findAll();

        // then - verify the output
        assertThat(clienteList).isNotNull();
        assertThat(clienteList.size()).isEqualTo(2);
    }

    @DisplayName("Junit test for get all clientes operation")
    @Test
    public void givenClienteList_whenGetPromedioEdad_thenReturnPromedioEdad() {
        ClienteEntity cliente1 = ClienteEntity.builder()
                .nombre("Angel")
                .apellido("Romaní")
                .edad(26)
                .fechaNacimiento(LocalDate.of(1998, 1, 19))
                .build();

        ClienteEntity cliente2 = ClienteEntity.builder()
                .nombre("René")
                .apellido("Diaz")
                .edad(20)
                .fechaNacimiento(LocalDate.of(2004, 1, 19))
                .build();

        clienteRepository.save(cliente1);
        clienteRepository.save(cliente2);

        // when - action or the behaviour that we are going test
        Double promedioEdad = clienteRepository.getPromedioEdad();

        // then - verify the output
        assertThat(promedioEdad).isEqualTo(23);
    }

    @DisplayName("Junit test for get all clientes operation")
    @Test
    public void givenClienteList_whenGetDesviacionEstandarEdad_thenReturnDesviacionEstandarEdad() {
        ClienteEntity cliente1 = ClienteEntity.builder()
                .nombre("Angel")
                .apellido("Romaní")
                .edad(20)
                .fechaNacimiento(LocalDate.of(2004, 1, 19))
                .build();

        ClienteEntity cliente2 = ClienteEntity.builder()
                .nombre("René")
                .apellido("Diaz")
                .edad(10)
                .fechaNacimiento(LocalDate.of(2014, 1, 19))
                .build();

        clienteRepository.save(cliente1);
        clienteRepository.save(cliente2);

        // when - action or the behaviour that we are going test
        Double desviacionEstandarEdad = clienteRepository.getDesviacionEstandarEdad();

        // then - verify the output
        assertThat(desviacionEstandarEdad).isEqualTo(5);
    }
}