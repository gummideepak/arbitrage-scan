import { DefaultHttpInterceptor } from './interceptors/default-http-interceptor';
import { ApiModule } from './../../swagger/api.module';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ArbitrageDashboardComponent } from './components/arbitrage-dashboard/arbitrage-dashboard.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { MaterialModule } from './meterial-module';
import { MatNativeDateModule } from '@angular/material/core';
import { BASE_PATH } from 'swagger';
import { environment } from 'src/environments/environment';
import { LogoWrapperComponent } from './shared/logo-wrapper/logo-wrapper.component';
import { NgxSpinnerModule } from 'ngx-spinner';

@NgModule({
  declarations: [
    AppComponent,
    ArbitrageDashboardComponent,
    LogoWrapperComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    MaterialModule,
    MatNativeDateModule,
    ReactiveFormsModule,
    ApiModule,
    NgxSpinnerModule
  ],
  providers: [
    { provide: BASE_PATH, useValue: environment.API_BASE_PATH },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: DefaultHttpInterceptor,
      multi: true,
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
