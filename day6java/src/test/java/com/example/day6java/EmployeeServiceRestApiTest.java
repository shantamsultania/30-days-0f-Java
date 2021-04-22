package com.example.day6java;

import com.example.day6java.JDBCConnectSpringBoot.EmployeeServiceRestApi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeServiceRestApi.class)
class EmployeeServiceRestApiTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testCreateTable() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/jdbcc/createtable")).andExpect(status().isOk());

    }

    @Test
    public void testGetMethod() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/jdbcc/getall")).andExpect(status().isOk());
    }

    @Test
    public void testAddEmployee() throws Exception {
        String jsonString = "{\n" +
                "\"employeeId\":120,\n" +
                "\"employeeName\":\"shantam\",\n" +
                "\"employeeDepartment\":\"cse\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/jdbcc/adddata")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testDropTable() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/jdbcc/table/delete")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testDropRow() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/jdbcc/row/delete/{id}", "120")).andExpect(MockMvcResultMatchers.status().isOk());
    }


}