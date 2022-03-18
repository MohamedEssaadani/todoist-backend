package org.essaadani.categoryms.repository;


import org.essaadani.categoryms.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
