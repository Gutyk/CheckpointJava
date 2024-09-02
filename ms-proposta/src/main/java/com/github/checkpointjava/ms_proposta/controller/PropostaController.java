package com.github.checkpointjava.ms_proposta.controller;

import com.github.checkpointjava.ms_proposta.dto.PropostaDTO;
import com.github.checkpointjava.ms_proposta.service.PropostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/propostas")
public class PropostaController {

    @Autowired
    private PropostaService propostaService;

    @PostMapping
    public ResponseEntity<PropostaDTO> createProposta(@RequestBody PropostaDTO propostaDTO) {
        PropostaDTO createdProposta = propostaService.insert(propostaDTO);
        return new ResponseEntity<>(createdProposta, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PropostaDTO>> getProposta() {
        List<PropostaDTO> propostas = propostaService.findAll();
        return new ResponseEntity<>(propostas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropostaDTO> getPropostaById(@PathVariable Long id) {
        PropostaDTO proposta = propostaService.findById(id);
        return proposta != null ? new ResponseEntity<>(proposta, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
