package pgw.linhas.areas.pgwlinhasareas.services;

import pgw.linhas.areas.pgwlinhasareas.dtos.PassagemDto;
import pgw.linhas.areas.pgwlinhasareas.dtos.VooDto;
import pgw.linhas.areas.pgwlinhasareas.models.Passagem;
import pgw.linhas.areas.pgwlinhasareas.models.Voo;

import java.util.List;
import java.util.Optional;

public interface VooService {
    Voo cadastrarVoos(VooDto vooDto);
    Voo alterarVoo(VooDto vooDto, Optional<Voo> vooOptional);
    List<VooDto> recuperarVoos();
    Optional<Voo> findById(long id);
    Voo cancelar(VooDto vooDto);

    void atualizarInFormacoesVoo(Passagem passagem);

}
