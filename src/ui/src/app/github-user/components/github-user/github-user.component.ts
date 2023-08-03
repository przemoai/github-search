import {Component} from '@angular/core';
import {GithubUserService} from "../../services/github-user.service";
import {Observable} from "rxjs";
import {GithubUserDetails} from "../../models/GithubUserDetails";

@Component({
  selector: 'app-github-user',
  templateUrl: './github-user.component.html',
  styleUrls: ['./github-user.component.scss']
})
export class GithubUserComponent {

  githubUser$: Observable<GithubUserDetails> = this.githubUserService.getGithubUserDetails()

  constructor(private readonly githubUserService: GithubUserService) {

  }


}
