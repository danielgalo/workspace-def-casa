package main;

public class Element {
	private int atomicNumber;
	private String symbol;
	private String name;
	private String atomicMass;
	private String electronicConfiguration;
	private double electronegativity;
	private int atomicRadius;
	private String ionRadius;
	private int vanDerWaalsRadius;
	private int ionizationEnergy;
	private int electronAffinity;
	private String oxidationStates;
	private String standardState;
	private String bondingType;
	private int meltingPoint;
	private int boilingPoint;
	private double density;
	private String groupBlock;
	private int yearDiscovered;
	private String block;
	private String cpkHexColor;
	private int period;
	private int group;

	public Element(int atomicNumber, String symbol, String name, String atomicMass, String electronicConfiguration,
			double electronegativity, int atomicRadius, String ionRadius, int vanDerWaalsRadius, int ionizationEnergy,
			int electronAffinity, String oxidationStates, String standardState, String bondingType, int meltingPoint,
			int boilingPoint, double density, String groupBlock, int yearDiscovered, String block, String cpkHexColor,
			int period, int group) {
		this.atomicNumber = atomicNumber;
		this.symbol = symbol;
		this.name = name;
		this.atomicMass = atomicMass;
		this.electronicConfiguration = electronicConfiguration;
		this.electronegativity = electronegativity;
		this.atomicRadius = atomicRadius;
		this.ionRadius = ionRadius;
		this.vanDerWaalsRadius = vanDerWaalsRadius;
		this.ionizationEnergy = ionizationEnergy;
		this.electronAffinity = electronAffinity;
		this.oxidationStates = oxidationStates;
		this.standardState = standardState;
		this.bondingType = bondingType;
		this.meltingPoint = meltingPoint;
		this.boilingPoint = boilingPoint;
		this.density = density;
		this.groupBlock = groupBlock;
		this.yearDiscovered = yearDiscovered;
		this.block = block;
		this.cpkHexColor = cpkHexColor;
		this.period = period;
		this.group = group;
	}

	/**
	 * @return the atomicNumber
	 */
	public int getAtomicNumber() {
		return atomicNumber;
	}

	/**
	 * @param atomicNumber the atomicNumber to set
	 */
	public void setAtomicNumber(int atomicNumber) {
		this.atomicNumber = atomicNumber;
	}

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the atomicMass
	 */
	public String getAtomicMass() {
		return atomicMass;
	}

	/**
	 * @param atomicMass the atomicMass to set
	 */
	public void setAtomicMass(String atomicMass) {
		this.atomicMass = atomicMass;
	}

	/**
	 * @return the electronicConfiguration
	 */
	public String getElectronicConfiguration() {
		return electronicConfiguration;
	}

	/**
	 * @param electronicConfiguration the electronicConfiguration to set
	 */
	public void setElectronicConfiguration(String electronicConfiguration) {
		this.electronicConfiguration = electronicConfiguration;
	}

	/**
	 * @return the electronegativity
	 */
	public double getElectronegativity() {
		return electronegativity;
	}

	/**
	 * @param electronegativity the electronegativity to set
	 */
	public void setElectronegativity(double electronegativity) {
		this.electronegativity = electronegativity;
	}

	/**
	 * @return the atomicRadius
	 */
	public int getAtomicRadius() {
		return atomicRadius;
	}

	/**
	 * @param atomicRadius the atomicRadius to set
	 */
	public void setAtomicRadius(int atomicRadius) {
		this.atomicRadius = atomicRadius;
	}

	/**
	 * @return the ionRadius
	 */
	public String getIonRadius() {
		return ionRadius;
	}

	/**
	 * @param ionRadius the ionRadius to set
	 */
	public void setIonRadius(String ionRadius) {
		this.ionRadius = ionRadius;
	}

	/**
	 * @return the vanDerWaalsRadius
	 */
	public int getVanDerWaalsRadius() {
		return vanDerWaalsRadius;
	}

