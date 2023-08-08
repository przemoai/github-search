import {Component, Input} from '@angular/core';
import {GithubUserRepository} from "../../models/GithubUserRepository";

@Component({
  selector: 'app-user-repository',
  templateUrl: './user-repository.component.html',
  styleUrls: ['./user-repository.component.scss']
})
export class UserRepositoryComponent {
  @Input() repository: GithubUserRepository= <GithubUserRepository>{}

}
