package pgw.linhas.areas.pgwlinhasareas.dtos;

import pgw.linhas.areas.pgwlinhasareas.models.PrecoByClasse;
import pgw.linhas.areas.pgwlinhasareas.models.Voo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

public class PassagemDto {
    private Long passagemId;

    private String localizador;

    private String passageiroNome;

    private String cpfPassageiro;
    private Date dataNascimentoPassageiro;
    private float totalViagem;

    private String classeEscolhida;

    private String origem;

    private String destino;

    private String codigoVoo;

    private String nomeComprador;

    private String emailComprador;

    private String cpfComprador;
    private LocalDate dataCompra;
    private Integer qtdBagagemExtra;

    private String statusPassagem;

    private Date dataPartida;
    private Date dataChegada;
    private Integer qtdPassagens;

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
}
