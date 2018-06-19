package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import system.model.Employee;
import system.model.SearchQuery;
import system.service.EmployeeSearchService;


@Controller
@RequestMapping("/search")
public class EmployeeController {
    @Autowired
    private EmployeeSearchService employeeSearchService;

//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public @ResponseBody
//    List<Employee> getAllUsers() {
//        return employeeSearchService.getAllEmployees();
//    }

    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    public ModelAndView validateUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("searchQuery", new SearchQuery());
        modelAndView.setViewName("employees_result_page");
        return modelAndView;
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public @ResponseBody
    String checkUser(@ModelAttribute("searchQuery") SearchQuery searchQuery) {
        if ("admin".equals(searchQuery.getFirstName()) && "admin".equals(searchQuery.getSecondName())) {
            return "valid";
        }
        return "invalid";
    }
}
