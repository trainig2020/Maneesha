package com.DeptEmpUI.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import com.DeptEmpUI.model.Department;
import com.DeptEmpUI.model.DepartmentList;
import com.DeptEmpUI.model.Employee;
import com.DeptEmpUI.model.EmployeeList;



@RestController

public class DeptController {




	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/")
	public ModelAndView loginPage() {
		return new ModelAndView("redirect:/listDept");

	}

	@GetMapping("/home")
	public ModelAndView listDeptId(HttpServletRequest request, ModelAndView modelAndView,
			@RequestParam(required = false) Integer page) {
		
		
		DepartmentList lst = restTemplate.getForObject("http://dept-emp-service/organize/listDept",
				DepartmentList.class);
		int deptId = lst.getDepartments().get(0).getDeptId();
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("page", page);
		if(page!=null) {
			
			return new ModelAndView("redirect:/listDeptName?deptId=" + deptId+"&page="+page);
		}
		
		return new ModelAndView("redirect:/listDeptName?deptId=" + deptId);

	}

	@GetMapping("/listDeptName")
	public ModelAndView listDeptName(HttpServletRequest request, HttpServletResponse response,@RequestParam(required = false) Integer page) {
		
		HttpSession httpSession = request.getSession();
		
		
		int id = Integer.parseInt(request.getParameter("deptId"));
		List<Department> lstDept = new ArrayList<Department>();

		DepartmentList lst = restTemplate.getForObject("http://dept-emp-service/organize/listDept",
				DepartmentList.class);
		
		for (int i = 0; i < lst.getDepartments().size(); i++) {
			lstDept.add(lst.getDepartments().get(i));
		}
		EmployeeList empLst = restTemplate.getForObject("http://dept-emp-service/organize/emp/" + id,
				EmployeeList.class);
		List<Employee> listEmp = new ArrayList<Employee>();
		
		for (int i = 0; i < empLst.getEmployees().size(); i++) {
			listEmp.add(empLst.getEmployees().get(i));
		}

		

		PagedListHolder<Employee> pagedListHolder = new PagedListHolder<Employee>(listEmp);
		pagedListHolder.setPageSize(2);
		
		ModelAndView modelAndView = new ModelAndView("form");

		modelAndView.addObject("maxPages", pagedListHolder.getPageCount());
		
		

		if (page == null || page < 1 || page > pagedListHolder.getPageCount())
			page = 1;

		modelAndView.addObject("page", page);
		if (page == null || page < 1 || page > pagedListHolder.getPageCount()) {
			pagedListHolder.setPage(0);
			modelAndView.addObject("empLst", pagedListHolder.getPageList());
		} else if (page <= pagedListHolder.getPageCount()) {
			pagedListHolder.setPage(page - 1);
			modelAndView.addObject("empLst", pagedListHolder.getPageList());
		}
		httpSession.setAttribute("page", page);
		httpSession.setAttribute("empLst", listEmp);
		modelAndView.addObject("deptId", id);
		modelAndView.addObject("deptLst", lstDept);
		// modelAndView.addObject("empLst", listEmp);
		modelAndView.addObject("home", "homemp");
		modelAndView.addObject("check", "checklist");
		

		return modelAndView;

	}

	

