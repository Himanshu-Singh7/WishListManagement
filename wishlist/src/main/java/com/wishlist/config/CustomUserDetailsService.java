package com.wishlist.config;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.wishlist.entity.Role;
import com.wishlist.entity.User;
import com.wishlist.repository.UserRepo;


@Service
public class CustomUserDetailsService implements UserDetailsService {

	
    @Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User user = userRepo.findByUsernameOrEmail(username, username).orElseThrow(()-> new UsernameNotFoundException("User not found with username or email:"+username));
		
		 return new org.springframework.security.core.userdetails.User(user.getEmail(),
	                user.getPassword(), mapRolesToAuthorities(user.getRoles()));
	}


    
	private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }


    
	

}
