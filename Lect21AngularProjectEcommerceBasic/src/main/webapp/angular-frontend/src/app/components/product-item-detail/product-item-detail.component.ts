import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductService } from '../../services/product.service';
import { CartService } from '../../services/cart.service';
import { Product } from '../../models/Product';


@Component({
  selector: 'app-product-item-detail',
  templateUrl: './product-item-detail.component.html',
  styleUrls: ['./product-item-detail.component.css']
})
export class ProductItemDetailComponent implements OnInit {
  product: Product | undefined;
  selectedAmount: number = 1;

  constructor(
    private route: ActivatedRoute,
    private productService: ProductService,
    private cartService: CartService
  ) { }

  ngOnInit(): void {
    // this.getProduct();
    let id:string = this.route.snapshot.paramMap.get('id');

    this.productService.getProductByID(parseInt(id))
      .subscribe(data=>{
        this.product = data
      })
  }

  getProduct(): void {
//TODO: Get the product description

  }

  addToCart(product: Product, amount: any): void {
    // const cartProductPayload = {
    //   id: product.id,
    //   name: product.name,
    //   price: product.price,
    //   url: product.url,
    //   amount: parseInt(amount)
    // };


    this.cartService.addToCart(product, amount)
      .subscribe(data=>{
          console.log("updated cart")
          alert(amount+" items updated to cart!!!")
        })
  }

  // util
  getPageId(): any {
    // return this.route.snapshot.paramMap.get('id');
    return ''
  }
}
