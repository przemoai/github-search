import {Component, EventEmitter, Input, Output} from '@angular/core';
import {GithubUserSearchHistory} from "../../models/GithubUserSearchHistory";

@Component({
  selector: 'app-history-row',
  templateUrl: './history-row.component.html',
  styleUrls: ['./history-row.component.scss']
})
export class HistoryRowComponent {
  @Input() history: GithubUserSearchHistory = <GithubUserSearchHistory>{};
  @Output() deleteFromHistoryEvent:EventEmitter<string> = new EventEmitter<string>();
  deleteFromHistory(username: string) {
    this.deleteFromHistoryEvent.emit(username);
  }
}
