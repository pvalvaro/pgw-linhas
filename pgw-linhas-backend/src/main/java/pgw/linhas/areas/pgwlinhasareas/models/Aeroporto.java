package pgw.linhas.areas.pgwlinhasareas.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Entity
@Table(name = "TB_AEROPORTOS")
public class Aeroporto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long aeroportoId;
    @Column(nullable = false, length = 150, unique = true)
    private String aeroportoNome;
    @Column(nullable = false, length = 5, unique = true)
    private String codigoIATA;
    @Column(nullable = false, length = 30)
    private String cidadeNome;
    @Column(nullable = false)
    private String estadoNome;

    public  Aeroporto(){
    }

    public Aeroporto(long aeroportoId, String aeroportoNome, String codigoIATA, String cidadeNome, String estadoNome) {
        this.aeroportoId = aeroportoId;
        this.aeroportoNome = aeroportoNome;
        this.codigoIATA = codigoIATA;
        this.cidadeNome = cidadeNome;
        this.estadoNome = estadoNome;
    }
}
