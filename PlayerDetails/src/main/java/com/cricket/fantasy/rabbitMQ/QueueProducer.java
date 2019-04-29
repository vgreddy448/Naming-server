/*
 * package com.cricket.fantasy.rabbitMQ;
 * 
 * import org.codehaus.jackson.map.ObjectMapper; import org.slf4j.Logger; import
 * org.slf4j.LoggerFactory; import
 * org.springframework.amqp.rabbit.core.RabbitTemplate; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.beans.factory.annotation.Value; import
 * org.springframework.stereotype.Component;
 * 
 * import com.cricket.fantasy.players.Players;
 * 
 * @Component public class QueueProducer {
 * 
 * protected Logger logger = LoggerFactory.getLogger(getClass());
 * 
 * @Value("${fanout.exchange}") private String fanoutExchange; private final
 * RabbitTemplate rabbitTemplate;
 * 
 * @Autowired public QueueProducer(RabbitTemplate rabbitTemplate) { super();
 * this.rabbitTemplate = rabbitTemplate; }
 * 
 * public void produce(Players players) throws Exception {
 * logger.info("Storing notification...");
 * rabbitTemplate.setExchange(fanoutExchange); rabbitTemplate.convertAndSend(new
 * ObjectMapper().writeValueAsString(players));
 * logger.info("Notification stored in queue sucessfully"); }
 * 
 * }
 */