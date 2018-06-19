package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.dao.EmployeeDao;
import system.model.Employee;

import java.util.List;

@Service
public class EmployeeSearchService {
    @Autowired
    private EmployeeDao employeeDao;

//    public List<Employee> getAllEmployees() {
//        return employeeDao.getAllEmployees();
//    }
}
