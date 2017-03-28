package helpfully;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class StringUtiler {
	
	@Test
	public void commonUseLineSeparator(){
		System.getProperty("line.separator");
	}
	
	@Test
	public void 直接new出含元素的List(){
		List<String> l1 = new ArrayList<String>(Arrays.asList(new String[]{"s1","s2"}));
		System.out.println(l1.toString());
	}
}

/*通用换行符*/
//helpfully.StringUtiler.commonUseLineSeparator()