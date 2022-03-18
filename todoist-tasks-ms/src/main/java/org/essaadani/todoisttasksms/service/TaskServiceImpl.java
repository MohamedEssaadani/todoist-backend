package org.essaadani.todoisttasksms.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.essaadani.todoisttasksms.dto.TaskRequestDTO;
import org.essaadani.todoisttasksms.dto.TaskResponseDTO;
import org.essaadani.todoisttasksms.entities.Task;
import org.essaadani.todoisttasksms.mappers.TaskMapper;
import org.essaadani.todoisttasksms.openfeign.CategoryRestClient;
import org.essaadani.todoisttasksms.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    TaskRepository taskRepository;
    CategoryRestClient categoryRestClient;
    TaskMapper taskMapper;

    @Override
    public List<TaskResponseDTO> findAllByCategory(Long categoryId) {
        // get all tasks by category id
        List<Task>  tasks= taskRepository.findByCategoryId(categoryId);
        System.out.println(categoryId);

        // set category
        tasks.forEach(task->{
            System.out.println(task.getTitle());
            // get category from category micro service
        task.setCategory(categoryRestClient.getCustomerById(categoryId));
        });

        return tasks
                .stream()
                .map(taskMapper::taskToTaskDto)
                .collect(Collectors.toList());


    }

    @Override
    public TaskResponseDTO addTask(TaskRequestDTO taskRequestDTO) {
        return null;
    }
}
