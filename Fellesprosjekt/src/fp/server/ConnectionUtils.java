package fp.server;

import java.io.BufferedWriter;
import java.io.IOException;

public class ConnectionUtils {
	public static void flush(BufferedWriter output) throws IOException{
		output.newLine();
		output.flush();
	}
}
