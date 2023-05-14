package security.dto;

public class AccountDto {

	private int accountNo;
	private String accountHodlerName;
	private String accountType;
	private String ifscCode;
	private double balance;
	private String status;
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountHodlerName() {
		return accountHodlerName;
	}
	public void setAccountHodlerName(String accountHodlerName) {
		this.accountHodlerName = accountHodlerName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
