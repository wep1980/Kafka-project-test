package br.com.wepdev.config;

import java.util.HashMap;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaConfig {
	
	
	@Autowired
	public KafkaProperties properties;
	
	@Bean
	public KafkaAdmin kafkaAdmin() {
		
		var configs = new HashMap<String, Object>();
		configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
		
		return new KafkaAdmin(configs);
	}
	
	
	@Bean
	public KafkaAdmin.NewTopics topics(){
		return new  KafkaAdmin.NewTopics( // Array de um novo topico
				TopicBuilder.name("str-topic")
				.partitions(2)
				.replicas(1)
				.build()
				);
	}

}
