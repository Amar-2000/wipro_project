import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RestService {

  constructor(private http:HttpClient) { }

  strUrl = "http://localhost:8080/";

  validate() :Observable<any>{
    let UID = "amarkolhe";
    let PWD = "amar1204";

    let loginUrl = this.strUrl + "Validate?UID=" + UID + "&PWD=" + PWD; 

    return this.http.get(loginUrl, {responseType:"text"});
  }
}
