package pgw.linhas.areas.pgwlinhasareas.dtos;

import lombok.Data;
import org.springframework.beans.BeanUtils;
import pgw.linhas.areas.pgwlinhasareas.models.Voo;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.time.LocalDate;

@Data
public class VooDto {
    private long vooId;
    @NotBlank
    @Size(max = 10)
    private String codigoAviao;
    private Timestamp partida;
    private Timestamp chegada;
    private Integer totalAssentos;
    @NotBlank
    private String status;
    private String origem;
    private String destino;
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


    public static VooDto convertVooToDTO(Voo voo){
        VooDto vooDto = new VooDto();
        BeanUtils.copyProperties(voo, vooDto);
        return  vooDto;
    }
}
