import { Component } from '@angular/core';
import { Hardysoft } from 'src/app/model/hardysoft';
import { ShardysoftService } from 'src/app/service/shardysoft.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-hardysoft',
  templateUrl: './hardysoft.component.html',
  styleUrls: ['./hardysoft.component.css'],
})
export class HardysoftComponent {
  hys: Hardysoft[] = [];
  isLogged = false;

  constructor(
    private sHys: ShardysoftService,
    private tokenS: TokenService
  ) {}

  ngOnInit(): void {
    this.cargarHys();
    if (this.tokenS.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  cargarHys() {
    this.sHys.lista().subscribe((data) => {
      this.hys = data;
    });
  }

  delete(id?: number) {
    if (id != undefined) {
      this.sHys.delete(id).subscribe(
        (data) => {
          this.cargarHys();
        },
        (err) => {
          alert('No se pudo borrar la experiencia');
        }
      );
    }
  }
}
