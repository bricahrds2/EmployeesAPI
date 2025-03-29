package services;

// junit 5 5.11.2
import com.example.restservice.api.Employee;
import com.example.restservice.api.Employees;
import com.example.restservice.services.EmployeesDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = EmployeesDAO.class)
public class EmployeesDAOTest {

    @MockitoBean
    private Employees employees;


    @BeforeEach
    void setUp() {
        // Create a fake employee list for testing
        List<Employee> mockEmployeeList = new ArrayList<>();
        mockEmployeeList.add(new Employee(1, "John", "Smith", "President", "mstern@myside.com"));
        mockEmployeeList.add(new Employee(2, "Sam", "Stern", "COO", "prem@gmail.com"));

        // Mock behavior of getEmployeeList()
        when(employees.getEmployeeList()).thenReturn(mockEmployeeList);
    }

    @Test
    public void testGetEmployees() {
        // Act
        List<Employee> result = employees.getEmployeeList();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getFname());
    }
}
