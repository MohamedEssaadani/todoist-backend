package org.essaadani.todoisttasksms.dto;

import lombok.Data;

@Data
public class TaskRequestDTO {
    private String title;
    // category
    private Long categoryId;
}
