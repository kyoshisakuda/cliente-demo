package pe.intercorpretail.demo.persistence;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import pe.intercorpretail.demo.dominio.Cliente;

import javax.annotation.Resource;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ClienteRepositoryTest {

    @Resource
    private TestEntityManager entityManager;

    @Resource
    private ClienteRepository clienteRepository;

    @Before
    public void setUp() {
        entityManager.persist(new Cliente("John", "Doe", 23, LocalDate.of(1996, 12, 10)));
        entityManager.persist(new Cliente("Will", "Smith", 46, LocalDate.of(1973, 05, 10)));
        entityManager.persist(new Cliente("Jane", "Smith", 15, LocalDate.of(2004, 07, 10)));
        entityManager.flush();
    }

    @Test
    public void calcularPromedioEdades_retornaPromedioEdades() {
        Double promedio = 28.0;
        assertEquals(promedio, clienteRepository.calcularPromedioEdades());
    }

}