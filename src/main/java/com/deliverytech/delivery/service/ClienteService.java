package com.deliverytech.delivery.service;


import com.deliverytech.delivery.dto.request.ClienteRequestDTO;
import com.deliverytech.delivery.dto.response.ClienteResponseDTO;

import java.util.List;

public interface ClienteService  {

    ClienteResponseDTO cadastrar(ClienteRequestDTO dto);

    ClienteResponseDTO buscarPorId(Long id, ClienteRequestDTO dto);

    ClienteResponseDTO atualizar(Long id, ClienteRequestDTO dto);

    ClienteResponseDTO ativarDesativar(Long id);

    List<ClienteResponseDTO> listarAtivos();

    List<ClienteResponseDTO> buscarPorNome(String nome);



}