import { Injectable } from '@angular/core';
import {catchError, Observable} from "rxjs";
import {ResponseList} from "../model/response-list";
import {ClientResponse} from "../model/client";
import {HttpClient, HttpParams} from "@angular/common/http";
import {HttpErrorHandlerService} from "./http-error-handler.service";

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(
    private httpClient: HttpClient,
    private httpErrorHandlerService: HttpErrorHandlerService,
  ) { }

  findAll(page?: number): Observable<ResponseList<ClientResponse>> {
    let params = new HttpParams();
    if(page) {
      params = params.append('page', page);
    }
    return this.httpClient.get<ResponseList<ClientResponse>>('http://localhost:8080/clients', {params})
      .pipe(catchError(this.httpErrorHandlerService.handleError));
  }
}
