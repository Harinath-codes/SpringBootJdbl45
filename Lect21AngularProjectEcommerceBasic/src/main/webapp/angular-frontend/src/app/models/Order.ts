//TODO: Add the contents of the order class

export class Orders{
    cartIDList:Array<number> = new Array()
    user:User = new User()  
  }

 export class User {
    address: string
    creditCard: string
    id: number
    name: string
 }
export class Cart{
    active: boolean
    id: number
    productID: number
    quantity: number
    userID: number
}