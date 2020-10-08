package model;

public class Route {

	private String idA;
	private String idB;

	public String getIdA() {
		return idA;
	}

	public void setIdA(String idA) {
		this.idA = idA;
	}

	public String getIdB() {
		return idB;
	}

	public void setIdB(String idB) {
		this.idB = idB;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idA == null) ? 0 : idA.hashCode());
		result = prime * result + ((idB == null) ? 0 : idB.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Route other = (Route) obj;
		if (idA == null) {
			if (other.idA != null)
				return false;
		} else if (!idA.equals(other.idA))
			return false;
		if (idB == null) {
			if (other.idB != null)
				return false;
		} else if (!idB.equals(other.idB))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Route [idA=" + idA + ", idB=" + idB + "]";
	}

	public Route(String idA, String idB) {
		this.idA = idA;
		this.idB = idB;
	}

	public Route() {
	}

}
