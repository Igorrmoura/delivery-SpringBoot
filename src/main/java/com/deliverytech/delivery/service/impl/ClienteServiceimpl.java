package com.deliverytech.delivery.service.impl;

import com.deliverytech.delivery.config.ModelMapperConfig;
import com.deliverytech.delivery.dto.request.ClienteRequestDTO;
import com.deliverytech.delivery.dto.response.ClienteResponseDTO;
import com.deliverytech.delivery.entities.Cliente;
import com.deliverytech.delivery.exceptions.BusinessException;
import com.deliverytech.delivery.repository.ClienteRepository;
import com.deliverytech.delivery.service.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClienteServiceimpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ClienteResponseDTO cadastrar(ClienteRequestDTO dto) {
        if (clienteRepository.existsByEmail(dto.getEmail())){
            throw new BusinessException("email já cadastrado" + dto.getEmail());

        }
        Cliente cliente = modelMapper.map(dto, Cliente.class);
        cliente.setAtivo(true);
        Cliente saveSalvo = clienteRepository.save(cliente);
        return  modelMapper.map(saveSalvo, ClienteResponseDTO.class);
    }

    @Override
    public ClienteResponseDTO buscarPorId(Long id, ClienteRequestDTO dto) {
        return null;
    }

    @Override
    public ClienteResponseDTO atualizar(Long id, ClienteRequestDTO dto) {
        // Buscar cliente existente
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Cliente não encontrado: " + id));

        // Validar dados do cliente
        if (clienteRepository.existsByEmail(dto.getEmail())){
            throw new BusinessException("email já cadastrado" + dto.getEmail());

        }
        if (dto.getNome() == null  || dto.getEmail().isEmpty()) {
            throw new BusinessException("Email do cliente é obrigatório");
        }
        // Converter DTO para entidade
        Cliente cliente = modelMapper.map(dto, Cliente.class);
        cliente.setAtivo(true);

        // Salvar cliente
        Cliente saveSalvo = clienteRepository.save(cliente);

        // Retornar DTO de resposta
        return  modelMapper.map(saveSalvo, ClienteResponseDTO.class);
    }

    @Override
    public ClienteResponseDTO ativarDesativar(Long id) {
        return null;
    }

    @Override
    public List<ClienteResponseDTO> listarAtivos() {
        return List.of();
    }

    @Override
    public List<ClienteResponseDTO> buscarPorNome(String nome) {
        return List.of();
    }
}