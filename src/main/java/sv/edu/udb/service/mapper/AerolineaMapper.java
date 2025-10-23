package sv.edu.udb.service.mapper;

import org.mapstruct.Mapper;
import sv.edu.udb.controller.request.AerolineaRequest;
import sv.edu.udb.model.Aerolinea;

@Mapper(componentModel = "spring")
public interface AerolineaMapper {
    Aerolinea toAerolinea(AerolineaRequest request);
}
