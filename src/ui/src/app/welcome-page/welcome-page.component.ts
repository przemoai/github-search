import {Component} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-home-page', templateUrl: './welcome-page.component.html', styleUrls: ['./welcome-page.component.scss']
})
export class WelcomePageComponent {
  technologies: string[] = ['spring', 'java', 'angular', 'maven', 'azure', 'azure-postgres', 'github', 'github-actions']

  constructor(private readonly router: Router) {
  }

  goToApp() {
    this.router.navigate(['/github'])
  }
}
