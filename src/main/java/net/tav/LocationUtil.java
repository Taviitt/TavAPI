package net.tav;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

import java.util.ArrayList;
import java.util.List;

public class LocationUtil {
    private static LocationUtil instance;

    public static LocationUtil getInstance() {
        if(instance == null) instance = new LocationUtil();
        return instance;
    }

    /**
     * Get locations within a radius
     * ! Y location is set at center Y location
     *
     * @param center | center location to get radius from
     * @param radius | radius for center location
     * @return all locations within a radius of center
     */
    public List<Location> squareRadiusLocations(Location center, int radius) {
        List<Location> locs = new ArrayList<>();
        Location min = new Location(center.getWorld(), center.getX() - radius, center.getY(), center.getZ() - radius);
        Location max = new Location(center.getWorld(), center.getX() + radius, center.getY(), center.getZ() + radius);
        return getLocations(center, locs, min, max);
    }

    /**
     * Get locations within a radius
     * ! Y location is added to center radius
     *
     * @param center | center location to get radius from
     * @param radius | radius for center location
     * @return all locations within a radius of center
     */
    public List<Location> squareRadiusLocationsWithY(Location center, int radius) {
        List<Location> locs = new ArrayList<>();
        Location min = new Location(center.getWorld(), center.getX() - radius, center.getY() - radius, center.getZ() - radius);
        Location max = new Location(center.getWorld(), center.getX() + radius, center.getY() + radius, center.getZ() + radius);
        return getLocations(center, locs, min, max);
    }

    /**
     * Check if two locations are the same block location (Integer)
     *
     * @param loc1 Location 1
     * @param loc2 Location 2
     * @return If locations share the same block location
     */
    public boolean isSameBlockLocation(Location loc1, Location loc2) {
        return loc1.getBlockX() == loc2.getBlockX() && loc1.getBlockY() == loc2.getBlockY() && loc1.getBlockZ() == loc2.getBlockZ();
    }

    /**
     * Check if a location is safe
     *
     * @param location Location to check
     * @return If location is safe
     */
    public boolean isSafeLocation(Location location) {
        try {
            Block feet = location.getBlock();
            if (!feet.getType().isAir() && !feet.getLocation().add(0, 1, 0).getBlock().getType().isAir()) {
                return false; // not transparent (will suffocate)
            }
            Block head = feet.getRelative(BlockFace.UP);
            if (!head.getType().isAir()) {
                return false; // not transparent (will suffocate)
            }
            Block ground = feet.getRelative(BlockFace.DOWN);
            // returns if the ground is solid or not.
            return ground.getType().isSolid();
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
        return false;
    }

    private List<Location> getLocations(Location center, List<Location> locs, Location min, Location max) {
        for (int x = (int) min.getX(); x < (int) max.getX(); x++) {
            for (int z = (int) min.getZ(); z < (int) max.getZ(); z++) {
                Location cord = new Location(center.getWorld(), x, center.getY(), z);
                locs.add(cord);
            }
        }
        return locs;
    }

}
