/**
* @author corina pasareanu corina.pasareanu@sv.cmu.edu
*
*/

package gov.nasa.jpf.vm;
import gov.nasa.jpf.annotation.MJI;

public class JPF_java_lang_String extends NativePeer {
	  @MJI
	  public int intern____Ljava_lang_String_2 (MJIEnv env, int ref) {
	    return ref;
	  }
	  
	  @MJI
	  public int format__Ljava_lang_String_2_3Ljava_lang_Object_2__Ljava_lang_String_2 (MJIEnv env, int clsObjRef, int fmtRef, int argRef) {
	    System.err.println("Warning: String formatting ignored!");
	    return fmtRef;
	  }

	  @MJI
	  public int format__Ljava_util_Locale_2Ljava_lang_String_2_3Ljava_lang_Object_2__Ljava_lang_String_2 (MJIEnv env, int clsObjRef, int locRef, int fmtRef, int argRef) {
		  System.err.println("Warning: String formatting ignored!");
		  return fmtRef;
	  }
}
