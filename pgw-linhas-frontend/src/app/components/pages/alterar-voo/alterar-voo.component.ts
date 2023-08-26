import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Voo } from 'src/app/models/voo.model';
import { VooService } from 'src/app/services/voo-service/voo.service';

@Component({
  selector: 'app-alterar-voo',
  templateUrl: './alterar-voo.component.html',
  styleUrls: ['./alterar-voo.component.css']
})
export class AlterarVooComponent implements OnInit {

  id: number = 0;
  voo: Voo = new Voo();
  constructor(
    private vooService: VooService, 
    private router: Router, 
    private activeRoute: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.id = this.activeRoute.snapshot.params['id'];

    this.vooService.recuperarVooId(this.id).subscribe(resultado => {
      this.voo = resultado;
    }, error => console.log(error));
  }

  alterarVoo(){
    this.vooService.alterarVoo(this.id, this.voo).subscribe( data =>{
      this.recuperarListaVoos();
    }
    , error => console.log(error));
  }

  recuperarListaVoos(){
    this.router.navigate(['/listar']);
  }

}
