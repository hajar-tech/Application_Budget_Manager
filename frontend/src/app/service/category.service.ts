import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

class Category {
}

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private api = 'http://localhost/8080/api/transactions';

  constructor( private http: HttpClient ) { }

  getTransactions():Observable<Category[]>{
    return this.http.get<Category[]>(this.api);
  }
  addTransaction(category: Category):Observable<Category>{
    return this.http.post(this.api,category);
  }}
