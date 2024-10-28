import java.time.LocalDate;

public class MemberClassRegistrationDatabase extends DBO {

    // private ArrayList<MemberClassRegistration> records ;
    // private final String fileName;

    public MemberClassRegistrationDatabase(String fileName) {
        super(fileName);
    }

    public Record createRecordFrom (String line) {
        String[] parts = line.split(",");
        return new MemberClassRegistration(parts[0], parts[1], parts[2], LocalDate.parse(parts[3]));
    }

    // public ArrayList<MemberClassRegistration> returnAllRecords() {
    //     return records;
    // }

    // public boolean contains (String key) {
    //     for (MemberClassRegistration record : records) {
    //         if (record.getSearchKey().equals(key)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    // public MemberClassRegistration getRecord(String key) {
    //     for (MemberClassRegistration record : records) {
    //         if (record.getSearchKey().equals(key)) {
    //             return record;
    //         }
    //     }
    //     return null;
    // }

    // public void insertRecord(MemberClassRegistration record) {
    //     if(!contains(record.getSearchKey())) {
    //         records.add(record);
    //     }
    //     else {
    //         System.out.println("Registration already exists");
    //     }
    // }

    // public void deleteRecord(String key) {
    //     MemberClassRegistration record = getRecord(key);
    //     if (record != null) {
    //         records.remove(record);
    //     }
    // }

    // public void readFromFile() {
    //     try {
    //         File file = new File(fileName);
    //         Scanner fileScanner = new Scanner(file);
    //         while (fileScanner.hasNextLine()) {
    //             insertRecord(createRecordFrom(fileScanner.nextLine()));
    //         }
    //         fileScanner.close();
    //     } catch (FileNotFoundException e) {
    //         System.out.println("File not found");
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
