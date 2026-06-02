package demo.demo.mapper.category;

import demo.demo.dto.request.category.CategoryRequest;
import demo.demo.dto.response.category.CategoryResponse;
import demo.demo.model.category.Category;

public class CategoryMapper {

    public static Category requestToCategory(CategoryRequest request){
        Category category = new Category();
        category.setName(request.getName());
        return category;
    }

    public static CategoryResponse categoryToResponse(Category category){
        CategoryResponse response = new CategoryResponse(category.getId(), category.getName());
        return response;
    }
}
