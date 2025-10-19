package sv.edu.udb.service.mapper;

import org.mapstruct.Mapper;
import sv.edu.udb.controller.request.PasajeroRequest;
import sv.edu.udb.model.Pasajero;

@Mapper(componentModel = "spring")
public interface PasajeroMapper {
    Pasajero toPasajero(PasajeroRequest request);
}
