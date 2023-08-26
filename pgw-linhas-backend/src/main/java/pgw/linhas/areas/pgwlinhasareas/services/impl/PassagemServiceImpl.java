package pgw.linhas.areas.pgwlinhasareas.services.impl;

import org.springframework.stereotype.Service;
import pgw.linhas.areas.pgwlinhasareas.dtos.PassagemDto;
import pgw.linhas.areas.pgwlinhasareas.models.Passagem;
import pgw.linhas.areas.pgwlinhasareas.models.Voo;
import pgw.linhas.areas.pgwlinhasareas.repositories.PassagemRepository;
import pgw.linhas.areas.pgwlinhasareas.services.PassagemService;
import pgw.linhas.areas.pgwlinhasareas.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PassagemServiceImpl implements PassagemService {
   final PassagemRepository passagemRepository;

    public PassagemServiceImpl(PassagemRepository passagemRepository) {
        this.passagemRepository = passagemRepository;
    }

    Util util = new Util();
    List<PassagemDto> passagemDtoList = new ArrayList<>();

    @Override
    public Optional<Passagem> findById(long id) {
        return passagemRepository.findById(id);
    }

    @Override
    public List<PassagemDto> recuperarTodosPassageiros() {
        passagemDtoList = new ArrayList<>();
        List<Passagem> passagemList = passagemRepository.findAll();
        PassagemDto dto = new PassagemDto();
        for (Passagem passagem: passagemList) {
            util.copiarPropriedades(passagem, dto);
            passagemDtoList.add(dto);
        }
        return passagemDtoList;
    }

    @Override
    public Passagem comprarPassagem(PassagemDto passagemDto) {
        Passagem passagem = new Passagem();
        util.copiarPropriedades(passagemDto, passagem);
        return passagemRepository.save(passagem);
    }

    @Override
    public List<PassagemDto> recuperarPassagensCPFComprador(String cpf) {
        passagemDtoList = new ArrayList<>();
        List<Passagem> passagemList = passagemRepository.recuperarPassagensCPFComprador(cpf);
        PassagemDto dto = new PassagemDto();
        for (Passagem passagem: passagemList) {
            util.copiarPropriedades(passagem, dto);
            passagemDtoList.add(dto);
        }
        return passagemDtoList;
    }

    @Override
    public List<PassagemDto> recuperarPassagemVoo(String codigo) {
        passagemDtoList = new ArrayList<>();
        List<Passagem> passagemList = passagemRepository.recuperarPassagemVoo(codigo);
        PassagemDto dto = new PassagemDto();
        for (Passagem passagem: passagemList) {
            util.copiarPropriedades(passagem, dto);
            passagemDtoList.add(dto);
        }
        return passagemDtoList;
    }

    @Override
    public Passagem cancelar(PassagemDto passagemDto, Optional<Passagem> optional) {
        Passagem passagemAtual = optional.get();
        passagemAtual.setStatusPassagem(passagemDto.getStatusPassagem());
        return passagemRepository.save(passagemAtual);
    }
}
