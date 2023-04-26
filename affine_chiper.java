/*name=om bhardwaj
 * class = 2241023
 * reg no =2241002151
 * branch = cse
 * date = 5/02/2023
 */
import java.io.*;
public class affine_chiper {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter Plain Text :");
		String pltxt = in.readLine();
		System.out.println("Enter key 1 and key 2:");
		int k1 = Integer.parseInt(in.readLine());
		int k2 = Integer.parseInt(in.readLine());
		System.out.println(encrypt(pltxt,k1,k2));
		System.out.print("Enter Chiper Text :");
		String cptxt = in.readLine();
		System.out.println("Enter key 1 and key 2:");
		int k3 = Integer.parseInt(in.readLine());
		int k4 = Integer.parseInt(in.readLine());
		System.out.println(decrypt(cptxt,k3,k4));
	}
	public static String encrypt(String plaintext, int key1, int key2) {
		plaintext = plaintext.toLowerCase();
		String chipertext = "";
		for(int i=0; i < plaintext.length(); i++) {
			char ch = plaintext.charAt(i);
			char new_ch = (char)(((((int)ch-97)*key1 + key2)%26)+97);
			chipertext = chipertext + new_ch;
		}
		return chipertext;
	}
	public static String decrypt(String chipertext, int key1, int key2) {
		chipertext = chipertext.toLowerCase();
		String plaintext = "";
		int mul_inv = multiplicativeInverse((int)key1,26);
		for(int i=0; i < chipertext.length(); i++) {
			char ch = chipertext.charAt(i);
			char new_ch=' ';
			int x= (int)ch-97-key2;
			if(x < 0)
				new_ch = (char)((26%((x*mul_inv)))+97);
			else
				new_ch = (char)(((x*mul_inv)%26)+97);
			plaintext = plaintext + new_ch;
		}
		return plaintext;
	}
	static int multiplicativeInverse(int a, int mod) {
		for(int i=0; i<mod; i++) {
			if((a*i)%mod == 1)
				return i;
		}
		return-1;
	}
}