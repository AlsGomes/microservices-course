package br.com.agdev.mscourse.controllers;

import java.util.Optional;

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
		Optional<User> objOpt = repository.findByEmail(email);
		if (objOpt.isEmpty())
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(objOpt.get());
	}
}
