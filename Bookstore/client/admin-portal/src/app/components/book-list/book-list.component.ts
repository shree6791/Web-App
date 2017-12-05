import { Book } from '../../models/book';

import { Router} from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { MdDialog, MdDialogRef } from '@angular/material';

import { LoginService } from '../../services/login.service';
import { RemoveBookService } from '../../services/remove-book.service';
import { GetBookListService } from '../../services/get-book-list.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})

export class BookListComponent implements OnInit {


	private checked: boolean;
	private allChecked: boolean;

	private bookList: Book[];
	private selectedBook : Book;  
	private removeBookList: Book[] = new Array();

	constructor(

		private router: Router,
		public dialog: MdDialog,
		private removeBookService: RemoveBookService,
		private getBookListService: GetBookListService    

	) { }

	ngOnInit() {
		this.getBookList();
	}

	onSelect(book:Book) {
		this.selectedBook=book;
		this.router.navigate(['/viewBook', this.selectedBook.id]);
	}

	getBookList() {

		this.getBookListService.getBookList().subscribe(
			
			res => {
				console.log(res.json());
				this.bookList=res.json();
			}, 

			error => {
				console.log(error);
			}
		);

	}

	updateRemoveBookList(checked:boolean, book:Book) {

		if(checked) {
			this.removeBookList.push(book);
		} else {
			this.removeBookList.splice(this.removeBookList.indexOf(book), 1);
		}

	}

	updateSelected(checked: boolean) {

		if(checked) {
			this.allChecked = true;
			this.removeBookList=this.bookList.slice();
		} else {
			this.allChecked=false;
			this.removeBookList=[];
		}

	}

	removeSelectedBooks() {

		let dialogRef = this.dialog.open(DialogResultExampleDialog);

		dialogRef.afterClosed().subscribe(

			result => {
			console.log(result);

				if(result=="yes") {

				  for (let book of this.removeBookList) {
				    this.removeBookService.sendBook(book.id).subscribe(
				      res => {

				      }, 
				      err => {
				      }
				      );
				  }

			  this.getBookList();

			}
		}); 

	}

	openDialog(book:Book) {

		let dialogRef = this.dialog.open(DialogResultExampleDialog);

		dialogRef.afterClosed().subscribe(

			result => {
				
				console.log(result);

				if(result=="yes") {
					
					this.removeBookService.sendBook(book.id).subscribe(
						res => {
							console.log(res);
							this.getBookList();
						}, 
						err => {
							console.log(err);
						});
				}
		});
	}

}

@Component({
  selector: 'dialog-result-example-dialog',
  templateUrl: './dialog-result-example-dialog.html'
})

export class DialogResultExampleDialog {  
  constructor(public dialogRef: MdDialogRef<DialogResultExampleDialog>) {}
}