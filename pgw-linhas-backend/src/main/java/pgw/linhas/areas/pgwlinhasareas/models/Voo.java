package pgw.linhas.areas.pgwlinhasareas.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

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
    @Column(nullable = false)
    private float valorAssento;
    private boolean economica;
    private boolean executiva;
    private boolean primeira;
    private Integer qtdAssentoPrimeira;
    private Integer qtdAssentoExecutiva;
    private Integer qtdAssentoEconomica;
    private float precoAssentoPrimeira;
    private float precoAssentoExecutiva;
    private float precoAssentoEconomica;
    public Voo(){
    }

    public Voo(long vooId, String codigoAviao, Timestamp partida, Timestamp chegada, Integer totalAssentos, String status, String origem, String destino, float valorAssento, boolean economica, boolean executiva, boolean primeira, Integer qtdAssentoPrimeira, Integer qtdAssentoExecutiva, Integer qtdAssentoEconomica, float precoAssentoPrimeira, float precoAssentoExecutiva, float precoAssentoEconomica) {
        this.vooId = vooId;
        this.codigoAviao = codigoAviao;
        this.partida = partida;
        this.chegada = chegada;
        this.totalAssentos = totalAssentos;
        this.status = status;
        this.origem = origem;
        this.destino = destino;
        this.valorAssento = valorAssento;
        this.economica = economica;
        this.executiva = executiva;
        this.primeira = primeira;
        this.qtdAssentoPrimeira = qtdAssentoPrimeira;
        this.qtdAssentoExecutiva = qtdAssentoExecutiva;
        this.qtdAssentoEconomica = qtdAssentoEconomica;
        this.precoAssentoPrimeira = precoAssentoPrimeira;
        this.precoAssentoExecutiva = precoAssentoExecutiva;
        this.precoAssentoEconomica = precoAssentoEconomica;
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
