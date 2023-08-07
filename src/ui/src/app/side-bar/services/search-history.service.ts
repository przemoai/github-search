import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {GithubUserSearchHistory} from "../models/GithubUserSearchHistory";

@Injectable({
  providedIn: 'root'
})
export class SearchHistoryService {

  constructor(private readonly http: HttpClient) {
  }

  getSearchHistory(): Observable<GithubUserSearchHistory[]> {
    return this.http.get<GithubUserSearchHistory[]>("http://localhost:8080/api/v1/github/history")
  }
}
