package vn.agilino.workshop.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopic {

    private final String topicName;

    public KafkaTopic(@Value("${spring.kafka.topic-name}") String topicName) {
        this.topicName = topicName;
    }

    public String getTopicName() {
        return topicName;
    }
}
