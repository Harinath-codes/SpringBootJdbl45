import { Component, OnInit } from '@angular/core';
import { ProductService } from '../../services/product.service';
import { CartService } from '../../services/cart.service';
import { Product } from '../../models/Product';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[];

  constructor(
    private productService: ProductService,
    private cartService: CartService
  ) {
    this.products = [];
  }

  ngOnInit(): void {
 //TODO: Get the product list
    this.productService.getProducts().subscribe(data=>{
      this.products = data
    })
  }

  addToCart(product: Product, quantity: number): void {
    const cartProductPayload = {
      id: product.id,
      name: product.title,
      price: product.price,
      url: product.imageURL,
    };

    console.log(product)
    console.log(quantity)

    this.cartService.addToCart(product, quantity)
      .subscribe(data=>{
        alert("Added to Cart Successfully!")
      })
  }
}
