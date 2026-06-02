package demo.demo.service.category;

import demo.demo.repository.category.JpaCategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryDeleterService {
    private final JpaCategoryRepository jpaCategoryRepository;

    public CategoryDeleterService(JpaCategoryRepository jpaCategoryRepository) {
        this.jpaCategoryRepository = jpaCategoryRepository;
    }

    public void delete(Long id){
        jpaCategoryRepository.deleteById(id);
    }
}
