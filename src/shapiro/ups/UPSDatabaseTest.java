package shapiro.ups;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

public class UPSDatabaseTest {

	@Test
	/** 
	 * Add a Package to a Location. 
	 * Verify that the Package is returned with getPackages().
	 * Verify that the Location is returned with getLocation().
	 */
	public void testAddPackageToLocation() {
		UPSDatabase ups = new UPSDatabase();
		Location location = new Location(1234, 5678);
		Package pkg = new Package("1234567890");
		ups.addPackageToLocation(location, pkg);
		Assert.assertEquals(location, ups.getLocation(pkg));
		HashSet<Package> pkgs = new HashSet<Package>();
		pkgs.add(pkg);
		Assert.assertEquals(pkgs, ups.getPackages(location));
	}

	@Test
	/** 
	 * Add a Package to a Location then update the Package Location to a different Location. 
	 * Verify that the Package is returned with getPackages().
	 * Verify that the Location is returned with getLocation().
	 * Verify that the Package is NOT returned when calling getPackage() with the first Location.
	 */
	public void testUpdatePackageLocation() {
		UPSDatabase ups = new UPSDatabase();
		Location location = new Location(1234, 5678);
		Package pkg = new Package("1234567890");
		ups.addPackageToLocation(location, pkg);
		Location newLocation = new Location(9876, 54321);
		ups.updatePackageLocation(pkg, newLocation);
		Assert.assertEquals(newLocation, ups.getLocation(pkg));
		HashSet<Package> pkgs = new HashSet<Package>();
		pkgs.add(pkg);
		Assert.assertEquals(pkgs, ups.getPackages(newLocation));
		Assert.assertNotEquals(pkgs, ups.getPackages(location));
	}

	@Test
	/**
	 * Verify that calling getPackages() returns an empty Set when called with
	 * a Location without Packages.
	 */
	public void testGetPackagesReturnsAnEmptySet() {
		UPSDatabase ups = new UPSDatabase();
		Assert.assertEquals(new HashSet<Package>(), ups.getPackages(new Location(1234, 5678)));
	}

	@Test
	/**
	 * Verify that calling getLocation() on an unknown Package returns null.
	 */
	public void testGetLocationReturnsNull() {
		UPSDatabase ups = new UPSDatabase();
		Assert.assertNull(ups.getLocation(new Package("12345678")));
	}

}
