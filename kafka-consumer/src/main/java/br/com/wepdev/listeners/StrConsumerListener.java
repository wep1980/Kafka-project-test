package br.com.wepdev.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.wepdev.custom.StrConsumerCustomListner;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class StrConsumerListener {
	
	@SneakyThrows // Esse metodo pode lançar uma excessão, seria a mesma coisa que declarar : throws Exception
	@StrConsumerCustomListner(groupId = "group-1")
	public void create(String message) {
		log.info("CREATE ::: Receive message {}", message);
		throw new IllegalArgumentException("EXCEPTION...."); // Lançando uma exception para testes
	}
	

	@StrConsumerCustomListner(groupId = "group-1")
	public void log(String message) {
		log.info("LOG ::: Receive message {}", message);
	}
	
	
	@KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "validMessageContainerFactory")
	public void history(String message) {
		log.info("HISTORY ::: Receive message {}", message);
	}
}
