package bankapplication.service;

import bankapplication.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User UserToCreate ) throws IllegalAccessException;

}
