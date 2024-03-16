import { AfterViewInit, Component, OnInit } from '@angular/core';
import { CalculatorDashboardService } from './calculator-dashboard.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import cloneDeep from 'lodash/cloneDeep';
import { MatDialog } from '@angular/material/dialog';
import { LeadCaptureComponent } from './lead-capture/lead-capture.component';

@Component({
  selector: 'calculator-dashboard',
  templateUrl: './calculator-dashboard.component.html',
  styleUrl: './calculator-dashboard.component.scss'
})
export class CalculatorDashboardComponent implements OnInit, AfterViewInit {

  form: FormGroup;
  calculatedValues;
  isSuccess = false;
  isMonthlyBillRequired = false;
  isRoofAreaRequired = false;
  staticAlertClosed = true;

  constructor(
    private calculatorService: CalculatorDashboardService,
    private fb: FormBuilder,
    private dialog: MatDialog
  )
  {}

  ngOnInit(): void {
    this.form = this.fb.group({
      monthlyBill:['', Validators.required],
      roofArea:['', Validators.required]
    });
    this.form.controls['monthlyBill'].valueChanges.subscribe((val) => {
      if(String(val).length > 0){
        console.log(val);
        this.isMonthlyBillRequired = false;
      }
    });
    this.form.controls['roofArea'].valueChanges.subscribe((val) => {
      if(String(val).length > 0){
        console.log(val);
        this.isRoofAreaRequired = false;
      }
    });
  }

  ngAfterViewInit(){
    this.dialog.open(LeadCaptureComponent,{
      width: '100%',
      maxWidth: '45vw',
      maxHeight: '68vh',
      disableClose: true,
      position:{
        top: '30px'
      },
      backdropClass:'blurred'
    });
  }

  calculate(){
    if(this.form.invalid){
      if(this.form.controls['monthlyBill'].errors !== null){
        if(this.form.controls['monthlyBill'].errors['required']){
          this.isMonthlyBillRequired = true;
        }
      }
      if(this.form.controls['roofArea'].errors !== null){
        if(this.form.controls['roofArea'].errors['required']){
          this.isRoofAreaRequired = true;
        }
      }
      return;
    }
    let request = cloneDeep(this.form.value);
    this.calculatorService.getCalulatedResponse(request).subscribe((response:any)=>{
      this.isSuccess = true;
      this.calculatedValues = response;
    });
  }

  resetForm(){
    this.form.patchValue({
      monthlyBill:'',
      roofArea:''
    });
    if(this.isSuccess){
      this.isSuccess = !this.isSuccess;
    }
    this.isMonthlyBillRequired = false;
    this.isRoofAreaRequired = false;
  }
}

