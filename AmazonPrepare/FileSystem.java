mport java.util.ArrayList;


public class FileSystem {
	public abstract class Entry{
		protected Directory parent;
		protected long created;
		protected long lastUpdated;
		protected long lastAccessed;
		protected String name;
		
		public Entry(String n, Directory p){
			name = n;
			parent = p;
			created = System.currentTimeMillis();
			lastUpdated = System.currentTimeMillis();
			lastAccessed = System.currentTimeMillis();
		}
		
		public boolean delete(){
			if(parent == null){
				return false;
			}
			return parent.deleteEntry(this);
		}
		
		public abstract int size();
		
		public String getFullPath(){
			if(parent == null){
				return name;
			}else{
				return parent.getFullPath() + "/" + name;
			}
		}
		//getters and setters
		public long getCreateTime(){
			return created;
		}
		public long getLastUpdatedTime(){
			return lastUpdated;
		}
		public long getLastAccessedTime(){
			return lastAccessed;
		}
		public void changeName(String n){
			name = n;
		}
		public String getName(){
			return name;
		}
	}
	
	public class File extends Entry{
		private String content;
		private int size;
		public File(String n, Directory p, int sz){
			super(n, p);
			size = sz;
		}
		public int size(){
			return size;
		}
		public String getContent(){
			return content;
		}
		public void setContents(String c){
			content = c;
		}
	}
	
	public class Directory extends Entry{
		protected ArrayList<Entry> contents;
		public Directory(String n, Directory p){
			super(n, p);
			contents = new ArrayList<Entry>();
		}
		
		public int size(){
			int size = 0;
			for(Entry e : contents){
				size += e.size();
			}
			return size;
		}
		
		public int numberofFiles(){
			int count = 0;
			for(Entry e: contents){
				if(e instanceof File){
					count++;
				}else{
					count++; //directory counts as files
					Directory d = (Directory) e;
					count += d.numberofFiles();
				}
			}
			return count;
		}
		public boolean deleteEntry(Entry entry){
			return contents.remove(entry);
		}
		public boolean addEntry(Entry entry){
			return contents.add(entry);
		}
		protected ArrayList<Entry> getContents(){
			return contents;
		}
		
	}

}

