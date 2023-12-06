package bankapplication.service.impl;


import bankapplication.domain.model.User;
import bankapplication.domain.repository.UserRepository;
import bankapplication.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {
   private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new NoSuchElementException());
    }

    @Override
    public User create(User userToCreate) throws IllegalAccessException {
        if(userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalAccessException("This account number already exists.");
        }
        return userRepository.save(userToCreate);
    }
}
