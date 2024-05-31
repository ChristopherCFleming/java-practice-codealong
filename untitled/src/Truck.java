public class Truck implements Vehicle{

    private static final int MAX_KM_PER_HOUR = 195;
    private int kilometersPerHour = 0;

    @Override
    public void accelerate() {
        kilometersPerHour = Math.min(kilometersPerHour + 10, MAX_KM_PER_HOUR);
    }

    @Override
    public String getVelocityMessage() {
        return String.format("%s km/hr", kilometersPerHour);
    }
}
