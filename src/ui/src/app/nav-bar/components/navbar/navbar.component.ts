import {Component} from '@angular/core';
import {FormControl} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-navbar', templateUrl: './navbar.component.html', styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {
  githubUserControl = new FormControl('', []);

  constructor(private readonly router: Router) {
  }

  searchByUsername() {
    this.router.navigate(['/github/user/' + this.githubUserControl.value])
  }
}
