
export class PageResponse<T> {
  constructor(public results: T[],
              public totalpages: number,
              public totalElements: number
  ) {
  }
}
