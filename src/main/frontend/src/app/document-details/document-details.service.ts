
import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Headers, RequestOptions } from '@angular/http';
import 'rxjs/Rx';


@Injectable()
export class DocumentDetailsService {

  urlDocumentDetails = '/api/v1/documents-details/';
  constructor(private http: Http) { }

  addDocumentDetails(documentDetails) {
    const headers = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: headers });
    return this.http.post(this.urlDocumentDetails, documentDetails, options);
  }
}
