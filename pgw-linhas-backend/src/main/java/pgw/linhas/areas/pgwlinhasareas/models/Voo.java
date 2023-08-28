package pgw.linhas.areas.pgwlinhasareas.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "TB_VOOS")
public class Voo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long vooId;
   @Column(nullable = false, length = 10, unique = true)
    private String codigoAviao;
    @Column(nullable = false)
    private LocalDate partida;
    @Column(nullable = false)
    private LocalDate chegada;
    private String horaPartida;
    private String horaChegada;
    @Column(nullable = false)
    private Integer totalAssentos;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private String origem;
    @Column(nullable = false)
    private String destino;
    @Column(nullable = false)
    private String economica;
    private String executiva;
    private String primeira;
    private Integer qtdAssentoPrimeira;
    private Integer qtdAssentoExecutiva;
    private Integer qtdAssentoEconomica;
    private float precoAssentoPrimeira;
    private float precoAssentoExecutiva;
    private float precoAssentoEconomica;
    public Voo(){
    }
}
