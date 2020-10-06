package com.DeptEmpUI.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import com.DeptEmpUI.model.Department;
import com.DeptEmpUI.model.Employee;


@RestController

public class EmployeeController {
	

	@Autowired
	private RestTemplate restTemplate;
	
	@SuppressWarnings("unchecked")
	@GetMapping(value = "/newEmp")
	public ModelAndView showFormForAdd(HttpServletRequest request) {
		
		String Register  = "NewForm";
		HttpSession session1 = request.getSession();
		List<Employee> lst =(List<Employee>)session1.getAttribute("empLst");
		List<Department> deptlst = (List<Department>) session1.getAttribute("deptList");
		ModelAndView model = new ModelAndView("form");
		PagedListHolder<Employee> pagedListHolder = new PagedListHolder<Employee>(lst);
		pagedListHolder.setPageSize(2);

		model.addObject("maxPages", pagedListHolder.getPageCount());
		Integer page = pagedListHolder.getPageCount();
		if (page == null || page < 1 || page > pagedListHolder.getPageCount())
			page = 1;

		model.addObject("page", page);
		if (page == null || page < 1 || page > pagedListHolder.getPageCount()) {
			pagedListHolder.setPage(0);
			model.addObject("empLst", pagedListHolder.getPageList());
		} else if (page <= pagedListHolder.getPageCount()) {
			pagedListHolder.setPage(page - 1);
			model.addObject("empLst", pagedListHolder.getPageList());
		}
		model.addObject("deptLst", deptlst);
		
		//model.addObject("empLst", lst);
		session1.setAttribute("page", page);
		model.addObject("deptLst",deptlst);
		model.addObject("Register", Register);
		model.addObject("addEmp", "regEmp");
		model.addObject("home", "homemp");	
		return model;	
	}
	
	@PostMapping(value = "/saveEmp")
	public ModelAndView saveEmployee( HttpServletRequest request,@ModelAttribute Employee employee, HttpServletResponse response) {
	
		
		HttpSession session2 = request.getSession();
		int deptId =  Integer.parseInt(request.getParameter("deptId"));
		@SuppressWarnings("unused")
		ModelAndView model = new ModelAndView("form");
		Employee employee1 = new Employee();
		employee1.setEmpId(employee.getEmpId());
		employee1.setEmpName(employee.getEmpName());
		employee1.setAge(employee.getAge());
		employee1.setDeptId(employee.getDeptId());
		
		
		restTemplate.postForObject("http://dept-emp-service/organize/addEmp", employee1, Employee.class);
		
		@SuppressWarnings("unchecked")
		List<Employee> lst =(List<Employee>) session2.getAttribute("empLst");
		
		
		Integer page =  (Integer) session2.getAttribute("page");
		PagedListHolder<Employee> pagedListHolder = new PagedListHolder<Employee>(lst);
		 int value =  pagedListHolder.getNrOfElements();
	       
	          if((value %2) ==0) {
	        	 
	              return new ModelAndView("redirect:/listDeptName?deptId="+deptId+"&page="+(page+1));
	          }
	          else {
	             return new ModelAndView("redirect:/listDeptName?deptId="+deptId+"&page="+page);
	          }
	   
	
	}


	@SuppressWarnings("unchecked")
	@GetMapping(value = "/editEmp")
	public ModelAndView editEmployee(HttpServletRequest request) {
		
		int employeeId = Integer.parseInt(request.getParameter("empId"));
		int did =  Integer.parseInt(request.getParameter("deptId"));
		HttpSession session2 = request.getSession();
		List<Employee> lst =(List<Employee>) session2.getAttribute("empLst");
		List<Department> deptlst = (List<Department>) session2.getAttribute("deptList");
		
		session2.setAttribute("empLst", lst);
		ModelAndView model = new ModelAndView("form");

		PagedListHolder<Employee> pagedListHolder = new PagedListHolder<Employee>(lst);
	
		pagedListHolder.setPageSize(2);
		model.addObject("maxPages", pagedListHolder.getPageCount());
		Integer page =  (Integer) session2.getAttribute("page");
		System.out.println("Page value in list Emp  "+page);
		
		if (page == null || page < 1 || page > pagedListHolder.getPageCount())
			page = 1;

		model.addObject("page", page);
		if (page == null || page < 1 || page > pagedListHolder.getPageCount()) {
			pagedListHolder.setPage(0);
			model.addObject("empLst", pagedListHolder.getPageList());
		} else if (page <= pagedListHolder.getPageCount()) {
			pagedListHolder.setPage(page - 1);
			model.addObject("empLst", pagedListHolder.getPageList());
		}
		model.addObject("home", "homemp");
		model.addObject("deptLst", deptlst);
		//model.addObject("empLst", lst);
		model.addObject("employeeid", employeeId);
		model.addObject("deptId", did);
		return model;
	}

	@PostMapping(value = "/updateEmp")
	public ModelAndView updateEmployee(HttpServletRequest request, @ModelAttribute Employee employee) {
	
		HttpSession session2 = request.getSession();
		int employeeId = Integer.parseInt(request.getParameter("empId"));
		int deptId =  Integer.parseInt(request.getParameter("deptId"));
		
		  Employee employee1 = new Employee();
		  employee1.setEmpId(employee.getEmpId());
		  employee1.setEmpName(employee.getEmpName());
		  employee1.setAge(employee.getAge());
		  employee1.setDeptId(employee.getDeptId());
		 
		  restTemplate.put("http://dept-emp-service/organize/updateEmp/"+employeeId, employee);
		  
		  Integer page =  (Integer) session2.getAttribute("page");
		  if(page!=null) {
			  return new ModelAndView("redirect:/listDeptName?deptId="+deptId+"&page="+page);
		  }

		return new ModelAndView("redirect:/listDeptName?deptId="+deptId);



	}

	@GetMapping(value = "/deleteEmp")
	public ModelAndView deleteEmployee(HttpServletRequest request) {
		
		HttpSession session2 = request.getSession();
		
		int employeeId = Integer.parseInt(request.getParameter("empId"));
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		restTemplate.delete("http://dept-emp-service/organize/deleteEmp/"+employeeId);
		Integer page =  (Integer) session2.getAttribute("page");
		  if(page!=null) {
			  return new ModelAndView("redirect:/listDeptName?deptId="+deptId+"&page="+page);
		  }
		return new ModelAndView("redirect:/listDeptName?deptId="+deptId);
	}


}
