package pe.intercorpretail.demo.persistence;

import pe.intercorpretail.demo.dominio.Cliente;

import java.util.List;

public interface ClientePersistence {

    Cliente guardar(Cliente cliente);

    List<Cliente> listar();

}
