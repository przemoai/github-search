import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomePageComponent} from "./components/home-page/home-page.component";
import {AppComponent} from "./app.component";

const routes: Routes = [
  {path: "", redirectTo: "github", pathMatch: "full"},
  {
    path: "github", component: AppComponent, children: [
      {path: "", component: HomePageComponent}
    ]
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
