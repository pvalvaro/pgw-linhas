package pgw.linhas.areas.pgwlinhasareas.controllers;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pgw.linhas.areas.pgwlinhasareas.dtos.AeroportoDto;
import pgw.linhas.areas.pgwlinhasareas.models.Aeroporto;
import pgw.linhas.areas.pgwlinhasareas.services.AeroportoService;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/pwg-linhas-aereas")
public class AeroportoController {
    final AeroportoService aeroportoService;

    public AeroportoController(AeroportoService aeroportoService) {
        this.aeroportoService = aeroportoService;
    }

    @PostMapping
    public ResponseEntity<Object> cadastrarAeroporto(@RequestBody @Valid AeroportoDto aeroportoDto){
        /*if(aeroportoService.existeCodigoIATA(aeroportoDto.getCodigoIATA())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Aeroporto já cadastrado");
        }*/
        return ResponseEntity.status(HttpStatus.CREATED).body(aeroportoService.cadastrarAeroporto(aeroportoDto));
    }

    @GetMapping
    public ResponseEntity<List<AeroportoDto>> recuperarAeroportos(){
        return ResponseEntity.status(HttpStatus.OK).body(aeroportoService.recuperarAeroportos());
    }
}
