package io.reactivestax.springboot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.reactivestax.springboot.entity.Employee;
import io.reactivestax.springboot.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void registrationWorksThroughAllLayers() throws Exception {
        Employee user = new Employee(1l,"tester", "user");

        mockMvc.perform(post("/employees", 42L)
                        .contentType("application/json")
                        .param("sendWelcomeMail", "true")
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk());

        Optional<Employee> userEntity = employeeRepository.findById(1l);
        assertThat(userEntity.get().getName()).isEqualTo("tester");
    }

    @Test
    void getEmployee() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/employees/{id}",1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void deleteEmployeeAPI() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders.delete("/employees/{id}", 1) )
                .andExpect(status().isOk());
    }
}