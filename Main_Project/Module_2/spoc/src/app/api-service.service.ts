import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class ApiServiceService {

  public requestUrl: string = "http://localhost:8083/show";
  public singleRequestUrl: string = "http://localhost:8083/show/";
  public techTrainersUrl: string = "http://localhost:8083/trainers/";
  public roomUrl: string = "http://localhost:8083/rooms/";
  public sendRequestUrl: string = "http://localhost:8083/updated";
  public sendFinalRequestUrl: string = "http://localhost:8083/finalrequest/";
  public getUpdatedRequestUrl: string = "http://localhost:8083/showUpdated/";
  public getApprovedRequestUrl: string = "http://localhost:8083/showApproved";
  public sendApprovedRequestUrl:string = "http://localhost:8083/approvedRequest/";
  public getApprovedRequestByIdUrl:string = "http://localhost:8083/showApproved/";

  constructor(private http: HttpClient) { }

  getPendingRequest(){
    // console.log(this.http.get(this.requestUrl));
    return this.http.get(this.requestUrl);
  }

  getApprovedRequest(){
    return this.http.get(this.getApprovedRequestUrl);
  }

  getRequestById(id){
    // console.log(this.http.get(this.singleRequestUrl+id));
    return this.http.get(this.singleRequestUrl+id);
  }

  getUpdatedRequestById(id){
    return this.http.get(this.getUpdatedRequestUrl+id);
  }

  getTrainerByTechnology(tech){
    return this.http.get(this.techTrainersUrl+tech);
  }

  getRoomByCapacity(cc){
    return this.http.get(this.roomUrl+cc);
  }

  getApprovedRequestById(id){
    return this.http.get(this.getApprovedRequestByIdUrl+id);
  }

  sendRequest(request:any, requestId:any){
    return this.http.post<any>(this.sendRequestUrl+'/'+requestId, request);
  }

  sendFinalRequest(finalRequest:any, trainerId:any, roomId:any, requestId:any){
    return this.http.post<any>(this.sendFinalRequestUrl+trainerId+'/'+roomId +'/'+ requestId,finalRequest)
  }

  sendApprovedRequest(requestId:any){
    return this.http.post<any>(this.sendApprovedRequestUrl+requestId, null);
  }




}
