import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ApiUrlService {

  public apiUrl = 'http://localhost:9005/';
  public project = this.apiUrl + 'project/';

  constructor() { }
}
