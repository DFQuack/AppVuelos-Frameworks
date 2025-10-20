package sv.edu.udb.service.mapper;

import org.mapstruct.Mapper;
import sv.edu.udb.controller.request.ReservacionRequest;
import sv.edu.udb.model.Reservacion;

@Mapper(componentModel = "spring")
public interface ReservacionMapper {
    Reservacion toReservacion(ReservacionRequest reservacionRequest);
}
