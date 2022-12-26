package vn.agilino.workshop;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.SendResult;
import org.springframework.lang.Nullable;

public class TestKafkaTemplate<K,V> extends KafkaTemplate<K,V> {
    public TestKafkaTemplate(ProducerFactory<K, V> producerFactory) {
        super(producerFactory);
    }

    public TestKafkaTemplate(ProducerFactory<K, V> producerFactory,
            Map<String, Object> configOverrides) {
        super(producerFactory, configOverrides);
    }

    public TestKafkaTemplate(ProducerFactory<K, V> producerFactory, boolean autoFlush) {
        super(producerFactory, autoFlush);
    }

    public TestKafkaTemplate(ProducerFactory<K, V> producerFactory, boolean autoFlush,
            Map<String, Object> configOverrides) {
        super(producerFactory, autoFlush, configOverrides);
    }

    @Override
    public CompletableFuture<SendResult<K, V>> send(String topic, @Nullable V data) {
        // overwrite for tests to do nothing
        return null;
    }
}
