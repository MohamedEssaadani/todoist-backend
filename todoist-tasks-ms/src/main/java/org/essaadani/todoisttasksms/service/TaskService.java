package org.essaadani.todoisttasksms.service;

import org.essaadani.todoisttasksms.dto.TaskRequestDTO;
import org.essaadani.todoisttasksms.dto.TaskResponseDTO;
import org.essaadani.todoisttasksms.entities.Task;

import java.util.List;

public interface TaskService {
    // tasks by category
    List<TaskResponseDTO> findAllByCategory(Long categoryId);
    // create task
    TaskResponseDTO addTask (TaskRequestDTO taskRequestDTO);
}
