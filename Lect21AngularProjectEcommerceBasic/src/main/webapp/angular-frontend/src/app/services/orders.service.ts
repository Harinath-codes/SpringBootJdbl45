import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Orders } from '../models/Order';
import { Product } from '../models/Product';

@Injectable({
  providedIn: 'root'
})
export class OrdersService {


  baseURL:string = "http://localhost:8080/orders"
  headers = new HttpHeaders({ Authorization: 'Basic ' + btoa('prasant' + ':' + 'password') });
    

  constructor(private http: HttpClient) { }

  postOrder(order:Orders): Observable<any> {
  //TODO: Fetch the product list from the API
     return this.http.post(this.baseURL+"/add",order,{headers:this.headers})
  }

}
