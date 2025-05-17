import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Category} from './category.service';

export interface Transaction {
  id?: number;
  montant: number;
  date: string;
  description: string;
  type: 'revenu' | 'dépense';
  category: Category;
}


@Injectable({
  providedIn: 'root'
})
export class TransactionService {
  private api = 'http://localhost/8080/api/v1/transaction';

  constructor( private http: HttpClient ) { }

  getTransactions():Observable<Transaction[]>{
    return this.http.get<Transaction[]>(this.api);
  }
  addTransaction(transaction:Transaction):Observable<Transaction>{
    return this.http.post<Transaction>(this.api, transaction);
  }
}
