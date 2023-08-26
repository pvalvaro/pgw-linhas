import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdicionarVooComponent } from './components/pgw-voo/adicionar-voo/adicionar-voo.component';
import { ListarVooComponent } from './components/pgw-voo/listar-voo/listar-voo.component';
import { DetalharVooComponent } from './components/pgw-voo/detalhar-voo/detalhar-voo.component';
import { AlterarVooComponent } from './components/pages/alterar-voo/alterar-voo.component';
import { PrecoComponent } from './components/pgw-voo/preco/preco.component';
import { ComprarPassagemComponent } from './components/pages/comprar-passagem/comprar-passagem.component';
import { PassagemResumoComponent } from './components/pages/passagem-resumo/passagem-resumo.component';
import { HomeComponent } from './components/pages/home/home.component';
import { LoginComponent } from './components/pages/login/login.component';
import { MenuComponent } from './components/pages/menu/menu.component';

const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'home', component: HomeComponent},
  {path: 'adicionar', component: AdicionarVooComponent},
  {path: 'listar', component: ListarVooComponent},
  {path: 'detalhar', component: DetalharVooComponent},
  {path: 'alterar-voo/:id', component: AlterarVooComponent},
  {path: 'preco', component: PrecoComponent},
  {path: 'comprar', component: ComprarPassagemComponent},
  {path: 'passagem-resumo', component: PassagemResumoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
