package hw6;

public class ProfileText {
    String id;
    String username;
    String deskName;

    public ProfileText(String id, String username, String deskName) {
        this.id = id;
        this.username = username;
        this.deskName = deskName;
    }

    public ProfileText(Profile profile) {
        this.id = profile.getId().getText();
        this.username = profile.getUsername().getText();
        this.deskName = profile.getDeskName().getText().replaceAll("\n", " ");
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getDeskName() {
        return deskName;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        ProfileText guest = (ProfileText) obj;
        return id.equals(guest.getId()) && (username.equals(guest.getUsername()) && deskName.equals(guest.getDeskName()));
    }

    @Override
    public String toString() {
        return id + " " + username + " " + deskName;
    }
}
