package pgw.linhas.areas.pgwlinhasareas.services;

import pgw.linhas.areas.pgwlinhasareas.dtos.AeroportoDto;
import pgw.linhas.areas.pgwlinhasareas.models.Aeroporto;

import java.util.List;

public interface AeroportoService {
    Aeroporto cadastrarAeroporto(AeroportoDto aeroportoDto);
    List<AeroportoDto> recuperarAeroportos();
}
