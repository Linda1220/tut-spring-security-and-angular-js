package demo.model;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by Linda on 26/02/16.
 */
@Transactional
public interface OrderDetailDAO extends CrudRepository<OrderDetail, Long> {
}
