import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../models/Product';
import { Cart } from '../models/Order';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  cartProducts: any[] = [];
  URL:string  ="http://localhost:8080/product"
  headers = new HttpHeaders({ Authorization: 'Basic ' + btoa('prasant' + ':' + 'password') });
    
  constructor(private http: HttpClient) { }


  getCartProducts():Observable<any> {

    return  this.http.get(this.URL+"/cart/"+parseInt(localStorage.getItem("user")),{headers:this.headers})

  }

  // private Integer userID;
  // private Integer productID;
  // private Integer quantity;
  addToCart(product: Product, quantity:number):Observable<any> {
    //TODO: Add item to the cart
    let obj = {
      "userID":parseInt(localStorage.getItem("user")),
      "productID":product.id,
      "quantity":quantity
    }
    // existingProduct.amount += parseInt(amount);
  return  this.http.post(this.URL+"/add-to-cart",obj,{headers:this.headers})

    // alert('Added to cart!');
  }

  clearCart() {
    this.cartProducts = [];
    return this.cartProducts;
  }

  //  private Integer ID;

  //   private Integer userID;
  //   private Integer productID;
  //   private Integer quantity;
  //   private boolean active=false;

  updateCart(prod:Product,cart:Cart):Observable<any> {
    //TODO: Add item to the cart
    let obj = {
      "userID":parseInt(localStorage.getItem("user")),
      "productID":prod.id,
      "quantity":cart.quantity,
      "id":cart.id,
      active:cart.active
    }
    console.log(obj)
    // existingProduct.amount += parseInt(amount);
  return  this.http.put(this.URL+"/update-to-cart",obj,{headers:this.headers})

    // alert('Added to cart!');
  }

  submitOrder(order: any): Observable<any> {
  //Submit the order information the API

  return this.http.post("",null)
  
  }
}
