package with_abstraction;

public class NexiaCar extends Car{
    @Override
    protected void getSpeedToReach_100() {
        System.out.println("10 s");
    }
}
