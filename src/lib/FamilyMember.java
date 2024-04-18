package lib;

public class FamilyMember {
    private String name;
    private String idNumber;

    public FamilyMember(String name, String idNumber) {
        this.name = name;
        this.idNumber = idNumber;
    }

    public String getIdNumber(){
        return idNumber;
    }
    
}
