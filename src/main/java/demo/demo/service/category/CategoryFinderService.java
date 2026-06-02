package demo.demo.service.category;

import demo.demo.exception.category.CategoryNotFoundException;
import demo.demo.model.category.Category;
import demo.demo.repository.category.JpaCategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryFinderService {
    private final JpaCategoryRepository jpaCategoryRepository;

    public CategoryFinderService(JpaCategoryRepository jpaCategoryRepository) {
        this.jpaCategoryRepository = jpaCategoryRepository;
    }

    public Category find(Long id){
        return jpaCategoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));

    }
}
