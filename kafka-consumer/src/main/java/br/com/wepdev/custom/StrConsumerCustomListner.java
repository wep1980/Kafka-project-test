package br.com.wepdev.custom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.kafka.annotation.KafkaListener;

@Retention(RetentionPolicy.RUNTIME) // Informa para o compilador e JVM que essa anotação esta disponivel em tempo de execução
@Target(ElementType.METHOD) // Pode definir suas proprias anotações customizadas
@KafkaListener
public @interface StrConsumerCustomListner {
	
	
	@AliasFor(annotation = KafkaListener.class, attribute = "topics") // Decorar atributos dentro de uma unica anotação
	String[] topics() default "str-topic";
	
	@AliasFor(annotation = KafkaListener.class, attribute = "containerFactory") // Decorar atributos dentro de uma unica anotação
	String containerFactory() default "strContainerFactory";

	@AliasFor(annotation = KafkaListener.class, attribute = "groupId") // Decorar atributos dentro de uma unica anotação
	String groupId() default ""; // O default sera definido por nos mesmo
}
