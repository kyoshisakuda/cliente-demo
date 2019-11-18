package pe.intercorpretail.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pe.intercorpretail.demo.dto.ClienteDTO;
import pe.intercorpretail.demo.dto.KPIClientesDTO;
import pe.intercorpretail.demo.service.ClienteService;
import pe.intercorpretail.demo.service.KPIClienteService;

import javax.annotation.Resource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ClienteController.class)
public class ClienteControllerTest {

    private static final String CREAR_CLIENTE_URL = "/cliente/creacliente";
    private static final String GET_KPI_URL = "/cliente/kpideclientes";
    private static final String GET_CLIENTES_URL = "/cliente/listclientes";

    @Resource
    private MockMvc mvc;

    @Resource
    private ObjectMapper objectMapper;

    @MockBean
    private ClienteService clienteService;

    @MockBean
    private KPIClienteService kpiClienteService;

    @Test
    public void crearCliente_returnClienteCreado() throws Exception {
        ClienteDTO cliente = new ClienteDTO("Nombre", "Apellido", 20, LocalDate.now());
        when(clienteService.crearCliente(cliente)).thenReturn(cliente);
        mvc.perform(post(CREAR_CLIENTE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isCreated());
    }

    @Test
    public void getKPIClientes_returnKPIs() throws Exception {
        KPIClientesDTO kpiClientesDTO = new KPIClientesDTO(39.0, 13.55);
        when(kpiClienteService.obtenerKPIs()).thenReturn(kpiClientesDTO);
        mvc.perform(get(GET_KPI_URL))
                .andExpect(status().isOk());
    }

    @Test
    public void listarClientes_returnListaClientes() throws Exception {
        List<ClienteDTO> clientes = new ArrayList<>();
        when(clienteService.listarClientes()).thenReturn(clientes);
        mvc.perform(get(GET_CLIENTES_URL))
                .andExpect(status().isOk());
    }
}