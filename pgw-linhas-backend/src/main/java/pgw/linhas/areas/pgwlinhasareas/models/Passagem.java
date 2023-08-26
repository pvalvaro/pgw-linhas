package pgw.linhas.areas.pgwlinhasareas.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
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
    private LocalDate dataCompra;
    private Integer qtdBagagemExtra;
    @Column(nullable = false, length = 10)
    private String statusPassagem;
    private Date dataPartida;
    private Date dataChegada;
    private Integer qtdPassagens;

    public Passagem(){
    }

    public Passagem(Long passagemId, String localizador, String passageiroNome, String cpfPassageiro,
                    Date dataNascimentoPassageiro, float totalViagem, String classeEscolhida, String origem, String destino,
                    String codigoVoo, String nomeComprador, String emailComprador, String cpfComprador, LocalDate dataCompra,
                    Integer qtdBagagemExtra, String statusPassagem, Date dataPartida, Date dataChegada, Integer qtdPassagens) {
        this.passagemId = passagemId;
        this.localizador = localizador;
        this.passageiroNome = passageiroNome;
        this.cpfPassageiro = cpfPassageiro;
        this.dataNascimentoPassageiro = dataNascimentoPassageiro;
        this.totalViagem = totalViagem;
        this.classeEscolhida = classeEscolhida;
        this.origem = origem;
        this.destino = destino;
        this.codigoVoo = codigoVoo;
        this.nomeComprador = nomeComprador;
        this.emailComprador = emailComprador;
        this.cpfComprador = cpfComprador;
        this.dataCompra = dataCompra;
        this.qtdBagagemExtra = qtdBagagemExtra;
        this.statusPassagem = statusPassagem;
        this.dataPartida = dataPartida;
        this.dataChegada = dataChegada;
        this.qtdPassagens = qtdPassagens;
    }

    public Long getPassagemId() {
        return passagemId;
    }

    public void setPassagemId(Long passagemId) {
        this.passagemId = passagemId;
    }

    public String getLocalizador() {
        return localizador;
    }

    public void setLocalizador(String localizador) {
        this.localizador = localizador;
    }

    public String getPassageiroNome() {
        return passageiroNome;
    }

    public void setPassageiroNome(String passageiroNome) {
        this.passageiroNome = passageiroNome;
    }

    public String getCpfPassageiro() {
        return cpfPassageiro;
    }

    public void setCpfPassageiro(String cpfPassageiro) {
        this.cpfPassageiro = cpfPassageiro;
    }

    public Date getDataNascimentoPassageiro() {
        return dataNascimentoPassageiro;
    }

    public void setDataNascimentoPassageiro(Date dataNascimentoPassageiro) {
        this.dataNascimentoPassageiro = dataNascimentoPassageiro;
    }

    public float getTotalViagem() {
        return totalViagem;
    }

    public void setTotalViagem(float totalViagem) {
        this.totalViagem = totalViagem;
    }

    public String getClasseEscolhida() {
        return classeEscolhida;
    }

    public void setClasseEscolhida(String classeEscolhida) {
        this.classeEscolhida = classeEscolhida;
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

    public String getCodigoVoo() {
        return codigoVoo;
    }

    public void setCodigoVoo(String codigoVoo) {
        this.codigoVoo = codigoVoo;
    }

    public String getNomeComprador() {
        return nomeComprador;
    }

    public void setNomeComprador(String nomeComprador) {
        this.nomeComprador = nomeComprador;
    }

    public String getEmailComprador() {
        return emailComprador;
    }

    public void setEmailComprador(String emailComprador) {
        this.emailComprador = emailComprador;
    }

    public String getCpfComprador() {
        return cpfComprador;
    }

    public void setCpfComprador(String cpfComprador) {
        this.cpfComprador = cpfComprador;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Integer getQtdBagagemExtra() {
        return qtdBagagemExtra;
    }

    public void setQtdBagagemExtra(Integer qtdBagagemExtra) {
        this.qtdBagagemExtra = qtdBagagemExtra;
    }

    public String getStatusPassagem() {
        return statusPassagem;
    }

    public void setStatusPassagem(String statusPassagem) {
        this.statusPassagem = statusPassagem;
    }

    public Date getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(Date dataPartida) {
        this.dataPartida = dataPartida;
    }

    public Date getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(Date dataChegada) {
        this.dataChegada = dataChegada;
    }

    public Integer getQtdPassagens() {
        return qtdPassagens;
    }

    public void setQtdPassagens(Integer qtdPassagens) {
        this.qtdPassagens = qtdPassagens;
    }

    @Override
    public String toString() {
        return "Passagem{" +
                "passagemId=" + passagemId +
                ", localizador='" + localizador + '\'' +
                ", passageiroNome='" + passageiroNome + '\'' +
                ", cpfPassageiro='" + cpfPassageiro + '\'' +
                ", dataNascimentoPassageiro=" + dataNascimentoPassageiro +
                ", totalViagem=" + totalViagem +
                ", classeEscolhida='" + classeEscolhida + '\'' +
                ", origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                ", codigoVoo='" + codigoVoo + '\'' +
                ", nomeComprador='" + nomeComprador + '\'' +
                ", emailComprador='" + emailComprador + '\'' +
                ", cpfComprador='" + cpfComprador + '\'' +
                ", dataCompra=" + dataCompra +
                ", qtdBagagemExtra=" + qtdBagagemExtra +
                ", statusPassagem='" + statusPassagem + '\'' +
                ", dataPartida=" + dataPartida +
                ", dataChegada=" + dataChegada +
                ", qtdPassagens=" + qtdPassagens +
                '}';
    }
}
