package com.github.checkpointjava.ms_proposta.service;

import com.github.checkpointjava.ms_proposta.dto.PropostaDTO;
import com.github.checkpointjava.ms_proposta.model.Proposta;
import com.github.checkpointjava.ms_proposta.model.User;
import com.github.checkpointjava.ms_proposta.repository.PropostaRepository;
import com.github.checkpointjava.ms_proposta.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PropostaService {

    private final PropostaRepository propostaRepository;
    private final UserRepository userRepository;

    public PropostaService(PropostaRepository propostaRepository, UserRepository userRepository) {
        this.propostaRepository = propostaRepository;
        this.userRepository = userRepository;
    }

    public List<PropostaDTO> findAll() {
        return propostaRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }


    public PropostaDTO insert(PropostaDTO propostaDTO) {
        Proposta proposta = toEntity(propostaDTO);
        Proposta savedProposta = propostaRepository.save(proposta);
        return toDTO(savedProposta);
    }

    public PropostaDTO findById(Long id) {
        Optional<Proposta> propostaOpt = propostaRepository.findById(id);
        return propostaOpt.map(this::toDTO).orElse(null);
    }

    public PropostaDTO update(Long id, PropostaDTO propostaDTO) {
        Optional<Proposta> existingPropostaOpt = propostaRepository.findById(id);
        if (existingPropostaOpt.isPresent()) {
            Proposta existingProposta = existingPropostaOpt.get();

            existingProposta.setSolicitado(propostaDTO.getSolicitado());
            existingProposta.setMeses(propostaDTO.getMeses());
            existingProposta.setValidacao(propostaDTO.getValidacao());

            Optional<User> userOpt = userRepository.findById(propostaDTO.getUserId());
            if (userOpt.isPresent()) {
                existingProposta.setUser(userOpt.get());
                Proposta updatedProposta = propostaRepository.save(existingProposta);
                return toDTO(updatedProposta);
            }
        }
        return null;
    }

    public boolean delete(Long id) {
        if (propostaRepository.existsById(id)) {
            propostaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private PropostaDTO toDTO(Proposta proposta) {
        PropostaDTO propostaDTO = new PropostaDTO();
        propostaDTO.setId(proposta.getId());
        propostaDTO.setSolicitado(proposta.getSolicitado());
        propostaDTO.setMeses(proposta.getMeses());
        propostaDTO.setValidacao(proposta.getValidacao());
        propostaDTO.setUserId(proposta.getUser().getId());
        return propostaDTO;
    }

    private Proposta toEntity(PropostaDTO propostaDTO) {
        Proposta proposta = new Proposta();
        proposta.setSolicitado(propostaDTO.getSolicitado());
        proposta.setMeses(propostaDTO.getMeses());
        proposta.setValidacao(propostaDTO.getValidacao());

        Optional<User> userOpt = userRepository.findById(propostaDTO.getUserId());
        if (userOpt.isPresent()) {
            proposta.setUser(userOpt.get());
        }

        return proposta;
    }
}
