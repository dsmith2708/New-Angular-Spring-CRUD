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
    console.log("CustomerService getAll hit");
    return this.http.get(this.getGetWebPath());
  }

  getGetWebPath() {
    return "//localhost:8080/all-customers";
  }

  getDeleteWebPath() {
    return "http://localhost:8080/delete-customer/";
  }

  getPutWebPath() {
    return "http://localhost:8080/update-customer";
  }

  deleteCustomer(id) {
    return this.http.delete(this.getDeleteWebPath() + id);
  }

  updateCustomer(customer) {
    console.log("CustomerService updateCustomer hit with" + JSON.stringify(customer));
    return this.http.put(this.getPutWebPath(), JSON.stringify(customer)).subscribe(
        response => response as customer,
        error => console.log(error)
    );
  }

}
