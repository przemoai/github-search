import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HomePageComponent} from './home-page/home-page.component';
import {GithubUserComponent} from './github-user/components/github-user/github-user.component';
import {HttpClientModule} from "@angular/common/http";
import {NgOptimizedImage} from "@angular/common";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from "@angular/material/button";
import { NavbarComponent } from './nav-bar/components/navbar/navbar.component';
import {MatInputModule} from "@angular/material/input";
import {MatIconModule} from "@angular/material/icon";
import {ReactiveFormsModule} from "@angular/forms";
import {SideBarComponent} from "./side-bar/components/side-bar/side-bar.component";
import { HistoryRowComponent } from './side-bar/components/history-row/history-row.component';
import { UserRepositoryComponent } from './github-user/components/user-repository/user-repository.component';
import {MatExpansionModule} from "@angular/material/expansion";
import { LoginPageComponent } from './auth-guard/login-page/login-page.component';


@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    GithubUserComponent,
    NavbarComponent,
    SideBarComponent,
    HistoryRowComponent,
    UserRepositoryComponent,
    LoginPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgOptimizedImage,
    BrowserAnimationsModule,
    MatButtonModule,
    MatInputModule,
    MatIconModule,
    ReactiveFormsModule,
    MatExpansionModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
