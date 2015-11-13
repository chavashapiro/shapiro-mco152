package shapiro.ups;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * REQUIREMENT: You may not use an ArrayList (or any "List") in this class.
 */
public class UPSDatabase {

	private HashMap<Location, HashSet<Package>> locations;
	private HashMap<Package, Location> pkgs;

	public UPSDatabase() {
		locations = new HashMap<Location, HashSet<Package>>();
		pkgs = new HashMap<Package, Location>();
	}

	/**
	 * Add a package to the specified Location
	 */
	public void addPackageToLocation(Location location, Package pkg) {
		// put in locations map
		if (locations.containsKey(location)) {
			locations.get(location).add(pkg);
		} else {
			HashSet<Package> pkgs = new HashSet<Package>();
			pkgs.add(pkg);
			locations.put(location, pkgs);
		}

		// put in pkgs map
		pkgs.put(pkg, location);
	}

	/**
	 * Update a Package's Location.
	 */
	public void updatePackageLocation(Package pkg, Location location) {
		// update in locations
		Location currentLocation = getLocation(pkg);
		locations.get(currentLocation).remove(pkg);
		if (locations.containsKey(location)) {
			locations.get(location).add(pkg);
		} else {
			HashSet<Package> pkgs = new HashSet<Package>();
			pkgs.add(pkg);
			locations.put(location, pkgs);
		}

		// update in pkgs
		pkgs.put(pkg, location);
	}

	/**
	 * @return a Set of Packages at the specified Location or an empty Set if
	 *         the Location doesn't exist or there are no Packages at that
	 *         Location.
	 */
	public Set<Package> getPackages(Location location) {
		if (locations.containsKey(location)) {
			// if there are no pkgs at this location, the hashset is empty so
			// it'll automatically return empty set
			return locations.get(location);
		}
		// if location doesn't exist return empty set
		HashSet<Package> empty = new HashSet<Package>();
		return empty;
	}

	/**
	 * @return the Location of a Package or null if the Package doesn't exist.
	 */
	public Location getLocation(Package pkg) {
		return pkgs.get(pkg);
	}
}
