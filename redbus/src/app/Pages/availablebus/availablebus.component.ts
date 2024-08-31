import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-availablebus',
  templateUrl: './availablebus.component.html',
  styleUrl: './availablebus.component.css'
})
export class AvailablebusComponent {
  constructor(private router : Router){}
  payment(){
    this.router.navigate(['payment']);
  
  }

}
