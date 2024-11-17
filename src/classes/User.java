package classes;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class User extends Database {

    private String userId;
    private String userName;
    private String userContact;
    private String userEmail;

    // Simulated database (list of user records)
    private List<Object[]> usersDetails = new ArrayList<>();

    // Default constructor
    public User() {
        // Initialize with some default data (could be replaced with actual file loading logic)
        loadData();
    }

    // Constructor to initialize user data
    public User(String userId, String userName, String userContact, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userContact = userContact;
        this.userEmail = userEmail;
    }

    // Getters and setters for user properties
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserContact() {
        return userContact;
    }

    public void setUserContact(String userContact) {
        this.userContact = userContact;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    // Initialize data (this could be replaced by file/database loading)
    private void loadData() {
        usersDetails.add(new Object[]{"1", "OP Vyas", "+918765432109", "op.vyas@organization.in"});
        usersDetails.add(new Object[]{"2", "Pranav Sahu", "+919876543210", "pranav@company.in"});
        usersDetails.add(new Object[]{"3", "Yash Mishra", "+918765432109", "yash@company.in"});
        usersDetails.add(new Object[]{"4", "Ashutosh Kumar", "+919812345678", "ashutosh.kumar@organization.in"});
        usersDetails.add(new Object[]{"5", "Deepak Sharma", "+919765432101", "deepak.sharma@organization.in"});
        usersDetails.add(new Object[]{"6", "Krish Patel", "+919876543210", "krish.patel@organization.in"});
        usersDetails.add(new Object[]{"7", "Anjali Verma", "+917654321098", "anjali.verma@company.in"});
        usersDetails.add(new Object[]{"8", "Rohan Gupta", "+919543210987", "rohan.gupta@company.in"});
        usersDetails.add(new Object[]{"9", "Vikram Singh", "+918432109876", "vikram.singh@company.in"});
        usersDetails.add(new Object[]{"10", "Aniket Verma", "+917654321234", "aniket.verma@organization.in"});
        usersDetails.add(new Object[]{"11", "Sophia Rao", "+919210987654", "sophia.rao@company.in"});
        usersDetails.add(new Object[]{"12", "Liam Das", "+918109876543", "liam.das@company.in"});
        usersDetails.add(new Object[]{"13", "Ava Sen", "+917321098765", "ava.sen@company.in"});
        usersDetails.add(new Object[]{"14", "Mason Reddy", "+919432109876", "mason.reddy@company.in"});
        usersDetails.add(new Object[]{"15", "Isabella Nair", "+918321098765", "isabella.nair@company.in"});
        usersDetails.add(new Object[]{"16", "Ethan White", "+919876543322", "ethan.white@organization.in"});
        usersDetails.add(new Object[]{"17", "Charlotte Iyer", "+918765432110", "charlotte.iyer@organization.in"});
        usersDetails.add(new Object[]{"18", "Lucas Mehta", "+919765432211", "lucas.mehta@organization.in"});
        usersDetails.add(new Object[]{"19", "Amelia Sharma", "+917654321345", "amelia.sharma@organization.in"});
        usersDetails.add(new Object[]{"20", "Benjamin Mishra", "+918543210987", "benjamin.mishra@organization.in"});
        // Add more sample users as needed
    }

    // Add new user data
    @Override
    public void addData() {
        usersDetails.add(new Object[]{userId, userName, userContact, userEmail});
        JOptionPane.showMessageDialog(null, "User Added Successfully");
    }

    // Update existing user data
    @Override
    public void updateData() {
        boolean updated = false;
        for (Object[] record : usersDetails) {
            if (record[0].equals(userId)) { // Check by user ID
                record[1] = userName;
                record[2] = userContact;
                record[3] = userEmail;
                updated = true;
                break;
            }
        }
        if (updated) {
            JOptionPane.showMessageDialog(null, "User Updated Successfully");
        } else {
            JOptionPane.showMessageDialog(null, "User ID not found");
        }
    }

    // Delete user data
    @Override
    public void deleteData() {
        boolean removed = usersDetails.removeIf(record -> record[0].equals(userId));  // Remove by user ID
        if (removed) {
            JOptionPane.showMessageDialog(null, "User Deleted Successfully");
        } else {
            JOptionPane.showMessageDialog(null, "User ID not found");
        }
    }

    // Retrieve all user data
    @Override
    public List<Object[]> getData() {
        return new ArrayList<>(usersDetails); // Return a copy to prevent external modification
    }
}
