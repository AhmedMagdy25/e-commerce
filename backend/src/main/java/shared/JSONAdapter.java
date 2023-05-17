package shared;
import java.util.List;

import com.google.gson.Gson;

public class JSONAdapter {
	private Gson gson = new Gson();
	
	public String toJSON(List<? extends Object> data) {
		String json = this.gson.toJson(data);
		return json;
	}
}
