import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../shared/customer/customer.service';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {

  constructor(private customerService: CustomerService) { }

  newCustomer = {};

  ngOnInit() {
  }

  saveNewCustomer() {
    console.log(this.customerService.saveNewCustomer(this.newCustomer));
    location.reload();
  }
}
