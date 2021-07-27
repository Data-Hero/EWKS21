import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {MatTableDataSource} from '@angular/material/table';
import {BookingControllerService} from '../../shared/_generated/rest-api';

export interface FunctionBundle {
  functionBundleId: string;
  functionNumber: string;
  priceByMinute: number;
  discount: number;
}

const ELEMENTS: FunctionBundle[] = [];


@Component({
  selector: 'app-booking-functionbundle',
  templateUrl: './booking-functionbundle.component.html',
  styleUrls: ['./booking-functionbundle.component.css']
})
export class BookingFunctionbundleComponent implements OnInit {

  displayedColumns: string[] = ['functionBundleId', 'functionNumber', 'priceByMinute', 'discount'];
  dataSource: MatTableDataSource<FunctionBundle> = new MatTableDataSource(ELEMENTS);
  uploadForm: FormGroup;
  addForm: FormGroup;
  addFunctionBundleForm: boolean = false;

  constructor(private bookingControllerService: BookingControllerService,
              private changeDetectorRefs: ChangeDetectorRef) {
    this.uploadForm = new FormGroup({
      UserId: new FormControl()
    });
    this.addForm = new FormGroup({
      FunctionBundleId: new FormControl(),
      FunctionId: new FormControl(),
      Discount: new FormControl(),
      PriceByMinute: new FormControl()
    });
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    const formData = new FormData();
    // @ts-ignore
    formData.append('UserId', this.uploadForm.get('UserId').value);
    this.dataSource.data = []
    // @ts-ignore
    this.bookingControllerService.getAvailableFunctionBundles(+formData.get('UserId').valueOf(), 'body')
      .subscribe(value => {
        let response: FunctionBundle[] = [];
        value.forEach(element => {
          console.log(element.functionNumber);
          response.push({
              functionBundleId: element.functionBundleId!,
              functionNumber: element.functionNumber?.pop()!,
              discount: element.discount!,
              priceByMinute: element.priceByMinute!
            }
          );
        });
        this.dataSource.data = response;
      });
    this.changeDetectorRefs.detectChanges();
  }

  onTextChange($event: Event) {

  }

  showAddFunctionBundleForm() {
    this.addFunctionBundleForm = true;
  }

  hideAddFunctionBundleForm() {
    this.addFunctionBundleForm = false;
  }

  onCreate() {
    const formData = new FormData();
    this.bookingControllerService.addFunctionBundle({
      // @ts-ignore
      functionBundleId: this.addForm.get('FunctionBundleId').value,
      // @ts-ignore
      functionNumber:  this.addForm.get('FunctionId').value.split(","),
      // @ts-ignore
      discount:  this.addForm.get('Discount').value,
      // @ts-ignore
      priceByMinute:  this.addForm.get('PriceByMinute').value
      }
    ).subscribe(value => console.log(value));
  }
}
