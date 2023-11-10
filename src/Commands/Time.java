package Commands;

public class Time implements Command{
    @Override
    public String[] execute(String[] arguments) {
        long time = System.currentTimeMillis();
        String[] times = {((((time/360000)/10)+2)%24) + ":" + (time/60000)%60 + ":" + (time/1000)%60};
        return times;
    }
}
