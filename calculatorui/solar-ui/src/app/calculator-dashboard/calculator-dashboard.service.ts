import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CalculatorDashboardService {

  constructor(
    private httpClient: HttpClient
  ) { }

  baseUrl = "http://localhost:8080/api/calculate";
  leadUrl = "http://localhost:8080/api/captureLead";

  getCalulatedResponse(request:any):Observable<any>{
    return this.httpClient.post<any>(this.baseUrl,request);
  }

  saveLead(request:any):Observable<any>{
    return this.httpClient.post<any>(this.leadUrl, request);
  }
}
