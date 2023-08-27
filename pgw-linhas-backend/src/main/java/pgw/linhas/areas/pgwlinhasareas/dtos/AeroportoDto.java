package pgw.linhas.areas.pgwlinhasareas.dtos;

import lombok.Data;
import pgw.linhas.areas.pgwlinhasareas.models.Aeroporto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class AeroportoDto {
    @NotBlank
    @Size(max = 150)
    private String aeroportoNome;
    @NotBlank
    @Size(max = 5)
    private String codigoIATA;
    @NotBlank
    @Size(max = 30)
    private String cidadeNome;
    @NotBlank
    @Size(max = 30)
    private String estadoNome;

     public static AeroportoDto convertAeroportoToDTO(Aeroporto aeroporto){
        AeroportoDto aeroportoDto = new AeroportoDto();
        aeroportoDto.setAeroportoNome(aeroporto.getAeroportoNome());
        aeroportoDto.setCidadeNome(aeroporto.getCidadeNome());
        aeroportoDto.setCodigoIATA(aeroporto.getCodigoIATA());
        aeroportoDto.setEstadoNome(aeroporto.getEstadoNome());

        return  aeroportoDto;
    }
}
