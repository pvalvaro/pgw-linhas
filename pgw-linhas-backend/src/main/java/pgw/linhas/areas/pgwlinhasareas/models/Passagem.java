package pgw.linhas.areas.pgwlinhasareas.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
@Data
@Entity
@Table(name = "TB_PASSAGENS")
public class Passagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long passagemId;
    @Column(nullable = false, length = 15, unique = true)
    private String localizador;
    @Column(nullable = false, length = 70)
    private String passageiroNome;
    @Column(nullable = false, length = 11)
    private String cpfPassageiro;
    @Column(nullable = false)
    private Date dataNascimentoPassageiro;
    @Column(nullable = false)
    private float totalViagem;
    @Column(nullable = false, length = 10)
    private String classeEscolhida;
    @Column(nullable = false, length = 30)
    private String origem;
    @Column(nullable = false, length = 30)
    private String destino;
    @Column(nullable = false, length = 10)
    private String codigoVoo;
    @Column(nullable = false, length = 70)
    private String nomeComprador;
    @Column(nullable = false, length = 250)
    private String emailComprador;
    @Column(nullable = false, length = 11)
    private String cpfComprador;
    @Column(nullable = false)
    private Date dataCompra;
    private Integer qtdBagagemExtra;
    @Column(nullable = false, length = 10)
    private String statusPassagem;
    private Timestamp dataPartida;
    private Timestamp dataChegada;
    private Integer qtdPassagens;

}
