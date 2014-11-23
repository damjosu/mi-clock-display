public class ClockDisplay
{
    //The hours.
    private NumberDisplay hour;
    //The minutes.
    private NumberDisplay minute;
    //The current time.
    private String currentTime;
    //The current year
    private NumberDisplay year;
    //The current month;
    private NumberDisplay month;
    //The current day;
    private NumberDisplay day;

    /**
     * Initialize the clock to 00:00a.m. 00/00/00
     */
    public ClockDisplay()
    {
        hour = new NumberDisplay(24);
        minute = new NumberDisplay(60);
        year = new NumberDisplay(2999);
        month = new NumberDisplay(13);
        day = new NumberDisplay(31);
        updateDisplay();
    }

    /**
     * Initialize the clock to the given time.
     */
    public ClockDisplay(int newHour, int newMinute, int newDay, int newMonth, int newYear)
    {
        hour = new NumberDisplay(24);
        minute = new NumberDisplay(60);
        year = new NumberDisplay(2999);
        month = new NumberDisplay(13);
        day = new NumberDisplay(31);        
        hour.setValue(newHour);
        minute.setValue(newMinute);
        day.setValue(newDay);
        month.setValue(newMonth);
        year.setValue(newYear);        
        updateDisplay();
    }

    /**
     * Sets the clock to the given hour, minute, day, month and year.
     */
    public void setTime(int newHour, int newMinute, int newDay, int newMonth, int newYear)
    {
        hour.setValue(newHour);
        minute.setValue(newMinute);
        day.setValue(newDay);
        month.setValue(newMonth);
        year.setValue(newYear);
        updateDisplay();
    }

    /**
     * Returns the Time in 24h format.
     */
    public String getTime()
    {
        return currentTime;
    }

    /**
     * Sets the time 1 minute forward.
     */
    public void timeTick()
    {
        minute.increment();
        if (minute.getValue() == 0) {
            hour.increment();
            if (hour.getValue() == 0) {
                day.increment();
                if (day.getValue() == 0) {
                    day.increment();
                    month.increment();
                    if (month.getValue() == 0) {
                        month.increment();
                        year.increment();
                    }
                }
            }
        }
        updateDisplay();    
    } 
    
    /**
     * Updates the current time.
     */
    private void updateDisplay()
    {
        if (hour.getValue() > 12) {
            int newHour = hour.getValue() - 12;
            currentTime = newHour + ":" +  minute.getDisplayValue() + "p.m. " + day.getDisplayValue() + "/" + month.getDisplayValue() + "/" + year.getDisplayValue();
        }
        else {
            currentTime = hour.getDisplayValue() + ":" +  minute.getDisplayValue() + "a.m. " + day.getDisplayValue() + "/" + month.getDisplayValue() + "/" + year.getDisplayValue();
        }    
    }   
}    