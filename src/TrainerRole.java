//this is essentially the GUI we will use
//for members add setRegistrationStatus and getRegistrationDate

import java.time.LocalDate;

public class TrainerRole {

    private static MemberDatabase memberDatabase;
    private static ClassDatabase classDatabase;
    private static MemberClassRegistrationDatabase registrationDatabase;


    public TrainerRole() {
        memberDatabase = new MemberDatabase("Members.txt");
        classDatabase = new ClassDatabase("Classes.txt");
        registrationDatabase = new MemberClassRegistrationDatabase("Registration.txt");
    }

    public void addMember(String memberId, String name, String membershipType, String email, String phoneNumber, String status) {
        Member member = new Member(memberId, name, membershipType, email, phoneNumber, status);
        memberDatabase.insertRecord(member);
    }

    public MemberDatabase getListOfMembers() {
        return memberDatabase;
    }

    public void addClass(String classID, String className, String trainerId, int duration, int maxParticipants) {
        if(!TrainerDatabase.contains(trainerId)) {
            System.out.println("Trainer does not exist");
            return;
        }
        Class newClass = new Class(classID, className, trainerId, duration, maxParticipants);
        classDatabase.insertRecord(newClass);
    }

    public ClassDatabase getListOfClasses() {
        return classDatabase;
    }

    public void registerMemberForClass(String memberId, String classId, LocalDate registrationDate) {
        if(!memberDatabase.contains(memberId)) {
            System.out.println("Member does not exist");
            return;
        }
        if(!classDatabase.contains(classId)) {
            System.out.println("Class does not exist");
            return;
        }
        if(((Class) classDatabase.getRecord(classId)).getAvailableSeats() == 0) {
            System.out.println("Class is full");
            return;
        }
        MemberClassRegistration registration = new MemberClassRegistration(memberId, classId,"Active", registrationDate);
        registrationDatabase.insertRecord(registration);
        Class class1 = (Class) classDatabase.getRecord(classId);
        class1.setAvailableSeats( class1.getAvailableSeats() - 1);
        // classDatabase.getRecord(classId).setAvailableSeats((((Class) classDatabase.getRecord(classId)).getAvailableSeats() - 1));
    }

    public void cancelRegistration(String memberId, String classId) {
        if(!memberDatabase.contains(memberId)) {
            System.out.println("Member does not exist");
            return;
        }
        if(!classDatabase.contains(classId)) {
            System.out.println("Class does not exist");
            return;
        }
        MemberClassRegistration registration =  (MemberClassRegistration) registrationDatabase.getRecord(memberId + classId);
        if(registration == null) {
            System.out.println("Registration does not exist");
            return;
        }
        if (LocalDate.now().isAfter(registration.getRegistrationDate().plusDays(3))) {
            System.out.println("Registration date is more than 3 days ago:Cannot cancel registration");
            System.out.println("Registration date: " + registration.getRegistrationDate());
            System.out.println("Current date: " + LocalDate.now());
            return;
        }
        ((MemberClassRegistration) registrationDatabase.getRecord(memberId + classId)).setRegistrationStatus("Cancelled");
        Class class1 = (Class) classDatabase.getRecord(classId);
        class1.setAvailableSeats( class1.getAvailableSeats() + 1);
        // classDatabase.getRecord(classId).setAvailableSeats((((Class) classDatabase.getRecord(classId)).getAvailableSeats() + 1));
    }

    public MemberClassRegistrationDatabase getListOfRegistrations() {
        return registrationDatabase;
    }

    public void logout() {
        System.out.println("Logging out");
        memberDatabase.saveToFile();
        classDatabase.saveToFile();
        registrationDatabase.saveToFile();
    }

}
