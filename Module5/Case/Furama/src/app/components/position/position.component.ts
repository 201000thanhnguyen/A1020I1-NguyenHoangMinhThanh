import {AfterViewInit, Component, DoCheck, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {Position, IPosition, formGroupPosition} from "../../models/position";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Observable, Subject} from "rxjs";
import {PositionService} from "../../services/position.service";

declare function mainJs(): any;

@Component({
  selector: 'app-position',
  templateUrl: './position.component.html',
  styleUrls: ['./position.component.css']
})
export class PositionComponent implements OnInit, OnDestroy {

  formGroup!: FormGroup;
  positionArr: Position[] = [];

  // for dataTable
  dataTable: any;
  dtOptions: DataTables.Settings = {

  };
  dtTrigger: Subject<any> = new Subject<any>();

  // for modal
  attributeReadonly: boolean = false;
  attributeHidden: boolean = false;

  constructor(
    private positionService: PositionService,
    private formBuilder: FormBuilder
  ) {
  }

  ngOnInit(): void {
    // this.formGroup = formGroupPosition;
    this.formGroup = this.formBuilder.group({
      positionId: [''],
      positionName: ['', [Validators.required]],
    });

    this.getPositionList();
  }

  ngOnDestroy(): void {
    this.dtTrigger.unsubscribe();
  }

  getPositionList(): void{
    this.positionService.getAll().subscribe(
      (data) => {
        this.positionArr = data;
        this.dtTrigger.next();
      });
  }

  resetForm(){
    $('.data-table').DataTable().destroy();
    this.formGroup.reset();
    this.getPositionList();
  }

  inverseValueAttribute(){
    if (this.attributeReadonly || this.attributeHidden){
      this.attributeReadonly = false;
      this.attributeHidden = false;
    }
  }

  submitAddOrUpdate() {
    this.positionService.addOrUpdate(this.formGroup).subscribe( () => {
      this.resetForm();
    });
  }

  submitDeletePosition(id: any) {
    this.positionService.delete(id).subscribe(() => {
      this.resetForm();
    })
  }

  getOneObj(id: any){
    this.positionService.getOne(id).subscribe(
      (data) => {
        Object.keys(this.formGroup.controls).forEach( key => {
          // @ts-ignore
          this.formGroup.controls[key].setValue(data[key]);
        })
      });
  }

  btnEdit(positionId: number) {
    this.inverseValueAttribute();
    this.getOneObj(positionId);
  }

  btnDelete(positionId: number) {
    this.getOneObj(positionId);
    this.attributeReadonly = true;
    this.attributeHidden = true;
  }

  btnAdd() {
    this.formGroup.reset();
    this.inverseValueAttribute();
  }

}
