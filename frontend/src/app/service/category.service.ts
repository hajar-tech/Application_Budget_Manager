import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

export interface Category {
  id: number;
  name: string;
  type: 'income' | 'expense';
}

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private api = 'http://localhost:8080/api/category';

  constructor( private http: HttpClient ) { }

  getCategory():Observable<Category[]>{
    return this.http.get<Category[]>(this.api);
  }
  addCategory(category: Category):Observable<Category>{
    return this.http.post<Category>(this.api,category);
  }}
