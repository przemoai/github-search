import {Component, OnInit} from '@angular/core';
import {SearchHistoryService} from "../../services/search-history.service";
import {GithubUserSearchHistory} from "../../models/GithubUserSearchHistory";

@Component({
    selector: 'app-side-bar', templateUrl: './side-bar.component.html', styleUrls: ['./side-bar.component.scss']
})
export class SideBarComponent implements OnInit {
  searchHistory: GithubUserSearchHistory[] = [];

    constructor(private readonly searchHistoryService: SearchHistoryService) {
    }

  ngOnInit() {
    this.searchHistoryService.searchHistory$.subscribe((history: GithubUserSearchHistory[]) => {
      this.searchHistory = history;
    });
  }

}
