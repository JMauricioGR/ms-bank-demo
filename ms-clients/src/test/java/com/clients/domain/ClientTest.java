package com.clients.domain;

import com.clients.repository.ClientsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ClientTest {

    @Test
    public void saveClient() {

        Long clienId = 1L;
        String userPassword = "1A2B3C";
        Boolean status = Boolean.TRUE;
        Long id = 1L;
        String userName = "Camilo";
        String genre = "Male";
        Integer age = 25;
        String personalId = "CC1209348765";
        String address = "Calle 123";
        String phone = "+573002894563";

        Client client = new Client();
        client.setClientId(clienId);
        client.setUserPassword(userPassword);
        client.setStatus(status);
        client.setId(id);
        client.setUserName(userName);
        client.setGenre(genre);
        client.setAge(age);
        client.setPersonalId(personalId);
        client.setAddress(address);
        client.setPhone(phone);

        assertNotNull(client);
        assertThat(client.getClientId()).isEqualTo(1L);
        assertThat(client.getUserPassword()).isEqualTo("1A2B3C");
        assertThat(client.getStatus()).isEqualTo(Boolean.TRUE);
        assertThat(client.getId()).isEqualTo(1L);
        assertThat(client.getUserName()).isEqualTo("Camilo");
        assertThat(client.getGenre()).isEqualTo("Male");
        assertThat(client.getAge()).isEqualTo(25);
        assertThat(client.getPersonalId()).isEqualTo("CC1209348765");
        assertThat(client.getAddress()).isEqualTo("Calle 123");
        assertThat(client.getPhone()).isEqualTo("+573002894563");

    }

}