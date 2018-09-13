package cct.poly;

/**
 * <p>Title: Molecular Structure Viewer/Editor</p>
 *
 * <p>Description: Computational Chemistry Toolkit</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ANU</p>
 *
 * @author Dr. V. Vasilyev
 * @version 1.0
 */
public class CORNERELEMENT {
   /* list of corners */
   int i, j, k; /* corner id */
   float value; /* corner value */
   public CORNERELEMENT(int _i, int _j, int _k, float _value) {
      i = _i;
      j = _j;
      k = _k;
      value = _value;
   }

   public CORNERELEMENT() {
   }
}
