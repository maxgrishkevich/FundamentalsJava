

public class OtherClass{
    private String description;
    private int status;

    public OtherClass(int status){
        this.status = status;
        description = "This OtherClass object has status " + status;
    }

    public OtherClass(int status, String description){
        this.status = status;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
