package pgw.linhas.areas.pgwlinhasareas.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pgw.linhas.areas.pgwlinhasareas.dtos.VooDto;
import pgw.linhas.areas.pgwlinhasareas.models.Voo;
import pgw.linhas.areas.pgwlinhasareas.services.VooService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("/pwg-linhas-aereas/voo")
public class VooController {
    final VooService vooService;

    public VooController(VooService vooService) {
        this.vooService = vooService;
    }

    @PostMapping
    public ResponseEntity<Object> cadastrarVoo(@RequestBody @Valid VooDto vooDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(vooService.cadastrarVoos(vooDto));
    }

    @GetMapping
    public ResponseEntity<List<VooDto>> recuperarVoos(){
        return ResponseEntity.status(HttpStatus.OK).body(vooService.recuperarVoos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> recuperarVoo(@PathVariable(value = "id") long id){
        Optional<Voo> vooOptional = vooService.findById(id);
        if(!vooOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Voo não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(vooOptional.get());
    }

    //altera voo
    @PutMapping("/{id}")
    public ResponseEntity<Object> alterarVoo(@PathVariable(value = "id") long id, @RequestBody @Valid VooDto vooDto){
        Optional<Voo> vooOptional = vooService.findById(id);
        if(!vooOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Voo não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(vooService.alterarVoo(vooDto, vooOptional));
    }

    @PatchMapping("/cancelar/{id}")
    public ResponseEntity<Object> cancelarVoo(@PathVariable(value = "id") long id, @RequestBody VooDto vooDto){
        vooDto.setStatus("Cancelado");
        return ResponseEntity.status(HttpStatus.OK).body(vooService.cancelar(vooDto));
    }
}
