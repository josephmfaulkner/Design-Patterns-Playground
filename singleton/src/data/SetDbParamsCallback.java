package data;

import java.sql.PreparedStatement;

public interface SetDbParamsCallback {
	public void call(PreparedStatement stmt);
}
