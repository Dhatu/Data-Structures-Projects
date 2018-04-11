
public class CarListNode {
	private Car data;
	private CarListNode next;
	private CarListNode prev;
	
	public CarListNode(Car initData){
	//Default constructor.
		try {
		if(initData == null){
			throw new IllegalArgumentException();
		}
		data = initData;
		next = null;
		prev = null;
		} catch(IllegalArgumentException x) {
			System.out.println("Data is null or non present at the moment.");
		}
	}
	public Car getData(){
		return data;
	}
	public CarListNode getprevLink()
		{
		return prev;
		}
	public CarListNode getnextLink()
	{
	return next;
	}
	public void setData(Car newData)
	{
	data = newData;
	}
	public void setprevLink(CarListNode newprev)
	{
	prev = newprev;
	}
	public void setnextLink(CarListNode newnext)
	{
	next = newnext;
	}
	
}
