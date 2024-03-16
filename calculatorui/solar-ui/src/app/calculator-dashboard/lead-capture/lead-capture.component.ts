import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CalculatorDashboardService } from '../calculator-dashboard.service';
import cloneDeep from 'lodash/cloneDeep';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material/snack-bar';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-lead-capture',
  templateUrl: './lead-capture.component.html',
  styleUrl: './lead-capture.component.scss'
})
export class LeadCaptureComponent {
  isInvalid = false;
  form:FormGroup;
  isMaxLength:boolean = true;
  horizontalPosition: MatSnackBarHorizontalPosition = 'center';
  verticalPosition: MatSnackBarVerticalPosition = 'top';

  constructor(
    private fb: FormBuilder,
    private calculatorService: CalculatorDashboardService,
    private snackBar: MatSnackBar,
    private matDialogRef: MatDialogRef<LeadCaptureComponent>
  )
  {}

  ngOnInit(){
    this.form=this.fb.group({
      phoneNo:['', Validators.pattern('^\\d+$')]
    });
    this.form.valueChanges.subscribe((num)=>{
      if(Number.isNaN(num))
        this.form.controls['phoneNo'].setErrors({'pattern':true})
        this.isMaxLength = true;
      if(num.phoneNo.length === 10){
        this.isMaxLength = true;
      }
    })
  }

  submit(){
    if(this.form.invalid){
      return;
    }
    if(this.form.value.phoneNo.length < 10){
      this.isMaxLength = false;
      return;
    }
    let request = this.form.value;
    this.calculatorService.saveLead(request).subscribe((response:any) =>{
      if(response.message === 'SUCCESS'){
        this.snackBar.open('Phone number saved successfully','',{
          horizontalPosition: this.horizontalPosition,
          verticalPosition: this.verticalPosition,
          duration: 2000,
        })
        .afterDismissed()
        .subscribe(()=>this.matDialogRef.close());
      }
    },
    (error)=>{
      console.log(error);
      if(error.status == 400){
        this.snackBar.open('Error!! Phone Number Already Exists','',{
          horizontalPosition: this.horizontalPosition,
          verticalPosition: this.verticalPosition,
          duration: 2000
        });
      }
    })
  }
}
