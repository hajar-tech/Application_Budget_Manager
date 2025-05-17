import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

class Transaction {
}

@Injectable({
  providedIn: 'root'
})
export class TransactionService {
  private api = 'http://localhost/8080/api/transactions';

  constructor( private http: HttpClient ) { }

  getTransactions():Observable<Transaction[]>{
    return this.http.get<Transaction[]>(this.api);
  }
  addTransaction(transaction:Transaction):Observable<Transaction>{
    return this.http.post(this.api, transaction);
  }
}
