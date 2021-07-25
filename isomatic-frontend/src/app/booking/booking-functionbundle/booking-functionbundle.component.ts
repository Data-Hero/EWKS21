import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {BookingControllerService} from '../booking-services/booking-controller.service';
import {MatTableDataSource} from '@angular/material/table';

export interface FunctionBundle {
  functionBundleId: string;
  functionNumber: string;
  priceByMinute: number;
  discount: number;
}

const ELEMENT_DATA: FunctionBundle[] = [
  {functionBundleId: 'FB1', functionNumber: 'F1', priceByMinute: 1.0079, discount: 0.1},
  {functionBundleId: 'FB2', functionNumber: 'F2', priceByMinute: 4.0026, discount: 0.1},
  {functionBundleId: 'FB3', functionNumber: 'F3', priceByMinute: 6.941, discount: 0.1},
  {functionBundleId: 'FB4', functionNumber: 'F4', priceByMinute: 9.0122, discount: 0.1},
  {functionBundleId: 'FB5', functionNumber: 'F5', priceByMinute: 10.811, discount: 0.1},
  {functionBundleId: 'FB6', functionNumber: 'F6', priceByMinute: 12.0107, discount: 0.1}
];


@Component({
  selector: 'app-booking-functionbundle',
  templateUrl: './booking-functionbundle.component.html',
  styleUrls: ['./booking-functionbundle.component.css']
})
export class BookingFunctionbundleComponent implements OnInit {

  displayedColumns: string[] = ['functionBundleId', 'functionNumber', 'priceByMinute', 'discount'];
  dataSource: MatTableDataSource<FunctionBundle> = new MatTableDataSource(ELEMENT_DATA);
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
    // @ts-ignore
    console.log(this.dataSource);
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
