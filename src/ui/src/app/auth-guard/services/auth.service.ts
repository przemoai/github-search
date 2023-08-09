import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, Router, RouterStateSnapshot, UrlTree} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {catchError, map, Observable, of} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private router: Router, private readonly http: HttpClient) {
  }

  canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> {
    return this.isLogged().pipe(map(isLogged => {
      if (isLogged) {
        return true;
      } else {
        return this.router.parseUrl('/auth/login');
      }
    }));
  }

  isLogged(): Observable<boolean> {
    return this.http.get<LoggedUser>("http://localhost:8080/api/v1/user").pipe(map((user: LoggedUser) => user.isLogged), catchError(() => of(false)));
  }

  login() {
    window.location.href = "http://localhost:8080/login/oauth2/authorization/github"
  }

  logout() {
    window.location.href = "http://localhost:8080/logout"
  }

}

export interface LoggedUser {
  username: string,
  isLogged: boolean
}
