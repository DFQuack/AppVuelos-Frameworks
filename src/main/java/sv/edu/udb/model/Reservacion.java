package sv.edu.udb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservacion {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private EstadoReserva estado = EstadoReserva.PAGO_PENDIENTE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vuelo", nullable = false)
    @JsonBackReference(value = "vuelo-reservacion")
    private Vuelo vuelo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "reservacion")
    @JsonManagedReference(value = "reservacion-pasajero")
    private List<Pasajero> pasajeros;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    @JsonBackReference(value = "usuario-reservacion")
    private Usuario usuario;

    @OneToOne(mappedBy = "reservacion")
    @JsonManagedReference(value = "reservacion-pago")
    private Pago pago;

    @OneToOne(mappedBy = "reservacion")
    @JsonManagedReference(value = "reservacion-cancelacion")
    private Cancelacion cancelacion;

    @OneToOne(mappedBy = "reservacion")
    @JsonManagedReference(value = "reservacion-reclamo")
    private Reclamo reclamo;
}
