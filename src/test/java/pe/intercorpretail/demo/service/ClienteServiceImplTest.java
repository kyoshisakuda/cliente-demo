package pe.intercorpretail.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import pe.intercorpretail.demo.dominio.Cliente;
import pe.intercorpretail.demo.dto.ClienteDTO;
import pe.intercorpretail.demo.persistence.ClientePersistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClienteServiceImplTest {

    @Mock
    private ClientePersistence clientePersistence;

    @InjectMocks
    private ClienteServiceImpl clienteService;

    @Test
    public void crearCliente_RetornarClienteGuardado() {
        ClienteDTO clienteEntrada = new ClienteDTO("John", "Doe", 29,
                LocalDate.of(1990, 01, 01));
        when(clientePersistence.guardar(Mockito.any(Cliente.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        ClienteDTO clienteRespuesta = clienteService.crearCliente(clienteEntrada);
        assertEquals(clienteEntrada.getNombre(), clienteRespuesta.getNombre());
        assertEquals(clienteEntrada.getApellido(), clienteRespuesta.getApellido());
        assertEquals(clienteEntrada.getEdad(), clienteRespuesta.getEdad());
        assertEquals(clienteEntrada.getFechaNacimiento(), clienteRespuesta.getFechaNacimiento());
    }

    @Test
    public void listarClientes_retornarListaClientes() {
        when(clientePersistence.listar()).thenReturn(getTestListaClientes());

        List<ClienteDTO> clientes = clienteService.listarClientes();
        assertEquals(3, clientes.size());
        clientes.forEach(cliente -> assertNotNull(cliente.getFechaProbableMuerte()));
    }

    private List<Cliente> getTestListaClientes() {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("John", "Doe", 19,
                LocalDate.of(2000, 06, 06)));
        clientes.add(new Cliente("Will", "Smith", 33,
                LocalDate.of(1986, 02, 25)));
        clientes.add(new Cliente("Jane", "Smith", 31,
                LocalDate.of(1988, 04, 13)));
        return clientes;
    }
}