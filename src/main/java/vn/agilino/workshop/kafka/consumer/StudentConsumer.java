package vn.agilino.workshop.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import vn.agilino.workshop.constant.KafkaGroup;
import vn.agilino.workshop.dto.StudentDTO;

import static vn.agilino.workshop.constant.KafkaTopics.STUDENT_NEW_REGISTRATION_TOPIC;

@Service
@Slf4j
public class StudentConsumer {

    @KafkaListener(topics = STUDENT_NEW_REGISTRATION_TOPIC,
            groupId = KafkaGroup.GROUP_STUDENT,
            containerFactory = "kafkaListenerContainerFactory")
    public void studentRegistrationConsumer(StudentDTO studentDTO) {
        log.error(studentDTO.toString());
    }
}
