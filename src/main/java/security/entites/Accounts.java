package security.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Accounts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_no")
	private int accountno;
	@Column(name = "account_holder_name")
	private String accountHodlerName;
	@Column(name = "account_type")
	private String accountType;
	@Column(name = "ifsc_code")
	private String ifscCode;
	@Column(name = "balance")
	private double balance;
	@Column(name = "status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "user_id",unique = true)
	private User user;

	public int getAccountno() {
		return accountno;
	}

	public void setAccountno(int accountno) {
		this.accountno = accountno;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
