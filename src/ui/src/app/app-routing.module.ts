import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {GithubUserComponent} from "./github-user/components/github-user/github-user.component";
import {LoginPageComponent} from "./auth-guard/login-page/login-page.component";
import {AuthService} from "./auth-guard/services/auth.service";
import {WelcomePageComponent} from "./welcome-page/welcome-page.component";
import {MainFrameComponent} from "./main-frame/main-frame.component";


const routes: Routes = [

  {path: "auth/login", component: LoginPageComponent},
  {path: "", component: WelcomePageComponent},

  {
    path: "github",
    component: MainFrameComponent,
    canActivate: [AuthService],
    children: [
      {path: "user/:username", component: GithubUserComponent, canActivate: [AuthService]},
    ]
  },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
