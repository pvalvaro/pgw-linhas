package pgw.linhas.areas.pgwlinhasareas.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pgw.linhas.areas.pgwlinhasareas.dtos.PassagemDto;
import pgw.linhas.areas.pgwlinhasareas.models.Passagem;
import pgw.linhas.areas.pgwlinhasareas.services.PassagemService;
import pgw.linhas.areas.pgwlinhasareas.services.VooService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/pwg-linhas-aereas/passagem")
public class PassagemController {
    final PassagemService passagemService;
    final VooService vooService;

    public PassagemController(PassagemService passagemService, VooService vooService) {
        this.passagemService = passagemService;
        this.vooService = vooService;
    }

    @PostMapping
    public ResponseEntity<Object> comprarPassagem(@RequestBody PassagemDto passagemDto){
        Passagem passagemComprada = passagemService.comprarPassagem(passagemDto);
        vooService.atualizarInFormacoesVoo(passagemComprada);
        return ResponseEntity.status(HttpStatus.CREATED).body(passagemComprada);
    }

    @GetMapping
    public ResponseEntity<List<PassagemDto>> recuperarTodosPassageiros(){
        return ResponseEntity.status(HttpStatus.OK).body(passagemService.recuperarTodosPassageiros());
    }

    @GetMapping("/comprador/{cpf}")
    public ResponseEntity<List<PassagemDto>> recuperarPassagensCPFComprador(@PathVariable(value ="cpf") String cpf){
        return ResponseEntity.status(HttpStatus.OK).body(passagemService.recuperarPassagensCPFComprador(cpf));
    }

    @GetMapping("/codivoo/{codigo}")
    public ResponseEntity<List<PassagemDto>> recuperarPassagemVoo(@PathVariable(value ="codigo") String codigo){
        return ResponseEntity.status(HttpStatus.OK).body(passagemService.recuperarPassagemVoo(codigo));
    }

    @PatchMapping("/cancelar/{id}")
    public ResponseEntity<Object> cancelarCompra(@PathVariable(value = "id") long id, @RequestBody PassagemDto passagemDto){
        Optional<Passagem> optionalPassagem = passagemService.findById(id);
        if(!optionalPassagem.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Passagem não encontrada");
        }
        if(optionalPassagem.isPresent() && optionalPassagem.get().getStatusPassagem().equals("Cancelada")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Passagem já está cancelado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(passagemService.cancelar(passagemDto, optionalPassagem));
    }
}
