import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;

    // TO DO: Implement a constructor that takes an ID and a role


    public AdminUser(Integer employeeID, String role) {
        this.setId(employeeID);
        this.employeeID = employeeID;
        this.role = role;
        this.securityIncidents = new ArrayList<>();
    }

    // TO DO: Implement HIPAACompliantUser!
    // TO DO: Implement HIPAACompliantAdmin!

    public void newIncident(String notes) {
        String report = String.format(
                "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n",
                new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }

    public void authIncident() {
        String report = String.format(
                "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n",
                new Date(),this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }

    @Override
    public ArrayList<String> reportSecurityIncidents() {
        return securityIncidents;
    }

    @Override
    public boolean assignPin(int pin) {
        if (String.valueOf(pin).length() == 6) {
            super.setPin(pin);
            return true;
        }
        return false;
    }

    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
        if (confirmedAuthID.equals(this.employeeID)) {
            return true;
        } else {
            authIncident();
            return false;
        }
    }

    @Override
    public boolean adminQATest(ArrayList<String> expectedIncidents) {
        return HIPAACompliantAdmin.super.adminQATest(expectedIncidents);
    }

    @Override
    public void printSecurityIncidents() {
        HIPAACompliantAdmin.super.printSecurityIncidents();
    }

    // TO DO: Setters & Getters


    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSecurityIncidents(int idx) {
        return securityIncidents.get(idx);
    }

    public void setSecurityIncidents(String securityIncidents) {
        this.securityIncidents.add(securityIncidents);
    }
}
