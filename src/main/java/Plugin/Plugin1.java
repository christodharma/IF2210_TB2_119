package Plugin;

import BasePlugin.BasePlugin;
import BasePlugin.BlankPage;
import Database.DatabaseService.DatabaseService;
import Database.DatabaseService.XmlService;
import Database.Product.ProductDB;
import Exception.Database.ExtensionException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.IOException;
import java.util.ArrayList;


public class Plugin1 implements BasePlugin {

    private CategoryDataset createDataset() {
        DatabaseService DB = new DatabaseService(new XmlService(ProductDB.class), "src/test/resources/data/Product.xml");
        ProductDB products = null;
        try {
            products = (ProductDB) DB.loadData();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExtensionException e) {
            e.printStackTrace();
        }
    
        if (products == null) {
            System.out.println("ProductDB is null");
        } else {
            System.out.println("ProductDB is not null");
        }

        assert products != null;
        products.toArrayList().forEach((v) -> System.out.println(v.getPrice()));
        // define new array list of Double
        ArrayList<Double> priceList = new ArrayList<Double>();
        System.out.println(products.toArrayList().size());
        // get the min and max of priceList
        priceList.forEach(p -> System.out.println(p));
        Double min = priceList.stream().min(Double::compare).orElse(0.0);
        Double max = priceList.stream().max(Double::compare).orElse(0.0);
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
    public void onLoad() {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Plugin1 plugin = new Plugin1();
        plugin.onLoad();
    }


}