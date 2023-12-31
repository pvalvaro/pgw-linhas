package pgw.linhas.areas.pgwlinhasareas.services.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pgw.linhas.areas.pgwlinhasareas.dtos.AeroportoDto;
import pgw.linhas.areas.pgwlinhasareas.models.Aeroporto;
import pgw.linhas.areas.pgwlinhasareas.repositories.AeroportoRepository;
import pgw.linhas.areas.pgwlinhasareas.services.AeroportoService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class AeroportoServiceImpl implements AeroportoService {
    final AeroportoRepository aeroportoRepository;

    public AeroportoServiceImpl(AeroportoRepository aeroportoRepository) {
        this.aeroportoRepository = aeroportoRepository;
    }

    @Transactional
    public List<Aeroporto> cadastrarAeroporto(List<AeroportoDto> aeroportoDtoList) {
        List<Aeroporto> aeroportoList = new ArrayList<>();
        Aeroporto aeroporto = new Aeroporto();
        for(AeroportoDto aeroportoDto: aeroportoDtoList){
            BeanUtils.copyProperties(aeroportoDto, aeroporto);
            aeroporto = aeroportoRepository.save(aeroporto);
            aeroportoList.add(aeroporto);
            aeroporto = new Aeroporto();
        }
        return aeroportoList;
    }

    public List<AeroportoDto> recuperarAeroportos(){
        List<Aeroporto> aeroportoList = aeroportoRepository.findAll();
        List<AeroportoDto> aeroportoDtosResult = new ArrayList<>();
        for (Aeroporto aeroporto: aeroportoList) {
            aeroportoDtosResult.add(AeroportoDto.convertAeroportoToDTO(aeroporto));
        }
        return aeroportoDtosResult;
    }

}
