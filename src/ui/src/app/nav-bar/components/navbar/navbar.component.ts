import {Component} from '@angular/core';
import {FormControl, Validators} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-navbar', templateUrl: './navbar.component.html', styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {
  githubUserControl = new FormControl('', [Validators.required]);


  constructor(private readonly router: Router) {
  }

  searchByUsername() {

    this.router.navigate(['/github/' + this.githubUserControl.value])

  }
}
