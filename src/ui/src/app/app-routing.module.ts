import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {GithubUserComponent} from "./github-user/components/github-user/github-user.component";

const routes: Routes = [
  {path: "", redirectTo: "github", pathMatch: "full"},
  {
    path: "github/:username", component: GithubUserComponent, children: []
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
