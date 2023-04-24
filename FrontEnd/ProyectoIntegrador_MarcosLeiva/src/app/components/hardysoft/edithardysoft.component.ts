import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Hardysoft } from 'src/app/model/hardysoft';
import { ShardysoftService } from 'src/app/service/shardysoft.service';

@Component({
  selector: 'app-edithardysoft',
  templateUrl: './edithardysoft.component.html',
  styleUrls: ['./edithardysoft.component.css'],
})
export class EdithardysoftComponent {
  hys: Hardysoft = null;

  constructor(
    private hysService: ShardysoftService,
    private activatedRouter: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    const id = this.activatedRouter.snapshot.params['id'];
    this.hysService.detail(id).subscribe(
      (data) => {
        this.hys = data;
      },
      (err) => {
        alert('Error al modificar');
        this.router.navigate(['']);
      }
    );
  }

  onUpdate() {
    const id = this.activatedRouter.snapshot.params['id'];
    this.hysService.update(id, this.hys).subscribe(
      (data) => {
        this.router.navigate(['']);
      },
      (err) => {
        alert('Error al modificar');
        this.router.navigate(['']);
      }
    );
  }
}
