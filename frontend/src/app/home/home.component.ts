import { response } from './../interfaces/response';
import { Component } from '@angular/core';
import { FormArray, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { Route, Router, RouterLink, RouterOutlet } from '@angular/router';
import { ApitestService } from '../services/apitest.service';
import { animate } from '@angular/animations';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [FormsModule, RouterLink, ReactiveFormsModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {


  names: string = 'value';
  body: response = {
    name: "nikhil",
    email: 4222,
    salary: 0
  };

  items = [
    {
      name:"ram",
      age:12
    },
    {
      name:"sham",
      age:43
    }
]


  constructor(private router: Router, private service: ApitestService) {
  }

  changeName() {
    console.log(this.names)
    this.names = "Sham";
    // this.router.navigate(['/about',12])

    this.service.getApi().subscribe((res: response) => {
      console.log(res);
    })


    this.service.postApi(this.body, 12).subscribe((response) => {
      console.log(response);
    })
  }


  name = new FormControl('');
  age = new FormControl('', Validators.required);
  email = new FormControl('');
  list = new FormArray<FormGroup>([]);



  formGroup = new FormGroup({
    name: this.name,
    age: this.age,
    email: this.email,
    list: this.list
  })

  call() {
    console.log(this.formGroup.value);
    this.service.postApi(this.formGroup.value, 20).subscribe((resp) => {
      console.log(resp);
    });
  }

  modifyArray(a: any, b: any) {

    const fg = new FormGroup(
      {
        el1: a,
        el2: b
      })
    this.list.push(fg);
  }

}
