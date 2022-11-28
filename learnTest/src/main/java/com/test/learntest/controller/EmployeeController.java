package com.test.learntest.controller;


import com.test.learntest.model.Employee;
import com.test.learntest.model.Response;
import com.test.learntest.service.dao.EmployRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/EmployeeService")
public class EmployeeController {

    @Autowired
    private EmployRepo employRepo;

@PostMapping("/addEmployee")
    public Response addEmploy(@RequestBody Employee employ){
        employRepo.save(employ);
        return new Response(employ.getId()+ "Insert",Boolean.TRUE);

    }

    @GetMapping("/getEmployee")
    public Response getAllEmployee(){
    List<Employee> employee = employRepo.findAll();
    return new Response("Record Count: " +  employee.size(),Boolean.TRUE);

    }


}
