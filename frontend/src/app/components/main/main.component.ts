import { Component, OnInit, HostListener } from '@angular/core';
import { DBUtilsService } from '../services/dbutils.service';
import { HttpClient } from '@angular/common/http';
import { IProducts } from '../interfaces/Products';
@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent implements OnInit {

  products: IProducts[];
  CAROUSEL_BREAKPOINT = 768;
  carouselDisplayMode = 'multiple';
  buttonText = "Do koszyka";
  constructor(private DBUtils: DBUtilsService, private http: HttpClient) { }
  ngOnInit() {
    this.DBUtils.getProducts().subscribe(data => {this.products = data;
      console.log(this.products);
    });


    this.slides = this.chunk(this.cards, 4);
    if (window.innerWidth < 1200 && window.innerWidth >= 992) {
      this.slides = this.chunk(this.cards, 4);
    }
    else if (window.innerWidth < 992 && window.innerWidth >= 768) {
      this.slides = this.chunk(this.cards, 3);
    }
    else if (window.innerWidth < 768 && window.innerWidth >= 576) {
      this.slides = this.chunk(this.cards, 2);
    }
    else if (window.innerWidth < 576) {
      this.slides = this.chunk(this.cards, 1);
    }

  }
  cards = [
    {title: '31,04zł', img: '../../../assets/img/witcher.jpg'},
    {title: '31,04zł', img: '../../../assets/img/witcher.jpg'},
    {title: '31,04zł', img: '../../../assets/img/witcher.jpg'},
    {title: '31,04zł', img: '../../../assets/img/witcher.jpg'},
    {title: '31,04zł', img: '../../../assets/img/witcher.jpg'},
    {title: '31,04zł', img: '../../../assets/img/witcher.jpg'},
    {title: '31,04zł', img: '../../../assets/img/witcher.jpg'},
    {title: '31,04zł', img: '../../../assets/img/witcher.jpg'},
    {title: '31,04zł', img: '../../../assets/img/witcher.jpg'}
  ];
  slides: any = [[]];
  chunk(arr, chunkSize) {
    let R = [];
    for (let i = 0, len = arr.length; i < len; i += chunkSize) {
      R.push(arr.slice(i, i + chunkSize));
    }
    return R;
  }


  @HostListener('window:resize')
  onWindowResize() {
    if (window.innerWidth < 1200 && window.innerWidth >= 992) {
      this.slides = this.chunk(this.cards, 4);
    }
    else if (window.innerWidth < 992 && window.innerWidth >= 768) {
      this.slides = this.chunk(this.cards, 3);
    }
    else if (window.innerWidth < 768 && window.innerWidth >= 576) {
      this.slides = this.chunk(this.cards, 2);
    }
    else if (window.innerWidth < 576) {
      this.slides = this.chunk(this.cards, 1);
    }

  }
}
