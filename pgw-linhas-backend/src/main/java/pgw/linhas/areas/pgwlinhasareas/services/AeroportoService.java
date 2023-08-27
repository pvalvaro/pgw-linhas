package pgw.linhas.areas.pgwlinhasareas.services;

import pgw.linhas.areas.pgwlinhasareas.dtos.AeroportoDto;
import pgw.linhas.areas.pgwlinhasareas.models.Aeroporto;

import java.util.List;

public interface AeroportoService {
    List<Aeroporto> cadastrarAeroporto(List<AeroportoDto> aeroportoDtoList);
    List<AeroportoDto> recuperarAeroportos();
}
