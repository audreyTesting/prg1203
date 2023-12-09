
public class Medal {
    private int medalnum;

    //constructor
    public Medal (int mn) {
        setMedalnum(mn);
    }

    //setter getters
    public void setMedalnum(int mn) {
        if (mn >= 0) {
            medalnum = mn;
        }
    }

    public int getMedalnum() {
        return medalnum;
    }

    //methods
    public void incMedal(int medalamount) {
        setMedalnum(medalnum + medalamount);
    }

    public void decMedal(int medalamount) {
        if (medalamount < medalnum) {
            setMedalnum (medalnum - medalamount);
        }
        else {
            setMedalnum (0);
        }
    }

    //to string
    public String toString() {
        return String.format
                ("%d \n", getMedalnum());
    }
}

