package pe.intercorpretail.demo.service;

import org.springframework.stereotype.Service;
import pe.intercorpretail.demo.dominio.Cliente;
import pe.intercorpretail.demo.dto.ClienteDTO;
import pe.intercorpretail.demo.persistence.ClientePersistence;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Resource
    private ClientePersistence clientePersistence;

    @Override
    public ClienteDTO crearCliente(ClienteDTO clienteDTO) {
        Cliente nuevoCliente = mapToCliente(clienteDTO);
        Cliente clienteGuardado = clientePersistence.guardar(nuevoCliente);
        return mapToClienteDTO(clienteGuardado);
    }

    @Override
    public List<ClienteDTO> listarClientes() {
        List<Cliente> clientes = clientePersistence.listar();
        return mapToListaClienteDTO(clientes);
    }

    private Cliente mapToCliente(ClienteDTO dto) {
        return new Cliente(dto.getNombre(), dto.getApellido(), dto.getEdad(), dto.getFechaNacimiento());
    }

    private ClienteDTO mapToClienteDTO(Cliente cliente) {
        return new ClienteDTO(cliente.getNombre(), cliente.getApellido(), cliente.getEdad(),
                cliente.getFechaNacimiento());
    }

    private List<ClienteDTO> mapToListaClienteDTO(List<Cliente> clientes) {
        return clientes.stream().map(this::mapToClienteDTO).collect(Collectors.toList());
    }

}
