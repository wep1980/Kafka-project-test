package br.com.wepdev.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wepdev.services.StringProducerService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/kafka/producer")
public class StringProducerResource {
	
	
	private final StringProducerService producerService;
	
	
	/*
	 * ResponseEntity<?> -> Não sabemos o tipo de retorno
	 */
	@PostMapping
	public ResponseEntity<?> sendMessage(@RequestBody String message){
		
		producerService.sendMessage(message);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
