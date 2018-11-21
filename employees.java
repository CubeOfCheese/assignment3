import java.util.LinkedList;
import java.util.Queue;

public class employees
{
  private employee[] theList = new employee[100];
  Queue<Integer> deletedList = new LinkedList<>();
  private int empCounter = 0;
  private int iteratorPosition = -1;

  public employees()
  {

  }
  public employees(employee aEmployee)
  {
    theList[0] = aEmployee;
    empCounter = 1;
  }

  public employee getEmployee(int index)
  {
    return theList[index];
  }
  public void add(employee aEmployee)
  {
    if (empCounter < theList.length)
    {
      theList[empCounter] = aEmployee;
      empCounter++;
    }
    else if (deletedList.peek() >= 0)
    {
      theList[deletedList.poll()] = aEmployee;
    }
  }
  public void delete(employee aEmployee)
  {
    aEmployee.setActive(false);
  }
  public void delete(int index)
  {
    theList[index].setActive(false);
    deletedList.add(index);
  }
  public int search(String aLastName, int start, int end)
  {
    int mid = (start + end)/2;
    int returnValue = -1;
    if (aLastName.compareTo(theList[mid].getEmployeeInfo().lastName) < 0)
    {
      System.out.println("goind down");
      return search(aLastName, start, mid);
    }
    else if (aLastName.compareTo(theList[mid].getEmployeeInfo().lastName) > 0)
    {
      System.out.println("goind up");
      return search(aLastName, mid, end);
    }
    else if (theList[mid].checkActive() == true)
    {
      System.out.println("found it");
      return mid;
    }
    System.out.println(returnValue);
    System.out.println("^returnValue");
    return returnValue;
  }
  public int search(employee aEmployee, int start, int end)
  {
    int mid = (start + end)/2;
    int returnValue = -1;
    if (aEmployee.getEmployeeInfo().lastName.compareTo(theList[mid].getEmployeeInfo().lastName) < 0)
    {
      return search(aEmployee, start, mid-1);
    }
    else if (aEmployee.getEmployeeInfo().lastName.compareTo(theList[mid].getEmployeeInfo().lastName) > 0)
    {
      return search(aEmployee, mid+1, end);
    }
    else if (aEmployee.checkActive() == true)
    {
      return mid;
    }
    return returnValue;
  }
  public void sort(int start, int end)
  {
    int low = start;
    int high = end;
    int mid = (high + low)/2;
    String pivot = theList[mid].getEmployeeInfo().lastName;
    while (low < high)
    {
      while (pivot.compareTo(theList[low].getEmployeeInfo().lastName) > 0) {low++;}
      while (pivot.compareTo(theList[high].getEmployeeInfo().lastName) < 0) {high--;}
      if (low <= high)
      {
        employee temp = theList[low];
        theList[low] = theList[high];
        theList[high] = temp;
        low++;
        high--;
      }
    }
    if (start < high) {sort(start, high);}
    if (end > low) {sort(low, end);}
  }

  public void iteratorStart()
  {
    iteratorPosition = -1;
  }
  public Boolean iteratorHasNext()
  {
    Boolean returnValue = true;
    iteratorPosition++;
    if (iteratorPosition >= empCounter)
    {
      returnValue = false;
    }
    return returnValue;
  }
  public employee iteratorGetNext()
  {
    if (theList[iteratorPosition].checkActive() == false)
    {
      iteratorPostition++;
    }
    return new employee(theList[iteratorPosition]);
  }
  public int getEmpCount()
  {
    return empCounter;
  }
  public int getIteratorPosition()
  {
    return iteratorPosition;
  }
}
