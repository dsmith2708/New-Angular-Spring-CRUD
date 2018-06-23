import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../shared/customer/customer.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customers: Array<any>;

  constructor(private customerService: CustomerService) { }

  ngOnInit() {
    this.customerService.getAll().subscribe(data => {
      this.customers = data;
    });
  }

  deleteCustomer(id) {
    console.log("customer-list-component deleteCustomer hit with id:" + id);
    this.customerService.deleteCustomer(id).subscribe((response) => {
       console.log("deleted"));
     });
  }
}
