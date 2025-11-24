package lecture.chapter5;

public class Student {

  private int id;
  private String firstName;
  private String lastName;


  public void drink(float amount){
    IO.println(firstName + " drinks " + amount + " l");
  }

  public void drink(float amount, int coffeinInMg){
    this.drink(amount);
    IO.println("und wird wach und aufmerksam!") ;
  }

  public void drink(float amount, double alcoholInPercentage){
    this.drink(amount);
    IO.println("und wird betrunken!") ;
  }

  public void drink(float amount, double alcoholInPercentage, int coffeinInMg){
    this.drink(amount, coffeinInMg);
    IO.println("und wird betrunken!") ;
  }

  public void drink(int koDropsCount, float amount){
    this.drink(amount);
    IO.println("und kippt um!!") ;
  }



  // Constructors

  public Student(int id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  // Getter - Setter

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
