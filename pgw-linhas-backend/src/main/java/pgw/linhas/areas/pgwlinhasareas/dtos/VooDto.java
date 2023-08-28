package pgw.linhas.areas.pgwlinhasareas.dtos;

import lombok.Data;
import org.springframework.beans.BeanUtils;
import pgw.linhas.areas.pgwlinhasareas.models.Voo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class VooDto {
    private long vooId;
    private String codigoAviao;
    private LocalDate partida;
    private LocalDate chegada;
    private Integer totalAssentos;
    private String status;
    private String origem;
    private String destino;
    private float valorAssento;
    private String economica;
    private String executiva;
    private String primeira;
    private Integer qtdAssentoPrimeira;
    private Integer qtdAssentoExecutiva;
    private Integer qtdAssentoEconomica;
    private float precoAssentoPrimeira;
    private float precoAssentoExecutiva;
    private float precoAssentoEconomica;
    private String horaPartida;
    private String horaChegada;


    public static VooDto convertVooToDTO(Voo voo){
        VooDto vooDto = new VooDto();
        BeanUtils.copyProperties(voo, vooDto);
        return  vooDto;
    }
}
