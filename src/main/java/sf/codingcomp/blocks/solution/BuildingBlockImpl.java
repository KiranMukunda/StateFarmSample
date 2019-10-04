package sf.codingcomp.blocks.solution;

import java.util.ArrayList;
import java.util.Iterator;

import sf.codingcomp.blocks.BuildingBlock;

public class BuildingBlockImpl implements BuildingBlock {
	private BuildingBlockImpl under;
	private BuildingBlockImpl over;
	private boolean flag = false; 
	
    @Override
    public Iterator<BuildingBlock> iterator() {
    	BuildingBlockImpl c1 = this;
    	BuildingBlockImpl cursor,prev;
    	prev = null;
    	cursor = null;
    	cursor = c1;
    	while (cursor.under != null) {
//    		prev = cursor.under;
    		cursor = cursor.under;
    	}
//    	cursor = cursor.under;
//    	cursor.over = prev;
    	
    	final BuildingBlockImpl ctemp = cursor;
        // TODO Auto-generated method stub
    	 Iterator<BuildingBlock> it = new Iterator<BuildingBlock>() {
			 
             @Override
             public boolean hasNext() {
            	 if(ctemp.over != null) {
            		 return true;
            	 }
            	 else {
            		 return false;
            	 }
//                 return cursor.over != null;
             }

             @Override
             public BuildingBlock next() {
            	 BuildingBlockImpl ret;
            	 ret = ctemp;
            	 ctemp = ctemp.over;
                 return ret;
             }

             @Override
             public void remove() {
                 throw new UnsupportedOperationException();
             }
         };
         return it;
    }

    @Override
    public void stackOver(BuildingBlock b) {
        if (b != null) {
        	this.under = (BuildingBlockImpl)b;
        	BuildingBlockImpl tmp = (BuildingBlockImpl)b;
        	tmp.over = this;
        	
        }
        
        
    }

    @Override
    public void stackUnder(BuildingBlock b) {
    	if (b != null) {
        	this.over = (BuildingBlockImpl)b;
        	BuildingBlockImpl tmp = (BuildingBlockImpl)b;
        	tmp.under = this;
        }
        
    }

    @Override
    public BuildingBlock findBlockUnder() {
        // TODO Auto-generated method stub
        if (this.under != null)
        {
        	return this.under;
        }
        else
        {
        	return null;
        }
    }

    @Override
    public BuildingBlock findBlockOver() {
        // TODO Auto-generated method stub
    	if (this.over != null)
        {
        	return this.over;
        }
        else
        {
        	return null;
        }
    }

}
