import {Component, Input} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {ClientService} from "../service/client-service.service";
import {Location} from "@angular/common";
import {ProductService} from "../service/product-service.service";
import {ProductResponse} from "../model/product-response";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.sass']
})
export class ProductListComponent {
  private endListReached: boolean = false;
  private page: number = 0;
  private clientId?: number;
  @Input()
  infiniteScroll: boolean = true;
  @Input()
  limit?: number;
  loading: boolean = false;
  products: ProductResponse[] = [];

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private location: Location,
    private productService: ProductService,
  ) {
    console.log(this.router.getCurrentNavigation());
    this.clientId = this.router.getCurrentNavigation()?.extras?.state?.['clientId'];
    if (this.clientId) {
      this.onScroll();
    } else {
      this.location.back();
    }
  }

  onScroll() {
    if(this.infiniteScroll && !this.endListReached && !this.loading) {
      this.getProducts();
    }
  }

  private getProducts() {
    this.loading = true;
    this.productService.findByClientId(this.page, this.clientId).subscribe(r => {
      this.products = this.products.concat(r.results);
      if(this.page < r.totalPages) {
        this.page++;
      } else {
        this.endListReached = true;
      }
    }).add(() => this.loading = false);
  }

  ngOnInit(): void {
  }
}
