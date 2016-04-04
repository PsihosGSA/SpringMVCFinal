package ua.org.oa.gavrishs.model;


/**
 * Created by Anna on 17.02.2016.
 */
public enum Role {

    ROLE_USER("user"), ROLE_ADMIN("admin");

    private String displayName;

    Role(String displayName){
        setDisplayName(displayName);
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

}