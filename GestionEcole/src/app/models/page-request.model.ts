import {Filter} from './filter.model';


export class PageRequest {
  constructor(public page: number,
              public size: number,
              public Filters: Filter[]
           ) {
  }
}
