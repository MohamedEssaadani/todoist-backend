package org.essaadani.categoryms;

import lombok.RequiredArgsConstructor;
import org.essaadani.categoryms.entities.Category;
import org.essaadani.categoryms.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
public class CategoryMsApplication implements RepositoryRestConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(CategoryMsApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CategoryRepository categoryRepository){
        return args -> {
          categoryRepository.save(new Category(null, "TODO"));
          categoryRepository.save(new Category(null, "INPROGRESS"));
          categoryRepository.save(new Category(null, "DONE"));
        };
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Category.class);
    }


}
