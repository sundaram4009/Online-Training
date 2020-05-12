import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RequestsComponent } from './requests/requests.component';
import { ViewRequestsComponent } from './view-requests/view-requests.component';
import { HttpClientModule } from '@angular/common/http';
import { ApiServiceService } from './api-service.service';
import { PmModuleComponent } from './pm-module/pm-module.component';

@NgModule({
  declarations: [
    AppComponent,
    RequestsComponent,
    ViewRequestsComponent,
    PmModuleComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [ApiServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
