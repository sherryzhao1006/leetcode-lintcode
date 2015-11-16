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
	public int compareVersion(String version1, String version2) {
        if(version1.length() == 0) return -1;
        if(version2.length() == 0) return 1;
        String[] sp1=version1.split("\\.");
        String[] sp2=version2.split("\\.");
        int index1=0,index2=0;
        
        while(index1<sp1.length && index2<sp2.length){
            int val1=Integer.parseInt(sp1[index1]);
            int val2=Integer.parseInt(sp2[index2]);
            if(val1 > val2){
                return 1;
            }else if(val1 <val2){
                return -1;
            }else{
                index1++;
                index2++;
            }
        }
        while(index1<sp1.length){
            if(Integer.parseInt(sp1[index1]) !=0)
                return 1;
            index1++;
        }
        while(index2<sp2.length){
            if(Integer.parseInt(sp2[index2]) !=0)
                return -1;
            index2++;
        }
        return 0; 
    }

}
