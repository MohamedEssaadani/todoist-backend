package org.essaadani.categoryms.mappers;

import org.essaadani.categoryms.dto.CategoryRequestDTO;
import org.essaadani.categoryms.dto.CategoryResponseDTO;
import org.essaadani.categoryms.entities.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryResponseDTO toCategoryDTO(Category category);
    Category toCategory(CategoryRequestDTO categoryRequestDTO);
}
