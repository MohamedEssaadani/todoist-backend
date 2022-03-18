package org.essaadani.todoisttasksms.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.essaadani.todoisttasksms.dto.TaskRequestDTO;
import org.essaadani.todoisttasksms.dto.TaskResponseDTO;
import org.essaadani.todoisttasksms.entities.Task;
import org.essaadani.todoisttasksms.mappers.TaskMapper;
import org.essaadani.todoisttasksms.models.Category;
import org.essaadani.todoisttasksms.openfeign.CategoryRestClient;
import org.essaadani.todoisttasksms.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {
    TaskRepository taskRepository;
    CategoryRestClient categoryRestClient;
    TaskMapper taskMapper;

    @Override
    public List<TaskResponseDTO> findAllByCategory(Long categoryId, String name) {
        List<Task>  tasks = null;

        if(categoryId != null){
            // get all tasks by category id
            tasks = taskRepository.findByCategoryId(categoryId);
            return tasks
                    .stream()
                    .map(taskMapper::taskToTaskDto)
                    .collect(Collectors.toList());
        }

        if(name != null){
            // get all tasks by category id
            tasks = taskRepository.findByCategoryName(name);
            return tasks
                    .stream()
                    .map(taskMapper::taskToTaskDto)
                    .collect(Collectors.toList());
        }

        return null;
    }

    @Override
    public TaskResponseDTO addTask(TaskRequestDTO taskRequestDTO) {
        Task task = taskMapper.taskDtoToTask(taskRequestDTO);
        task.setCategoryName(getCategoryById(task.getCategoryId()).getName());
        task.setCategory(getCategoryById(task.getCategoryId()));

        Task savedTask = taskRepository.save(task);

        return taskMapper.taskToTaskDto(savedTask);
    }

    private Category getCategoryById(Long categoryId){
        return categoryRestClient.getCategoryById(categoryId);
    }
}
