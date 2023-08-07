import {Component} from '@angular/core';
import {SearchHistoryService} from "../../services/search-history.service";
import {Observable} from "rxjs";
import {GithubUserSearchHistory} from "../../models/GithubUserSearchHistory";

@Component({
    selector: 'app-side-bar', templateUrl: './side-bar.component.html', styleUrls: ['./side-bar.component.scss']
})
export class SideBarComponent {

    searchHistory$: Observable<GithubUserSearchHistory[]> = this.searchHistoryService.getSearchHistory()
    constructor(private readonly searchHistoryService: SearchHistoryService) {
    }


}
