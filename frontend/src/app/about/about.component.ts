import { Component, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-about',
  standalone: true,
  imports: [],
  templateUrl: './about.component.html',
  styleUrl: './about.component.css'
})
export class AboutComponent {


  @Input() name:any;
  @Input() age:any;


  private route: ActivatedRoute;

  constructor(activatedRoute: ActivatedRoute) {
    this.route = activatedRoute;
    console.log(this.route);
    console.log(this.route.snapshot.params['id'])
    console.log(this.route.queryParams.forEach((element) => {
      console.log(element)
    }))
  }

  ngOnChanges(){
    console.log("Props changed")
  }





}
