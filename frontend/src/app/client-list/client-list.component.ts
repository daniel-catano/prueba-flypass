import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {ClientService} from "../service/client-service.service";
import {ClientResponse} from "../model/client";
import {ClientRoutingParams} from "../model/client-routing-params";

@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.sass']
})
export class ClientListComponent implements OnInit{
  private endListReached: boolean = false;
  private page: number = 0;
  @Input()
  infiniteScroll: boolean = true;
  @Input()
  limit?: number;
  loading: boolean = false;
  clients: ClientResponse[] = [];

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private clientService: ClientService,
  ) {}

  goToProducts(clientId: number) {
    const transactionDetailRoutingParams: ClientRoutingParams = {clientId};
    this.router.navigate(['/product'], {state: transactionDetailRoutingParams}).then();
  }

  onScroll() {
    if(this.infiniteScroll && !this.endListReached && !this.loading) {
      this.getClients();
    }
  }

  private getClients() {
    this.loading = true;
    this.clientService.findAll(this.page).subscribe(r => {
      this.clients = this.clients.concat(r.results);
      if(this.page < r.totalPages) {
        this.page++;
      } else {
        this.endListReached = true;
      }
    }).add(() => this.loading = false);
  }

  ngOnInit(): void {
    this.onScroll();
  }
}
