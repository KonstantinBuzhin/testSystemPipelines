package model;

import java.util.List;
import java.util.Vector;

public class Result {

	private String existing;
	private String minLength;

	public String getExisting() {
		return existing;
	}

	public void setExisting(String existing) {
		this.existing = existing;
	}

	public String getMinLength() {
		return minLength;
	}

	public void setMinLength(String minLength) {
		this.minLength = minLength;
	}

	public Result() {
	}

	public Result(String existing, String minLength) {
		this.existing = existing;
		this.minLength = minLength;
	}

	@Override
	public String toString() {
		return "Result [existing=" + existing + ", minLength=" + minLength + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((existing == null) ? 0 : existing.hashCode());
		result = prime * result + ((minLength == null) ? 0 : minLength.hashCode());
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
		Result other = (Result) obj;
		if (existing == null) {
			if (other.existing != null)
				return false;
		} else if (!existing.equals(other.existing))
			return false;
		if (minLength == null) {
			if (other.minLength != null)
				return false;
		} else if (!minLength.equals(other.minLength))
			return false;
		return true;
	}

	public List<String> getValues() {
		Vector<String> values = new Vector<String>();
		values.add(existing);
		values.add(minLength);
		return values;
	}
}
