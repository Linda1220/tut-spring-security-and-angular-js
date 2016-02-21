package demo.model;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by Linda on 21/02/16.
 */

@Transactional
public interface ProductDAO extends CrudRepository<Product, Long> {
}
