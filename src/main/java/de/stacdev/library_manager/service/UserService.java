package de.stacdev.library_manager.service;

import de.stacdev.library_manager.dto.UserDTO;
import de.stacdev.library_manager.entity.User;
import de.stacdev.library_manager.exception.UserNotFoundException;
import de.stacdev.library_manager.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * @author Collins Souop
 */
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = User.builder()
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .email(userDTO.getEmail())
                .build();
        User userSaved = userRepository.save(user);
        return mapToDto(userSaved);
    }

    public UserDTO getUserById(Integer id) {
        User user = userRepository
                .findById(id).orElseThrow(() ->
                        new UserNotFoundException(
                                "User with ID: " + id + " not found"));
        return mapToDto(user);
    }

    public UserDTO updateUser(Integer id, UserDTO userDTO) {
        User user = userRepository
                .findById(id).orElseThrow(() ->
                        new UserNotFoundException(
                                "User with ID: " + id + " not found"));

        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        User userUpdated = userRepository.save(user);

        return mapToDto(userUpdated);
    }

    public void deleteUserById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(
                        "User with ID: " + id + " not found"
                ));
        userRepository.deleteById(user.getId());
    }

    private UserDTO mapToDto(User user) {
        return UserDTO.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }

}
