package security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import security.dto.AccountDto;
import security.exception.AccountNotFoundException;
import security.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {

	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/find.htm")
	public String showFindAccountPage(){
		System.out.println("new");
		return "find-account";
	}

	
	  @PostMapping("/find.htm") 
	  public String findAccount(@RequestParam("accountNo") String accNo,Model model) { 
		  System.out.println("account");
		  AccountDto acc= accountService.findAccount(Integer.parseInt(accNo));
	  model.addAttribute("account",acc); 
	  return "account-details"; 
	  }
	 
	@ExceptionHandler(AccountNotFoundException.class)
	public String handleAccountNotFoundException(AccountNotFoundException e) {
		return "account-error";
	}
	@GetMapping("/home.htm")
	public String home() {
		return "home";
	}

}
