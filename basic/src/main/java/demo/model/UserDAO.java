// Copyright Fairfax Media 2014

package demo.model;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ke.yang on 21/02/2016.
 */
@Transactional
public interface UserDAO extends CrudRepository<User, Long> {
}
