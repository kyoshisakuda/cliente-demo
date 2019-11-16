package pe.intercorpretail.demo.service;

import pe.intercorpretail.demo.dto.ClienteDTO;

import java.util.List;

public interface ClienteService {

    ClienteDTO crearCliente(ClienteDTO cliente);

    List<ClienteDTO> listarClientes();

}
