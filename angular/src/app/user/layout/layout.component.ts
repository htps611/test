import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css']
})
export class LayoutComponent implements OnInit {

  constructor() {
  }

  ngOnInit() {
    this.loadScript('../../../assets/plugins/jquery/dist/jquery.min.js');
    this.loadScript('../../../assets/plugins/bootstrap/dist/js/bootstrap.min.js');
    this.loadScript('../../../assets/plugins/jquery-bar-rating/dist/jquery.barrating.min.js');
    this.loadScript('../../../assets/plugins/owl-carousel/owl.carousel.min.js');
    this.loadScript('../../../assets/plugins/gmap3.min.js');
    this.loadScript('../../../assets/plugins/imagesloaded.pkgd.js');
    this.loadScript('../../../assets/plugins/isotope.pkgd.min.js');
    this.loadScript('../../../assets/plugins/bootstrap-select/dist/js/bootstrap-select.min.js');
    this.loadScript('../../../assets/plugins/jquery.matchHeight-min.js');
    this.loadScript('../../../assets/plugins/slick/slick/slick.min.js');
    this.loadScript('../../../assets/plugins/elevatezoom/jquery.elevatezoom.js');
    this.loadScript('../../../assets/plugins/Magnific-Popup/dist/jquery.magnific-popup.min.js');
    this.loadScript('../../../assets/plugins/jquery-ui/jquery-ui.min.js');
    this.loadScript('https://maps.googleapis.com/maps/api/js?key=AIzaSyAx39JFH5nhxze1ZydH-Kl8xXM3OK4fvcg&amp;region=GB');
    this.loadScript('../../../assets/plugins/revolution/js/jquery.themepunch.tools.min.js');
    this.loadScript('../../../assets/plugins/revolution/js/jquery.themepunch.revolution.min.js');
    this.loadScript('../../../assets/plugins/revolution/js/extensions/revolution.extension.video.min.js');
    this.loadScript('../../../assets/plugins/revolution/js/extensions/revolution.extension.slideanims.min.js');
    this.loadScript('../../../assets/plugins/revolution/js/extensions/revolution.extension.layeranimation.min.js');
    this.loadScript('../../../assets/plugins/revolution/js/extensions/revolution.extension.navigation.min.js');
    this.loadScript('../../../assets/plugins/revolution/js/extensions/revolution.extension.parallax.min.js');
    this.loadScript('../../../assets/plugins/revolution/js/extensions/revolution.extension.actions.min.js');
    this.loadScript('../../../../assets/js/main.js');
  }

  loadScript(url) {
    console.log('preparing to load...');
    const node = document.createElement('script');
    node.src = url;
    node.type = 'text/javascript';
    document.getElementsByTagName('head')[0].appendChild(node);
  }

}
