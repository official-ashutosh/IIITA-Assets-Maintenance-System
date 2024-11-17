package classes;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.*;

public class AssetTracking extends Database {

    private String id;
    private String assetName;
    private String userName;
    private String working;
    private String outOfOrder;
    private String repairable;

    // Simulated database as a List of Object arrays
    private List<Object[]> assetTrackingDetails = new ArrayList<>();

    public AssetTracking() {
        // Adding data using specified users and assets
        try {
            // Load XML file
            File xmlFile = new File("assets.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList trackingList = doc.getElementsByTagName("tracking");

            // Loop through the tracking nodes and add them to the list
            for (int i = 0; i < trackingList.getLength(); i++) {
                Node node = trackingList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    String trackingId = element.getElementsByTagName("id").item(0).getTextContent();
                    String assetName = element.getElementsByTagName("assetName").item(0).getTextContent();
                    String personAssigned = element.getElementsByTagName("personAssigned").item(0).getTextContent();
                    String status1 = element.getElementsByTagName("status1").item(0).getTextContent();
                    String status2 = element.getElementsByTagName("status2").item(0).getTextContent();
                    String status3 = element.getElementsByTagName("status3").item(0).getTextContent();

                    assetTrackingDetails.add(new Object[]{trackingId, assetName, personAssigned, status1, status2, status3});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public AssetTracking(String id, String assetName, String userName, String working, String outOfOrder, String repairable) {
        this.id = id;
        this.assetName = assetName;
        this.userName = userName;
        this.working = working;
        this.outOfOrder = outOfOrder;
        this.repairable = repairable;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getWorking() {
        return working;
    }

    public void setWorking(String working) {
        this.working = working;
    }

    public String getOutOfOrder() {
        return outOfOrder;
    }

    public void setOutOfOrder(String outOfOrder) {
        this.outOfOrder = outOfOrder;
    }

    public String getRepairable() {
        return repairable;
    }

    public void setRepairable(String repairable) {
        this.repairable = repairable;
    }

    // Add new data
    @Override
    public void addData() {
        assetTrackingDetails.add(new Object[]{id, assetName, userName, working, outOfOrder, repairable});
        JOptionPane.showMessageDialog(null, "Added Successfully");
    }

    // Update existing data
    @Override
    public void updateData() {
        boolean updated = false;
        for (Object[] record : assetTrackingDetails) {
            if (record[0].equals(id)) { // Check by ID
                record[1] = assetName;
                record[2] = userName;
                record[3] = working;
                record[4] = outOfOrder;
                record[5] = repairable;
                updated = true;
                break;
            }
        }
        if (updated) {
            JOptionPane.showMessageDialog(null, "Updated Successfully");
        } else {
            JOptionPane.showMessageDialog(null, "Asset Tracking ID not found");
        }
    }

    // Delete data
    @Override
    public void deleteData() {
        boolean removed = assetTrackingDetails.removeIf(record -> record[0].equals(id)); // Remove by ID
        if (removed) {
            JOptionPane.showMessageDialog(null, "Deleted Successfully");
        } else {
            JOptionPane.showMessageDialog(null, "Asset Tracking ID not found");
        }
    }

    // Retrieve all data
    @Override
    public List<Object[]> getData() {
        return new ArrayList<>(assetTrackingDetails); // Return a copy to prevent external modification
    }
}
