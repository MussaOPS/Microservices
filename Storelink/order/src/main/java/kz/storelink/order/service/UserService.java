package kz.storelink.order.service;

import kz.storelink.order.model.User;
import kz.storelink.order.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public User getUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("Not Found User");
        }

        return userRepository.findById(id).get();

    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

}
