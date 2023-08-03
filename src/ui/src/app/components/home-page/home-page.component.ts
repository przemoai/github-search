import {Component} from '@angular/core';
import {GithubUserService} from "../../github-user/services/github-user.service";

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent {
  constructor(private readonly githubUserService: GithubUserService) {
  }
}
