package gymsubscription;

/*
  Programmer: Lama Albakri 
  Gym Subscription System
*/
public class info {
    private  String name;
    private  String ID;
    private  String number;
    private  String gen;

    public info(String name, String ID, String number, String gen) {
        this.name = name;
        this.ID = ID;
        this.number = number;
        this.gen = gen;
    }

    info() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public String getNumber() {
        return number;
    }

    public String getGen() {
        return gen;
    }
}