package com.company;


public class Main
{

    public static void main(String[] args)
    {
        //cannot construct from abstract class
        AbstractCar car = new AbstractCar();
        //or abstract subclass
        GeneralMotors car1 = new GeneralMotors();
        //but you can from a non-abstract subclass of abstract class
        Ford Mustang = new Ford();
        Mustang.setYear(1977); //method from abstract superclass
        Mustang.setMake(1); //setting make to mustang

        //creating object chevrolet
        Chevrolet camaro = new Chevrolet();
        camaro.setID(149); //setID is from GM abstract superclass
        camaro.setYear(1989); //setYear is from AbstractCar superclass 2 layers up
        camaro.setMake(1); //method from within Chevrolet class
    }
}

//abstract class
abstract class AbstractCar
{
    int Year;
    public void AbstractCar()
    {
    }
    public void setYear(int year)
    {
        Year = year;
    }
}

//subclass that is normal (non-abstract)
class Ford extends AbstractCar
{
    public String Make;
    String[] makes = {"Mustang","F150","Ranger"};
    public void Ford(int makeNumber)
    {
    }
    public void setMake(int makeNumber)
    {
        Make = makes[makeNumber];
    }
}

//subclass that is still abstract
abstract class GeneralMotors extends AbstractCar
{
    int InternalID;
    public void GeneralMotors()
    {
    }
    public void setID(int ID)
    {
        InternalID = ID;
    }
}

//Chevrolet is a subclass of GM because GM owns several car companies (including chevy).
//This way, GM can have company-wide methods. While company-wide methods
//are still abstract they are not as general as would be used across non-GM
//"cars"
class Chevrolet extends GeneralMotors
{
    String[] makes = {"Camaro","Silverado","Suburban"};
    public String Make;
    public void Chevrolet()
    {
    }
    public void setMake(int makeNumber)
    {
        Make = makes[makeNumber];
    }
}