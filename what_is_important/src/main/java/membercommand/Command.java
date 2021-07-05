package membercommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	public abstract String excute(HttpServletRequest request, HttpServletResponse response);
}
