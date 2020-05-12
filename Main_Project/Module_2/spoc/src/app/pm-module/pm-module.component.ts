import { Component, OnInit } from '@angular/core';
import { ApiServiceService } from '../api-service.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Time } from '@angular/common';

@Component({
  selector: 'app-pm-module',
  templateUrl: './pm-module.component.html',
  styleUrls: ['./pm-module.component.css']
})
export class PmModuleComponent implements OnInit {


  public singleRequest: any=[];
  public approveRequestArray:any = [];
  requestId:number;
  verticalName:string
  technologyName:string;
  pmName:string;
  candidateCount:number;
  trainingMode:string;
  trainingStartDate:Date;
  trainingEndDate:Date;
  trainingStartTime:Time;
  trainingEndTime:Time;
  comment:any;
  requestStatus:boolean;
  public request_id:any;
  
  constructor(private api: ApiServiceService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    let requestId = this.route.snapshot.paramMap.get('requestId');
    // console.log(requestId);
    this.request_id = requestId;
    this.api.getRequestById(this.request_id)
    .subscribe(data => 
      this.singleRequest = data);

    this.api.getUpdatedRequestById(this.request_id)
    .subscribe(data =>
      this.approveRequestArray = data);
      console.log(this.approveRequestArray);
  }

  redirectHome(request:any){
    this.router.navigate(['/pendingrequests']);
    this.api.sendApprovedRequest(request.requestId)
    .subscribe(
      data => console.log('Success', data),
      error => console.log('Error', error)
    );
  }



}
