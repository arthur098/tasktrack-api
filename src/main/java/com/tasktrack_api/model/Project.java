package com.tasktrack_api.model;

import com.tasktrack_api.enumerator.EnumProjectCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "projects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class Project {

    @Id
    private String id;
    private String title;
    private String description;
    private EnumProjectCategory category;
    private Integer progress;
    private LocalDateTime createdAt;
}
