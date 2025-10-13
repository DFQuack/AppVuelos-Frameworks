package sv.edu.udb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ciudadOrigen;

    @Column(nullable = false)
    private String ciudadDestino;

    @Column(nullable = false)
    private Integer duracionEstimada; // Minutos

    @Column(nullable = false)
    private LocalDateTime horaSalida;

    @Column(nullable = false)
    private Double tarifa;

    @Column(nullable = false)
    private EstadoVuelo estado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_aerolinea")
    private Aerolinea aerolinea;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_avion")
    private Avion avion;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "vuelo")
    private List<Reservacion> reservaciones;
}
