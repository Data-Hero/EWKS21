import {Inject, Injectable, InjectionToken, Optional} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient, HttpEvent, HttpHeaders, HttpResponse} from '@angular/common/http';
import {BookingDto} from './bookingDto';
import {FunctionBundleDto} from './functionBundleDto';
import {Configuration} from './configuration';

@Injectable({
  providedIn: 'root'
})
export class BookingControllerService {

  protected basePath = 'http://localhost:8081';
  public defaultHeaders = new HttpHeaders();
  public configuration = new Configuration();

  constructor(protected httpClient: HttpClient,
              @Optional() @Inject(new InjectionToken<string>('basePath')) basePath: string,
              @Optional() configuration: Configuration) {
    if (basePath) {
      this.basePath = basePath;
    }
    if (configuration) {
      this.configuration = configuration;
      this.basePath = basePath || configuration.basePath || this.basePath;
    }
  }

  /**
   * @param consumes string[] mime-types
   * @return true: consumes contains 'multipart/form-data', false: otherwise
   */
  private canConsumeForm(consumes: string[]): boolean {
    const form = 'multipart/form-data';
    for (const consume of consumes) {
      if (form === consume) {
        return true;
      }
    }
    return false;
  }


  /**
   *
   *
   * @param body
   * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
   * @param reportProgress flag to report request and response progress.
   */
  public addFunctionBundle(body: FunctionBundleDto, observe?: 'body', reportProgress?: boolean): Observable<any>;
  public addFunctionBundle(body: FunctionBundleDto, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<any>>;
  public addFunctionBundle(body: FunctionBundleDto, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<any>>;
  public addFunctionBundle(body: FunctionBundleDto, observe: any = 'body', reportProgress: boolean = false): Observable<any> {

    if (body === null || body === undefined) {
      throw new Error('Required parameter body was null or undefined when calling addFunctionBundle.');
    }

    let headers = this.defaultHeaders;

    // to determine the Accept header
    let httpHeaderAccepts: string[] = [];
    const httpHeaderAcceptSelected: string | undefined = this.configuration.selectHeaderAccept(httpHeaderAccepts);
    if (httpHeaderAcceptSelected != undefined) {
      headers = headers.set('Accept', httpHeaderAcceptSelected);
    }

    // to determine the Content-Type header
    const consumes: string[] = [
      'application/json'
    ];
    const httpContentTypeSelected: string | undefined = this.configuration.selectHeaderContentType(consumes);
    if (httpContentTypeSelected != undefined) {
      headers = headers.set('Content-Type', httpContentTypeSelected);
    }

    return this.httpClient.request<any>('post', `${this.basePath}/functionBundle/add`,
      {
        body: body,
        withCredentials: this.configuration.withCredentials,
        headers: headers,
        observe: observe,
        reportProgress: reportProgress
      }
    );
  }

  /**
   *
   * @param body
   * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
   * @param reportProgress flag to report request and response progress.
   */
  public bookFunctionBundle(body: FunctionBundleDto, observe?: 'body', reportProgress?: boolean): Observable<BookingDto>;
  public bookFunctionBundle(body: FunctionBundleDto, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<BookingDto>>;
  public bookFunctionBundle(body: FunctionBundleDto, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<BookingDto>>;
  public bookFunctionBundle(body: FunctionBundleDto, observe: any = 'body', reportProgress: boolean = false): Observable<any> {

    if (body === null || body === undefined) {
      throw new Error('Required parameter body was null or undefined when calling bookFunctionBundle.');
    }

    let headers = this.defaultHeaders;

    // to determine the Accept header
    let httpHeaderAccepts: string[] = [
      '*/*'
    ];
    const httpHeaderAcceptSelected: string | undefined = this.configuration.selectHeaderAccept(httpHeaderAccepts);
    if (httpHeaderAcceptSelected != undefined) {
      headers = headers.set('Accept', httpHeaderAcceptSelected);
    }

    // to determine the Content-Type header
    const consumes: string[] = [
      'application/json'
    ];
    const httpContentTypeSelected: string | undefined = this.configuration.selectHeaderContentType(consumes);
    if (httpContentTypeSelected != undefined) {
      headers = headers.set('Content-Type', httpContentTypeSelected);
    }

    return this.httpClient.request<BookingDto>('post', `${this.basePath}/book`,
      {
        body: body,
        withCredentials: this.configuration.withCredentials,
        headers: headers,
        observe: observe,
        reportProgress: reportProgress
      }
    );
  }

  /**
   *
   * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
   * @param reportProgress flag to report request and response progress.
   */
  public getAllBookings(observe?: 'body', reportProgress?: boolean): Observable<Array<BookingDto>>;
  public getAllBookings(observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<Array<BookingDto>>>;
  public getAllBookings(observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<Array<BookingDto>>>;
  public getAllBookings(observe: any = 'body', reportProgress: boolean = false): Observable<any> {

    let headers = this.defaultHeaders;

    // to determine the Accept header
    let httpHeaderAccepts: string[] = [
      '*/*'
    ];
    const httpHeaderAcceptSelected: string | undefined = this.configuration.selectHeaderAccept(httpHeaderAccepts);
    if (httpHeaderAcceptSelected != undefined) {
      headers = headers.set('Accept', httpHeaderAcceptSelected);
    }

    // to determine the Content-Type header
    const consumes: string[] = [];

    return this.httpClient.request<Array<BookingDto>>('get', `${this.basePath}/booking`,
      {
        withCredentials: this.configuration.withCredentials,
        headers: headers,
        observe: observe,
        reportProgress: reportProgress
      }
    );
  }

  /**
   *
   *
   * @param userId
   * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
   * @param reportProgress flag to report request and response progress.
   */
  public getAvailableFunctionBundles(userId: number, observe?: 'body', reportProgress?: boolean): Observable<Array<FunctionBundleDto>>;
  public getAvailableFunctionBundles(userId: number, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<Array<FunctionBundleDto>>>;
  public getAvailableFunctionBundles(userId: number, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<Array<FunctionBundleDto>>>;
  public getAvailableFunctionBundles(userId: number, observe: any = 'body', reportProgress: boolean = false): Observable<any> {
    console.log(userId)
    if (userId === null || userId === undefined) {
      throw new Error('Required parameter userId was null or undefined when calling getAvailableFunctionBundles.');
    }

    let headers = this.defaultHeaders;

    // to determine the Accept header
    let httpHeaderAccepts: string[] = [
      '*/*'
    ];
    const httpHeaderAcceptSelected: string | undefined = this.configuration.selectHeaderAccept(httpHeaderAccepts);
    if (httpHeaderAcceptSelected != undefined) {
      headers = headers.set('Accept', httpHeaderAcceptSelected);
    }

    // to determine the Content-Type header
    const consumes: string[] = [];

    return this.httpClient.request<Array<FunctionBundleDto>>('get', `${this.basePath}/functionBundle/${encodeURIComponent(String(userId))}`,
      {
        withCredentials: this.configuration.withCredentials,
        headers: headers,
        observe: observe,
        reportProgress: reportProgress
      }
    );
  }

  /**
   *
   *
   * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
   * @param reportProgress flag to report request and response progress.
   */
  public getConfig(observe?: 'body', reportProgress?: boolean): Observable<string>;
  public getConfig(observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<string>>;
  public getConfig(observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<string>>;
  public getConfig(observe: any = 'body', reportProgress: boolean = false): Observable<any> {

    let headers = this.defaultHeaders;

    // to determine the Accept header
    let httpHeaderAccepts: string[] = [
      '*/*'
    ];
    const httpHeaderAcceptSelected: string | undefined = this.configuration.selectHeaderAccept(httpHeaderAccepts);
    if (httpHeaderAcceptSelected != undefined) {
      headers = headers.set('Accept', httpHeaderAcceptSelected);
    }

    // to determine the Content-Type header
    const consumes: string[] = [];

    return this.httpClient.request<string>('get', `${this.basePath}/config`,
      {
        withCredentials: this.configuration.withCredentials,
        headers: headers,
        observe: observe,
        reportProgress: reportProgress
      }
    );
  }

}
