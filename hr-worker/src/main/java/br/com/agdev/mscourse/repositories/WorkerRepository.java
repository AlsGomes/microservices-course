package br.com.agdev.mscourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agdev.mscourse.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
