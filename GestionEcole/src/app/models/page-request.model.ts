import {Filter} from './filter.model';
import {Sort} from './sort.model';
import {Direction} from '../enums/direction.enum';



export class PageRequest {
  constructor(public page: number,
              public size: number,
              public filters: Filter[],
              public sortDirection: Direction,
              public sortField: string
           ) {
  }
}
