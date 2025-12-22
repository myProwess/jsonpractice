package requests.jacksonrequest;

public class UserRequest {
    private String name;
    private String job;

    // Constructor
    public UserRequest(String name, String job) {
        this.name = name;
        this.job = job;
    }

    // Getters and Setters (Required for Serialization)
    public String getName() { return name; }
    public String getJob() { return job; }
    public void setName(String name) { this.name = name; }
    public void setJob(String job) { this.job = job; }
}
