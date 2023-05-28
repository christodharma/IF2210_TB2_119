package Plugin;

import BasePlugin.BasePlugin;
import BasePlugin.BlankPage;
import Database.DatabaseService.DatabaseService;
import Database.DatabaseService.JsonService;
import Database.Memberships.MemberDB;
import Exception.Database.ExtensionException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import java.io.IOException;

public class Plugin2 implements BasePlugin {

    @Override
    public void onLoad() {
        BlankPage newPage = new BlankPage();
        DatabaseService DB = new DatabaseService(new JsonService(MemberDB.class), "src/test/resources/data/Members.JSON");
        MemberDB members = null;
        try {
             members = (MemberDB) DB.loadData();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExtensionException e) {
            e.printStackTrace();
        }
        
        if (members != null) {
            DefaultPieDataset dataset = new DefaultPieDataset();
            dataset.setValue("Member", members.toArrayList().size());
            newPage.setTitle("Plugin 2");
            // Create the pie chart
            JFreeChart chart = ChartFactory.createPieChart("Pie Chart Insight", dataset, true, true, false);
            
            // Create a chart panel to hold the chart
            ChartPanel chartPanel = new ChartPanel(chart);
            
            // Add the chart panel to the container panel
            newPage.getPanel();
            newPage.getPanel().add(chartPanel);
            newPage.setVisible(true);

            System.out.println("Plugin 2 loaded");
        }

    }

}
