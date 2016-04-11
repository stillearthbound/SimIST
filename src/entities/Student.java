
package entities;


public class Student extends Person {
    private int studentIDnum;
    private double GPA;
    private String classStanding;

    public Student(String fName, String lName, int age, int studentIDnum, double GPA, String classStanding)
    {
     super(fName, lName, age);
     this.studentIDnum = studentIDnum;
     this.GPA = GPA;
     this.classStanding = classStanding;
    }

//  public String getInfo()
//  {
//     return super.getInfo();
//
//     }
}
