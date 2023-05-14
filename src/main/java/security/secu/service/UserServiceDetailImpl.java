package security.secu.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import security.entites.User;
import security.repositroy.UserRepository;
import security.secu.bean.UserDetaislImpl;
@Service
public class UserServiceDetailImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserDetaislImpl userDetaislImpl=null;
		
		Optional<User> user = userRepository.findByEmailAdress(username);
		
			if(user.isPresent()) {
				User t=user.get();
				userDetaislImpl=new UserDetaislImpl(t.getUserId(), t.getEmailAdress(), t.getPassword(), t.getRole().getRoleName(),t.getStatus());
			}else {
				throw new UsernameNotFoundException("user name not found");
			}
			
			return userDetaislImpl;
	}

//	public static void main(String[] args) {
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		System.out.println(passwordEncoder.encode("welcome1"));
//	}
	
}
