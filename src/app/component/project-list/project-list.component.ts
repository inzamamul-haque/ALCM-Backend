import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {BusinessRequirementService} from '../../service/business-requirement.service';

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.scss']
})
export class ProjectListComponent implements OnInit {

  projectList: Array<{name: string}> = [];
  constructor(private route: Router, private br: BusinessRequirementService) { }

  ngOnInit(): void {
  }

  getAllProject() {

  }

  createNewProject() {
    this.route.navigate(['project']);
  }
}
