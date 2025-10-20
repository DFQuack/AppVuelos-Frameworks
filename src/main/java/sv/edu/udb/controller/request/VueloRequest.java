package sv.edu.udb.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.*;
import sv.edu.udb.model.Aerolinea;
import sv.edu.udb.model.EstadoVuelo;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VueloRequest {
    @NotBlank
    private String ciudadOrigen;

    @NotBlank
    private String ciudadDestino;

    @Positive
    private Integer duracion;

    @Future
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime horaSalida;

    @Positive
    @Digits(integer = 6, fraction = 2)
    private Double tarifa;

    @NotNull
    private EstadoVuelo estado;
}
