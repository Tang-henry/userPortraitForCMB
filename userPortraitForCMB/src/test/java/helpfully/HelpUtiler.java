package helpfully;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class HelpUtiler {
	
	@Test
	public void forMap(){
		Map<String, String> map = new HashMap<String, String>();
		
		/*键值都需要*/
		for (Map.Entry<String, String> entry : map.entrySet()) {
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
		
		/*只取键*/
		for (String key : map.keySet()) {  
		    System.out.println("Key = " + key);  
		} 
		
		/*只取值*/
		for (String value : map.values()) {  
		    System.out.println("Value = " + value);  
		}  
	}
	
	@Test
	public void doDelWhenFor(){
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1,"one");  
        map.put(2,"two");  
        map.put(3,"three");  
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();  
        while(it.hasNext()){  
            Map.Entry<Integer, String> entry=it.next();  
            int key=entry.getKey();  
            System.out.println("map key value:"+key+ " "+entry.getValue());
            it.remove();
        }  
        
        System.out.println("map.size():"+map.size());
        
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        
        Iterator<Integer> listIterator = list.iterator();
        
        while (listIterator.hasNext()) {   
        	Integer value = listIterator.next();
            System.out.println("list value:"+value);
            listIterator.remove();
        }
        
        System.out.println("list.size():"+list.size());
	}
}

/*遍历map*/
//helpfully.HelpUtiler.forMap()

/*遍历map list时移除*/
//helpfully.HelpUtiler.doDelWhenFor()