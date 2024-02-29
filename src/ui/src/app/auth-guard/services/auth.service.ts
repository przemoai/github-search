import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, Router, RouterStateSnapshot, UrlTree} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {catchError, map, Observable, of} from "rxjs";
import {environment} from "../../../environments/environment";

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
    return this.http.get<LoggedUser>(`${environment.apiUrl}/api/v1/user`)
      .pipe(map((user: LoggedUser) => user.isLogged), catchError(() => of(false)));
  }

  login() {
    window.location.href = `${environment.apiUrl}/login`
  }

  logout() {
    window.location.href = `${environment.apiUrl}/logout`
  }

}

export interface LoggedUser {
  username: string,
  isLogged: boolean
}
