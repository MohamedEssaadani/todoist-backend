package org.essaadani.todoisttasksms.openfeign;

import org.essaadani.todoisttasksms.models.Category;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("CATEGORY-SERVICE")
public interface CategoryRestClient {
    @GetMapping("/categories/{id}")
    Category getCategoryById(@PathVariable Long id);
}
