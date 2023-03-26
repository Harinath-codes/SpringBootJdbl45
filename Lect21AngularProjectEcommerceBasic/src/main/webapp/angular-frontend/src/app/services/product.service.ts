import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../models/Product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {


  baseURL:string = "http://localhost:8080/product"

  headers = new HttpHeaders({ Authorization: 'Basic ' + btoa('prasant' + ':' + 'password') });
    
  constructor(private http: HttpClient) { }

  getProducts(): Observable<Product[]> {
  //TODO: Fetch the product list from the API
  
     return this.http.get<Product[]>(this.baseURL,{headers:this.headers})
  }

  getProductByID(id:number):Observable<Product>{
    return this.http.get<Product>(this.baseURL+"/"+id,{headers:this.headers})
  }
}
