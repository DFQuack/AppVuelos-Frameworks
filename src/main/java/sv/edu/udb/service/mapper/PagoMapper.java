package sv.edu.udb.service.mapper;

import org.mapstruct.Mapper;
import sv.edu.udb.controller.request.PagoRequest;
import sv.edu.udb.model.Pago;

@Mapper(componentModel = "spring")
public interface PagoMapper {
    Pago toPago(PagoRequest request);
}
