import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  URL:string  ="http://localhost:8080/user"
  
  constructor(private http: HttpClient) { }
  getAllUser():Observable<any>{
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa('prasant' + ':' + 'password') });
      
      return this.http.get(this.URL,{headers})
      // return this.http.get(this.URL)
  }


}
