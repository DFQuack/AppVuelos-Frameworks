package sv.edu.udb.controller.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.*;
import sv.edu.udb.model.RolUsuario;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotNull
    private RolUsuario rol;

    @NotBlank
    @Email
    private String correo;

    @Pattern(regexp = "^[0-9]{4}-[0-9]{4}$")
    private String telefono;
}
