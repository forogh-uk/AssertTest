package com.test.learntest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.learntest.model.Employee;
import com.test.learntest.model.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest

class LearnTestApplicationTests {
private MockMvc mockMvc;
@Autowired
private WebApplicationContext context;
//to convert to json using object mapper
    ObjectMapper om= new ObjectMapper();





@Before
public void setUp(){
    mockMvc= MockMvcBuilders.webAppContextSetup(context).build();
}

@Test
public void addEmployeeTest() throws Exception {

    //request body
    Employee employee = new Employee();
    employee.setName("forogh");
    employee.setDept("It");
    //request body finish
    //convert employee object to string
    //wew can not use object in mvc we have to convert it(object mapper)
    String jsonRequest=om.writeValueAsString(employee);
    //hit the controller and get the response in format of mvc result

    MvcResult result = mockMvc.perform(post("/EmployeeService/addEmployee").content(jsonRequest)
            //how we have expected =status is ok==200
                    .content(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();

    //

    String resultContent=result.getResponse().getContentAsString();
    //convert to coresponding response,read value convert string to object
    //return
    Response response =om.readValue(resultContent,Response.class);
    Assert.assertTrue(response.isStatus()==Boolean.TRUE);



}

    @Test
    public void getEmployeeTest() throws Exception {


        MvcResult result = mockMvc.perform(get("/EmployeeService/getEmployee").content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();

        String resultContent=result.getResponse().getContentAsString();
        //convert to
        //return
        Response response =om.readValue(resultContent,Response.class);
        Assert.assertTrue(response.isStatus()==Boolean.TRUE);


    }

    @Test
    void contextLoads() {
    }

}
