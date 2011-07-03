

public class UserWord {
	public String meaning;
	
	private List<Object> list;
	private String title;

	public boolean immediate;

	public UserWord(String title,String meaning,List<Object> list){
		this.title = title;
		this.meaning = meaning;
		this.list = list;
	}

	public String toString(){
		return this.title;
	}

	public List<Object> toArray(){
		List<Object> list = new List<Object>();
	
		for(Object obj : this.list)
		{
			if (obj instanceof UserWord) {
				UserWord new_name = (UserWord) obj;
				list.addAll(new_name.toArray());
			}
			else list.add(obj);
		}
		return list;
	}
}