	/**
	 * @param vanDerWaalsRadius the vanDerWaalsRadius to set
	 */
	public void setVanDerWaalsRadius(int vanDerWaalsRadius) {
		this.vanDerWaalsRadius = vanDerWaalsRadius;
	}

	/**
	 * @return the ionizationEnergy
	 */
	public int getIonizationEnergy() {
		return ionizationEnergy;
	}

	/**
	 * @param ionizationEnergy the ionizationEnergy to set
	 */
	public void setIonizationEnergy(int ionizationEnergy) {
		this.ionizationEnergy = ionizationEnergy;
	}

	/**
	 * @return the electronAffinity
	 */
	public int getElectronAffinity() {
		return electronAffinity;
	}

	/**
	 * @param electronAffinity the electronAffinity to set
	 */
	public void setElectronAffinity(int electronAffinity) {
		this.electronAffinity = electronAffinity;
	}

	/**
	 * @return the oxidationStates
	 */
	public String getOxidationStates() {
		return oxidationStates;
	}

	/**
	 * @param oxidationStates the oxidationStates to set
	 */
	public void setOxidationStates(String oxidationStates) {
		this.oxidationStates = oxidationStates;
	}

	/**
	 * @return the standardState
	 */
	public String getStandardState() {
		return standardState;
	}

	/**
	 * @param standardState the standardState to set
	 */
	public void setStandardState(String standardState) {
		this.standardState = standardState;
	}

	/**
	 * @return the bondingType
	 */
	public String getBondingType() {
		return bondingType;
	}

	/**
	 * @param bondingType the bondingType to set
	 */
	public void setBondingType(String bondingType) {
		this.bondingType = bondingType;
	}

	/**
	 * @return the meltingPoint
	 */
	public int getMeltingPoint() {
		return meltingPoint;
	}

	/**
	 * @param meltingPoint the meltingPoint to set
	 */
	public void setMeltingPoint(int meltingPoint) {
		this.meltingPoint = meltingPoint;
	}

	/**
	 * @return the boilingPoint
	 */
	public int getBoilingPoint() {
		return boilingPoint;
	}

	/**
	 * @param boilingPoint the boilingPoint to set
	 */
	public void setBoilingPoint(int boilingPoint) {
		this.boilingPoint = boilingPoint;
	}

	/**
	 * @return the density
	 */
	public double getDensity() {
		return density;
	}

	/**
	 * @param density the density to set
	 */
	public void setDensity(double density) {
		this.density = density;
	}

	/**
	 * @return the groupBlock
	 */
	public String getGroupBlock() {
		return groupBlock;
	}

	/**
	 * @param groupBlock the groupBlock to set
	 */
	public void setGroupBlock(String groupBlock) {
		this.groupBlock = groupBlock;
	}

	/**
	 * @return the yearDiscovered
	 */
	public int getYearDiscovered() {
		return yearDiscovered;
	}

	/**
	 * @param yearDiscovered the yearDiscovered to set
	 */
	public void setYearDiscovered(int yearDiscovered) {
		this.yearDiscovered = yearDiscovered;
	}

	/**
	 * @return the block
	 */
	public String getBlock() {
		return block;
	}

	/**
	 * @param block the block to set
	 */
	public void setBlock(String block) {
		this.block = block;
	}

	/**
	 * @return the cpkHexColor
	 */
	public String getCpkHexColor() {
		return cpkHexColor;
	}

	/**
	 * @param cpkHexColor the cpkHexColor to set
	 */
	public void setCpkHexColor(String cpkHexColor) {
		this.cpkHexColor = cpkHexColor;
	}

	/**
	 * @return the period
	 */
	public int getPeriod() {
		return period;
	}

	/**
	 * @param period the period to set
	 */
	public void setPeriod(int period) {
		this.period = period;
	}

	/**
	 * @return the group
	 */
	public int getGroup() {
		return group;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(int group) {
		this.group = group;
	}

}
