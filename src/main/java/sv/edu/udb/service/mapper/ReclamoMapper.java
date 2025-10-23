package sv.edu.udb.service.mapper;

import org.mapstruct.Mapper;
import sv.edu.udb.controller.request.ReclamoRequest;
import sv.edu.udb.model.Reclamo;

@Mapper(componentModel = "spring")
public interface ReclamoMapper {
    Reclamo toReclamo(ReclamoRequest request);
}
