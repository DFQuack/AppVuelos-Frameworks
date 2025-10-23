package sv.edu.udb.service.mapper;

import org.mapstruct.Mapper;
import sv.edu.udb.controller.request.TripulanteRequest;
import sv.edu.udb.model.Tripulante;

@Mapper(componentModel = "spring")
public interface TripulanteMapper {
    Tripulante toTripulante(TripulanteRequest request);
}
