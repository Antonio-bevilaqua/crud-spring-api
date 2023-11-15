package api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api.entities.User;

import java.util.List;

import api.repositories.UserRepository;
import api.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        final User foundUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());

        userRepository.delete(foundUser);
    }

    public User update(Long id, User user) {
        final User foundUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());

        if (user.getNome() != null) {
            foundUser.setNome(user.getNome());
        }
        if (user.getEmail() != null) {
            foundUser.setEmail(user.getEmail());
        }
        if (user.getTelefone() != null) {
            foundUser.setTelefone(user.getTelefone());
        }
        if (user.getPassword() != null) {
            foundUser.setPassword(user.getPassword());
        }

        return userRepository.save(foundUser);
    }
}
