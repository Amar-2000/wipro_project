import { Component } from '@angular/core';
import { RestService } from './rest.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'practice';

  constructor(private restService:RestService){}

  Validate(){
   
    this.restService.validate().subscribe({
      next: (data) => {alert (data);},

      error : (err) => console.log(err)

    })
  }
}
