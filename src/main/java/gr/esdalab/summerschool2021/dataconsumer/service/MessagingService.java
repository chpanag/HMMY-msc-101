package gr.esdalab.summerschool2021.dataconsumer.service;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Base64;

@Service
@Data
@Log4j2
public class MessagingService {

    @Autowired
    private IMqttClient mqttClient;

    @Value("${mqtt.topics}")
    private String[] topics;


    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Arrays.asList(topics).forEach(topic -> {
            try {
                log.info("Subscribing to: {}.", topic);
                subscribe(topic);
            } catch (MqttException | InterruptedException e) {
                log.error(e);
            }
        });
    }


    public void subscribe(final String topic) throws MqttException, InterruptedException {


        mqttClient.subscribeWithResponse(topic, (tpic, msg) -> {

            System.out.println("Messages received: " + msg.toString());
            MqttMessage mqttMessage = new MqttMessage();
            mqttMessage.setPayload(new String("Received from summerschool2").getBytes());
            mqttClient.publish("summerschool/2021/topic/4", mqttMessage);

        });
    }

}
