public class ClockDisplay
{
    // The hours.
    private NumberDisplay hour;
    // The minutes.
    private NumberDisplay minute;
    // The current time.
    private String currentTime;

    /**
     * Initialize the clock to 00:00
     */
    public ClockDisplay()
    {
        hour = new NumberDisplay(24);
        minute = new NumberDisplay(60);
        currentTime = hour.getDisplayValue() + ":" + minute.getDisplayValue();
    }
    
    /**
     * Initialize the clock to the given time.
     */
    public ClockDisplay(int newHour, int newMinute)
    {
       hour = new NumberDisplay(24);
       minute = new NumberDisplay(60);
       hour.setValue(newHour);
       minute.setValue(newMinute);
       currentTime = hour.getDisplayValue() + ":" +  minute.getDisplayValue();
    }

    /**
     * Sets the clock to the given hour and minute.
     */
    public void setTime(int newHour, int newMinute)
    {
       hour.setValue(newHour);
       minute.setValue(newMinute);
       currentTime = hour.getDisplayValue() + ":" +  minute.getDisplayValue();
    }
    
    /**
     * Returns the Time in 24h format.
     */
    public String getTime()
    {
        return currentTime;
    }
}    