public class Record
{
  public String lastName;
  public String firstName;
  public double payRate;
  public double hoursWorked;
  public double grossPay;
  public double tax;
  public double netPay;
  public double taxRate;

  public Record()
  {
    lastName = "Bond";
    firstName = "James";
    payRate = 0;
    hoursWorked = 0;
    grossPay = 0;
    tax = 0;
    netPay = 0;
    taxRate = 0;
  }
  public Record(Record aRecord)
  {
    lastName = aRecord.lastName;
    firstName = aRecord.firstName;
    payRate = aRecord.payRate;
    hoursWorked = aRecord.hoursWorked;
    grossPay = aRecord.grossPay;
    tax = aRecord.tax;
    netPay = aRecord.netPay;
    taxRate = aRecord.taxRate;
  }
  public Record(String aFirstName, String aLastName)
  {
    firstName = aFirstName;
    lastName = aLastName;
    payRate = 0;
    hoursWorked = 0;
    grossPay = 0;
    tax = 0;
    netPay = 0;
    taxRate = 0;
  }
  public Record(String aFirstName, String aLastName, double aPayRate)
  {
    firstName = aFirstName;
    lastName = aLastName;
    payRate = aPayRate;
    hoursWorked = 0;
    grossPay = 0;
    tax = 0;
    netPay = 0;
    taxRate = 0;
  }
  public Record(String aFirstName, String aLastName, double aPayRate, double aHoursWorked)
  {
    firstName = aFirstName;
    lastName = aLastName;
    payRate = aPayRate;
    hoursWorked = aHoursWorked;
    grossPay = 0;
    tax = 0;
    netPay = 0;
    taxRate = 0;
  }
  public Record(String aFirstName, String aLastName, double aPayRate, double aHoursWorked, double aTaxRate)
  {
    firstName = aFirstName;
    lastName = aLastName;
    payRate = aPayRate;
    hoursWorked = aHoursWorked;
    grossPay = 0;
    tax = 0;
    netPay = 0;
    taxRate = aTaxRate;
  }
}
