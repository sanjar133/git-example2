package with_abstraction;

public class TeslaCar extends Car{
    @Override
    protected void getSpeedToReach_100() {
        System.out.println("1.9 s");
    }
}
