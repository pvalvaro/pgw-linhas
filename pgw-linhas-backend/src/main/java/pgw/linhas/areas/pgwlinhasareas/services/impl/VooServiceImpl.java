package pgw.linhas.areas.pgwlinhasareas.services.impl;

import org.springframework.stereotype.Service;
import pgw.linhas.areas.pgwlinhasareas.dtos.VooDto;
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
        vooAtualizacao.setEconomica(vooDto.isEconomica());
        vooAtualizacao.setPrimeira(vooDto.isPrimeira());
        vooAtualizacao.setExecutiva(vooDto.isExecutiva());
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
}
