import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {GithubUserDetails} from "../models/GithubUserDetails";
import {Observable, shareReplay} from "rxjs";
import {SearchHistoryService} from "../../side-bar/services/search-history.service";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class GithubUserService {
  constructor(private readonly http: HttpClient, private readonly searchHistoryService: SearchHistoryService) {
  }

  getGithubUserDetails(username: string): Observable<GithubUserDetails> {
    const githubUserDetailsObservable: Observable<GithubUserDetails> = this.http.get<GithubUserDetails>(`${environment.apiUrl}/api/v1/github/user/` + username).pipe(shareReplay(1));

    this.searchHistoryService.updateSearchHistory()

    return githubUserDetailsObservable
  }
}
