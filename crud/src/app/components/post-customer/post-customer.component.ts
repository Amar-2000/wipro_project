import { Component } from '@angular/core';
import { CustomerService } from '../../service/customer.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-post-customer',
  templateUrl: './post-customer.component.html',
  styleUrl: './post-customer.component.css'
})
export class PostCustomerComponent {

  postCustomerForm!:FormGroup;
  constructor(private customerService:CustomerService, private fb:FormBuilder){}

  ngOnInit(){
    this.postCustomerForm = this.fb.group({
      name : [null, Validators.required],
      email : [null, Validators.required, Validators.email],
      phone : [null, Validators.required]
    })
  }

  postCustomer(){

    // console.log(this.postCustomerForm.value)
    this.customerService.postCustomer(this.postCustomerForm.value).subscribe((res)=>{
      console.log(res);
    })
  }

}
