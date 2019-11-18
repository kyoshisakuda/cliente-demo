package pe.intercorpretail.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.intercorpretail.demo.dominio.Cliente;
import pe.intercorpretail.demo.dto.ClienteDTO;
import pe.intercorpretail.demo.dto.KPIClientesDTO;
import pe.intercorpretail.demo.service.ClienteService;
import pe.intercorpretail.demo.service.KPIClienteService;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.lang.invoke.MethodHandles;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);

    @Resource
    private ClienteService clienteService;

    @Resource
    private KPIClienteService kpiClienteService;

    @PostMapping("/creacliente")
    public ResponseEntity<ClienteDTO> crearCliente(@Valid @RequestBody ClienteDTO cliente) {
        logger.info("Insertando nuevo cliente [{}]", cliente);
        return ResponseEntity.ok(clienteService.crearCliente(cliente));
    }

    @GetMapping("/kpideclientes")
    public ResponseEntity<KPIClientesDTO> getKPIClientes() {
        logger.info("Obteniendo KPIs de clientes");
        return ResponseEntity.ok(kpiClienteService.obtenerKPIs());
    }

    @GetMapping("/listclientes")
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        logger.info("listando clientes");
        return ResponseEntity.ok(clienteService.listarClientes());
    }

}
