public class Class implements Record{

    private String classID;
    private String className;
    private String trainerID;
    private int duration;
    private int availableSeats;

    public Class(String classID, String className, String trainerID, int duration, int availableSeats) {
        this.classID = classID;
        this.className = className;
        this.trainerID = trainerID;
        this.duration = duration;
        this.availableSeats = availableSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String lineRepresentation(){
        return String.join(",",classID,className,trainerID,String.valueOf(duration),String.valueOf(availableSeats));
    }

    public String getSearchKey(){
        return this.classID;
    }
}
