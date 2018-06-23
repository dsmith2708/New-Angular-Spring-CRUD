import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../shared/customer/customer.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customers: Array<any>;

  updatedCustomer = {};

  listHidden = false;

  constructor(private customerService: CustomerService) { }

  ngOnInit() {
    this.customerService.getAll().subscribe(data => {
      this.customers = data;
    });
  }

  updateCustomer(selectedCustomer) {
    this.listHidden = true;
    this.updatedCustomer.id = selectedCustomer.id;
    this.updatedCustomer.firstName = selectedCustomer.firstName;
    this.updatedCustomer.lastName = selectedCustomer.lastName;
    this.updatedCustomer.accountNo = selectedCustomer.accountNo;
  };

  saveCustomerChanges() {
    this.listHidden = false;
    console.log(this.customerService.updateCustomer(this.updatedCustomer));
    location.reload();
  }

  deleteCustomer(id) {
    console.log("customer-list-component deleteCustomer hit with id:" + id);
    this.customerService.deleteCustomer(id).subscribe((response) => {
       console.log("deleted"));
       location.reload();
     };
  };



}
