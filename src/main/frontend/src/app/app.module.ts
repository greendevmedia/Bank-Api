import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgBootstrapFormValidationModule } from 'ng-bootstrap-form-validation';
import { AppComponent } from './app.component';
import { Http, HttpModule, Response } from '@angular/http';
import { ClientComponent } from './client/client.component';
import { ClientService } from './client/client.service';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { DocumentDetailsService } from './document-details/document-details.service';
import { Headers, RequestOptions } from '@angular/http';



@NgModule({
  declarations: [
    AppComponent,
    ClientComponent,
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    ReactiveFormsModule,
    NgBootstrapFormValidationModule,
    NgbModule.forRoot(),

  ],
  providers: [DocumentDetailsService, ClientService],
  bootstrap: [AppComponent]
})
export class AppModule { }
