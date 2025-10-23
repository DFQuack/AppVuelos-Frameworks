package sv.edu.udb.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.*;
import sv.edu.udb.model.Genero;
import sv.edu.udb.model.GrupoEtario;
import sv.edu.udb.model.Reservacion;

import java.time.LocalDate;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PasajeroRequest {
    @NotBlank
    private String nombres;

    @NotBlank
    private String apellidos;

    @NotNull
    private Genero genero;

    @NotNull
    private GrupoEtario grupoEtario;

    @Past
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate fechaNacimiento;

    @NotBlank
    private String pasaporte;

    private String asiento;

    @NotNull
    private Reservacion reservacion;
}
