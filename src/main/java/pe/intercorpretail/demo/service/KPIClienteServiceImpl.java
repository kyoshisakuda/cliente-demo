package pe.intercorpretail.demo.service;

import org.springframework.stereotype.Service;
import pe.intercorpretail.demo.dto.KPIClientesDTO;
import pe.intercorpretail.demo.persistence.ClientePersistence;

import javax.annotation.Resource;
import java.text.DecimalFormat;

@Service
public class KPIClienteServiceImpl implements KPIClienteService {

    @Resource
    private ClientePersistence clientePersistence;

    @Override
    public KPIClientesDTO obtenerKPIs() {
        return new KPIClientesDTO(clientePersistence.getPromedioEdades(),
                clientePersistence.getDesviacionEstandarEdades());
    }

}
