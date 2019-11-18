package pe.intercorpretail.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.intercorpretail.demo.dominio.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("select avg(c.edad) from Cliente c")
    Double calcularPromedioEdades();

    @Query(value = "select std(c.edad) from cliente c", nativeQuery = true)
    Double calcularDesviacionEstandarEdades();

}
