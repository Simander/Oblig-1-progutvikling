package bil;
//important import sentences
import java.text.DateFormat;
import java.util.Calendar;

public class Bil
{
        private String regNum; //Registration Number
        public String brand; //Maker of the car
        public String model; //Car-model
        private Calendar regDate; //The date when the car was first registered
        DateFormat formata; 
        Bil next;
        //Constructor
        public Bil(String r, String b, String m, Calendar d)
        {
                regNum = r;
                brand = b;
                model = m;
                regDate = d;
                next = null;
               formata = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.MEDIUM);
                
        }
        //get-method for returning the Registration Number
        public String getRegNum()
        {
                return regNum;
        }
        //ToString Method
        public String toString()
        {
                return "Registration Number: " + regNum +
                 "\nBrand: " + brand + "\nModel: " + model +
                 "\nRegistration Date: " + formata.format(regDate.getTime());
        }
}
