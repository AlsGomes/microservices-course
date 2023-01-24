package br.com.agdev.mscourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.agdev.mscourse.entities.User;
import br.com.agdev.mscourse.repositories.UserRepository;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserRepository repository;

	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);
	}

	@GetMapping("/search")
	public ResponseEntity<User> findByParams(@RequestParam String email) {
		User obj = repository.findByEmail(email).get();
		return ResponseEntity.ok(obj);
	}
}
