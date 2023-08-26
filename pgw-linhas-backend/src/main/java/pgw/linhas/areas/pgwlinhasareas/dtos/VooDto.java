package pgw.linhas.areas.pgwlinhasareas.dtos;

import org.springframework.beans.BeanUtils;
import pgw.linhas.areas.pgwlinhasareas.models.Voo;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class VooDto {
    private long vooId;
    @NotBlank
    @Size(max = 10)
    private String codigoAviao;
    private LocalDate partida;
    private LocalDate chegada;
    private Integer totalAssentos;
    @NotBlank
    private String status;
    private String origem;
    private String destino;

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

    public static VooDto convertVooToDTO(Voo voo){
        VooDto vooDto = new VooDto();
        BeanUtils.copyProperties(voo, vooDto);

        return  vooDto;
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
}
