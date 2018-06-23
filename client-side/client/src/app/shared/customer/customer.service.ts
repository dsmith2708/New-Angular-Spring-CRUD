import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    let webPath = "//localhost:8080/all-customers";
    console.log("CustomerService getAll hit" + this.http.get('//localhost:8080/all-customers'));
    return this.http.get(this.getWebPath());
  }

  getWebPath() {
    return "//localhost:8080/all-customers";
  }

}
