package org.essaadani.todoisttasksms.web;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.essaadani.todoisttasksms.dto.TaskResponseDTO;
import org.essaadani.todoisttasksms.entities.Task;
import org.essaadani.todoisttasksms.mappers.TaskMapper;
import org.essaadani.todoisttasksms.openfeign.CategoryRestClient;
import org.essaadani.todoisttasksms.repository.TaskRepository;
import org.essaadani.todoisttasksms.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class TaskRestController {
    TaskService taskService;
    TaskRepository taskRepository;
    TaskMapper taskMapper;

    @GetMapping("/tasks/{categoryId}")
    public List<TaskResponseDTO> tasksByCategory(@PathVariable Long categoryId){
        // get all tasks by category id
        List<Task>  tasks= taskRepository.findByCategoryId(categoryId);

        return tasks
                .stream()
                .map(taskMapper::taskToTaskDto)
                .collect(Collectors.toList());
    }
}
