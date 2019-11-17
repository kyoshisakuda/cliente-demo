package pe.intercorpretail.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import pe.intercorpretail.demo.dto.KPIClientesDTO;
import pe.intercorpretail.demo.persistence.ClientePersistence;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class KPIClienteServiceImplTest {

    @InjectMocks
    private KPIClienteServiceImpl kpiClienteService;

    @Mock
    private ClientePersistence clientePersistence;

    @Test
    public void obtenerKPIs_retornaPromedioEdades() {
        when(clientePersistence.getPromedioEdades()).thenReturn(37.75);
        KPIClientesDTO kpi = kpiClienteService.obtenerKPIs();
        assertEquals(37.75, kpi.getPromedioEdad());
    }

    @Test
    public void obtenerKPIs_retornaDesviacionEstandarEdades() {
        when(clientePersistence.getDesviacionEstandarEdades()).thenReturn(12.987);
        KPIClientesDTO kpi = kpiClienteService.obtenerKPIs();
        assertEquals(12.987, kpi.getDesviacionEstandarEdad());
    }
}