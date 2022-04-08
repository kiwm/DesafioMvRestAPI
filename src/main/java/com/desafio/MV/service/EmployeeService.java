package com.desafio.MV.service;

import com.desafio.MV.exception.ResourceNotFoundException;
import com.desafio.MV.model.Employee;
import com.desafio.MV.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()) {
            employeeRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Employee", "Id", id) ;
        }
    }

    public Employee updateEmployee(Long id, Employee employee) {
        employee.setId(id);
        Optional<Employee> employeeTest = employeeRepository.findById(id);
        if (employeeTest.isPresent()) {
            return employeeRepository.save(employee);
        }
        throw new ResourceNotFoundException("Employee", "Id", id);
    }
}
