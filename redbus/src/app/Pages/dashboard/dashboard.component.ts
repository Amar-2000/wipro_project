import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { BusserviceService } from '../../service/busservice.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {

  response:any;
  searchBusForm! : FormGroup;
  constructor(private router : Router, private busservice:BusserviceService, private fb:FormBuilder ){}

  ngOnInit(){

    this.searchBusForm = this.fb.group({

      source : [null, Validators.required],
      destination : [null, Validators.required],
      date : [null, Validators.required]
    })

    
  }

  
  
searching(){
  this.busservice.searchBus(this.searchBusForm.value).subscribe((res)=>{
    console.log(this.searchBusForm.value);
    // console.log(res);
    this.response=res
    // console.log(this.response);
    this.busservice.setBusData(res);

    
  })
  this.router.navigate(['availablebus']);

}
}
