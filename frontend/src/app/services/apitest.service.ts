import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { response } from '../interfaces/response';


@Injectable({
  providedIn: 'root'
})
export class ApitestService {

  postUrl = "/api/post";
  getUrl = "/api/get";

  constructor(private httpClient: HttpClient) { }


  getApi(): Observable<response> {
    let httpHeaders = new HttpHeaders({
      "Content-Type": "application/json"
    })

    return this.httpClient.get<response>(this.getUrl, { headers: httpHeaders });
  }


  postApi(body:any,id:number) : Observable<any>{

    let params={
      dummy:"value"
    }
    return this.httpClient.post(this.postUrl,body,{params});
  }

}
