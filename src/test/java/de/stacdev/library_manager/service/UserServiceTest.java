package de.stacdev.library_manager.service;

import de.stacdev.library_manager.dto.UserDTO;
import de.stacdev.library_manager.entity.User;
import de.stacdev.library_manager.exception.UserNotFoundException;
import de.stacdev.library_manager.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private UserDTO userDTO;
    private User user;

    @BeforeEach
    public void setUp() {
        userDTO = UserDTO.builder()
                .firstName("Ethan")
                .lastName("Souop")
                .email("ethan@stacdev.de")
                .build();

        user = User.builder()
                .firstName("Ethan")
                .lastName("Souop")
                .email("ethan@stacdev.de")
                .build();
    }

    @Test
    public void testCreateUser() {
        when(userRepository.save(any(User.class)))
                .thenReturn(user);
        UserDTO createdUser = userService.createUser(userDTO);

        assertNotNull(createdUser);
        assertEquals(userDTO.getUserId(), createdUser.getUserId());
        verify(userRepository, times(1))
                .save(any(User.class));
    }

    @Test
    public void testUpdateUser() {
        when(userRepository.findById(1))
                .thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class)))
                .thenReturn(user);

        UserDTO updatedUserDTO = userService.updateUser(1, userDTO);

        assertNotNull(updatedUserDTO);
        assertEquals(userDTO.getLastName(), updatedUserDTO.getLastName());
        verify(userRepository, times(1)).findById(1);
        verify(userRepository, times(1)).save(any(User.class));

    }

    @Test
    public void testGetUserFound() {
        when(userRepository.findById(1))
                .thenReturn(Optional.of(user));

        UserDTO foundUserDTO = userService.getUserById(1);

        assertNotNull(foundUserDTO);
        assertEquals(userDTO.getFirstName(), foundUserDTO.getFirstName());
        verify(userRepository, times(1)).findById(1);
    }

    @Test
    public void testGetUserNotFound() {
        Integer userId = 1;
        when(userRepository.findById(userId))
                .thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class,
                () -> userService.getUserById(userId));
    }

    @Test
    public void deleteUserById() {
        when(userRepository.findById(1))
                .thenReturn(Optional.of(user));
        userService.deleteUserById(1);

        verify(userRepository, times(1))
                .deleteById(1);

    }
}