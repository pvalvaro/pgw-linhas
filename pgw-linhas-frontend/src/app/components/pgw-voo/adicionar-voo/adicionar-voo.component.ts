import { Component, OnInit } from '@angular/core';
import { Voo } from 'src/app/models/voo.model';
import { VooService } from 'src/app/services/voo-service/voo.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adicionar-voo',
  templateUrl: './adicionar-voo.component.html',
  styleUrls: ['./adicionar-voo.component.css']
})
export class AdicionarVooComponent implements OnInit {

  voo: Voo = {
    codigoAviao: '', 
    partida: new Date(), 
    chegada: new Date(),
    totalAssentos: 0,
    status: '',
    destino: '',
    origem: ''
  };
  submetido = false;

  voos?: Voo[];
  constructor(private vooService: VooService,
    private router: Router) { } 

  ngOnInit(): void {
    this.recuperarVoos();
  }

  onSelectBlur() {
    if(this.voo.origem === this.voo.destino)
      alert('Origem e destino não podem ser iguais');
  }

  cadastrarVoo(): void{
    const data = {
      codigoAviao:this.voo.codigoAviao,
      partida:this.voo.partida,
      chegada:this.voo.chegada,
      totalAssentos:this.voo.totalAssentos,
      status: "Confirmado",
      destino: this.voo.destino,
      origem: this.voo.origem
    };

    this.vooService.cadastrarVoo(data)
      .subscribe({
        next:(res) => {
          console.log(res);
          this.submetido = true
          this.recuperarVoos();
        },
        error: (e) => console.error(e)
      });
  }

  recuperarVoos():void{
    this.vooService.recuperarVoos()
      .subscribe({
        next:(data) => {
          this.voos = data;
        },
        error:(e) => console.log(e)
      });
  }
  alterarVoo(id?: number){
    this.router.navigate(['alterar-voo', id]);
  }
  cancelarVoo(id?: number, voo?: Voo){
    this.vooService.cancelarVoo(id, voo).subscribe( data => {
      console.log(data);
      this.recuperarVoos();
    })
  }

  novoVoo(): void{
    this.submetido = false;
    this.voo = {
      codigoAviao: '', 
      partida: new Date(), 
      chegada: new Date(),
      totalAssentos: 0,
      status: '',
      destino: '',
      origem: ''
    };
  }
}
