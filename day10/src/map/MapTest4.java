package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.kbstar.dto.UserDTO;

public class MapTest4 {

	public static void main(String[] args) {
		Map<String, UserDTO> db = new HashMap<String, UserDTO>();
		
		db.put("id01", new UserDTO("id01", "pw01", "james1"));
		db.put("id02", new UserDTO("id02", "pw02", "james2"));
		db.put("id03", new UserDTO("id03", "pw03", "james3"));
		
		db.get("id02");
		UserDTO u = db.get("id02");
		System.out.println(u);
		
		UserDTO uu = new UserDTO("id02", "pw002", "james22");
		db.put(uu.getId(), uu);
		
		Collection<UserDTO> col = db.values();
		
		for(UserDTO user:col) {
			System.out.println(user);
		}
	}
	

}
