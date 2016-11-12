
/**
 * Passenger of Airplane.
 * 
 * String firstName, lastName
 * Passenger (String firstName, String lastName)
 * getFullName()
 * getFirstName()
 * getLastName()
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Passenger
{
    private String firstName, lastName;
    
    public Passenger(String first, String last) {
        firstName = first;
        lastName = last;
    }
    
    public String getFullName() {
        return firstName + " " + lastName;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
}
