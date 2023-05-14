package security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import security.dto.AccountDto;
import security.entites.Accounts;
import security.exception.AccountNotFoundException;
import security.repositroy.AccountRepository;

@Service  
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;


	@Transactional(readOnly = true)
	public AccountDto findAccount(int accountNo) {
		System.out.println("account service");
		Optional<Accounts> optionalAccount =accountRepository.findById(accountNo);
		AccountDto accountDto = new AccountDto();
		
			 
		  optionalAccount.ifPresentOrElse((t)->{
		  accountDto.setAccountNo(t.getAccountno());
		  accountDto.setAccountHodlerName(t.getAccountHodlerName());
		  accountDto.setAccountType(t.getAccountType());
		  accountDto.setBalance(t.getBalance());
		  accountDto.setIfscCode(t.getIfscCode()); accountDto.setStatus(t.getStatus());
		  
		  },()->{ throw new AccountNotFoundException("accountNo not found") ; });
		
		  return accountDto;
		 
	}
	
}
