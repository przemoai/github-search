import {Component} from '@angular/core';
import {SearchHistoryService} from "../../services/search-history.service";

@Component({
    selector: 'app-side-bar', templateUrl: './side-bar.component.html', styleUrls: ['./side-bar.component.scss']
})
export class SideBarComponent {
    constructor(private readonly searchHistoryService: SearchHistoryService) {
    }


}
