import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

import {Observable} from 'rxjs';


export interface Budget {
  id?: number;
  limitBudget: number;
  startDate: string;
  endDate: string;
  category: {
    id: number;
    name?: string;
  };
}
@Injectable({
  providedIn: 'root'
})
export class BudgetService {
  private api = 'http://localhost:8080/api/v1/budgets';

  constructor( private http: HttpClient ) { }

  getBudget():Observable<Budget[]>{
    return this.http.get<Budget[]>(this.api);
  }
  addBudget(budget:Budget):Observable<Budget>{
    return this.http.post<Budget>(this.api, budget);
  }}
