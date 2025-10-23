package sv.edu.udb.service.mapper;

import org.mapstruct.Mapper;
import sv.edu.udb.controller.request.CancelacionRequest;
import sv.edu.udb.model.Cancelacion;

@Mapper(componentModel = "spring")
public interface CancelacionMapper {
    Cancelacion toCancelacion(CancelacionRequest request);
}
