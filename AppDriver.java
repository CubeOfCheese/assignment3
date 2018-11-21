public class AppDriver
{
  static double totalPayRate = 0;
  static double totalHoursWorked = 0;
  static double totalGrossPay = 0;
  static double totalTaxAmount = 0;
  static double totalNetPay = 0;

  static double averagePayRate = 0;
  static double averageHoursWorked = 0;
  static double averageGrossPay = 0;
  static double averageTaxAmount = 0;
  static double averageNetPay = 0;

  public static void main (String[] args)
  {
    employees container = new employees();
    container.add(new employee("Ed", "Whittle", 11.50, 25.5, .15));
    container.add(new employee("Carl", "Davidson", 8.75, 38.0, .15));
    container.add(new employee("Paula", "Prentiss", 15.75, 50.50, .15));
    container.add(new employee("John", "Doe", 17.0, 46.5, .15));
    container.add(new employee("Louise", "Marion", 13.0, 40.0, .15));
    container.sort(0, 4);
    container.iteratorStart();

    System.out.println("Employee             Pay     Hours      Gross    Tax        Net");
    System.out.println("Name                 Rate    Worked     Pay      Amount     Pay");
    System.out.println("========             ====    ======     =====    ======    ======\n");

    while (container.iteratorHasNext())
    {
      Record info = container.iteratorGetNext().getEmployeeInfo();
      totalPayRate = totalPayRate + info.payRate;
      totalHoursWorked = totalHoursWorked + info.hoursWorked;
      totalGrossPay = totalGrossPay + info.grossPay;
      totalTaxAmount = totalTaxAmount + info.tax;
      totalNetPay = totalNetPay + info.netPay;
      System.out.println(String.format("%-20.20s ", info.lastName+", "+info.firstName)+String.format("%5.2f",info.payRate)+String.format("%10.2f",info.hoursWorked)+String.format("%10.2f",info.grossPay)+String.format("%8.2f",info.tax)+String.format("%11.2f",info.netPay));
    }

    averagePayRate = totalPayRate/container.getEmpCount();
    averageHoursWorked = totalHoursWorked/container.getEmpCount();
    averageGrossPay = totalGrossPay/container.getEmpCount();
    averageTaxAmount = totalTaxAmount/container.getEmpCount();
    averageNetPay = totalNetPay/container.getEmpCount();

    System.out.println();
    System.out.println(String.format("%-21s", "Totals")+String.format("%5.2f",totalPayRate)+String.format("%10.2f",totalHoursWorked)+String.format("%10.2f",totalGrossPay)+String.format("%8.2f",totalTaxAmount)+String.format("%11.2f",totalNetPay));
    System.out.println(String.format("%-21s", "Averages")+String.format("%5.2f",averagePayRate)+String.format("%10.2f",averageHoursWorked)+String.format("%10.2f",averageGrossPay)+String.format("%8.2f",averageTaxAmount)+String.format("%11.2f",averageNetPay));
  }
}
// 
//
// int searchIndex = container.search(container.getEmployee(3), 0, container.getEmpCount());
// System.out.println(searchIndex);
// System.out.println("^searchIndex");
// System.out.println(container.getEmployee(searchIndex));
