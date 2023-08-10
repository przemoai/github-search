import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {WelcomePageComponent} from './welcome-page/welcome-page.component';
import {GithubUserComponent} from './github-user/components/github-user/github-user.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {NgOptimizedImage} from "@angular/common";
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatButtonModule} from "@angular/material/button";
import {NavbarComponent} from './nav-bar/components/navbar/navbar.component';
import {MatInputModule} from "@angular/material/input";
import {MatIconModule} from "@angular/material/icon";
import {ReactiveFormsModule} from "@angular/forms";
import {SideBarComponent} from "./side-bar/components/side-bar/side-bar.component";
import {HistoryRowComponent} from './side-bar/components/history-row/history-row.component';
import {UserRepositoryComponent} from './github-user/components/user-repository/user-repository.component';
import {MatExpansionModule} from "@angular/material/expansion";
import {LoginPageComponent} from './auth-guard/login-page/login-page.component';
import {AuthInterceptor} from "./auth-guard/interceptors/auth.interceptor";
import {MainFrameComponent} from "./main-frame/main-frame.component";
import { FilesSizePipe } from './github-user/pipes/files-size.pipe';
import { LoadingIndicatorComponent } from './loading-indicator/loading-indicator.component';
import {ClipboardModule} from "@angular/cdk/clipboard";
import {MatTooltipModule} from "@angular/material/tooltip";



@NgModule({
  declarations: [
    AppComponent,
    WelcomePageComponent,
    GithubUserComponent,
    NavbarComponent,
    SideBarComponent,
    HistoryRowComponent,
    UserRepositoryComponent,
    LoginPageComponent,
    MainFrameComponent,
    FilesSizePipe,
    LoadingIndicatorComponent
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
        MatExpansionModule,
        ClipboardModule,
        MatTooltipModule
    ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
