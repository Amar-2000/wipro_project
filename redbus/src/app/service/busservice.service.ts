import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginSignupComponent } from '../Pages/login-signup/login-signup.component';

const strUrl = "http://localhost:8080/api/"

@Injectable({
  providedIn: 'root'
})
export class BusserviceService {

  constructor(private http:HttpClient) { }

  // username="user@gmail.com";
  // password="pass";
  registerUser(user:any):Observable<any>{
    return this.http.post(strUrl + "register",user);
  }

   

  userLogin(email:any, password:any):Observable<any>{
    console.log(email, password)
      return this.http.get(strUrl + "login?email=" + email + "&password=" + password, {responseType:'text'}); 
  }
}
