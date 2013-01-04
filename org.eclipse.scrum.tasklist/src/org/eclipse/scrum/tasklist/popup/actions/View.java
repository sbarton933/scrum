package org.eclipse.scrum.tasklist.popup.actions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.birt.report.model.api.DesignConfig;
import org.eclipse.birt.report.model.api.DesignEngine;
import org.eclipse.birt.report.model.api.ElementFactory;
import org.eclipse.birt.report.model.api.IDesignEngine;
import org.eclipse.birt.report.model.api.IDesignEngineFactory;
import org.eclipse.birt.report.model.api.ReportDesignHandle;
import org.eclipse.birt.report.model.api.SessionHandle;
import org.eclipse.birt.report.viewer.utilities.WebViewer;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.osgi.framework.Bundle;

public class View extends ViewPart {
  public static final String ID = "org.eclipse.scrum.tasklist.reportview";

public void createPartControl(Composite parent) {
    String path = "";
    try {
      Bundle bundle = Platform.getBundle("org.eclipse.scrum.tasklist");
      URL url = FileLocator.find(bundle, new Path("burnDownChart.rptdesign"), null);
      path = FileLocator.toFileURL(url).getPath();
    } catch (MalformedURLException me) {
      System.out.println("Fehler bei URL " + me.getStackTrace());
    } catch (IOException e) {
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
