/**
 * Api Documentation
 * Api Documentation
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
/* tslint:disable:no-unused-variable member-ordering */

import { Inject, Injectable, Optional }                      from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams,
         HttpResponse, HttpEvent }                           from '@angular/common/http';
import { CustomHttpUrlEncodingCodec }                        from '../encoder';

import { Observable }                                        from 'rxjs/Observable';


import { BASE_PATH, COLLECTION_FORMATS }                     from '../variables';
import { Configuration }                                     from '../configuration';


@Injectable()
export class ExchangePriceControllerService {

    protected basePath = 'https://localhost:8080';
    public defaultHeaders = new HttpHeaders();
    public configuration = new Configuration();

    constructor(protected httpClient: HttpClient, @Optional()@Inject(BASE_PATH) basePath: string, @Optional() configuration: Configuration) {
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
     * getBTCPrice
     * 
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public getBTCPriceUsingGET(observe?: 'body', reportProgress?: boolean): Observable<Array<string>>;
    public getBTCPriceUsingGET(observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<Array<string>>>;
    public getBTCPriceUsingGET(observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<Array<string>>>;
    public getBTCPriceUsingGET(observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

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
        ];

        return this.httpClient.get<Array<string>>(`${this.basePath}/getBTCPrice`,
            {
                withCredentials: this.configuration.withCredentials,
                headers: headers,
                observe: observe,
                reportProgress: reportProgress
            }
        );
    }

    /**
     * getTickersBuyPrices
     * 
     * @param cryptoTickerList cryptoTickerList
     * @param fiatCurrency fiatCurrency
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public getTickersBuyPricesUsingGET(cryptoTickerList: Array<string>, fiatCurrency?: string, observe?: 'body', reportProgress?: boolean): Observable<{ [key: string]: { [key: string]: ExchangePriceDto; }; }>;
    public getTickersBuyPricesUsingGET(cryptoTickerList: Array<string>, fiatCurrency?: string, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<{ [key: string]: { [key: string]: ExchangePriceDto; }; }>>;
    public getTickersBuyPricesUsingGET(cryptoTickerList: Array<string>, fiatCurrency?: string, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<{ [key: string]: { [key: string]: ExchangePriceDto; }; }>>;
    public getTickersBuyPricesUsingGET(cryptoTickerList: Array<string>, fiatCurrency?: string, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

        if (cryptoTickerList === null || cryptoTickerList === undefined) {
            throw new Error('Required parameter cryptoTickerList was null or undefined when calling getTickersBuyPricesUsingGET.');
        }


        let queryParameters = new HttpParams({encoder: new CustomHttpUrlEncodingCodec()});
        if (cryptoTickerList) {
            cryptoTickerList.forEach((element) => {
                queryParameters = queryParameters.append('cryptoTickerList', <any>element);
            })
        }
        if (fiatCurrency !== undefined && fiatCurrency !== null) {
            queryParameters = queryParameters.set('fiatCurrency', <any>fiatCurrency);
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
        ];

        return this.httpClient.get<{ [key: string]: { [key: string]: ExchangePriceDto; }; }>(`${this.basePath}/getTickersBuyPrices`,
            {
                params: queryParameters,
                withCredentials: this.configuration.withCredentials,
                headers: headers,
                observe: observe,
                reportProgress: reportProgress
            }
        );
    }

}
