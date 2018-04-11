//My own API
public class PackageNode {
	private Package shipment;
	private PackageNode next;
	
	public PackageNode(Package initData){
	//Default constructor.
		try {
			if(initData == null){
				throw new IllegalArgumentException();
			}
			shipment = initData;
			next = null;
			} catch(IllegalArgumentException x) {
				System.out.println("Data is null or non present at the moment.");
			}
	}
	public Package getData(){
		return shipment;
	}

	public PackageNode getnextLink()
	{
	return next;
	}
	public void setData(Package newData)
	{
		shipment = newData;
	}

	public void setnextLink(PackageNode newnext)
	{
	next = newnext;
	}
}
