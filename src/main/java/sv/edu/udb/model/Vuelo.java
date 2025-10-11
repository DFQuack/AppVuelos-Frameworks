package sv.edu.udb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

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
    private Estado estado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aerolinea_id")
    private Aerolinea aerolinea;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "avion_id")
    private Avion avion;
}
