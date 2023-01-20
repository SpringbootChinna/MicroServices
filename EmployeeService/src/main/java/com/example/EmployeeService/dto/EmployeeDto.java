package com.example.EmployeeService.dto;

import com.example.EmployeeService.entity.Address;
import com.example.EmployeeService.entity.Employee;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeDto {

    private Employee employee;
    private List<Address> addresses;
}
