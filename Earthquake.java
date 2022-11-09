
public class Earthquake {
	private String dateTime;
	private double depth;
	private double lng;
	private String src;
	private String eqid;
	private double magnitude;
	private double lat;
	
	public Earthquake(String dateTime, double depth, double lng, String src, String eqid, double magnitude,
			double lat) {
		super();
		this.dateTime = dateTime;
		this.depth = depth;
		this.lng = lng;
		this.src = src;
		this.eqid = eqid;
		this.magnitude = magnitude;
		this.lat = lat;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public double getDepth() {
		return depth;
	}

	public void setDepth(double depth) {
		this.depth = depth;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getEqid() {
		return eqid;
	}

	public void setEqid(String eqid) {
		this.eqid = eqid;
	}

	public double getMagnitude() {
		return magnitude;
	}

	public void setMagnitude(double magnitude) {
		this.magnitude = magnitude;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	@Override
	public String toString() {
		return "dateTime=" + dateTime + ", depth=" + depth + ", lng=" + lng + ", src=" + src + ", eqid="
				+ eqid + ", magnitude=" + magnitude + ", lat=" + lat;
	}
	
	

}
