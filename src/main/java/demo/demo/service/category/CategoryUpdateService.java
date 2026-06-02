package demo.demo.service.category;

import demo.demo.dto.request.category.CategoryRequest;
import demo.demo.model.category.Category;
import demo.demo.repository.category.JpaCategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryUpdateService {
    private final JpaCategoryRepository jpaCategoryRepository;
    private final CategoryFinderService categoryFinderService;

    public CategoryUpdateService(JpaCategoryRepository jpaCategoryRepository, CategoryFinderService categoryFinderService) {
        this.jpaCategoryRepository = jpaCategoryRepository;
        this.categoryFinderService = categoryFinderService;
    }

    public Category update(CategoryRequest request, Long id){
        Category category = categoryFinderService.find(id);
        category.setName(request.getName());
        Category save = jpaCategoryRepository.save(category);
        return save;
    }
}
