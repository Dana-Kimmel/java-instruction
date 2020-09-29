
public class Sheep extends Animal implements Cloneable {
//fields
	String name;

	// constructors
	public Sheep() {
		name = "";
	}

	//
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getCountString() {
		return getCount() + " " + name;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
