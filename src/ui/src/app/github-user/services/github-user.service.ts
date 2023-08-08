import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {GithubUserDetails} from "../models/GithubUserDetails";
import {Observable} from "rxjs";
import {SearchHistoryService} from "../../side-bar/services/search-history.service";

@Injectable({
  providedIn: 'root'
})
export class GithubUserService {
  constructor(private readonly http: HttpClient, private readonly searchHistoryService: SearchHistoryService) {
  }

  getGithubUserDetails(username: string): Observable<GithubUserDetails> {
    const githubUserDetailsObservable: Observable<GithubUserDetails> = this.http.get<GithubUserDetails>("http://localhost:8080/api/v1/github/user/" + username);


    this.searchHistoryService.updateSearchHistory()


    return githubUserDetailsObservable
  }
}
