import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class DBO {
    private final ArrayList<Record> records;
    private final String fileName;

    DBO (String fileName) {
        this.fileName = fileName;
        records = new ArrayList<Record>();
        readFromFile();
    }

    public abstract Record createRecordFrom (String Line);

    public ArrayList<Record> returnAllRecords() {
        return records;
    }

    public boolean contains (String key) {
        for (Record record : records) {
            if (record.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public Record getRecord(String key) {
        for (Record record : records) {
            if (record.getSearchKey().equals(key)) {
                return record;
            }
        }
        return null;
    }

    public void insertRecord(Record record) {
        if(!contains(record.getSearchKey())) {
            records.add(record);
        }
        else {
            System.out.println("Member already exists");
        }
    }

    public void deleteRecord(String key) {
        Record record = getRecord(key);
        if (record != null) {
            records.remove(record);
        }
    }

    public void readFromFile() {
        try {
            File file = new File (fileName);
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                insertRecord(createRecordFrom(fileScanner.nextLine()));;
            }
            fileScanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void saveToFile() {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            for (int i = 0; i < records.size(); i ++) {
                fileWriter.write(records.get(i).lineRepresentation() + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
