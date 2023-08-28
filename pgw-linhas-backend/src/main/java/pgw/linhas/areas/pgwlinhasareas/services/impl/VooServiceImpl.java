package pgw.linhas.areas.pgwlinhasareas.services.impl;

import org.springframework.stereotype.Service;
import pgw.linhas.areas.pgwlinhasareas.dtos.PassagemDto;
import pgw.linhas.areas.pgwlinhasareas.dtos.VooDto;
import pgw.linhas.areas.pgwlinhasareas.models.Passagem;
import pgw.linhas.areas.pgwlinhasareas.models.Voo;
import pgw.linhas.areas.pgwlinhasareas.repositories.VooRepository;
import pgw.linhas.areas.pgwlinhasareas.services.VooService;
import pgw.linhas.areas.pgwlinhasareas.util.Util;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VooServiceImpl implements VooService {

    Util util = new Util();
    final VooRepository vooRepository;

    public VooServiceImpl(VooRepository vooRepository) {
        this.vooRepository = vooRepository;
    }
    @Transactional
    public Voo cadastrarVoos(VooDto vooDto) {
        Voo voo = new Voo();
        util.copiarPropriedades(vooDto, voo);
        return vooRepository.save(voo);
    }
    public Voo alterarVoo(VooDto vooDto, Optional<Voo> vooOptional){
        Voo vooAtualizacao = vooOptional.get();
        vooAtualizacao.setPartida(vooDto.getPartida());
        vooAtualizacao.setChegada(vooDto.getChegada());
        vooAtualizacao.setQtdAssentoEconomica(vooDto.getQtdAssentoEconomica());
        vooAtualizacao.setQtdAssentoPrimeira(vooDto.getQtdAssentoPrimeira());
        vooAtualizacao.setQtdAssentoExecutiva(vooDto.getQtdAssentoExecutiva());
        vooAtualizacao.setPrecoAssentoPrimeira(vooDto.getPrecoAssentoPrimeira());
        vooAtualizacao.setPrecoAssentoEconomica(vooDto.getPrecoAssentoEconomica());
        vooAtualizacao.setPrecoAssentoExecutiva(vooDto.getPrecoAssentoExecutiva());
        vooAtualizacao.setEconomica(vooDto.getEconomica());
        vooAtualizacao.setPrimeira(vooDto.getPrimeira());
        vooAtualizacao.setExecutiva(vooDto.getExecutiva());
        return vooRepository.save(vooAtualizacao);
    }
    public List<VooDto> recuperarVoos(){
        List<Voo> vooList = vooRepository.findAll();
        List<VooDto> vooDtoList = new ArrayList<>();
        for (Voo voo: vooList) {
            vooDtoList.add(VooDto.convertVooToDTO(voo));
        }
        return vooDtoList;
    }
    public Optional<Voo> findById(long id) {
        return vooRepository.findById(id);
    }
    @Override
    public Voo cancelar(VooDto vooDto) {
        Voo voo = new Voo();
        util.copiarPropriedades(vooDto, voo);
        return vooRepository.save(voo);
    }

    public void atualizarInFormacoesVoo(Passagem passagem){
        Voo vooInfoAntigo = new Voo();
        List<Voo> vooList = vooRepository.findByCodigoAviao(passagem.getCodigoVoo());

        for (Voo vA: vooList) {
            vooInfoAntigo = vA;
            vooInfoAntigo.setTotalAssentos(vA.getTotalAssentos() - passagem.getQtdPassagens());

            if(passagem.getClasseEscolhida().equals("Economica"))
                vooInfoAntigo.setQtdAssentoEconomica(vA.getQtdAssentoEconomica() - passagem.getQtdPassagens());

            if(passagem.getClasseEscolhida().equals("Primeira"))
                vooInfoAntigo.setQtdAssentoPrimeira(vA.getQtdAssentoPrimeira() - passagem.getQtdPassagens());


            if(passagem.getClasseEscolhida().equals("Executiva"))
                vooInfoAntigo.setQtdAssentoExecutiva(vA.getQtdAssentoExecutiva() - passagem.getQtdPassagens());

        }
        vooRepository.save(vooInfoAntigo);
    }
}
