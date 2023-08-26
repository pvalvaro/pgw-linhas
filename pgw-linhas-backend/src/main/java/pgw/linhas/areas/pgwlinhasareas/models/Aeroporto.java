package pgw.linhas.areas.pgwlinhasareas.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_AEROPORTOS")
public class Aeroporto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long aeroportoId;
    @Column(nullable = false, length = 70, unique = true)
    private String aeroportoNome;
    @Column(nullable = false, length = 5, unique = true)
    private String codigoIATA;
    @Column(nullable = false, length = 30)
    private String cidadeNome;
    @Column(nullable = false, length = 30, unique = true)
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

    public long getAeroportoId() {
        return aeroportoId;
    }

    public void setAeroportoId(long aeroportoId) {
        this.aeroportoId = aeroportoId;
    }

    public String getAeroportoNome() {
        return aeroportoNome;
    }

    public void setAeroportoNome(String aeroportoNome) {
        this.aeroportoNome = aeroportoNome;
    }

    public String getCodigoIATA() {
        return codigoIATA;
    }

    public void setCodigoIATA(String codigoIATA) {
        this.codigoIATA = codigoIATA;
    }

    public String getCidadeNome() {
        return cidadeNome;
    }

    public void setCidadeNome(String cidadeNome) {
        this.cidadeNome = cidadeNome;
    }

    public String getEstadoNome() {
        return estadoNome;
    }

    public void setEstadoNome(String estadoNome) {
        this.estadoNome = estadoNome;
    }

    @Override
    public String toString() {
        return "Aeroporto{" +
                "aeroportoId=" + aeroportoId +
                ", aeroportoNome='" + aeroportoNome + '\'' +
                ", codigoIATA='" + codigoIATA + '\'' +
                ", cidadeNome='" + cidadeNome + '\'' +
                ", estadoNome='" + estadoNome + '\'' +
                '}';
    }
}
