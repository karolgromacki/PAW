import { Component, OnInit, HostListener } from '@angular/core';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent implements OnInit {
  CAROUSEL_BREAKPOINT = 768;
  carouselDisplayMode = 'multiple';
  buttonText = "Do koszyka";
  cards = [
    {
      title: '31,04zł',
      img: '../../../assets/img/witcher.jpg'
    },
    {
      title: '31,04zł',
      img: '../../../assets/img/witcher.jpg'
    },
    {
      title: '31,04zł',
      img: '../../../assets/img/witcher.jpg'
    },
    {
      title: '31,04zł',
      img: '../../../assets/img/witcher.jpg'
    },
    {
      title: '31,04zł',
      img: '../../../assets/img/witcher.jpg'
    },
    {
      title: '31,04zł',
      img: '../../../assets/img/witcher.jpg'
    },
    {
      title: '31,04zł',
      img: '../../../assets/img/witcher.jpg'
    },
    {
      title: '31,04zł',
      img: '../../../assets/img/witcher.jpg'
    },
    {
      title: '31,04zł',
      img: '../../../assets/img/witcher.jpg'
    },
  ];
  slides: any = [[]];
  chunk(arr, chunkSize) {
    let R = [];
    for (let i = 0, len = arr.length; i < len; i += chunkSize) {
      R.push(arr.slice(i, i + chunkSize));
    }
    return R;
  }
  ngOnInit() {
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
