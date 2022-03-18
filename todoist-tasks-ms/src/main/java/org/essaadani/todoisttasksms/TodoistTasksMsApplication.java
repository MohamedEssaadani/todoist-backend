package org.essaadani.todoisttasksms;

import lombok.AllArgsConstructor;
import org.essaadani.todoisttasksms.entities.Task;
import org.essaadani.todoisttasksms.repository.TaskRepository;
import org.essaadani.todoisttasksms.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class TodoistTasksMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoistTasksMsApplication.class, args);
    }

    @Bean
    CommandLineRunner start(TaskRepository taskRepository){
        return args -> {
            Task task = new Task();
            task.setCategoryId(1L);
            task.setCategoryName("TODO");
            task.setTitle("Drink Coffee");
            task.setTimestamp(new Date());


            Task task2 = new Task();
            task2.setCategoryId(1L);
            task2.setCategoryName("TODO");
            task2.setTitle("Watch news");
            task2.setTimestamp(new Date());

            taskRepository.save(task);
            taskRepository.save(task2);

            taskRepository.findAll()
                    .stream()
                    .forEach(tsk -> {
                        System.out.println(tsk.getTitle());
                    });
        };
    }
}
