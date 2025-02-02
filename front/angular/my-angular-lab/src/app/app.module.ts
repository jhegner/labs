import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { LabEnableButtonComponent } from './lab-enable-button/lab-enable-button.component';
import { SpinnerComponent } from './lab-spinner/spinner/spinner.component';
import { LoadingInterceptor } from './lab-interceptor/loading.interceptor';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
@NgModule({
  declarations: [AppComponent, LabEnableButtonComponent, SpinnerComponent],
  imports: [BrowserModule, FormsModule, HttpClientModule],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: LoadingInterceptor,
      multi: true,
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
