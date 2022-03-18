package org.essaadani.todoisttasksms.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Category {
    private Long id;
    private String name;
    private Date timestamp;
}
