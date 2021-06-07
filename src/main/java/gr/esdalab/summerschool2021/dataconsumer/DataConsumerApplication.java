package gr.esdalab.summerschool2021.dataconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class DataConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataConsumerApplication.class, args);
    }

}
