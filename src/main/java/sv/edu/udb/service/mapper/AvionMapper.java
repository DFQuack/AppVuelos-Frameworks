package sv.edu.udb.service.mapper;

import org.mapstruct.Mapper;
import sv.edu.udb.controller.request.AvionRequest;
import sv.edu.udb.model.Avion;

@Mapper(componentModel = "spring")
public interface AvionMapper {
    Avion toAvion(AvionRequest request);
}
