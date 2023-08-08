import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {GithubUserComponent} from "./github-user/components/github-user/github-user.component";
import {LoginPageComponent} from "./auth-guard/login-page/login-page.component";

const routes: Routes = [
  {path: "", redirectTo: "github", pathMatch: "prefix"},
  {
    path: "github", component: LoginPageComponent
  },
  {
    path: "github/user/:username", component: GithubUserComponent
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
