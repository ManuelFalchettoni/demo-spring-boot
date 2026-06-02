package demo.demo.controller.category;

import demo.demo.dto.response.category.CategoryResponse;
import demo.demo.mapper.category.CategoryMapper;
import demo.demo.model.category.Category;
import demo.demo.service.category.CategoryFindAllService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryGetAllController {
    private final CategoryFindAllService categoryFindAllService;

    public CategoryGetAllController(CategoryFindAllService categoryFindAllService) {
        this.categoryFindAllService = categoryFindAllService;
    }
    @GetMapping
    public ResponseEntity<Page<CategoryResponse>> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page,size);
        Page<Category> categories = categoryFindAllService.findAll(pageable);

        return ResponseEntity.ok(
                categories.map(CategoryMapper::categoryToResponse)
        );
    }
}
