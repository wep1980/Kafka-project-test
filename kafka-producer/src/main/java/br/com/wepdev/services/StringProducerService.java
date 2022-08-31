package br.com.wepdev.services;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Service
public class StringProducerService {
	
	/*
	 * Construtor que ja injeta uma instancia, Lombok @RequiredArgsConstructor
	 */
	private  final KafkaTemplate<String, String> kafkaTemplate;
	
	
	public void sendMessage(String message) {
		
		kafkaTemplate.send("str-topic", message).addCallback(
				success -> {
					if(success != null) {
						log.info("Send message with success {}", message);
						log.info("Partition {}, Offset{}", 
								success.getRecordMetadata().partition(),
								success.getRecordMetadata().offset());
					}
				},
				error -> log.error("Error sendo message"));
	}

}
