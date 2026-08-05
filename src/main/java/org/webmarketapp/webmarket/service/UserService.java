package org.webmarketapp.webmarket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webmarketapp.webmarket.Repository.UserRepository;
import org.webmarketapp.webmarket.dto.UserRequestDTO;
import org.webmarketapp.webmarket.dto.UserResponseDTO;
import org.webmarketapp.webmarket.model.User;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDTO createUser(UserRequestDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setBirthDate(dto.getBirthDate());
        user.setPosition(dto.getPosition());
        user.setSalary(dto.getSalary());
        user.setRole(dto.getRole());

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
}
