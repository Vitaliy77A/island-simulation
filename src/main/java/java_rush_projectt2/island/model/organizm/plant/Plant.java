package java_rush_projectt2.island.model.organizm.plant;
import java_rush_projectt2.island.map.Location;
import java_rush_projectt2.island.model.organizm.GameSimulation;

public abstract class Plant implements GameSimulation {
protected Location location;

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public void play() {
        grov();
        reproduce();
    }

}
