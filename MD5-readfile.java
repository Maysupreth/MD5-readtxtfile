
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ass2_5809610206 {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		int cnt = 62;
		int count = 0;
		String ans = "";
		String hashValue = "acf06cdd9c744f969958e1f085554c8b";
		//String hashValue = "f99ed467ccc5617a505506c7c84a945a";
		String[] a = new String[cnt];
		String[] b = new String[cnt];
		String[] c = new String[cnt];
		String[] d = new String[cnt];

		for (int i = 0; i < cnt; i++) {
			if (i >= 0 && i <= 9) {
				a[i] = i + "";
			} else if (i > 9 && i <= 35) {
				a[i] = String.valueOf(Character.toChars(i + 55));
			} else if (i > 35 && i <= 62) {
				a[i] = String.valueOf(Character.toChars(i + 61));
			}
		}

		MessageDigest msgDi = MessageDigest.getInstance("MD5");

		for (int i = 0; i < cnt; i++) {
			for (int j = 0; j < cnt; j++) {
				for (int k = 0; k < cnt; k++) {
					for (int l = 0; l < cnt; l++) {
						ans = a[i] + a[j] + a[k] + a[l];
						String result = ans;
						msgDi.update(ans.getBytes());
						BigInteger hash = new BigInteger(1, msgDi.digest());
						result = hash.toString(16);
						while (result.length() < 32) {
							result = "0" + result;
						}
						count++;
						if (result.equalsIgnoreCase(hashValue)) {
							System.out.println("% crackpwd file");
							System.out.println("compare " + count + " times");
							System.out.println("password is \"" + ans + "\"");
						}
					}
				}
			}
		}

	}
}
