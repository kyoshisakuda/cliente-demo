package pe.intercorpretail.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
@Api(description = "Administración de clientes")
public class ClienteController {

    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);

    @Resource
    private ClienteService clienteService;

    @Resource
    private KPIClienteService kpiClienteService;

    @ApiOperation(value = "Crear nuevo cliente", response = ClienteDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Cliente creado satisfactoriamente")
    })
    @PostMapping(value = "/creacliente", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClienteDTO> crearCliente(@Valid @RequestBody ClienteDTO cliente) {
        logger.info("Insertando nuevo cliente [{}]", cliente);
        return new ResponseEntity<>(clienteService.crearCliente(cliente), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Mostrar promedio y desviación estandar de edades de clientes", response = KPIClientesDTO.class)
    @GetMapping(value = "/kpideclientes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KPIClientesDTO> getKPIClientes() {
        logger.info("Obteniendo KPIs de clientes");
        return ResponseEntity.ok(kpiClienteService.obtenerKPIs());
    }

    @ApiOperation(value = "Listar clientes", response = List.class)
    @GetMapping(value = "/listclientes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        logger.info("listando clientes");
        return ResponseEntity.ok(clienteService.listarClientes());
    }

}
