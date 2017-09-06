/*
 * Copyright (C) 2014, United States Government, as represented by the
 * Administrator of the National Aeronautics and Space Administration.
 * All rights reserved.
 *
 * The Java Pathfinder core (jpf-core) platform is licensed under the
 * Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0. 
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 */
package gov.nasa.jpf.vm;

import gov.nasa.jpf.annotation.MJI;
import gov.nasa.jpf.vm.ClassInfo;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.NativePeer;


/**
 * MJI NativePeer class for java.lang.StringBuffer library abstraction
 */
public class JPF_java_lang_StringBuffer extends NativePeer {
  
  boolean hasSharedField = false; // Java 1.4 has, 1.5 doesn't

  @MJI
  public void $clinit____V (MJIEnv env, int clsObjRef) {
    // apparently, Java 1.5 has changed the implementation of class
    // StringBuffer so that it doesn't use the 'shared' state anymore
    // (which was a performance hack to avoid copying the char array
    // data when creating String objects from subsequently unmodified
    // StringBuffers
    // adding this little extra logic here also serves the purpose of
    // avoiding a native ObjectStreamClass method which is called during
    // the static StringBuffer init
    ClassInfo ci = env.getClassInfo();
    if (ci.getInstanceField("shared") != null) {
      hasSharedField = true;
    }
  }

}

