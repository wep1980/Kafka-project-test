package br.com.wepdev.listeners;

import org.springframework.stereotype.Component;

import br.com.wepdev.custom.StrConsumerCustomListner;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class StrConsumerListener {
	
	@StrConsumerCustomListner(groupId = "group-1")
	public void create(String message) {
		log.info("CREATE ::: Receive message {}", message);
	}
	

	@StrConsumerCustomListner(groupId = "group-1")
	public void log(String message) {
		log.info("LOG ::: Receive message {}", message);
	}
	
	
	@StrConsumerCustomListner(groupId = "group-2")
	public void history(String message) {
		log.info("HISTORY ::: Receive message {}", message);
	}
}
