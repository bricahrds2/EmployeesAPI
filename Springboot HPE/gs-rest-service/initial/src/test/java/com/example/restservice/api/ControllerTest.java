package api;

import com.example.restservice.api.*;
import com.example.restservice.services.EmployeesDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = com.example.restservice.api.Controller.class)
@AutoConfigureMockMvc
@Import({TestConfig.class, JacksonConfig.class})
//@ComponentScan(basePackages = {"com.example.restservice"})
//@WebMvcTest(Controller.class)
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EmployeesDAO employeesDAO;
    private Employees employees;

    @InjectMocks
    private Controller controller;

    @Autowired
    private ObjectMapper objectMapper;

    private List<Employee> mockEmployeeList;

    @BeforeEach
    void setup(){

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockEmployeeList = new ArrayList<>();

        mockEmployeeList.add(new Employee(03, "Bryce", "Young", "Vice President", "byoung@myside.com"));
        mockEmployeeList.add(new Employee(04, "Tom", "Williams", "CFO", "twilliams@myside.com"));
        mockEmployeeList.add(new Employee(05, "Jaden", "O'Neal", "Manager", "joneal@myside.com"));


        Employees mockEmployees = new Employees();
        mockEmployees.setEmployeeList(mockEmployeeList);

        when(employeesDAO.getAllEmployees()).thenReturn(mockEmployees);
        //Employees mockEmployees = mock(Employees.class);
        //when(employeesDAO.getAllEmployees()).thenReturn(mockEmployees);

        // Mock behavior of getAllEmployee request()
    }

    @Test
    public void getAllEmployeesTest() throws Exception{
        //Given


        // Print Response
        // MvcResult result = mockMvc.perform(get("http://localhost:8080/employees/")
        //                        .contentType(MediaType.APPLICATION_JSON_VALUE))
        //                .andExpect(status().isOk())
        //                .andReturn();
        //
        //        System.out.println(result.getResponse().getContentAsString());


        //When and Then
        mockMvc.perform(get("http://localhost:8080/employees/")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.employeeList.length()").value(3))
                .andExpect(jsonPath("$.employeeList[1].fname").value("Tom"))
                .andExpect((jsonPath("$.employeeList[0].length()").value(5)))
                .andExpect((jsonPath("$.employeeList[2].title").value("Manager"))
        );

        verify(employeesDAO, times(1)).getAllEmployees();

    }

    @Test
    public void addEmployeeTest() throws Exception{
        //Given
        Employee employee1 = new Employee(5,"Steve", "Madden", "Recruiter", "smadden@fgmail.com");

        doNothing().when(employeesDAO).addEmployee(any(Employee.class));

        // MvcResult result = mockMvc.perform(post("http://localhost:8080/employees/")
        //                                       .contentType(MediaType.APPLICATION_JSON_VALUE)
        //                        .content(objectMapper.writeValueAsString(employee1)))
        //                                .andExpect(status().isCreated())
        //                                .andReturn();
        //
        //        // Print the raw JSON response
        //        String jsonResponse = result.getResponse().getContentAsString();
        //        System.out.println("Response JSON: " + jsonResponse);
        //
        //// Convert JSON response to Employee object
        //        Employee addedEmployee = objectMapper.readValue(jsonResponse, Employee.class);
        //        System.out.println("Added Employee: " + addedEmployee);



        //When and Then
         mockMvc.perform(post("http://localhost:8080/employees/")
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                               .content(objectMapper.writeValueAsString(employee1)))
                       .andExpect(status().isCreated())
                        ;
               ;


        // andExpect(jsonPath("$.employeeList[1].fname").value("Steve"))

        verify(employeesDAO, times(1)).addEmployee(any(Employee.class));

    }

}
