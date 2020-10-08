package model;

public class Pipeline {

	private String idX;
	private String idY;
	private String length;

	public Pipeline(String idX, String idY, String length) {
		this.idX = idX;
		this.idY = idY;
		this.length = length;
	}

	public Pipeline() {
	}

	public String getIdX() {
		return idX;
	}

	public void setIdX(String idX) {
		this.idX = idX;
	}

	public String getIdY() {
		return idY;
	}

	public void setIdY(String idY) {
		this.idY = idY;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "Pipeline [idX=" + idX + ", idY=" + idY + ", length=" + length + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idX == null) ? 0 : idX.hashCode());
		result = prime * result + ((idY == null) ? 0 : idY.hashCode());
		result = prime * result + ((length == null) ? 0 : length.hashCode());
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
		Pipeline other = (Pipeline) obj;
		if (idX == null) {
			if (other.idX != null)
				return false;
		} else if (!idX.equals(other.idX))
			return false;
		if (idY == null) {
			if (other.idY != null)
				return false;
		} else if (!idY.equals(other.idY))
			return false;
		if (length == null) {
			if (other.length != null)
				return false;
		} else if (!length.equals(other.length))
			return false;
		return true;
	}

}
