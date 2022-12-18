package vn.agilino.workshop.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class StudentDTO {
    @JsonIgnore
    private UUID id;
    private String name;
}
