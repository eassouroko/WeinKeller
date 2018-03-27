package com.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="WinwCategory")
@Table(name="winecategory")

public class WineCategory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1502520594906540485L;
	
	@Id
	@GeneratedValue
	private long id;
	private String categoryDescription;
	@OneToMany
	@JoinColumn(name = "fk_Winecategory")
	private java.util.Set<Wine> wineList;
	


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

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public java.util.Set<Wine> getWineList() {
		return wineList;
	}

	public void setWineList(java.util.Set<Wine> wineList) {
		this.wineList = wineList;
	}

	public WineCategory() {
		super();
	}

	public WineCategory(String categoryDescription) {
		super();
		//this.catId = catId;
		this.categoryDescription = categoryDescription;
		//this.wineList = wineList;
		wineList= new HashSet<Wine>();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((categoryDescription == null) ? 0 : categoryDescription.hashCode());
		result = prime * result + ((wineList == null) ? 0 : wineList.hashCode());
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
		if (!(obj instanceof WineCategory))
			return false;
		WineCategory other = (WineCategory) obj;
		if (id != other.id)
			return false;
		if (categoryDescription == null) {
			if (other.categoryDescription != null)
				return false;
		} else if (!categoryDescription.equals(other.categoryDescription))
			return false;
		if (wineList == null) {
			if (other.wineList != null)
				return false;
		} else if (!wineList.equals(other.wineList))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WineCategory [catId=" + id + ", categoryDescription=" + categoryDescription + ", wineList="
				+ wineList + "]";
	}
	
	

}
