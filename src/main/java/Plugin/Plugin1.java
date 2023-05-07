package Plugin;
import Products.*;
import DatabaseService.*;
import PluginInterface.PluginInterface;
import BasePlugin.BlankPage;
import BasePlugin.BasePlugin;
import org.jfree.chart.*;
import org.jfree.data.general.*;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.ui.ApplicationFrame;
import java.io.IOException;
import Exception.ExtensionException;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;


public class Plugin1 implements BasePlugin {

    private CategoryDataset createDataset() {
        // DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        // dataset.addValue(1.0, "Row 1", "Column 1");
        // dataset.addValue(5.0, "Row 1", "Column 2");
        // dataset.addValue(3.0, "Row 1", "Column 3");
        // dataset.addValue(2.0, "Row 2", "Column 1");
        // dataset.addValue(3.0, "Row 2", "Column 2");
        // dataset.addValue(2.0, "Row 2", "Column 3");
        // return dataset;

        DatabaseService DB = new DatabaseService(new JsonService(ProductDB.class), "src/test/resources/data/Products.JSON");
        ProductDB products = null;
        try {
             products = (ProductDB) DB.loadData();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExtensionException e) {
            e.printStackTrace();
        }
        
        // define new array list of Double
        ArrayList<Double> priceList = new ArrayList<Double>();
        products.getProducts().forEach((k,v) -> {
            priceList.add(v.getPrice());
        });
        // get the min and max of priceList
        Double min = priceList.stream().min(Double::compare).get();
        Double max = priceList.stream().max(Double::compare).get();
        // define the range of the price
        Double range = max - min;
        // Calculate the number of intervals dynamically based on the data size
        int intervals = Math.min(10, priceList.size());

        // Calculate the interval size
        double intervalSize = range / intervals;
        // define the interval list
        ArrayList<Double> intervalList = new ArrayList<Double>();
        // define the interval count list
        ArrayList<Integer> intervalCountList = new ArrayList<Integer>();
        // define the interval name list
        for (int i = 0; i < intervals; i++) {
            intervalList.add(min + intervalSize * i);
            intervalCountList.add(0);
        }
        // count the number of products in each interval
        for (int i = 0; i < priceList.size(); i++) {
            for (int j = 0; j < intervals; j++) {
                if (priceList.get(i) >= intervalList.get(j) && priceList.get(i) < intervalList.get(j) + intervalSize) {
                    intervalCountList.set(j, intervalCountList.get(j) + 1);
                }
            }
        }
        // define the dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < intervals; i++) {
            dataset.addValue(intervalCountList.get(i), "Harga", intervalList.get(i));
        }
        return dataset;

    }

    private ChartPanel createLineChart(String text, CategoryDataset dataset){
         JFreeChart lineChart = ChartFactory.createLineChart(
         text,
         "Bulan","Jumlah Penjualan",
         dataset,
         PlotOrientation.VERTICAL,
         true,true,false);
        ChartPanel chartPanel = new ChartPanel( lineChart );
        return chartPanel;
    }

    private ChartPanel createBarChart(String text, CategoryDataset dataset){
        JFreeChart barChart = ChartFactory.createBarChart(
         text,
         "Range Harga",
         "Jumlah Produk",
         dataset,
         PlotOrientation.VERTICAL,
         true, true, false);
        ChartPanel chartPanel = new ChartPanel( barChart );
        return chartPanel;
    }

    @Override
    public void onLoad(){
        BlankPage newPage = new BlankPage();
        newPage.setTitle("Plugin 1");
        CategoryDataset dataset = createDataset();
        ChartPanel chart = createBarChart("Persebaran Product Price", dataset);
        // chart.pack();
        // chart.setVisible(true);

        ChartPanel lineChart = createLineChart("Penjualan Per Bulan", dataset);
        // lineChart.pack();
        // lineChart.setVisible(true);
        newPage.setGrid(1, 2);
        newPage.getPanel().add(chart);
        newPage.getPanel().add(lineChart);
        newPage.setVisible(true);
        System.out.println("Plugin 2 loaded");
    }

}