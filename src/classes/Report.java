package classes;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Report {

    private static List<Object[]> reportDetails = new ArrayList<>();

    private String reportId;
    private String reportType;
    private String reportDescription;
    private String reportBy;

    public Report() {
    }

    public Report(String reportId, String reportBy, String reportType, String reportDescription) {
        this.reportId = reportId;
        this.reportType = reportType;
        this.reportDescription = reportDescription;
        this.reportBy = reportBy;
    }

    // Getter and Setter methods
    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getReportDescription() {
        return reportDescription;
    }

    public void setReportDescription(String reportDescription) {
        this.reportDescription = reportDescription;
    }

    public String getReportBy() {
        return reportBy;
    }

    public void setReportBy(String reportBy) {
        this.reportBy = reportBy;
    }

    // Add a new report
    public void addData() {
        reportDetails.add(new Object[]{reportId, reportType, reportDescription, reportBy});
        JOptionPane.showMessageDialog(null, "Report Added Successfully");
    }

    // Update an existing report
    public void updateData() {
        boolean found = false;
        for (Object[] report : reportDetails) {
            if (report[0].equals(reportId)) { // Match by reportId
                report[1] = reportType;
                report[2] = reportDescription;
                report[3] = reportBy;
                found = true;
                break;
            }
        }

        if (found) {
            JOptionPane.showMessageDialog(null, "Report Updated Successfully");
        } else {
            JOptionPane.showMessageDialog(null, "Report ID not found");
        }
    }

    // Delete a report
    public void deleteData() {
        boolean removed = reportDetails.removeIf(report -> report[0].equals(reportId));
        if (removed) {
            JOptionPane.showMessageDialog(null, "Report Deleted Successfully");
        } else {
            JOptionPane.showMessageDialog(null, "Report ID not found");
        }
    }

    // Fetch all report details
    public List<Object[]> getData() {
        return new ArrayList<>(reportDetails);
    }

    // Initialize some sample data
    static {
        reportDetails.add(new Object[]{"1", "Technical Issue", "Printer not working", "john.doe@company.com"});
        reportDetails.add(new Object[]{"2", "Maintenance", "Air conditioning repair", "jane.smith@company.com"});
        reportDetails.add(new Object[]{"3", "Complaint", "Noise from the server room", "alan.brown@company.com"});
        reportDetails.add(new Object[]{"4", "Request", "New office chair needed", "emma.davis@company.com"});
        reportDetails.add(new Object[]{"5", "Feedback", "Suggest improving Wi-Fi speed", "oliver.wilson@company.com"});
        reportDetails.add(new Object[]{"6", "Technical Issue", "Mouse not responding", "ashutosh@organization.com"});
        reportDetails.add(new Object[]{"7", "Request", "Require a new keyboard", "krish@organization.com"});
        reportDetails.add(new Object[]{"8", "Complaint", "Ergonomic chair adjustment needed", "deepak@organization.com"});
        reportDetails.add(new Object[]{"9", "Maintenance", "Projector bulb replacement", "aniket@organization.com"});
        reportDetails.add(new Object[]{"10", "Feedback", "Better ventilation needed in the server room", "op.vyas@organization.com"});
        reportDetails.add(new Object[]{"11", "Request", "Need a larger desk", "john.doe@company.com"});
        reportDetails.add(new Object[]{"12", "Technical Issue", "Desktop not booting up", "jane.smith@company.com"});
        reportDetails.add(new Object[]{"13", "Complaint", "Frequent power outages in the lab", "alan.brown@company.com"});
        reportDetails.add(new Object[]{"14", "Feedback", "Consider adding more printers to the office", "emma.davis@company.com"});
        reportDetails.add(new Object[]{"15", "Maintenance", "Chair wheels replacement", "oliver.wilson@company.com"});
        reportDetails.add(new Object[]{"16", "Request", "Additional monitors for workstations", "ashutosh@organization.com"});
        reportDetails.add(new Object[]{"17", "Technical Issue", "Router frequently disconnecting", "krish@organization.com"});
        reportDetails.add(new Object[]{"18", "Complaint", "Too cold in the conference room", "deepak@organization.com"});
        reportDetails.add(new Object[]{"19", "Maintenance", "Need replacement of light bulbs", "aniket@organization.com"});
        reportDetails.add(new Object[]{"20", "Feedback", "Provide training for new software", "op.vyas@organization.com"});
    }


}
