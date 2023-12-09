public class MedalTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Medal m1 = new Medal(4);

        System.out.println("Your number of medals is: " + m1);

        m1.decMedal(5);

        System.out.println("Your number of medals is: " + m1);

        m1.incMedal(2);

        System.out.println("Your number of medals is: " + m1);
    }

}
