import { Component, OnInit } from '@angular/core';
import { ApiServiceService } from '../api-service.service';
import { Time } from '@angular/common';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-requests',
  templateUrl: './requests.component.html',
  styleUrls: ['./requests.component.css']
})
export class RequestsComponent implements OnInit {

  public pendingRequests:any = [];
  public approvedRequests:any = [];
  requestId:number;
  verticalName:string;
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

  constructor(private api: ApiServiceService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.api.getPendingRequest()
    .subscribe(data => {
      this.pendingRequests = Array.from(Object.keys(data), k => data[k]);
    });
    this.api.getApprovedRequest()
    .subscribe(request => {
      this.approvedRequests = Array.from(Object.keys(request), k => request[k]);
    });
    console.log(this.approvedRequests);
    this.route.snapshot.paramMap.get(null);
  }

  newData(request: any){
    this.router.navigate(['/viewrequest', request.requestId,request.technologyName,request.candidateCount]);
  }

}
