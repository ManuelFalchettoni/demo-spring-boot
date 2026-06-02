package demo.demo.controller.category;

import demo.demo.dto.response.category.CategoryResponse;
import demo.demo.mapper.category.CategoryMapper;
import demo.demo.service.category.CategoryFinderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryGetController {
    private final CategoryFinderService categoryFinderService;

    public CategoryGetController(CategoryFinderService categoryFinderService) {
        this.categoryFinderService = categoryFinderService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> find(@PathVariable Long id){
        CategoryResponse response = CategoryMapper.categoryToResponse(categoryFinderService.find(id));
        return ResponseEntity.ok(response);
    }
}
