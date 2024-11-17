package classes;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Request extends Database {
    private static List<Object[]> requestDetails = new ArrayList<>();

    private String requestId;
    private String requestBy;
    private String requestItem;
    private String requestDate;

    public Request() {
    }

    public Request(String requestId, String requestBy, String requestItem, String requestDate) {
        this.requestId = requestId;
        this.requestBy = requestBy;
        this.requestItem = requestItem;
        this.requestDate = requestDate;
    }

    // Getter and Setter methods
    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestBy() {
        return requestBy;
    }

    public void setRequestBy(String requestBy) {
        this.requestBy = requestBy;
    }

    public String getRequestItem() {
        return requestItem;
    }

    public void setRequestItem(String requestItem) {
        this.requestItem = requestItem;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    // Add a new request
    @Override
    public void addData() {
        requestDetails.add(new Object[]{requestId, requestBy, requestItem, requestDate});
        JOptionPane.showMessageDialog(null, "Request Added Successfully");
    }

    // Update an existing request
    @Override
    public void updateData() {
        boolean found = false;
        for (Object[] request : requestDetails) {
            if (request[0].equals(requestId)) { // Match by requestId
                request[1] = requestBy;
                request[2] = requestItem;
                request[3] = requestDate;
                found = true;
                break;
            }
        }

        if (found) {
            JOptionPane.showMessageDialog(null, "Request Updated Successfully");
        } else {
            JOptionPane.showMessageDialog(null, "Request ID not found");
        }
    }

    // Delete a request
    @Override
    public void deleteData() {
        boolean removed = requestDetails.removeIf(request -> request[0].equals(requestId));
        if (removed) {
            JOptionPane.showMessageDialog(null, "Request Deleted Successfully");
        } else {
            JOptionPane.showMessageDialog(null, "Request ID not found");
        }
    }

    // Fetch all request details
    @Override
    public List<Object[]> getData() {
        return new ArrayList<>(requestDetails);
    }

    // Initialize some sample data
    static {
        requestDetails.add(new Object[]{"1", "Laptop Repair", "Keyboard issue", "2024-11-10"});
        requestDetails.add(new Object[]{"2", "Printer Replacement", "Out of ink", "2024-11-12"});
        requestDetails.add(new Object[]{"3", "Projector Fix", "Screen flickering", "2024-11-13"});
        requestDetails.add(new Object[]{"4", "Chair Request", "Ergonomic chair needed", "2024-11-15"});
        requestDetails.add(new Object[]{"5", "Desk Setup", "Adjustable desk requested", "2024-11-16"});
        requestDetails.add(new Object[]{"6", "Monitor Adjustment", "Screen alignment issue", "2024-11-17"});
        requestDetails.add(new Object[]{"7", "Mouse Replacement", "Scroll wheel malfunction", "2024-11-18"});
        requestDetails.add(new Object[]{"8", "Keyboard Repair", "Keys are stuck", "2024-11-19"});
        requestDetails.add(new Object[]{"9", "Projector Maintenance", "Lens cleaning required", "2024-11-20"});
        requestDetails.add(new Object[]{"10", "Chair Repair", "Broken wheel replacement", "2024-11-21"});
        requestDetails.add(new Object[]{"11", "Desktop Setup", "New workstation setup", "2024-11-22"});
        requestDetails.add(new Object[]{"12", "Router Replacement", "Frequent disconnections", "2024-11-23"});
        requestDetails.add(new Object[]{"13", "Table Repair", "Loose screws", "2024-11-24"});
        requestDetails.add(new Object[]{"14", "Air Conditioner Maintenance", "Filter cleaning", "2024-11-25"});
        requestDetails.add(new Object[]{"15", "Water Cooler Repair", "Leaking water issue", "2024-11-26"});
        requestDetails.add(new Object[]{"16", "Laptop Software Update", "OS upgrade required", "2024-11-27"});
        requestDetails.add(new Object[]{"17", "Printer Maintenance", "Paper jam issue", "2024-11-28"});
        requestDetails.add(new Object[]{"18", "Chair Adjustment", "Height adjustment needed", "2024-11-29"});
        requestDetails.add(new Object[]{"19", "Projector Setup", "New projector installation", "2024-11-30"});
        requestDetails.add(new Object[]{"20", "Desk Replacement", "Old desk replacement", "2024-12-01"});
    }
}