package org.essaadani.todoisttasksms.mappers;

import org.essaadani.todoisttasksms.dto.TaskRequestDTO;
import org.essaadani.todoisttasksms.dto.TaskResponseDTO;
import org.essaadani.todoisttasksms.entities.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskResponseDTO taskToTaskDto(Task task);
    Task taskDtoToTask(TaskRequestDTO taskRequestDTO);
}
