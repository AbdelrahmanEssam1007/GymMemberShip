public class ClassDatabase extends DBO {

    // private static ArrayList<Class> records;
    // private final String fileName;

    //constructor
    public ClassDatabase(String fileName) {
        super(fileName);
    }

    //create a record from a string line in the file
    public Record createRecordFrom (String line) {
        String[] parts = line.split(",");
        return new Class(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
    }

    // public ArrayList<Class> returnAllRecords() {
    //     return records; //return all records
    // }

    //check if a record exists
    // public boolean contains (String key) {
    //     for (Class record : records) {
    //         if (record.getSearchKey().equals(key)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    //fetches a record for a given key
    // public Class getRecord(String key) {
    //     for (Class record : records) {
    //         if (record.getSearchKey().equals(key)) {
    //             return record;
    //         }
    //     }
    //     return null;
    // }

    //insert a record
    // public void insertRecord(Class record) {
    //     if(!contains(record.getSearchKey())) { //check if the record already exists
    //         records.add(record);
    //     }
    //     else {
    //         System.out.println("Class already exists");
    //     }
    // }

    //delete a record
    // public void deleteRecord(String key) {
    //     Class record = getRecord(key);
    //     if (record != null) { //check if the record exists
    //         records.remove(record);
    //     }
    // }

    // public void readFromFile() {
    //     try {
    //         File file = new File (fileName);
    //         Scanner fileScanner = new Scanner(file);
    //         while (fileScanner.hasNextLine()) {
    //             insertRecord(createRecordFrom(fileScanner.nextLine()));;
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
    //             fileWriter.write(records.get(i).lineRepresentation() + "\n");//write each record to the file
    //         }
    //         fileWriter.close();
    //     } catch (IOException e) {
    //         System.out.println("An error occurred.");
    //         e.printStackTrace();
    //     }
    // }
}
