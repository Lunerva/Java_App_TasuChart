package app_reportegraficas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class graficas {

    // agregamos el grafico al panel indicado
    public void agregarGrafica(JFreeChart grafico, JPanel panel) {
        //asignaremos las dimensiones del panel para que quede exacto
        ChartPanel Cpanel = new ChartPanel(grafico);
        Cpanel.setMouseWheelEnabled(true);
        Cpanel.setPreferredSize(new Dimension(panel.getWidth(), panel.getHeight()));

        panel.setLayout(new BorderLayout());
        panel.add(Cpanel, BorderLayout.NORTH);
    }

    // convertimos a XYDataset para hacer otros tipos de graficas
    public XYDataset convertirXYDataset(DefaultCategoryDataset dataset) {
        //esto es ir pasando datows de una grafica con filas y columnas a una de dispersion
        XYSeriesCollection xyDataset = new XYSeriesCollection();

        for (int i = 0; i < dataset.getRowCount(); i++) {
            XYSeries series = new XYSeries(dataset.getRowKey(i));
            for (int j = 0; j < dataset.getColumnCount(); j++) {
                double x = j;
                double y = dataset.getValue(i, j).doubleValue();
                series.add(x, y);
            }
            xyDataset.addSeries(series);
        }
        return xyDataset;
    }

}
