package org.essaadani.todoisttasksms.web;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.essaadani.todoisttasksms.dto.TaskRequestDTO;
import org.essaadani.todoisttasksms.dto.TaskResponseDTO;
import org.essaadani.todoisttasksms.entities.Task;
import org.essaadani.todoisttasksms.mappers.TaskMapper;
import org.essaadani.todoisttasksms.openfeign.CategoryRestClient;
import org.essaadani.todoisttasksms.repository.TaskRepository;
import org.essaadani.todoisttasksms.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class TaskRestController {
    TaskService taskService;
    TaskRepository taskRepository;
    TaskMapper taskMapper;

    @GetMapping("/tasks/byCategory")
    public List<TaskResponseDTO> tasksByCategory(@RequestParam(required = false) Long id,
                                                 @RequestParam(required = false) String name){
       return taskService.findAllByCategory(id, name);
    }
    @PostMapping("/tasks")
    public TaskResponseDTO addTask(@RequestBody TaskRequestDTO taskRequestDTO){
        return taskService.addTask(taskRequestDTO);
    }
}
