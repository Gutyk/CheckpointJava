package com.github.checkpointjava.ms_proposta.service;

import com.github.checkpointjava.ms_proposta.dto.UserDTO;
import com.github.checkpointjava.ms_proposta.model.User;
import com.github.checkpointjava.ms_proposta.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> findAll() {
        return userRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public UserDTO findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return toDTO(user);
    }

    public UserDTO insert(UserDTO userDTO) {
        User user = toEntity(userDTO);
        User savedUser = userRepository.save(user);
        return toDTO(savedUser);
    }

    public UserDTO update(Long id, UserDTO userDTO) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingUser.setNome(userDTO.getNome());
        existingUser.setSobrenome(userDTO.getSobrenome());
        existingUser.setCpf(userDTO.getCpf());
        existingUser.setTelefone(userDTO.getTelefone());
        existingUser.setRenda(userDTO.getRenda());

        User updatedUser = userRepository.save(existingUser);
        return toDTO(updatedUser);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    private UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setNome(user.getNome());
        userDTO.setSobrenome(user.getSobrenome());
        userDTO.setCpf(user.getCpf());
        userDTO.setTelefone(user.getTelefone());
        userDTO.setRenda(user.getRenda());
        return userDTO;
    }

    private User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setNome(userDTO.getNome());
        user.setSobrenome(userDTO.getSobrenome());
        user.setCpf(userDTO.getCpf());
        user.setTelefone(userDTO.getTelefone());
        user.setRenda(userDTO.getRenda());
        return user;
    }
}