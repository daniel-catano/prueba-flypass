import { Injectable } from '@angular/core';
import {HttpErrorResponse} from "@angular/common/http";
import {throwError} from "rxjs";
import {InformationMessages} from "../constants/informationMessages";

@Injectable({
  providedIn: 'root'
})
export class HttpErrorHandlerService {

  constructor() { }

  handleError(error: HttpErrorResponse) {
    if(typeof error.error === "string") {
      return throwError(() => new Error(error.error));
    }
    const message = error.error?.message??InformationMessages.somethingBadOccurred;
    return throwError(() => new Error(message));
  }
}
