import { Component, OnInit } from '@angular/core';
import { CartService } from '../../services/cart.service';
import { Router } from '@angular/router';
import { Orders, User } from '../../models/Order';
import { Product } from 'src/app/models/Product';
import { ProductCart } from 'src/app/models/ProductCart';
import { OrdersService } from 'src/app/services/orders.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  cartProducts: ProductCart[] = new Array();
  total: number = 0;
  customerName: string = '';
  customerAddress: string = '';
  customerCreditCard: string = '';

  constructor(
    private cartService: CartService,
    private router: Router,
    private orderService:OrdersService
  ) { }

  ngOnInit(): void {
    //alert("cart")
    let val:number = 0;
    this.cartService.getCartProducts()
      .subscribe((res:ProductCart[])=>{
        this.cartProducts = res
        this.total = this.getCartTotal(this.cartProducts);
        console.log(res)
      })

    // this.total = this.cartProducts.length
  }

  getCartTotal(cart: ProductCart[]): number {
    let sum = 0;
    cart.forEach(element => {
      sum +=element.product.price * element.cart.quantity
    });
   //TODO Sum up total cart price
    return sum
  }

  modelChanged(product: ProductCart): void {

    if (product.cart.quantity === 0) {
      this.cartProducts = this.cartProducts.filter((cartProduct: ProductCart) => cartProduct.product.id !== product.product.id);
      console.log(product)
       this.cartService.updateCart(product.product,product.cart)
       .subscribe(data=>{
        this.total = this.getCartTotal(this.cartProducts);
        alert('Item removed from cart!');

       })

    }else {
      console.log(product)
      this.cartService.updateCart(product.product,product.cart)
        .subscribe(data=>{
          this.total = this.getCartTotal(this.cartProducts);

        })

    }

  }

  onSubmit() {
    let order = new Orders();
    let user = new User()
    order.user = user
    user.address = this.customerAddress
    user.creditCard = this.customerCreditCard
    user.name = this.customerName
    user.id = parseInt(localStorage.getItem("user"))
    order.cartIDList = new Array()
    this.cartProducts.forEach(ele=>{
      order.cartIDList.push(ele.cart.id);
    })

//alert("submit")
    this.orderService.postOrder(order)
      .subscribe(data=>{
        //alert(data)
        this.cartService.clearCart();
        this.cartProducts = [];
        this.router.navigate(['/confirmation', { customerName: this.customerName, total: this.total }]);

      })


    //TODO: Submit order - call the service
  }

  // util
  allowOnlyNumbers(event: any): boolean {
    const characterCode = (event.which) ? event.which : event.keyCode;
    return (characterCode > 31 && (characterCode < 48 || characterCode > 57)) ? false : true;
  }
}
