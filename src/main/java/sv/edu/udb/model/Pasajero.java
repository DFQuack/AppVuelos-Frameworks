package sv.edu.udb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pasajero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombres;

    @Column(nullable = false)
    private String apellidos;

    @Column(nullable = false)
    private Genero genero;

    @Column(nullable = false)
    private GrupoEtario grupoEtario;

    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    @Column(nullable = false)
    private String pasaporte;

    private String asiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reservacion")
    private Reservacion reservacion;
}
