package com.example.EmployeeService.controller;

import com.example.EmployeeService.clients.AddressClient;
import com.example.EmployeeService.dto.EmployeeDto;
import com.example.EmployeeService.entity.Address;
import com.example.EmployeeService.entity.Employee;
import com.example.EmployeeService.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp-service")
public class HomeController {

    @Autowired
    private EmpRepo repo;

    @Autowired
    private AddressClient addressClient;

    @PostMapping("/save")
    public ResponseEntity<String> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        Employee saveEmployee = repo.save(employeeDto.getEmployee());
        if(saveEmployee != null && saveEmployee.getEmpId() > 0) {
            List<Address> addresses = employeeDto.getAddresses();
            addressClient.saveAddress(addresses, saveEmployee.getEmpId());
        }
        String res = "Employee "+saveEmployee.getEmpName()+ " saved successfull with ID : " + saveEmployee.getEmpId();
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> Employees = repo.findAll();
        return new ResponseEntity<>(Employees, HttpStatus.OK);
    }
}