	@GetMapping("/listDept")
	public ModelAndView listDepartment(HttpServletRequest request, @RequestParam(required = false) Integer page) {
		
		
		List<Department> lstDept = new ArrayList<Department>();

		DepartmentList lst = restTemplate.getForObject("http://dept-emp-service/organize/listDept",
				DepartmentList.class);
		System.out.println("In list dept");
		for (int i = 0; i < lst.getDepartments().size(); i++) {
			lstDept.add(lst.getDepartments().get(i));
		}
		ModelAndView modelAndView = new ModelAndView("form");
		PagedListHolder<Department> pagedListHolder = new PagedListHolder<Department>(lstDept);
		pagedListHolder.setPageSize(2);
		

		modelAndView.addObject("maxPages", pagedListHolder.getPageCount());

		if (page == null || page < 1 || page > pagedListHolder.getPageCount())
			page = 1;

		modelAndView.addObject("page", page);
		if (page == null || page < 1 || page > pagedListHolder.getPageCount()) {
			pagedListHolder.setPage(0);
			modelAndView.addObject("deptList", pagedListHolder.getPageList());
		} else if (page <= pagedListHolder.getPageCount()) {
			pagedListHolder.setPage(page - 1);
			modelAndView.addObject("deptList", pagedListHolder.getPageList());
		}

		HttpSession session = request.getSession();
		session.setAttribute("deptList", lstDept);
		session.setAttribute("page", page);
		return modelAndView;

	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/newDept")
	public ModelAndView newDepartment(ModelAndView model, HttpServletRequest request) {
		
		
		String Register = "NewFormDept";
		HttpSession session1 = request.getSession();
		List<Department> lst = (List<Department>) session1.getAttribute("deptList");
		session1.setAttribute("deptList", lst);

		PagedListHolder<Department> pagedListHolder = new PagedListHolder<Department>(lst);
		pagedListHolder.setPageSize(2);

		model.addObject("maxPages", pagedListHolder.getPageCount());
		Integer page =  pagedListHolder.getPageCount();
		if (page == null || page < 1 || page > pagedListHolder.getPageCount())
			page = 1;

		model.addObject("page", page);
		if (page == null || page < 1 || page > pagedListHolder.getPageCount()) {
			pagedListHolder.setPage(0);
			model.addObject("deptList", pagedListHolder.getPageList());
		} else if (page <= pagedListHolder.getPageCount()) {
			pagedListHolder.setPage(page - 1);
			model.addObject("deptList", pagedListHolder.getPageList());
		}
		session1.setAttribute("page", page);
		model.addObject("Register", Register);
		model.addObject("insertDept", "newDept");
		model.setViewName("form");
		Department department = new Department();
		model.addObject("department", department);
		return model;
	}

	@PostMapping(value = "/saveDept")
	public ModelAndView saveDepartment1 (@Valid @ModelAttribute Department department, HttpServletRequest request) {
		
		
		HttpSession session2 = request.getSession();
		@SuppressWarnings("unused")
		ModelAndView model = new ModelAndView("form");
		Department department1 = new Department();
		department1.setDeptId(department.getDeptId());
		department1.setDeptName(department.getDeptName());
		restTemplate.postForObject("http://dept-emp-service/organize/addDept", department1, Department.class);
		@SuppressWarnings("unchecked")
		List<Department> lst = (List<Department>) session2.getAttribute("deptList");
		
		session2.setAttribute("deptList", lst);
		Integer page =  (Integer) session2.getAttribute("page");
        PagedListHolder<Department> pagedListHolder = new PagedListHolder<Department>(lst);
        int value =  pagedListHolder.getNrOfElements();
        System.out.println("Page in Dept "+page);
          if((value %2) ==0) {
        	  
              return new ModelAndView("redirect:/listDept?page="+(page+1));
          }
          else {
        	  
             return new ModelAndView("redirect:/listDept?page="+page);
          }
		

	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/editDept")
	public ModelAndView editDepartment(HttpServletRequest request) {
		
		
		int deptId = Integer.parseInt(request.getParameter("id"));
		HttpSession session2 = request.getSession();
		Department department = restTemplate.getForObject("http://dept-emp-service/organize/listDept/" + deptId,
				Department.class);
		session2.setAttribute("department", department);
		List<Department> lst = (List<Department>) session2.getAttribute("deptList");
		session2.setAttribute("deptList", lst);
		ModelAndView model = new ModelAndView("form");

		PagedListHolder<Department> pagedListHolder = new PagedListHolder<Department>(lst);
		pagedListHolder.setPageSize(2);

		model.addObject("maxPages", pagedListHolder.getPageCount());
		Integer page =  (Integer) session2.getAttribute("page");
		if (page == null || page < 1 || page > pagedListHolder.getPageCount())
			page = 1;

		model.addObject("page", page);
		if (page == null || page < 1 || page > pagedListHolder.getPageCount()) {
			pagedListHolder.setPage(0);
			model.addObject("deptList", pagedListHolder.getPageList());
		} else if (page <= pagedListHolder.getPageCount()) {
			pagedListHolder.setPage(page - 1);
			model.addObject("deptList", pagedListHolder.getPageList());
		}
		//model.addObject("deptList", lst);
		model.addObject("departId", deptId);
		return model;
	}
	
	@GetMapping("/language")
	public ModelAndView getLanguage() {
		return new ModelAndView("redirect:/listDept");

	}

	@PostMapping(value = "/updateDept")
	public ModelAndView updateEmployee(HttpServletRequest request, @ModelAttribute Department department) {
		HttpSession session2 = request.getSession();
		
	
		int deptId = Integer.parseInt(request.getParameter("deptId"));

		Department department1 = new Department();
		department1.setDeptId(department.getDeptId());
		department1.setDeptName(department.getDeptName());

		restTemplate.put("http://dept-emp-service/organize/updateDept/" + deptId, department1);
		Integer page =  (Integer) session2.getAttribute("page");
		  if(page!=null) {
			 
			  return new ModelAndView("redirect:/listDept?page="+page);
		  }

		return new ModelAndView("redirect:/listDept");

	}

	@GetMapping(value = "/deleteDept")
	public ModelAndView deleteDepartment(HttpServletRequest request) {
		HttpSession session2 = request.getSession();
	
		int departId = Integer.parseInt(request.getParameter("id"));
		restTemplate.delete("http://dept-emp-service/organize/deleteDept/" + departId);
		Integer page =  (Integer) session2.getAttribute("page");
		  if(page!=null) {
			  return new ModelAndView("redirect:/listDept?page="+page);
		  }
		return new ModelAndView("redirect:/listDept");
	}

}
