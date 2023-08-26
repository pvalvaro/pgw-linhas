package pgw.linhas.areas.pgwlinhasareas.models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

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
    private Timestamp partida;
    @Column(nullable = false)
    private Timestamp chegada;
    @Column(nullable = false)
    private Integer totalAssentos;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private String origem;
    @Column(nullable = false)
    private String destino;

    public Voo(){
    }

    public Voo(long vooId, String codigoAviao, LocalDate partida, LocalDate chegada, Integer totalAssentos, String status, String origem, String destino) {
        this.vooId = vooId;
        this.codigoAviao = codigoAviao;
        this.partida = partida;
        this.chegada = chegada;
        this.totalAssentos = totalAssentos;
        this.status = status;
        this.origem = origem;
        this.destino = destino;
    }

    public long getVooId() {
        return vooId;
    }

    public void setVooId(long vooId) {
        this.vooId = vooId;
    }

    public String getCodigoAviao() {
        return codigoAviao;
    }

    public void setCodigoAviao(String codigoAviao) {
        this.codigoAviao = codigoAviao;
    }

    public LocalDate getPartida() {
        return partida;
    }

    public void setPartida(LocalDate partida) {
        this.partida = partida;
    }

    public LocalDate getChegada() {
        return chegada;
    }

    public void setChegada(LocalDate chegada) {
        this.chegada = chegada;
    }

    public Integer getTotalAssentos() {
        return totalAssentos;
    }

    public void setTotalAssentos(Integer totalAssentos) {
        this.totalAssentos = totalAssentos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public String toString() {
        return "Voo{" +
                "vooId=" + vooId +
                ", codigoAviao='" + codigoAviao + '\'' +
                ", partida=" + partida +
                ", chegada=" + chegada +
                ", totalAssentos=" + totalAssentos +
                ", status='" + status + '\'' +
                ", origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                '}';
    }
}
