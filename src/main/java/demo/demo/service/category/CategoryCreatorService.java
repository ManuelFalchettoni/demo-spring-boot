package demo.demo.service.category;

import demo.demo.dto.request.category.CategoryRequest;
import demo.demo.mapper.category.CategoryMapper;
import demo.demo.model.category.Category;
import demo.demo.repository.category.JpaCategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryCreatorService {
    private final JpaCategoryRepository jpaCategoryRepository;

    public CategoryCreatorService(JpaCategoryRepository jpaCategoryRepository) {
        this.jpaCategoryRepository = jpaCategoryRepository;
    }

    public Category create(CategoryRequest request){
        Category category = CategoryMapper.requestToCategory(request);
        Category saved = jpaCategoryRepository.save(category);
        return saved;
    }
}
