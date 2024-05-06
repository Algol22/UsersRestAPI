package com.restapi.restapi;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Past;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {


    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@Valid @RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created: " + user.toString());
    }

    @PutMapping("/update/")
    public ResponseEntity<String> updateUser(@Valid @RequestBody User user) {
        boolean updated = updateUserValues(user);
        if (updated) {
            return ResponseEntity.ok("User updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User " + user.getFirstName() + " not found.");
        }
    }
    public boolean updateUserValues(User user) {
        Optional<User> optionalUser = userRepository.findById(user.getId());
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            existingUser.setBirthDate(user.getBirthDate());
            userRepository.save(existingUser);
            return true;
        }
        return false;
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok("User deleted successfully.");
    }

    @GetMapping("/search")
    public ResponseEntity<?> getUsersByBirthDateRange(@RequestParam @Past LocalDate from,
                                                      @RequestParam @Past LocalDate to) {
        if (from.isAfter(to)) {
            throw new EntityNotFoundException("From date must be before To date.");
        }
        List<User> users = userRepository.findByBirthDateBetween(from, to);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/list-all")
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

}
