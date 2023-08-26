import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Home } from 'src/app/models/home.model';
import { VooService } from 'src/app/services/voo-service/voo.service';
import { Voo } from 'src/app/models/voo.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  home:Home = {
    origem: '',
    destino: '',
    datapartida: new Date()
  }
  
  voos?: Voo[];
  vooBusca?: Voo;
  listaAeroportos?:[];

  isADMIN = false;
  logar = false;

  constructor(private vooService: VooService,
     private router: Router) { }

    
   ngOnInit(): void {
     const objetoArmazenado = sessionStorage.getItem('Role_ADMIN');
     this.isADMIN = objetoArmazenado !== null ? JSON.parse(objetoArmazenado) : false;
  }

  onSelectBlur() {
    if(this.home.origem === this.home.destino)
      alert('Origem e destino não podem ser iguais');
  }

  validacoes() {
    this.home.origem === '' ? alert('Local de Origem não informado') : true;
    this.home.destino === '' ? alert('Local de Destino não informado') : true;
    this.home.datapartida === null ? alert('Data não informada') : true;
  }

  pesquisarVoos(){
    const filtro = {
      origem:this.home.origem,
      destino:this.home.destino,
      datapartida:this.home.datapartida
    };  
    
    this.validacoes();

    this.vooService.recuperarVoos().subscribe({
      next:(resultado) => {
        let resultFiltro = [];
        for(let vo of resultado){
          if(filtro.datapartida === vo.partida)
            resultFiltro.push(vo);
        }
        if(resultFiltro)  
          this.voos = resultFiltro;
      },
      error:(e) => console.log(e)
    });
  }
  comprar(voo: Voo){
    voo.destino = this.home.destino;
    voo.origem = this.home.origem;
    window.sessionStorage.setItem('voo', JSON.stringify(voo));
    this.router.navigate(['comprar']);
  }
  infoPassagens(){
    this.router.navigate(['comprar']);
  }
  infoVoos(){
    this.router.navigate(['adicionar']);
  }
  infoPrecos(){
    this.router.navigate(['preco']);
  }
  infoAeroporto(){
  }
}
