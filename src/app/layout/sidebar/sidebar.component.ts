import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }
  goToBank(){
   this.router.navigate(['bank']);
  }
  goToEmployee() {
    this.router.navigate(['employee']);
  }
  goToHome() {
    this.router.navigate(['home']);
  }
  goToSalaryRank() {
    this.router.navigate(['salary-rank']);
  }
  goToAccount() {
    this.router.navigate(['account']);
  }
  employeeList() {
    this.router.navigate(['employee-list']);
  }

  salaryRankList() {
    this.router.navigate(['salaryRank-list']);
  }

  bankList() {
    this.router.navigate(['bank-list']);
  }

  bankAccountList() {
    this.router.navigate(['bankAccount-list']);
  }

  setBasicAmount() {
    this.router.navigate(['set-basic']);
  }

  goToCompany() {
    this.router.navigate(['company-account']);
  }

  goTobankAccountList() {
    this.router.navigate(['company-accountList']);
  }

  sendMoney() {
    this.router.navigate(['send-money']);
  }
}
