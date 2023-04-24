import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { NewExperienciaComponent } from './components/experiencia/new-experiencia.component';
import { EditExpeComponent } from './components/experiencia/edit-expe.component';
import { NeweducComponent } from './components/educacion/neweduc.component';
import { EditeducComponent } from './components/educacion/editeduc.component';
import { NewhardysoftComponent } from './components/hardysoft/newhardysoft.component';
import { EdithardysoftComponent } from './components/hardysoft/edithardysoft.component';

const routes: Routes = [
  // Paths para login y pantalla principal
  {path: '', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'nuevaexp', component: NewExperienciaComponent},
  {path: 'editexp/:id', component: EditExpeComponent},
  {path: 'newedu', component: NeweducComponent},
  {path: 'editedu/:id', component: EditeducComponent},
  {path: 'newhys', component: NewhardysoftComponent},
  {path: 'edithys/:id', component: EdithardysoftComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
