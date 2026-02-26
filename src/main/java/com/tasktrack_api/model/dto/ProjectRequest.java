package com.tasktrack_api.model.dto;

import com.tasktrack_api.enumerator.EnumProjectCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProjectRequest(String cod,
                             @NotBlank(message = "{project.title.required}") String title,
                             @NotBlank(message = "{project.description.required}") String description,
                             @NotNull(message = "{project.category.required}") EnumProjectCategory category,
                             Integer progress) {
}
