package com.example.day5java.JDBCConnectSpringBoot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeServiceProviderApi.class)
class EmployeeServiceProviderApiTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testCreateTable() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/jdbc/createtable")).andExpect(status().isOk());

    }

    @Test
    public void testGetMethod() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/jdbc/getall")).andExpect(status().isOk());
    }

    @Test
    public void testAddEmployee() throws Exception {
        String jsonString = "{\n" +
                "\"employeeId\":120,\n" +
                "\"employeeName\":\"shantam\",\n" +
                "\"employeeDepartment\":\"cse\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/jdbc/adddata")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testDropTable() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/jdbc/table/delete")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testDropRow() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/jdbc/row/delete/{id}", "120")).andExpect(MockMvcResultMatchers.status().isOk());
    }


}