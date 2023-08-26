package pgw.linhas.areas.pgwlinhasareas.dtos;

import pgw.linhas.areas.pgwlinhasareas.models.Aeroporto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AeroportoDto {
    @NotBlank
    @Size(max = 70)
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

    public static AeroportoDto convertAeroportoToDTO(Aeroporto aeroporto){
        AeroportoDto aeroportoDto = new AeroportoDto();
        aeroportoDto.setAeroportoNome(aeroporto.getAeroportoNome());
        aeroportoDto.setCidadeNome(aeroporto.getCidadeNome());
        aeroportoDto.setCodigoIATA(aeroporto.getCodigoIATA());
        aeroportoDto.setEstadoNome(aeroporto.getEstadoNome());

        return  aeroportoDto;
    }
}
