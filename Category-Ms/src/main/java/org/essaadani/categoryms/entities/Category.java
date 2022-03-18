package org.essaadani.categoryms.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Category {
    @Id @GeneratedValue
    private Long id;
    private String name;
}
