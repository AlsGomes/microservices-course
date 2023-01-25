package br.com.agdev.mscourse.controllers;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.agdev.mscourse.config.UserSecurity;
import br.com.agdev.mscourse.entities.User;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserDetailsService service;

	@GetMapping("/search")
	public ResponseEntity<User> findByParams(@RequestParam String email) {
		UserSecurity userSecurity = (UserSecurity) service.loadUserByUsername(email);

		if (Objects.isNull(userSecurity))
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(userSecurity.getUser());
	}
}
