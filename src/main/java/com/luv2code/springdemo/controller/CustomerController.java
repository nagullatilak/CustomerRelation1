 package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	//need to inject the customerservice
	@Autowired
	private CustomerService customerService;
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		// Get customers from service
		List<Customer> theCustomers=customerService.getCustomers();
		//add the customers to the model
		theModel.addAttribute("customers",theCustomers);
		return "list-customers";	
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModal) {
		//Create model attribute to bind the form data
		theModal.addAttribute("customer", new Customer());
		return "customer-add";
	}
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		//save the customer to the list
		customerService.saveCustomer(theCustomer);
		return "customer-confirm";
		//return "redirect:/customer/list";
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,Model theModal) {
		//Get the customer from the DB
		Customer theCustomer = customerService.getCustomer(theId);
		//set customer as modal attribute to prepopulate your data
		theModal.addAttribute("customer",theCustomer);
		//save over to your form
		return "customer-add";
	}
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int theId,Model theModel) {
		Customer theCustomer=customerService.deleteCustomer(theId);
		theModel.addAttribute("customer", theCustomer);
		return "redirect:/customer/list";
	}

}
