import {Component, OnInit} from '@angular/core';
import {GithubUserService} from "../../services/github-user.service";
import {Observable} from "rxjs";
import {GithubUserDetails} from "../../models/GithubUserDetails";
import {ActivatedRoute, Params} from "@angular/router";

@Component({
  selector: 'app-github-user',
  templateUrl: './github-user.component.html',
  styleUrls: ['./github-user.component.scss']
})
export class GithubUserComponent implements OnInit {
  username: string = ""
  githubUser$: Observable<GithubUserDetails> = new Observable<GithubUserDetails>()

  constructor(private readonly githubUserService: GithubUserService, private readonly route: ActivatedRoute) {
  }

  goToGithubProfile() {
    this.githubUser$.subscribe((user: GithubUserDetails) => window.open(user.url, "_blank"))
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => {
      this.username = params['username']
      this.githubUser$ = this.githubUserService.getGithubUserDetails(this.username)
    })
  }
}
