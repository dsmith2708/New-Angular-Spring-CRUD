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

  getPostWebPath() {
    return "//localhost:8080/add-customer";
  }

  getDeleteWebPath() {
    return "//localhost:8080/delete-customer/";
  }

  getPutWebPath() {
    return "http://localhost:8080/update-customer";
  }

  saveNewCustomer(newCustomer) {
    return this.http.post(this.getPostWebPath(), JSON.stringify(newCustomer)).subscribe(
        response => response,
        error => console.log(error)
    );
  }

  deleteCustomer(id) {
    return this.http.delete(this.getDeleteWebPath() + id).subscribe(
        response => response,
        error => console.log(error)
    );
  }

  updateCustomer(customer) {
    console.log("CustomerService updateCustomer hit with" + JSON.stringify(customer));
    return this.http.put(this.getPutWebPath(), JSON.stringify(customer)).subscribe(
        response => response,
        error => console.log(error)
    );
  }

}
