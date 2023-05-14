package security.secu.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetaislImpl implements UserDetails{

	private int userId;
	private String emailAdress;
	private String password;
	private String status;
	private Collection<GrantedAuthority> authorities;
	
	//authorities is the object that contains role name
	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public UserDetaislImpl(int userId, String emailAdress, String password,String roleName, String status) {
		super();
		this.userId = userId;
		this.emailAdress = emailAdress;
		this.password = password;
		this.status = status;
		authorities=new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(roleName));
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return emailAdress;
	}

	@Override
	public boolean isAccountNonExpired() {
		return !status.equals("E");
	}

	@Override
	public boolean isAccountNonLocked() {
		return !status.equals("L");
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !status.equals("C");
	}

	@Override
	public boolean isEnabled() {
		return status.equals("A");
	}

}
