import 'hammerjs';
import { routing } from './app.routing';

import { NgModule } from '@angular/core';
import { MaterialModule } from '@angular/material';

import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';

import { LoginComponent } from './components/login/login.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';

import { ViewBookComponent } from './components/view-book/view-book.component';
import { EditBookComponent } from './components/edit-book/edit-book.component';
import { AddNewBookComponent } from './components/add-new-book/add-new-book.component';
import { BookListComponent, DialogResultExampleDialog } from './components/book-list/book-list.component';

import { LoginService } from './services/login.service';
import { GetBookService } from './services/get-book.service';
import { AddBookService } from './services/add-book.service';
import { EditBookService } from './services/edit-book.service';
import { RemoveBookService } from './services/remove-book.service';

import { UploadImageService } from './services/upload-image.service';
import { GetBookListService } from './services/get-book-list.service';


@NgModule({
  
  declarations: [
    AppComponent,
    LoginComponent,
    NavBarComponent,    
    BookListComponent,
    ViewBookComponent,
    EditBookComponent,
    AddNewBookComponent,
    DialogResultExampleDialog
  ],
  
  imports: [
    routing,
    HttpModule,
    FormsModule,
    BrowserModule,
    MaterialModule,
    BrowserAnimationsModule
  ],
  
  providers: [
    LoginService,
    GetBookService,
    AddBookService,
    EditBookService,
    RemoveBookService,
    GetBookListService,
    UploadImageService
  ],
  
  bootstrap: [AppComponent, DialogResultExampleDialog]

})

export class AppModule { }
