package org.essaadani.todoisttasksms.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.essaadani.todoisttasksms.models.Category;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Task {
    @Id @GeneratedValue
    private Long id;
    private String title;
    private Date timestamp;

    // category
    private Long categoryId;
    private String categoryName;

    @Transient
    private Category category;

}
