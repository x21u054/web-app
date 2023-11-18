package bo;

import java.util.UUID;

import org.mindrot.jbcrypt.BCrypt;

public class Utility {
	// パスワードのハッシュ化とソルトの生成
	public static String hashPassword(String plainPassword) {
	    String salt = BCrypt.gensalt(); // ランダムなソルトを生成
	    String hashedPassword = BCrypt.hashpw(plainPassword, salt); // パスワードをハッシュ化
	    return hashedPassword;
	}

	// パスワードの検証
	public static boolean verifyPassword(String plainPassword, String hashedPassword) {
	    return BCrypt.checkpw(plainPassword, hashedPassword);
	}
	
	//トークンの生成
	public static String generateAuthToken() {
		// ランダムなUUIDを生成
		UUID uuid = UUID.randomUUID();
		String authToken = uuid.toString();
		return authToken;
	}
}
