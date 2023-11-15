package api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.entities.User;
import api.services.UserService;
import api.services.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        try {
            return userService.findById(id);
        } catch (ResourceNotFoundException exception) {
            throw new ResourceNotFoundException();
        }
    }

    @PostMapping
    public User insert(@RequestBody User newUser) {
        return userService.insert(newUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            userService.delete(id);
            final HttpStatus status = HttpStatus.OK;
            return new ResponseEntity<>("Usuário removido com sucesso", status);
        } catch (ResourceNotFoundException exception) {
            throw new ResourceNotFoundException();
        }
    }

    @PutMapping("/{id}")
    public User update(@RequestBody User newUser, @PathVariable Long id) {
        try {
            return userService.update(id, newUser);
        } catch (ResourceNotFoundException exception) {
            throw new ResourceNotFoundException();
        }
    }

}
