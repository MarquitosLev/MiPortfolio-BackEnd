import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Hardysoft } from 'src/app/model/hardysoft';
import { ShardysoftService } from 'src/app/service/shardysoft.service';

@Component({
  selector: 'app-newhardysoft',
  templateUrl: './newhardysoft.component.html',
  styleUrls: ['./newhardysoft.component.css']
})
export class NewhardysoftComponent {
  nombre: string;
  porcent: number;

  constructor(private Shys: ShardysoftService, private router: Router){}

  ngOnInit(): void{

  }

  onCreate(): void{
    const hys = new Hardysoft(this.nombre, this.porcent);
    this.Shys.save(hys).subscribe(
      data => {
        alert("Skill Creada");
        this.router.navigate(['']);
      }, err => {
        alert("Falló al agregar esta Skill");
        this.router.navigate(['']);
      }
    )
  }

}
