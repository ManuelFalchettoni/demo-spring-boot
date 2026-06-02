package demo.demo.controller.category;

import demo.demo.dto.request.category.CategoryRequest;
import demo.demo.dto.response.category.CategoryResponse;
import demo.demo.mapper.category.CategoryMapper;
import demo.demo.service.category.CategoryCreatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryPostController {
    private final CategoryCreatorService categoryCreatorService;

    public CategoryPostController(CategoryCreatorService categoryCreatorService) {
        this.categoryCreatorService = categoryCreatorService;
    }
    @PostMapping
    public ResponseEntity<CategoryResponse> create(@RequestBody CategoryRequest request){
        CategoryResponse response = CategoryMapper.categoryToResponse(categoryCreatorService.create(request));
        return ResponseEntity.ok(response);
    }
}
