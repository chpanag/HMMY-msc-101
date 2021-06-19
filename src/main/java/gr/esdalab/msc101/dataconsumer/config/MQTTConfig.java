package gr.esdalab.msc101.dataconsumer.config;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "mqtt")
public class MQTTConfig {

    Map<String, String> topics;

    @Bean
    public MqttConnectOptions mqttConnectOptions() {
        return new MqttConnectOptions();
    }

    @Bean
    public IMqttClient mqttClient(@Value("${mqtt.clientID}") String clientId,
                                  @Value("${mqtt.broker-url}") String brokerUrl) throws MqttException {

        IMqttClient mqttClient = new MqttClient(brokerUrl, clientId);

        mqttClient.connect(mqttConnectOptions());

        return mqttClient;
    }

    public Map<String, String> getTopics(){
        return this.topics;
    }

    public void setTopics(Map<String, String> topics) {
        this.topics = topics;
    }
}
