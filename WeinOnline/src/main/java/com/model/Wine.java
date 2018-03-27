package com.model;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity(name="Wine")
@Table(name="wine")
public class Wine implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8186475807148688588L;
	/*
	 * Defining beans variables
	 * */
	@Id
	@GeneratedValue
	private long id;
	private String wineCode;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_Winecategory")
	private WineCategory wineCategory;
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the wineCode
	 */
	public String getWineCode() {
		return wineCode;
	}

	/**
	 * @param wineCode the wineCode to set
	 */
	public void setWineCode(String wineCode) {
		this.wineCode = wineCode;
	}

	private String wineName;
	private String wineDescription;
	private double wineUnitPrice;
	private double wineSize;
	private double alcoolContent;
	private int numberPerPackage;
	private String wineColor;
	
	/* Default Constructor*/
	public Wine() {
		super();
	}

	public Wine(WineCategory wineCategory, String windeCode, String wineName, String wineDescription, double wineUnitPrice,
			double wineSize, double alcoolContent, int numberPerPackage, String wineColor) {
		super();
		this.wineCategory = wineCategory;
		this.wineCode = windeCode;
		this.wineName = wineName;
		this.wineDescription = wineDescription;
		this.wineUnitPrice = wineUnitPrice;
		this.wineSize = wineSize;
		this.alcoolContent = alcoolContent;
		this.numberPerPackage = numberPerPackage;
		this.wineColor = wineColor;
	}

	public WineCategory getWineCategory() {
		return wineCategory;
	}

	public void setWineCategory(WineCategory wineCategory) {
		this.wineCategory = wineCategory;
	}

	

	

	public String getWineName() {
		return wineName;
	}

	public void setWineName(String wineName) {
		this.wineName = wineName;
	}

	public String getWineDescription() {
		return wineDescription;
	}

	public void setWineDescription(String wineDescription) {
		this.wineDescription = wineDescription;
	}

	public double getWineUnitPrice() {
		return wineUnitPrice;
	}

	public void setWineUnitPrice(double wineUnitPrice) {
		this.wineUnitPrice = wineUnitPrice;
	}

	public double getWineSize() {
		return wineSize;
	}

	public void setWineSize(double wineSize) {
		this.wineSize = wineSize;
	}

	public double getAlcoolContent() {
		return alcoolContent;
	}

	public void setAlcoolContent(double alcoolContent) {
		this.alcoolContent = alcoolContent;
	}

	public int getNumberPerPackage() {
		return numberPerPackage;
	}

	public void setNumberPerPackage(int numberPerPackage) {
		this.numberPerPackage = numberPerPackage;
	}

	public String getWineColor() {
		return wineColor;
	}

	public void setWineColor(String wineColor) {
		this.wineColor = wineColor;
	}

	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(alcoolContent);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + numberPerPackage;
		result = prime * result + ((wineCode == null) ? 0 : wineCode.hashCode());
		result = prime * result + ((wineCategory == null) ? 0 : wineCategory.hashCode());
		result = prime * result + ((wineColor == null) ? 0 : wineColor.hashCode());
		result = prime * result + ((wineDescription == null) ? 0 : wineDescription.hashCode());
		result = prime * result + ((wineName == null) ? 0 : wineName.hashCode());
		temp = Double.doubleToLongBits(wineSize);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(wineUnitPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Wine))
			return false;
		Wine other = (Wine) obj;
		if (Double.doubleToLongBits(alcoolContent) != Double.doubleToLongBits(other.alcoolContent))
			return false;
		if (numberPerPackage != other.numberPerPackage)
			return false;
		if (wineCode == null) {
			if (other.wineCode != null)
				return false;
		} else if (!wineCode.equals(other.wineCode))
			return false;
		if (wineCategory == null) {
			if (other.wineCategory != null)
				return false;
		} else if (!wineCategory.equals(other.wineCategory))
			return false;
		if (wineColor == null) {
			if (other.wineColor != null)
				return false;
		} else if (!wineColor.equals(other.wineColor))
			return false;
		if (wineDescription == null) {
			if (other.wineDescription != null)
				return false;
		} else if (!wineDescription.equals(other.wineDescription))
			return false;
		if (wineName == null) {
			if (other.wineName != null)
				return false;
		} else if (!wineName.equals(other.wineName))
			return false;
		if (Double.doubleToLongBits(wineSize) != Double.doubleToLongBits(other.wineSize))
			return false;
		if (Double.doubleToLongBits(wineUnitPrice) != Double.doubleToLongBits(other.wineUnitPrice))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Wine [windeCode=" + wineCode + ", wineCategory=" + wineCategory + ", wineName=" + wineName
				+ ", wineDescription=" + wineDescription + ", wineUnitPrice=" + wineUnitPrice + ", wineSize=" + wineSize
				+ ", alcoolContent=" + alcoolContent + ", numberPerPackage=" + numberPerPackage + ", wineColor="
				+ wineColor + "]";
	}
	
	
	
	
	

}
