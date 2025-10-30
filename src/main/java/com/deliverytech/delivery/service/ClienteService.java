package com.deliverytech.delivery.service;

import com.deliverytech.delivery.entities.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    public Cliente cadastrar(Cliente cliente) {
        return new Cliente();
    }
}