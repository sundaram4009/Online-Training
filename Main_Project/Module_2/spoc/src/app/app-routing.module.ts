import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RequestsComponent } from './requests/requests.component';
import { ViewRequestsComponent } from './view-requests/view-requests.component';
import { PmModuleComponent } from './pm-module/pm-module.component';


const routes: Routes = [
  {path: '', redirectTo: 'pendingrequests', pathMatch: 'full'},
  {path: "pendingrequests", component: RequestsComponent},
  {path: "viewrequest/:id/:tech/:cc", component: ViewRequestsComponent},
  {path: "pmModule/:requestId", component: PmModuleComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
