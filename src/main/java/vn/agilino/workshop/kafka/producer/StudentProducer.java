package vn.agilino.workshop.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import vn.agilino.workshop.constant.KafkaTopics;
import vn.agilino.workshop.dto.StudentDTO;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentProducer {

    private final KafkaTemplate<String, StudentDTO> kafkaTemplate;

    public void sendMessage(StudentDTO studentDTO) {
        studentDTO.setId(UUID.randomUUID());
        kafkaTemplate.send(KafkaTopics.STUDENT_NEW_REGISTRATION_TOPIC, studentDTO);
    }
}
