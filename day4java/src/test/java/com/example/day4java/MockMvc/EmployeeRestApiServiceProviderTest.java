package com.example.day4java.MockMvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(EmployeeRestApiServiceProvider.class)
class EmployeeRestApiServiceProviderTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetMethod() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getallemp")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testAddEmployee() throws Exception {
        String jsonString = "{\n" +
                "\"employeeId\":120,\n" +
                "\"employeeName\":\"shantam\",\n" +
                "\"employeeDepartment\":\"cse\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/addemp")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString)).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void testGetOneEmployee() throws Exception {
        String jsonString = "{\n" +
                "\"employeeId\":120,\n" +
                "\"employeeName\":\"shantam\",\n" +
                "\"employeeDepartment\":\"cse\"\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.get("/getoneemp/{name}","shantam"))
                .andDo(print()).andExpect(status().isOk());


    }

    @Test
    public void testUpdateEmployeeName() throws Exception {
        String jsonString = "{\n" +
                "\"employeeId\":120,\n" +
                "\"employeeName\":\"shantam\",\n" +
                "\"employeeDepartment\":\"cse\"\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.put("/updateempname/{name}/{name2}","shantam","sultania"))
                .andDo(print()).andExpect(status().isOk());


    }









}