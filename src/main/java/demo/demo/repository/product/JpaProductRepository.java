package demo.demo.repository.product;

import demo.demo.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
}
