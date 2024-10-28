public class TrainerDatabase extends DBO {

    // private static ArrayList<Trainer> records;
    // private final String fileName;

    public TrainerDatabase(String fileName) {
        super(fileName);
    }

    public Record createRecordFrom (String line) {
        String[] parts = line.split(",");
        return new Trainer(parts[0], parts[1], parts[2], parts[3], parts[4]);
    }

    // public ArrayList<Trainer> returnAllRecords() {
    //     return records;
    // }

    // public static boolean contains(String key) {
    //     for (Trainer record : records) {
    //         if (record.getSearchKey().equals(key)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    // public Trainer getRecord(String key) {
    //     for (Trainer record : records) {
    //         if (record.getSearchKey().equals(key)) {
    //             return record;
    //         }
    //     }
    //     return null;
    // }

    // public void insertRecord(Trainer record) {
    //     if(!contains(record.getSearchKey())) {
    //         records.add(record);
    //     }
    //     else {
    //         System.out.println("Trainer already exists");
    //     }
    // }

    // public void deleteRecord(String key) {
    //     Trainer record = getRecord(key);
    //     if (record != null) {
    //         records.remove(record);
    //     }
    // }

    // public void readFromFile() {
    //     try {
    //         File file = new File (fileName);
    //         Scanner fileScanner = new Scanner(file);
    //         while (fileScanner.hasNextLine()) {
    //             insertRecord(createRecordFrom(fileScanner.nextLine()));
    //         }
    //         fileScanner.close();
    //     }
    //     catch (FileNotFoundException e) {
    //         System.out.println("An error occurred.");
    //         e.printStackTrace();
    //     }
    // }

    // public void saveToFile() {
    //     try {
    //         FileWriter fileWriter = new FileWriter(fileName);
    //         for (int i = 0; i < records.size(); i ++) {
    //             fileWriter.write(records.get(i).lineRepresentation() + "\n");
    //         }
    //         fileWriter.close();
    //     } catch (IOException e) {
    //         System.out.println("An error occurred.");
    //         e.printStackTrace();
    //     }
    // }

}
