import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, ReactiveFormsModule } from '@angular/forms';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import 'rxjs/add/operator/map';
import { DocumentDetailsService } from '../document-details/document-details.service';
import { ClientService } from './client.service';
import { Headers, RequestOptions } from '@angular/http';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {

  clientForm;
  clients;
  public isCollapsed = true;
  public isCollapsed2 = true;

  constructor(private http: Http, private documentDetailsService: DocumentDetailsService, private clientService: ClientService) { }

  ngOnInit() {
    this.clientForm = new FormGroup({
      firstName: new FormControl('mateo', Validators.required),
      lastName: new FormControl('bleo', Validators.required),
      email: new FormControl('a@a.pl', Validators.email),
      telephone: new FormControl('123456789', Validators.required, ),
      password: new FormControl('123456789'),
      birthDate: new FormControl('2020-02-02'),
      contractStart: new FormControl('2020-02-02'),
      contractEnd: new FormControl('2020-02-02'),
      documentDetails: new FormGroup({
        id: new FormControl(''),
        documentNumber: new FormControl('', Validators.compose([Validators.required,
        Validators.maxLength(9), Validators.minLength(9)])),
        documentType: new FormControl('', Validators.required)
      })
    })
  }

  getClientsList() {
    this.clientService.getClientsList()
      .toPromise().then(response => response.json()).then(response => this.clients = response);
    console.log(this.clients);
  }

  addClient(client) {
    return this.clientService.addClient(client).subscribe(
      () => { },
      err => console.log(err)
    )
  }

  addDocumentDetails(client) {
    this.documentDetailsService.addDocumentDetails(client.documentDetails).toPromise().then(response => {
      client.documentDetails = response.json(),
        this.addClient(client),
        console.log(response.json())
    })
  }
}









