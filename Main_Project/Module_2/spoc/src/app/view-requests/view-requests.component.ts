import { Component, OnInit } from '@angular/core';
import { ApiServiceService } from '../api-service.service';
import { Time, NgIf } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-view-requests',
  templateUrl: './view-requests.component.html',
  styleUrls: ['./view-requests.component.css']
})
export class ViewRequestsComponent implements OnInit {

  //Setting display of forms based on buttons

  // isChecked: boolean;
  isCheckedTrainerName: any;
  isCheckedRoomName: any;
  isCheckedTrainer: boolean = false;
  isCheckedRoom: boolean = false;
  trainerSet: boolean;
  roomSet: boolean;
  showUpdateForm: boolean = false;
  showApprovalForm: boolean = false;

 //For Trainers of particlaur technology
  public techTrainers: any=[];
  trainerId:number;
  trainerName:string;
  trainerTechnologyName: string;
  trainerAvailFromDate:Date;
  trainerAvailTillDate:Date;
  trainerAvailFromTime:Time;
  trainerAvailTillTime:Time;
  contact:string;
  alreadyAssignedTrainer:boolean;

  public technology_name: any;

  //For available rooms
  public rooms: any=[];
  roomId:number;
  roomNo:number;
  capacity:number;
  roomAvailFromDate:Date;
  roomAvailTillDate:Date;
  roomAvailFromTime:Time;
  roomAvailTillTime:Time;
  alreadyAssignedRoom:boolean;

  public room_capacity: any;

  public singleRequest: any=[];
  public approveRequestArray:any = [];
  public array:any = [];
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
  requestStatus:any;

  public request_id:any;
  public trainer_id:any;
  public room_id:any=0;
  public showMsg:boolean = false;

  constructor(private api: ApiServiceService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    let id = this.route.snapshot.paramMap.get('id');
    this.request_id = id;
    // console.log(this.request_id);
    this.api.getRequestById(this.request_id)
    .subscribe(data => 
      this.singleRequest = data);
      console.log("hello");
     console.log(this.singleRequest);

    let tech = this.route.snapshot.paramMap.get('tech');
    this.technology_name = tech;
    this.api.getTrainerByTechnology(this.technology_name)
    .subscribe(data => {
      this.techTrainers = Array.from(Object.keys(data),k=>data[k]);
    });

    let cc = this.route.snapshot.paramMap.get('cc');
    this.room_capacity = cc;
    this.api.getRoomByCapacity(this.room_capacity)
    .subscribe(data => {
      this.rooms = Array.from(Object.keys(data),k=>data[k]);
    });

    this.api.getApprovedRequestById(this.request_id)
    .subscribe(data => 
      this.approveRequestArray = data);

  }


  editForm(){
    this.showUpdateForm =true;
  }

  approvalForm(){
    this.showApprovalForm = true;
  }

  updateRequest(){
    console.log(this.singleRequest);
    this.api.sendRequest(this.singleRequest,this.request_id)
    .subscribe(
      data => console.log('Success', data),
      error => console.log('Error', error)
    );
    this.router.navigate(['/pmModule',this.singleRequest.requestId]);
      
  }
/*
  redirect(request){
    this.router.navigate(['/pmModule',request.requestId]);
  }*/

  // Uploading the final request
  finalRequest(){
    //console.log(this.singleRequest);
    //console.log(this.approveRequestArray);
    /*this.approveRequestArray.requestId = this.singleRequest.requestId;
    this.approveRequestArray.verticalName = this.singleRequest.verticalName;
    this.approveRequestArray.technologyName = this.singleRequest.technologyName;
    this.approveRequestArray.pmName = this.singleRequest.pmName;
    this.approveRequestArray.candidateCount = this.singleRequest.candidateCount;
    this.approveRequestArray.trainingMode = this.singleRequest.trainingMode;
    this.approveRequestArray.trainingStartDate = this.singleRequest.trainingStartDate;
    this.approveRequestArray.trainingEndDate = this.singleRequest.trainingEndDate;
    this.approveRequestArray.trainingStartTime = this.singleRequest.trainingStartTime;
    this.approveRequestArray.trainingEndTime = this.singleRequest.trainingEndTime;
    this.approveRequestArray.comment = this.singleRequest.comment;
    this.approveRequestArray = Object.assign({}, this.approveRequestArray);   
    console.log("object of final request") 
    console.log(this.approveRequestArray);*/
    this.api.sendFinalRequest(this.singleRequest, this.trainer_id, this.room_id,this.request_id)
    .subscribe(
      data => console.log('Success', data),
      error => console.log('Error', error)
    );

    this.showMsg = true;
  }

  finalApprovedRequest(){
    this.api.sendFinalRequest(this.approveRequestArray, this.trainer_id, this.room_id,this.request_id)
    .subscribe(
      data => console.log('Success', data),
      error => console.log('Error', error)
    );

    this.showMsg = true;
  }

  selectCheckboxTrainer(e,t:any){
    this.isCheckedTrainer = true;
    this.isCheckedTrainerName = e.target.name;
    console.log(t);
   // this.array.trainerName = t.trainerName;
    this.trainer_id = t.trainerId;
    this.singleRequest.trainerName = t.trainerName;
   // console.log(this.singleRequest.trainerName);
    if (this.approveRequestArray !=null){
      this.approveRequestArray.trainerName = t.trainerName;} 
    //console.log(this.singleRequest.trainerName);    
    //console.log(this.approveRequestArray.trainerName);
  }

  selectCheckboxRoom(e,r:any){
    this.isCheckedRoom = true;
    this.isCheckedRoomName = e.target.name;
    console.log(r);
    //this.array.roomNo = r.roomNo;
    this.room_id = r.roomId;
    this.singleRequest.roomNo = r.roomNo;
    if (this.approveRequestArray !=null){
    this.approveRequestArray.roomNo = r.roomNo;}
    //console.log(this.approveRequestArray.roomNo);
    //console.log(this.newproduct);

  }
  
  cancel(){
    this.showUpdateForm = false;
    this.showApprovalForm = false;
    this.isCheckedTrainer = false;
    this.isCheckedRoom = false;
  }

}
