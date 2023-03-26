import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable()
export class TokenInterceptor implements HttpInterceptor {

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
      const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa('prasant' + ':' + 'password') });

    request = request.clone({
      setHeaders: {
        Authorization: `Bearer ${headers}`
      }
    });    return next.handle(request);
  }
}
