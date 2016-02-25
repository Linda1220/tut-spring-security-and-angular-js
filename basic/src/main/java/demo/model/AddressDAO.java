package demo.model;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by Linda on 25/02/16.
 */
@Transactional
public interface AddressDAO extends CrudRepository<Order, Long> {
}
