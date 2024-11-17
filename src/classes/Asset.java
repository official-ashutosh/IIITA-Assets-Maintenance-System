package classes;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Asset extends Database {

    // In-memory list to store assets
    private List<Object[]> assetsDetails = new ArrayList<>();

    private String assetId;
    private String assetName;
    private String assetDescription;
    private String assetQuantity;
    private String assetCompany;
    private String assetPrice;

    public Asset() {
        // Pre-populating some data
        try {
            // Load XML file
            File xmlFile = new File("assets.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList assetList = doc.getElementsByTagName("asset");

            // Loop through the asset nodes and add them to the list
            for (int i = 0; i < assetList.getLength(); i++) {
                Node node = assetList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    String id = element.getElementsByTagName("id").item(0).getTextContent();
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String model = element.getElementsByTagName("model").item(0).getTextContent();
                    String quantity = element.getElementsByTagName("quantity").item(0).getTextContent();
                    String brand = element.getElementsByTagName("brand").item(0).getTextContent();
                    String price = element.getElementsByTagName("price").item(0).getTextContent();

                    assetsDetails.add(new Object[]{id, name, model, quantity, brand, price});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Asset(String assetId, String assetName, String assetDescription, String assetQuantity, String assetCompany, String assetPrice) {
        this();
        this.assetId = assetId;
        this.assetName = assetName;
        this.assetDescription = assetDescription;
        this.assetQuantity = assetQuantity;
        this.assetCompany = assetCompany;
        this.assetPrice = assetPrice;
    }

    @Override
    public void addData() {
        // Check if the asset ID already exists
        for (Object[] asset : assetsDetails) {
            if (asset[0].equals(assetId)) {
                JOptionPane.showMessageDialog(null, "Asset ID already exists!");
                return;
            }
        }
        // Add new asset
        assetsDetails.add(new Object[]{assetId, assetName, assetDescription, assetQuantity, assetCompany, assetPrice});
        JOptionPane.showMessageDialog(null, "Added Successfully");
    }

    @Override
    public void updateData() {
        boolean updated = false;

        for (Object[] asset : assetsDetails) {
            if (asset[0].equals(assetId)) { // Match by asset ID
                asset[1] = assetName;
                asset[2] = assetDescription;
                asset[3] = assetQuantity;
                asset[4] = assetCompany;
                asset[5] = assetPrice;
                updated = true;
                break;
            }
        }

        if (updated) {
            JOptionPane.showMessageDialog(null, "Updated Successfully");
        } else {
            JOptionPane.showMessageDialog(null, "Asset ID not found!");
        }
    }

    @Override
    public void deleteData() {
        boolean removed = assetsDetails.removeIf(asset -> asset[0].equals(assetId)); // Remove by asset ID
        if (removed) {
            JOptionPane.showMessageDialog(null, "Deleted Successfully");
        } else {
            JOptionPane.showMessageDialog(null, "Asset ID not found!");
        }
    }

    @Override
    public List<Object[]> getData() {
        // Return a copy of the data to prevent external modifications
        return new ArrayList<>(assetsDetails);
    }

    // Getters and Setters
    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetDescription() {
        return assetDescription;
    }

    public void setAssetDescription(String assetDescription) {
        this.assetDescription = assetDescription;
    }

    public String getAssetQuantity() {
        return assetQuantity;
    }

    public void setAssetQuantity(String assetQuantity) {
        this.assetQuantity = assetQuantity;
    }

    public String getAssetCompany() {
        return assetCompany;
    }

    public void setAssetCompany(String assetCompany) {
        this.assetCompany = assetCompany;
    }

    public String getAssetPrice() {
        return assetPrice;
    }

    public void setAssetPrice(String assetPrice) {
        this.assetPrice = assetPrice;
    }
}
