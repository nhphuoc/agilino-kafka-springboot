package vn.agilino.workshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.agilino.workshop.dto.StudentDTO;
import vn.agilino.workshop.kafka.producer.StudentProducer;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/kafka", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {
    private final StudentProducer producer;

    @PostMapping(path = "/send")
    public ResponseEntity<Void> sendKafKaMessage(@RequestBody StudentDTO studentDTO) {
        producer.sendMessage(studentDTO);
        return ResponseEntity.noContent().build();
    }
}
