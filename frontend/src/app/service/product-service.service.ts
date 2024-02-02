import { Injectable } from '@angular/core';
import {catchError, Observable} from "rxjs";
import {ResponseList} from "../model/response-list";
import {ClientResponse} from "../model/client";
import {HttpClient, HttpParams} from "@angular/common/http";
import {HttpErrorHandlerService} from "./http-error-handler.service";
import {ProductResponse} from "../model/product-response";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(
    private httpClient: HttpClient,
    private httpErrorHandlerService: HttpErrorHandlerService,
  ) { }

  findByClientId(page?: number, clientId?: number): Observable<ResponseList<ProductResponse>> {
    let params = new HttpParams();
    if(page) {
      params = params.append('page', page);
    }
    return this.httpClient.get<ResponseList<ProductResponse>>(`http://localhost:8080/clients/${clientId}/products`, {params})
      .pipe(catchError(this.httpErrorHandlerService.handleError));
  }
}
