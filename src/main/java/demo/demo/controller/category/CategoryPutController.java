package demo.demo.controller.category;

import demo.demo.dto.request.category.CategoryRequest;
import demo.demo.dto.response.category.CategoryResponse;
import demo.demo.mapper.category.CategoryMapper;
import demo.demo.service.category.CategoryUpdateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryPutController {
    private final CategoryUpdateService categoryUpdateService;

    public CategoryPutController(CategoryUpdateService categoryUpdateService) {
        this.categoryUpdateService = categoryUpdateService;
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> update(@RequestBody CategoryRequest request, @PathVariable Long id){
        CategoryResponse response = CategoryMapper.categoryToResponse(categoryUpdateService.update(request,id));
        return ResponseEntity.ok(response);
    }
}
