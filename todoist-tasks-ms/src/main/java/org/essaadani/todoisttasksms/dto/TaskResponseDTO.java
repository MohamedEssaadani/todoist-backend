package org.essaadani.todoisttasksms.dto;

import lombok.Data;
import org.essaadani.todoisttasksms.models.Category;


@Data
public class TaskResponseDTO {
    private Long id;
    private String title;

    // category
    private Category category;
}
