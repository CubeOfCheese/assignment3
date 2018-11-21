public class employee
{
  private Record info;
  private Boolean active = true;

  public employee()
  {
    info = new Record();
  }
  public employee(String firstName, String lastName)
  {
    info = new Record(firstName, lastName);
  }
  public employee(String firstName, String lastName, double payRate)
  {
    info = new Record(firstName, lastName, payRate);
  }
  public employee(String firstName, String lastName, double payRate, double hoursWorked)
  {
    info = new Record(firstName, lastName, payRate, hoursWorked);
    calculateGrossPay();
  }
  public employee(String firstName, String lastName, double payRate, double hoursWorked, double taxRate)
  {
    info = new Record(firstName, lastName, payRate, hoursWorked, taxRate);
    calculateGrossPay();
    calculateTax();
    calculateNetPay();
  }
  public employee(employee aEmployee)
  {
    info = aEmployee.getEmployeeInfo();
  }
  public employee(Record aInfo)
  {
    info = aInfo;
    calculateGrossPay();
    calculateTax();
    calculateNetPay();
  }

  public Record getEmployeeInfo()
  {
    return new Record(info);
  }
  public Boolean checkActive()
  {
    return active;
  }

  public void setPayRate(double aPayRate)
  {
    info.payRate = aPayRate;
  }
  public void setHoursWorked(double aHoursWorked)
  {
    info.hoursWorked = aHoursWorked;
  }
  public void setTaxRate(double aTaxRate)
  {
    info.taxRate = aTaxRate;
  }
  public void setActive(Boolean aBoolean)
  {
    active = aBoolean;
  }

  public void calculateGrossPay()
  {
    if (info.hoursWorked > 40)
    {
      double basePay = info.payRate * 40;
      double overtimeHours = info.hoursWorked - 40;
      double overtimePay = info.payRate * overtimeHours * 1.5;
      info.grossPay = basePay + overtimePay;
    }
    else
    {
      info.grossPay = info.payRate * info.hoursWorked;
    }
  }
  public void calculateTax()
  {
    info.tax = info.grossPay * info.taxRate;
  }
  public void calculateNetPay()
  {
    info.netPay = info.grossPay - info.tax;
  }
}
