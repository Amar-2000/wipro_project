import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { BusserviceService } from '../../service/busservice.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login-signup',
  templateUrl: './login-signup.component.html',
  styleUrl: './login-signup.component.css'
})
export class LoginSignupComponent {

  // email : any;
  // password:any;
  registerUserForm!: FormGroup;
  loginUserForm!: FormGroup;

  data : any;

  constructor(private router : Router, private busservice:BusserviceService, private fb:FormBuilder) {}

  ngOnInit(){
    this.registerUserForm= this.fb.group({
      name : [null, Validators.required],
      email : [null, Validators.required, Validators.email],
      contact : [null, Validators.required],
      password : [null, Validators.required],
      confirmPass : [null, Validators.required]
    });
    this.loginUserForm=this.fb.group({
      email : [null, Validators.required, Validators.email],
      password : [null, Validators.required]
      
    })
  }

  registerUser(){
    // console.log(this.registerUserForm.value)
    this.busservice.registerUser(this.registerUserForm.value).subscribe((res)=>{
      console.log(res);
      // next : (data: any) => {this.data=data}
    });
  }

  userLogin(){
    this.busservice.userLogin(this.loginUserForm.value.email, this.loginUserForm.value.password).subscribe((res)=>{
      console.log(res);
    });
  }

  activeForm : 'login' | 'register' ='login';
  loginform(){
    this.router.navigate(['dashboard']);
  }
  toggleForm(form : 'login' | 'register'){
    this.activeForm = form;
    


  }

}
