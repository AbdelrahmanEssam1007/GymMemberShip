//this is essentially the GUI we will use

public class AdminRole {
    private final TrainerDatabase database;

    public AdminRole() {
        database = new TrainerDatabase("Trainers.txt");
    }

    //adds a trainer to the database
    public void addTrainer(String trainerId, String name, String email, String specialty, String phoneNumber) {
        Trainer trainer = new Trainer(trainerId, name, email, specialty, phoneNumber);
        database.insertRecord(trainer);
    }

    //retrieves the list of trainers
    public TrainerDatabase getListOfTrainers() {
        return database;
    }

    //removes a trainer from the database
    public void removeTrainer(String trainerId) {
        database.deleteRecord(trainerId);
    }

    //save the database to a file on logout
    public void logout(){
        System.out.println("Logging out");
        database.saveToFile();
    }

}
