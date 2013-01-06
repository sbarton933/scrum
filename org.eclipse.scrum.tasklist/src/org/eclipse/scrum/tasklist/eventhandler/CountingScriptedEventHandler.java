package org.eclipse.scrum.tasklist.eventhandler;

import org.eclipse.birt.report.engine.api.script.IUpdatableDataSetRow;
import org.eclipse.birt.report.engine.api.script.ScriptException;
import org.eclipse.birt.report.engine.api.script.eventadapter.ScriptedDataSetEventAdapter;
import org.eclipse.birt.report.engine.api.script.instance.IDataSetInstance;

public class CountingScriptedEventHandler extends ScriptedDataSetEventAdapter{

	int count = 0;	
	
	@Override
	public boolean fetch(IDataSetInstance dataSet, IUpdatableDataSetRow row) {
		
		try 
		{
	        if (count < 10)
	        {
	            row.setColumnValue("count", count);
	        
	            count++;
	        
	            return true;
	        }
	    } 
		catch (ScriptException e) 
		{
	        e.printStackTrace();
	    }

	    try {
			return super.fetch(dataSet, row);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
	}

	@Override
	public void open(IDataSetInstance dataSet) {
		try {
			super.open(dataSet);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
