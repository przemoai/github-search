import {Component, Input} from '@angular/core';
import {GithubUserSearchHistory} from "../../models/GithubUserSearchHistory";

@Component({
  selector: 'app-history-row',
  templateUrl: './history-row.component.html',
  styleUrls: ['./history-row.component.scss']
})
export class HistoryRowComponent {
  @Input() history: GithubUserSearchHistory = <GithubUserSearchHistory>{};
}
