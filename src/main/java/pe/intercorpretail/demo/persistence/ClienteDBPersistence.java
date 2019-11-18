package pe.intercorpretail.demo.persistence;

import org.springframework.stereotype.Component;
import pe.intercorpretail.demo.dominio.Cliente;

import javax.annotation.Resource;
import java.util.List;

@Component
public class ClienteDBPersistence implements ClientePersistence {

    @Resource
    private ClienteRepository clienteRepository;

    @Override
    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @Override
    public Double getPromedioEdades() {
        return clienteRepository.calcularPromedioEdades();
    }

    @Override
    public Double getDesviacionEstandarEdades() {
        return clienteRepository.calcularDesviacionEstandarEdades();
    }
}
