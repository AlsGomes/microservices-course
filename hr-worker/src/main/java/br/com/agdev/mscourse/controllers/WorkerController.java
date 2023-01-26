package br.com.agdev.mscourse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agdev.mscourse.entities.Worker;
import br.com.agdev.mscourse.repositories.WorkerRepository;
import lombok.extern.slf4j.Slf4j;

@RefreshScope
@Slf4j
@RestController
@RequestMapping("/workers")
public class WorkerController {

	@Autowired
	private WorkerRepository repository;

	@Autowired
	private Environment env;
	
	@GetMapping("/configs")
	public ResponseEntity<Void> getConfigs() {
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = repository.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {

//		try {
//			Thread.sleep(3L * 1000L);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		log.info("PORT=" + env.getProperty("local.server.port"));

		Worker obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);
	}
}
