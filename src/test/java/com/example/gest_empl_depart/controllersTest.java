package com.example.gest_empl_depart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.example.gest_empl_depart.services.IEmployeeService;
import com.example.gest_empl_depart.services.dto.EmployeeDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class controllersTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IEmployeeService employeeService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldGetAllEmployees() throws Exception {
        var e1 = new EmployeeDTO("John", "Doe","fdsf","gfdgdf", 5000.0, 1);

        Mockito.when(employeeService.getAllEmployees()).thenReturn(List.of(e1));

        mockMvc.perform(get("/employees/employees"))
                .andExpect(status().isOk());
    }

}
