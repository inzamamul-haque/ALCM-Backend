import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {ApiUrlService} from './api-url.service';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class BusinessRequirementService {

  constructor(private http: HttpClient, private url: ApiUrlService) { }
  createNewProject(projectName: string) {
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'})
    };
    const url = this.url.project + 'create';
    const data = {
      name: projectName,
    };
    console.log(name);
    return this.http.post(url, data, httpOptions).pipe(map((res: any) => {
      return res;
    }));
  }
}
