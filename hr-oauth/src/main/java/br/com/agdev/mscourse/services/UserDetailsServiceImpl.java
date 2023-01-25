package br.com.agdev.mscourse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.agdev.mscourse.config.UserSecurity;
import br.com.agdev.mscourse.entities.User;
import br.com.agdev.mscourse.feignclients.UserFeignClient;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserFeignClient userFeignClient;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			ResponseEntity<User> responseEntity = userFeignClient.findByParams(username);
			User user = responseEntity.getBody();
			log.info(String.format("Email found: %s", username));
			return new UserSecurity(user);
		} catch (FeignException | UsernameNotFoundException e) {
			log.error(String.format("Email not found: %s", username));
			return null;
		}
	}
}
