package demo.demo.service.category;

import demo.demo.model.category.Category;
import demo.demo.repository.category.JpaCategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryFindAllService {
    private final JpaCategoryRepository jpaCategoryRepository;

    public CategoryFindAllService(JpaCategoryRepository jpaCategoryRepository) {
        this.jpaCategoryRepository = jpaCategoryRepository;
    }

    public Page<Category> findAll(Pageable pageable){
        return jpaCategoryRepository.findAll(pageable);
    }
}
