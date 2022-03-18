package org.essaadani.categoryms.repository;


import org.essaadani.categoryms.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @RestResource(path = "byName", rel = "byName")
     Category findByName(@Param("name") String name);


}
