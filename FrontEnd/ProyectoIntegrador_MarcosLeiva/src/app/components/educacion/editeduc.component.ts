import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Educacion } from 'src/app/model/educacion';
import { SeducacionService } from 'src/app/service/seducacion.service';

@Component({
  selector: 'app-editeduc',
  templateUrl: './editeduc.component.html',
  styleUrls: ['./editeduc.component.css'],
})
export class EditeducComponent {
  educ: Educacion = null;

  constructor(
    private educS: SeducacionService,
    private activatedRouter: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    const id = this.activatedRouter.snapshot.params['id'];
    this.educS.detail(id).subscribe(
      (data) => {
        this.educ = data;
      },
      (err) => {
        alert('Error');
        this.router.navigate(['']);
      }
    );
  }

  onUpdate() {
    const id = this.activatedRouter.snapshot.params['id'];
    this.educS.update(id, this.educ).subscribe(
      (data) => {
        this.router.navigate(['']);
      },
      (err) => {
        alert('Errores al modificar');
        this.router.navigate(['']);
      }
    );
  }
}
