package br.com.agdev.mscourse.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.agdev.mscourse.entities.User;

@FeignClient(name = "hr-user", path = "/users")
@Component
public interface UserFeignClient {

	@GetMapping("/search")
	ResponseEntity<User> findByParams(@RequestParam String email);
}
