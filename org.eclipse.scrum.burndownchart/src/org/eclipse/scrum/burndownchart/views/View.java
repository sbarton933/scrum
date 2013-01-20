package org.eclipse.scrum.burndownchart.views;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.ReportEngine;
import org.eclipse.birt.report.model.api.DataSetHandle;
import org.eclipse.birt.report.model.api.DesignConfig;
import org.eclipse.birt.report.model.api.DesignElementHandle;
import org.eclipse.birt.report.model.api.ElementFactory;
import org.eclipse.birt.report.model.api.IDesignEngine;
import org.eclipse.birt.report.model.api.IDesignEngineFactory;
import org.eclipse.birt.report.model.api.ReportDesignHandle;
import org.eclipse.birt.report.model.api.ScriptDataSetHandle;
import org.eclipse.birt.report.model.api.ScriptDataSourceHandle;
import org.eclipse.birt.report.model.api.SessionHandle;
import org.eclipse.birt.report.model.api.StructureFactory;
import org.eclipse.birt.report.viewer.utilities.WebViewer;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecp.scrum.sprinthistory.GetSprintHistory;
import org.eclipse.emf.ecp.scrum.sprinthistory.SprintStoryPoints;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.osgi.framework.Bundle;

public class View extends ViewPart {
  public static final String ID = "org.eclipse.scrum.burndownchart.reportview";

public void createPartControl(Composite parent) {
    String path = "";
    try 
    {
      Bundle bundle = Platform.getBundle("org.eclipse.scrum.burndownchart");
      URL url = FileLocator.find(bundle, new Path("burnDownChart.rptdesign"), null);
      path = FileLocator.toFileURL(url).getPath();
    } 
    catch (MalformedURLException me) 
    {
      System.out.println("Fehler bei URL " + me.getStackTrace());
    } 
    catch (IOException e) 
    {
      e.printStackTrace();
    } 
    
    try 
    {
	    String birtHome = "F:/Projects/Eclipse Plugin/Runtime/birt-runtime-4_2_1/ReportEngine";	    
	    EngineConfig engineConfig = new EngineConfig();
	    engineConfig.setBIRTHome(birtHome);	   
		org.eclipse.birt.core.framework.Platform.startup(engineConfig);	
	    ReportEngine re = new ReportEngine(engineConfig); 
	    IReportRunnable design =  re.openReportDesign(path);
	    
	    
	    DesignConfig config = new DesignConfig( );
        config.setBIRTHome("F:/Projects/Eclipse Plugin/Runtime/birt-runtime-4_2_1/ReportEngine");
	    IDesignEngine engine = null;
        try{

            IDesignEngineFactory factory = (IDesignEngineFactory) org.eclipse.birt.core.framework.Platform.createFactoryObject( IDesignEngineFactory.EXTENSION_DESIGN_ENGINE_FACTORY );
            engine = factory.createDesignEngine( config );

        }catch( Exception ex){
            ex.printStackTrace();
        }    
        SessionHandle session = engine.newSessionHandle( null ) ;
        ReportDesignHandle designHandle = null;
        ElementFactory designFactory = null;
        StructureFactory structFactory = null;  
        designHandle = session.openDesign(path);
        designFactory = designHandle.getElementFactory( );
        DataSetHandle dataSet = designHandle.findDataSet("Data Set");
        String dataSetName = dataSet.getName();
                    
        
        DesignElementHandle chart = designHandle.findElement("BurnDownChart");
        ScriptDataSourceHandle dataSourceHandle = (ScriptDataSourceHandle) designHandle.findDataSource("Data Source");
        ScriptDataSetHandle dataSetHandle = (ScriptDataSetHandle) designHandle.findDataSet("Data Set");
        
        // Set open( ) in code
        List<SprintStoryPoints> tempStoryPoints= GetSprintHistory.getInstance().getDataSetForBurnDownChart();
        //Shakti's Comment
        //get list of getsprint history from the interface getDataSetForBurnDownChart in GetSprintHistory.java source file
        
        for (SprintStoryPoints sprintStoryPoints : tempStoryPoints) {
        	
        	System.out.println("Date for Sprint is: "+sprintStoryPoints.getDateEnteredForSprint() + "--> "+ " Story points are :"+ sprintStoryPoints.getPerSprintStoryPoints());
        	
			
		}
        
        
    	dataSetHandle.setOpen( "i=0;"
    	+ "sourcedata = new Array( new Array(2), new Array(2), new Array(2), new Array(2), new Array(2), new Array(2), new Array(2), new Array(2), new Array(2));"
    	+ "sourcedata[0][0] = 1000; "
    	+ "sourcedata[0][1] = \"Day 1\";"
    	+ "sourcedata[1][0] = 900; "
    	+ "sourcedata[1][1] = \"Day 2\";"
    	+ "sourcedata[2][0] = 800; "
    	+ "sourcedata[2][1] = \"Day 3\";"
    	+ "sourcedata[3][0] = 700; "
    	+ "sourcedata[3][1] = \"Day 4\";"
    	+ "sourcedata[4][0] = 600; "
    	+ "sourcedata[4][1] = \"Day 5\";"
    	+ "sourcedata[5][0] = 500; "
    	+ "sourcedata[5][1] = \"Day 6\";"
    	+ "sourcedata[6][0] = 400; "
    	+ "sourcedata[6][1] = \"Day 7\";"
    	+ "sourcedata[7][0] = 300; "
    	+ "sourcedata[7][1] = \"Day 8\";"
    	+ "sourcedata[8][0] = 200; "
    	+ "sourcedata[8][1] = \"Day 9\";" );
        
    	// Set fetch( ) in code
    	
    	dataSetHandle.setFetch( "if ( i < 9 ){"
    	+ "row[\"StoryPoint\"] = sourcedata[i][0];"
    	+ "row[\"Day\"] = sourcedata[i][1];"
    	+ "i++;"
    	+ "return true;}" + "else return false;" );
         
    	
        
        designHandle.saveAs( path ); 
        designHandle.close( );
		
	} 
    catch (Exception e) 
    {
		e.printStackTrace();
	}
    
        
    
    
    Browser browser = new Browser(parent, SWT.NONE);
    // Use the filename of your report
    WebViewer.display(path, WebViewer.HTML, browser, "frameset");
    
  }

  
/**
   * Passing the focus request to the viewer's control.
   */

  public void setFocus() {
  }
} 
