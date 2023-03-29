import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-social',
  templateUrl: './social.component.html',
  styleUrls: ['./social.component.css']
})
export class SocialComponent {
  constructor(private router: Router){}

  login(){
    this.router.navigate(['/login']);
  }
}
