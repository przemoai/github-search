import {Component, OnInit} from '@angular/core';
import {GithubUserService} from "../../services/github-user.service";
import {Observable, shareReplay} from "rxjs";
import {GithubUserDetails} from "../../models/GithubUserDetails";

@Component({
  selector: 'app-github-user',
  templateUrl: './github-user.component.html',
  styleUrls: ['./github-user.component.scss']
})
export class GithubUserComponent implements OnInit {

  githubUser$: Observable<GithubUserDetails> = new Observable<GithubUserDetails>()

  constructor(private readonly githubUserService: GithubUserService) {
  }

  ngOnInit(): void {
    this.githubUser$ = this.githubUserService.getGithubUserDetails().pipe(shareReplay(1))
  }


}
