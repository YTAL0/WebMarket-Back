package org.webmarketapp.webmarket.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.webmarketapp.webmarket.core.exception.ResourceNotFoundException;
import org.webmarketapp.webmarket.domain.user.repository.UserRepository;
import org.webmarketapp.webmarket.domain.user.dto.UserRequestDTO;
import org.webmarketapp.webmarket.domain.user.dto.UserResponseDTO;
import org.webmarketapp.webmarket.domain.user.model.User;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponseDTO createUser(UserRequestDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setBirthDate(dto.getBirthDate());
        user.setPosition(dto.getPosition());
        user.setSalary(dto.getSalary());
        user.setRole(dto.getRole());

        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        User savedUser = userRepository.save(user);

        return convertToResponseDTO(savedUser);
    }
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    private UserResponseDTO convertToResponseDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setBirthDate(user.getBirthDate());
        dto.setPosition(user.getPosition());
        dto.setSalary(user.getSalary());
        dto.setRole(user.getRole());
        return dto;
    }

    public UserResponseDTO updateUser(Long id, UserRequestDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with ID " + id + " not found."));

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setBirthDate(dto.getBirthDate());
        user.setPosition(dto.getPosition());
        user.setSalary(dto.getSalary());

        if(dto.getPassword() != null && !dto.getPassword().isEmpty()) {
             user.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        if(dto.getRole() != null) {
            user.setRole(dto.getRole());
        }

        User updatedUser = userRepository.save(user);
        return convertToResponseDTO(updatedUser);
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with ID " + id + " not found."));
        userRepository.delete(user);
    }
}
