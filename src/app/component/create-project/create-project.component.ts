import { Component, OnInit } from '@angular/core';
import {BusinessRequirementService} from '../../service/business-requirement.service';

@Component({
  selector: 'app-create-project',
  templateUrl: './create-project.component.html',
  styleUrls: ['./create-project.component.scss']
})
export class CreateProjectComponent implements OnInit {
  name: string;

  constructor(private br: BusinessRequirementService) { }

  ngOnInit(): void {
  }
  saveNewProject() {
    this.br.createNewProject(this.name).subscribe((res: any) => {
      console.log(res);
    });
  }
}
