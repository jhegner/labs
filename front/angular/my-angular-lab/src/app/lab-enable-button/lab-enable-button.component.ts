import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-lab-enable-button',
  templateUrl: './lab-enable-button.component.html',
  styleUrls: ['./lab-enable-button.component.sass']
})
export class LabEnableButtonComponent{

  isChecked = false
  
  onCheck() {
    console.log("Opa meu valor eh ${isChecked}", this.isChecked)
  }

}
