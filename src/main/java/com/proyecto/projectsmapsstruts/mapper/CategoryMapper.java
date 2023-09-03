package com.proyecto.projectsmapsstruts.mapper;

import com.proyecto.projectsmapsstruts.dto.GetCategory;
import com.proyecto.projectsmapsstruts.entity.Category;
import com.proyecto.projectsmapsstruts.repository.CategoryRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper {
    @Autowired
    private CategoryRepository categoryRepository;

    abstract GetCategory toGetCategory(Category category);

    //quitamos cualquier anotacion para hacer nusetro mapping persoanzalido
    Category toEntity(GetCategory getCategory) {
        if (getCategory == null )
            return null;

        Category category = categoryRepository.findById(getCategory.getId())
                .orElse(null);

        if(category == null)
            return null;

        category.setId(getCategory.getId());
        category.setName((getCategory.getName()));
        return category;


    }

    abstract List<GetCategory> toGetCategoryList(List<Category> categoryList);

    abstract List<Category> toEntityList(List<GetCategory> getCategoryList);


}
