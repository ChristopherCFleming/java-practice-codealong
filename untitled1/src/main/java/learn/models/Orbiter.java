package learn.models;

public class Orbiter {
    private int orbiterID;
    private String name;
    private OrbiterType type;
    private String sponsor;

    public int getOrbiterID() {
        return orbiterID;
    }

    public void setOrbiterID(int orbiterID) {
        this.orbiterID = orbiterID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OrbiterType getType() {
        return type;
    }

    public void setType(OrbiterType type) {
        this.type = type;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }
}
