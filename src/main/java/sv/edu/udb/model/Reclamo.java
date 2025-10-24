package sv.edu.udb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Reclamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String comentario;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private EstadoReclamo estado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_reservacion", nullable = false)
    @JsonBackReference(value = "reservacion-reclamo")
    private Reservacion reservacion;
}
