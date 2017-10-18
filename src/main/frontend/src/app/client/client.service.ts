import { DocumentDetailsService } from '../document-details/document-details.service';
import { Injectable } from '@angular/core';
import { Http, Response, RequestOptions, Headers } from '@angular/http';

@Injectable()
export class ClientService {
  urlClients = '/api/v1/clients/';

  constructor(private http: Http, private documentDetailsService: DocumentDetailsService) { }

  getClientsList() {
    return this.http.get(this.urlClients);
  }

  addClient(client) {
    const headers = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: headers });
    return this.http.post(this.urlClients, client, options);
  }
}
