package String;
/**
 * Compare two version numbers version1 and version1.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise
 * return 0.
 * 
 * You may assume that the version strings are non-empty and contain only
 * digits and the . character.
 * The . character does not represent a decimal point and is used to separate
 * number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it
 * is the fifth second-level revision of the second first-level revision.
 * 
 * Here is an example of version numbers ordering:
 * 
 * 0.1 < 1.1 < 1.2 < 13.37
 * 
 * Tags: String
 */
public class CompareVersionNums {

	public static void main(String[] args) {
        String v1 = "001.3.3.7.000";
        String v2 = "1.3.3.7";
        System.out.println(compareVersion(v1, v2));
    }
	public static int compareVersion(String version1, String version2){
		String[] level1=version1.split("\\.");
		String[] level2=version2.split("\\.");
		int length=Math.max(level1.length, level2.length);
		int i;
		for(i=0;i<length;++i){
			Integer a=i<level1.length?Integer.parseInt(level1[i]):0;
			Integer b= i<level2.length? Integer.parseInt(level2[i]):0;
			if(a!=b){
				return a>b?1:-1;
			}
		}
		return 0;
	}

}
