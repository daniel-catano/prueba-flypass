import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-ghost-list',
  templateUrl: './ghost-list.component.html',
  styleUrls: ['./ghost-list.component.sass']
})
export class GhostListComponent {
  @Input()
  ghosts : number = 5;

  @Input()
  icon : string = '';

  @Input()
  material : boolean = true;
}
