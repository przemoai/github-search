import {Injectable} from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {GithubUserSearchHistory} from "../models/GithubUserSearchHistory";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class SearchHistoryService {

  private HISTORY_ENDPOINT: string = "api/v1/github/history"

  private searchHistorySubject: BehaviorSubject<GithubUserSearchHistory[]> = new BehaviorSubject<GithubUserSearchHistory[]>([]);
  searchHistory$: Observable<GithubUserSearchHistory[]> = this.searchHistorySubject.asObservable();

  constructor(private readonly http: HttpClient) {
    this.getSearchHistory()

  }

  updateSearchHistory() {
    this.getSearchHistory().subscribe((history: GithubUserSearchHistory[]) => {
      this.searchHistorySubject.next(history);
    });
  }

  getSearchHistory(): Observable<GithubUserSearchHistory[]> {
    return this.http.get<GithubUserSearchHistory[]>(`${environment.apiUrl}/${this.HISTORY_ENDPOINT}`)
  }

  removeFromHistory(username: string) {
    this.http.delete(`${environment.apiUrl}/${this.HISTORY_ENDPOINT}/${username}`).subscribe(() => {
      this.updateSearchHistory()
    })
  }
}
