import {Component, OnInit, ViewEncapsulation} from '@angular/core';
declare function mainJs(): any;
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  navigateUrl(event: any) {
    mainJs();
    $('html, body').animate({scrollTop: '0'}, 1000);

    let listUl: any = event.path[2].children;
    for (let item of listUl){
      $(item).find('li.nav-item.active').removeClass('active');
      $('div#ftco-nav').find('li').removeClass('active').end().find('li').find('a').removeClass('active');
    }

    let active = event.path[0];
    $(active).addClass('active');
    $(active).closest('li').addClass('active');
    if ($(active).closest('li.nav-item.dropdown')){
      $(active).closest('li.nav-item.dropdown').addClass('active');
    }
  }

}
