package sv.edu.udb.service.mapper;

import org.mapstruct.Mapper;
import sv.edu.udb.controller.request.VueloRequest;
import sv.edu.udb.model.Vuelo;

@Mapper(componentModel = "spring")
public interface VueloMapper {
    Vuelo toVuelo(VueloRequest vueloRequest);
}