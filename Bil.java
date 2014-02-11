package bil;

import java.util.Calendar;

public class Bil
{
        private String regNum; //Registration Number
        public String brand; //Maker of the car
        public String model; //Car-model
        private Calendar regDate; //The date when the car was first registered

        //Constructor
        public Bil(String r, String b, String m, Calendar d)
        {
                regNum = r;
                brand = b;
                model = m;
                regDate = d;
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
                 "\nRegistration Date: " + regDate;
        }
}
