import {Component, QueryList, ViewChildren} from '@angular/core';
import {CountryService} from "./country.service";
import {DecimalPipe} from "@angular/common";
import {Observable} from "rxjs";
import {Country} from "./country";
import {SortableDirective, SortEvent} from "./sortable.directive";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [CountryService, DecimalPipe]
})
export class AppComponent {
  title = 'DataTables';

  countries$: Observable<Country[]>;
  total$: Observable<number>;

  @ViewChildren(SortableDirective) headers!: QueryList<SortableDirective>;

  constructor(public service: CountryService) {
    this.countries$ = service.countries$;
    this.total$ = service.total$;
  }

  onSort({column, direction}: SortEvent) {
    // resetting other headers
    this.headers.forEach(header => {
      if (header.sortable !== column) {
        header.direction = '';
      }
    });

    this.service.sortColumn = column;
    this.service.sortDirection = direction;
  }
}
