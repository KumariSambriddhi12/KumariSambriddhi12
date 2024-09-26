import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StoreGUI {
    private JFrame frame;
    private JPanel mainPanel, departmentPanel, retailerPanel, buttonPanel;
    private JButton departmentButton, retailerButton;
    private JLabel nameLabel, storeIdLabel, storeNameLabel, locationLabel, openingHourLabel, totalSalesLabel, totalDiscountLabel, productNameLabel, markedPriceLabel, storeIdLabelRet, storeNameLabelRet, locationLabelRet, openingHourLabelRet, totalSalesLabelRet, totalDiscountLabelRet, VATInclusivePriceLabel, isPayementOnlineLabel,purchasedYearLabel,loyaltyPointLabel,isInSalesLabel;
    private JTextField storeIdTextField, storeNameTextField, locationTextField, openingHourTextField, totalSalesTextField, totalDiscountTextField, productNameTextField, markedPriceTextField, storeIdTextFieldRet, storeNameTextFieldRet, locationTextFieldRet, openingHourTextFieldRet, totalSalesTextFieldRet, totalDiscountTextFieldRet, VATInclusivePriceTextField,loyaltyPointTextField;
    private JButton closeDepartmentButton, closeRetailerButton, adDButton,adRButton,cdpButton,slpButton,rpButton,displayButton,deptClearButton, retClearButton, displayDepButton,displayRetButton;
    private JComboBox<String>purchasedYear;
    private JCheckBox isInSalesCheckBox;
    private ArrayList<Store> StoreList= new ArrayList<Store>();
    /*adDButton=add a department
     * adRButton=add a Retailer button
     * cdpButton= Calculate Discount Price button
     * slpButton= Set the loyalty point button
     * rpButton= Remove the product button
     */

    public StoreGUI() {
        frame = new JFrame("StoreGUI");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        buttonPanel = new JPanel();
        buttonPanel.setLayout(null);

        departmentButton = new JButton("Department");
        departmentButton.setBounds(200, 200, 150, 40);
        buttonPanel.add(departmentButton);

        retailerButton = new JButton("Retailer");
        retailerButton.setBounds(400, 200, 150, 40);
        buttonPanel.add(retailerButton);

        mainPanel = new JPanel(new CardLayout());
        mainPanel.add(buttonPanel, "Button Panel");

        departmentPanel = new JPanel();
        departmentPanel.setLayout(null);
        departmentPanel.setBackground(Color.YELLOW);
        departmentPanel.setPreferredSize(new Dimension(800, 800));

        JLabel departmentLabel = new JLabel("DEPARTMENT");
        departmentLabel.setBounds(250, 50, 200, 50);
        departmentPanel.add(departmentLabel);

        closeDepartmentButton = new JButton("Close");
        closeDepartmentButton.setBounds(650, 700, 100, 30);
        departmentPanel.add(closeDepartmentButton);

        storeIdLabel = new JLabel("Store Id :");
        storeIdLabel.setBounds(100, 100, 100, 30);
        departmentPanel.add(storeIdLabel);

        storeIdTextField = new JTextField();
        storeIdTextField.setBounds(200, 100, 150, 30);
        departmentPanel.add(storeIdTextField);

        storeNameLabel = new JLabel("Store Name :");
        storeNameLabel.setBounds(100, 150, 100, 30);
        departmentPanel.add(storeNameLabel);

        storeNameTextField = new JTextField();
        storeNameTextField.setBounds(200, 150, 150, 30);
        departmentPanel.add(storeNameTextField);

        locationLabel = new JLabel("Location :");
        locationLabel.setBounds(100, 200, 100, 30);
        departmentPanel.add(locationLabel);

        locationTextField = new JTextField();
        locationTextField.setBounds(200, 200, 150, 30);
        departmentPanel.add(locationTextField);

        openingHourLabel = new JLabel("Opening Hour :");
        openingHourLabel.setBounds(100, 250, 100, 30);
        departmentPanel.add(openingHourLabel);

        openingHourTextField = new JTextField();
        openingHourTextField.setBounds(200, 250, 150, 30);
        departmentPanel.add(openingHourTextField);

        totalSalesLabel = new JLabel("Total Sales :");
        totalSalesLabel.setBounds(100, 300, 100, 30);
        departmentPanel.add(totalSalesLabel);

        totalSalesTextField = new JTextField();
        totalSalesTextField.setBounds(200, 300, 150, 30);
        departmentPanel.add(totalSalesTextField);

        totalDiscountLabel = new JLabel("Total Discount :");
        totalDiscountLabel.setBounds(100, 350, 100, 30);
        departmentPanel.add(totalDiscountLabel);

        totalDiscountTextField = new JTextField();
        totalDiscountTextField.setBounds(200, 350, 150, 30);
        departmentPanel.add(totalDiscountTextField);

        productNameLabel = new JLabel("Product Name :");
        productNameLabel.setBounds(100, 400, 100, 30);
        departmentPanel.add(productNameLabel);

        productNameTextField = new JTextField();
        productNameTextField.setBounds(200, 400, 150, 30);
        departmentPanel.add(productNameTextField);

        markedPriceLabel = new JLabel("Marked Price :");
        markedPriceLabel.setBounds(100, 450, 100, 30);
        departmentPanel.add(markedPriceLabel);

        markedPriceTextField = new JTextField();
        markedPriceTextField.setBounds(200, 450, 150, 30);
        departmentPanel.add(markedPriceTextField);
        
        isInSalesLabel= new JLabel("Is in sales");
        isInSalesLabel.setBounds(100, 500,100,30);
        departmentPanel.add(isInSalesLabel);
        
        isInSalesCheckBox = new JCheckBox();
        isInSalesCheckBox.setBounds(200,500,50,30);
        departmentPanel.add(isInSalesCheckBox);
        
        
        adDButton= new JButton("Add a Department");
        adDButton.setBounds(400,280,150,30);
        departmentPanel.add(adDButton);
        
        cdpButton= new JButton("Calculate Discount Price");
        cdpButton.setBounds(400,240,200,25);
        departmentPanel.add(cdpButton);
        
        deptClearButton= new JButton("Clear");
        deptClearButton.setBounds(100,700,100,25);
        departmentPanel.add(deptClearButton);
        
        displayDepButton= new JButton("Display");
        displayDepButton.setBounds(400,450,100,50);
        departmentPanel.add(displayDepButton);

        departmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel("Department Panel");
            }
        });
        // This button switches to the button panel
        closeDepartmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel("Button Panel");
            }
        });
        //This button adds the object of department to the arraylist.
        adDButton.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               try{
                   if(storeIdTextField.getText().equals("")|| storeNameTextField.getText().equals("")||locationTextField.getText().equals("")||openingHourTextField.getText().equals("")||totalSalesTextField.getText().equals("")||totalDiscountTextField.getText().equals("")||productNameTextField.getText().equals("")||markedPriceTextField.getText().equals("")){
                       JOptionPane.showMessageDialog(adDButton,"Empty fields found");
                       
                   }
                
                   else{
                           
                        int storeId=Integer.parseInt(storeIdTextField.getText());
                        String storeName= storeNameTextField.getText();
                        String storeLocation= locationTextField.getText();
                        String openingHour= openingHourTextField.getText();
                        int totalSales= Integer.parseInt(totalSalesTextField.getText());
                        int totalDiscount=Integer.parseInt(totalDiscountTextField.getText());
                        String productName= productNameTextField.getText();
                        int markedPrice=Integer.parseInt(markedPriceTextField.getText());
                        boolean exist = false;
                        for(Store store: StoreList){
                            if(storeId == store.getStoreId()){
                                exist= true;
                            }//chewck   
                        }
                        if(exist==true){
                            JOptionPane.showMessageDialog(frame,"Department already exist");
                        }
                     
                        else{
                        Department department= new Department( storeId , storeName ,  storeLocation , openingHour, totalSales,totalDiscount,productName,markedPrice);
                        StoreList.add(department);
                        
                        JOptionPane.showMessageDialog(frame, "Department is added");
                    
                        }
                    }
            
               }catch(NumberFormatException ne){
                   System.out.println("Invalid input.Please enter the numeric value");
                   
               }
            
           }
        });
        //Calculates the discount price from the values taken from GUI
        cdpButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    int storeId = Integer.parseInt(storeIdTextField.getText());
                    for(Store store : StoreList){
                        if (store instanceof Department || store.getStoreId()== storeId){
                           Department department = (Department) store;
                           boolean isInSales= isInSalesCheckBox.isSelected();
                           double markedPrice = Double.parseDouble(markedPriceTextField.getText());
                           department.calculateDiscountPrice(isInSales,markedPrice);
                           JOptionPane.showMessageDialog(frame,"discount is calculated.");
                           return;
                           
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Storeid invalid");
                        }
                    }
                }catch(NumberFormatException ne){
                    JOptionPane.showMessageDialog(null,"Please enter the numeric value for Store id");
                        
                }
            }
        });
        

          // Clears all the values from the text field.       
        deptClearButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    storeIdTextField.setText("");
                    storeNameTextField.setText("");
                    locationTextField.setText("");
                    openingHourTextField.setText("");
                    totalSalesTextField.setText("");
                    totalDiscountTextField.setText("");
                    productNameTextField.setText("");
                    markedPriceTextField.setText("");
                    
                    
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"Something happened while clearing the data");
                    
                }
                
            }
        });
        //Displays the value taken from GUI.
        displayDepButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String a="";
                for(Store store : StoreList){
                    if (store instanceof Department){
                        Department department= (Department) store;
                        a = "Store Name:"+department.getStoreName()+"\n"+"Location:"+department.getLocation()+"\n"+"Opening Hour"+department.getOpeningHour()+"\n"+"Total Sales:"+department.getTotalSales()+"\n"+"Total Discount:"+department.getTotalDiscount()+"\n"+"Product Name"+department.getProductName()+"\n"+"Marked Price"+department.getMarkedPrice();
                        

                    }
                    
                }
                JOptionPane.showMessageDialog(frame, a);
                
            }
            
        });
        //Setting the panel for retailer class
        retailerPanel = new JPanel();
        retailerPanel.setLayout(null);
        retailerPanel.setBackground(Color.PINK);
        retailerPanel.setPreferredSize(new Dimension(800, 800));

        JLabel retailerLabel = new JLabel("RETAILER");
        retailerLabel.setBounds(250, 50, 200, 50);
        retailerPanel.add(retailerLabel);

        closeRetailerButton = new JButton("Close");
        closeRetailerButton.setBounds(650, 700, 100, 30);
        retailerPanel.add(closeRetailerButton);

        storeIdLabelRet = new JLabel("Store Id :");
        storeIdLabelRet.setBounds(100, 100, 100, 30);
        retailerPanel.add(storeIdLabelRet);

        storeIdTextFieldRet = new JTextField();
        storeIdTextFieldRet.setBounds(250, 100, 150, 30);
        retailerPanel.add(storeIdTextFieldRet);

        storeNameLabelRet = new JLabel("Store Name :");
        storeNameLabelRet.setBounds(100, 150, 100, 30);
        retailerPanel.add(storeNameLabelRet);

        storeNameTextFieldRet = new JTextField();
        storeNameTextFieldRet.setBounds(250, 150, 150, 30);
        retailerPanel.add(storeNameTextFieldRet);

        locationLabelRet = new JLabel("Location :");
        locationLabelRet.setBounds(100, 200, 100, 30);
        retailerPanel.add(locationLabelRet);

        locationTextFieldRet = new JTextField();
        locationTextFieldRet.setBounds(250, 200, 100, 30);
        retailerPanel.add(locationTextFieldRet);

        openingHourLabelRet = new JLabel("Opening Hour :");
        openingHourLabelRet.setBounds(100, 250, 100, 30);
        retailerPanel.add(openingHourLabelRet);

        openingHourTextFieldRet = new JTextField();
        openingHourTextFieldRet.setBounds(250, 250, 100, 30);
        retailerPanel.add(openingHourTextFieldRet);

        totalSalesLabelRet = new JLabel("Total Sales :");
        totalSalesLabelRet.setBounds(100, 300, 100, 30);
        retailerPanel.add(totalSalesLabelRet);

        totalSalesTextFieldRet = new JTextField();
        totalSalesTextFieldRet.setBounds(250, 300, 150, 30);
        retailerPanel.add(totalSalesTextFieldRet);

        totalDiscountLabelRet = new JLabel("Total Discount :");
        totalDiscountLabelRet.setBounds(100, 350, 100, 30);
        retailerPanel.add(totalDiscountLabelRet);

        totalDiscountTextFieldRet = new JTextField();
        totalDiscountTextFieldRet.setBounds(250, 350, 150, 30);
        retailerPanel.add(totalDiscountTextFieldRet);

        isPayementOnlineLabel = new JLabel("Is Payment Online:");
        isPayementOnlineLabel.setBounds(100, 400, 150, 30);
        retailerPanel.add(isPayementOnlineLabel);

        JCheckBox checkBox1 = new JCheckBox("");
        checkBox1.setBounds(250, 400, 30, 50);
        retailerPanel.add(checkBox1);

        VATInclusivePriceLabel = new JLabel("VAT Inclusive Price:");
        VATInclusivePriceLabel.setBounds(100, 450, 150, 30);
        retailerPanel.add(VATInclusivePriceLabel);

        VATInclusivePriceTextField = new JTextField();
        VATInclusivePriceTextField.setBounds(250, 450, 150, 30);
        retailerPanel.add(VATInclusivePriceTextField);
        
        purchasedYearLabel= new JLabel("Purchased Year:");
        purchasedYearLabel.setBounds(100,500,100,30);
        retailerPanel.add(purchasedYearLabel);
        
        String[] year= new String[11];
        for(int i=0; i<11; i++){
            year[i]=String.valueOf(2018+i);
        }
        purchasedYear=new JComboBox<String>(year);
        purchasedYear.setBounds(250,500,150,30);
        retailerPanel.add(purchasedYear);
        
        loyaltyPointLabel= new JLabel("Loyalty Point:");
        loyaltyPointLabel.setBounds(80,550,100,20);
        retailerPanel.add(loyaltyPointLabel);
        
        loyaltyPointTextField= new JTextField();
        loyaltyPointTextField.setBounds(200,550,150,25);
        retailerPanel.add(loyaltyPointTextField);
        
        
        adRButton= new JButton("Add a Retailer");
        adRButton.setBounds(500,280,150,30);
        retailerPanel.add(adRButton);
        
        retClearButton= new JButton("Clear");
        retClearButton.setBounds(100,700,100,25);
        retailerPanel.add(retClearButton);
        
        displayRetButton= new JButton("Display");
        displayRetButton.setBounds(200,600,100,30);
        retailerPanel.add(displayRetButton);
        
        slpButton= new JButton("Set Loyalty Point");
        slpButton.setBounds(500,230,150,30);
        retailerPanel.add(slpButton);
        
        rpButton= new JButton("Remove");
        rpButton.setBounds(400,600,100,30);
        retailerPanel.add(rpButton);

        mainPanel.add(departmentPanel, "Department Panel");
        mainPanel.add(retailerPanel, "Retailer Panel");

        frame.add(mainPanel, BorderLayout.CENTER);

        retailerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel("Retailer Panel");
            }
        });
        // This button switches us to button panel.
        closeRetailerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel("Button Panel");
            }
        });
        // This button adds object of retailer to the store list.
        adRButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    if (storeIdTextFieldRet.getText().equals("") || storeNameTextFieldRet.getText().equals("") ||locationTextFieldRet.getText().equals("") || openingHourTextFieldRet.getText().equals("") ||totalSalesTextFieldRet.getText().equals("") || totalDiscountTextFieldRet.getText().equals("") ||VATInclusivePriceTextField.getText().equals("")) {
                        JOptionPane.showMessageDialog(frame, "Empty fields found"); // Use frame or appropriate component
                    } 
                    else {
                        int storeId = Integer.parseInt(storeIdTextFieldRet.getText());
                        String storeName = storeNameTextFieldRet.getText();
                        String storeLocation = locationTextFieldRet.getText();
                        String openingHour = openingHourTextFieldRet.getText();
                        int totalSales = Integer.parseInt(totalSalesTextFieldRet.getText());
                        int totalDiscount = Integer.parseInt(totalDiscountTextFieldRet.getText());
                        int VATInclusivePrice = Integer.parseInt(VATInclusivePriceTextField.getText());
                        boolean isPaymentOnline = checkBox1.isSelected(); // Directly use checkbox state
                        String purchasedYR= purchasedYear.getSelectedItem().toString();
                        boolean exist = false;
                        for(Store store: StoreList){
                            if(storeId == store.getStoreId()){
                                exist= true;
                            }//chewck   
                        }
                        if(exist==true){
                            JOptionPane.showMessageDialog(frame,"Retailer already exist");
                        }
                     
                        else{
                        Retailer retailer= new Retailer( storeId , storeName ,  storeLocation , openingHour, totalSales,totalDiscount,VATInclusivePrice,isPaymentOnline,purchasedYR);
                        StoreList.add(retailer);
                        
                        JOptionPane.showMessageDialog(frame, "Retailer is added");
                    
                        }
                    }
                    
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Invalid number format. Please check your input.");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "An error occurred: " + ex.getMessage());
                }
            }
        });
        // This button sets the loyalty point by calling the method from retailer class and taking values from GUI.
        slpButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    int storeId = Integer.parseInt(storeIdTextFieldRet.getText());
                    for (Store store : StoreList){
                        if (store instanceof Retailer && store.getStoreId()== storeId){
                            Retailer retailer= (Retailer) store;
                            boolean isPayementOnline = checkBox1.isSelected();
                            int loyaltyPoint= Integer.parseInt(loyaltyPointTextField.getText());
                            retailer.setLoyaltyPoint(loyaltyPoint); //setLoyaltyPoint -> Setting the value of loyalty point by taking it from user.
                            
                            JOptionPane.showMessageDialog(null, "loyalty point is set");
                            return;
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Retailer not found");              
                    
                    }
                    }
                }
                catch(NumberFormatException ne){
                    JOptionPane.showMessageDialog(null,"Please enter the valid store id");
                    
                }
               
           }
        });
        
        // This button displays the value entered in GUI.
        displayRetButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String a="";
                for(Store store : StoreList){
                    if (store instanceof Retailer){
                        Retailer retailer= (Retailer) store;
                        a = "Store Name: " + retailer.getStoreName() +"\n"+"Location: "+retailer.getLocation()+"\n"+"Opening Hour: "+retailer.getOpeningHour()+"\n"+"Total Sales: " +retailer.getTotalSales()+"\n"+"Total Discount: "+retailer.getTotalDiscount()+"\n"+"VAT Inclusive Price: " + retailer.getVATInclusivePrice()+"\n"+"Purchased Year: " + retailer.getPurchasedYear()+"\n";
                        

                    }
                    
                }
                JOptionPane.showMessageDialog(frame, a);
            }
            
        });
        
        // This button clears all the text fields of GUI.
        retClearButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    storeIdTextFieldRet.setText("");
                    storeNameTextFieldRet.setText("");
                    locationTextFieldRet.setText("");
                    openingHourTextFieldRet.setText("");
                    totalSalesTextFieldRet.setText("");
                    totalDiscountTextFieldRet.setText("");
                    VATInclusivePriceTextField.setText("");
                    loyaltyPointTextField.setText("");
                    checkBox1 .setSelected(false);
                    
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"Something happened while clearing the data");
                    
                }
                
            }
        });
        //This button removes the product by calling the method from retailer class
        rpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int storeId = Integer.parseInt(storeIdTextFieldRet.getText());
                    for (Store store : StoreList) {
                        if (store instanceof Retailer && store.getStoreId() == storeId) {
                            Retailer retailer = (Retailer) store;
                            retailer.removeProduct();
                            JOptionPane.showMessageDialog(null, "Product removed successfully!");
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Retailer not found.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers.");
                }
            }
        });
        

        frame.setVisible(true);
    }

    private void switchPanel(String panelName) {
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, panelName);
    }

    public static void main(String[] args) {
        new StoreGUI();
    }
}