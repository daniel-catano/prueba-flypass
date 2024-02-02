import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {DialogData} from "./dialog-data";

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.sass']
})
export class DialogComponent {
  data: DialogData;
  constructor(
    @Inject(MAT_DIALOG_DATA) data: DialogData,
    private dialogRef: MatDialogRef<DialogComponent>
  ) {
    this.data = data;
  }

  onDismiss() {
    this.dialogRef.close(false );
  }

  onAccept() {
    this.dialogRef.close(true);
  }
}
