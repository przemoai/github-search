import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AppComponent} from "./app.component";
import {GithubUserComponent} from "./github-user/components/github-user/github-user.component";

const routes: Routes = [
  {path: "", redirectTo: "github", pathMatch: "full"},
  {
    path: "github", component: AppComponent, children: [
      {path: "", component: GithubUserComponent}
    ]
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
