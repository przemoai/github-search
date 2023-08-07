import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {GithubUserDetails} from "../models/GithubUserDetails";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class GithubUserService {
  constructor(private readonly http: HttpClient) {
  }

  getGithubUserDetails(username: string): Observable<GithubUserDetails> {
    return this.http.get<GithubUserDetails>("http://localhost:8080/api/v1/github/" + username)
  }
}
