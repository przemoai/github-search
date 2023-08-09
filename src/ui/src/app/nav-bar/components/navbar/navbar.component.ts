import {Component} from '@angular/core';
import {FormControl} from "@angular/forms";
import {Router} from "@angular/router";
import {AuthService} from "../../../auth-guard/services/auth.service";

@Component({
  selector: 'app-navbar', templateUrl: './navbar.component.html', styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {
  githubUserControl = new FormControl('', []);

  constructor(private readonly router: Router, private readonly authService: AuthService) {
  }

  searchByUsername() {

    this.router.navigate(['/github/user/' + this.githubUserControl.value])
  }

  isLogged() {
    return this.authService.isLogged()
  }

  login() {
    this.router.navigate(['/auth/login'])

  }

  logout() {
    this.authService.logout()
  }

  goWelcomePage() {
    this.router.navigate(["/"])
  }
}
