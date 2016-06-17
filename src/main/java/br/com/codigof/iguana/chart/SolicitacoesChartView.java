/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.codigof.iguana.chart;

/**
 *
 * @author thiago.aderaldo
 */

import br.com.codigof.iguana.jpa.entities.Solicitacoes;
import br.com.codigof.iguana.util.DateManager;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

@ManagedBean
public class SolicitacoesChartView implements Serializable {

    private LineChartModel lineModel1;
    private LineChartModel lineModel2;
    private BarChartModel barModel;
    @EJB
    private br.com.codigof.iguana.beans.SolicitacoesFacade ejbFacade;
    List<Solicitacoes> solicitacoes;
    List<String> currentWeek;

    
    @PostConstruct
    public void init() {
        createLineModels();
        createBarModels();
    }

    public BarChartModel getBarChartSolicitacoesByCurrentWeek(){
        return barModel;
    }
    public LineChartModel getLineModel1() {
        return lineModel1;
    }

    public LineChartModel getLineModel2() {
        return lineModel2;
    }

    private void createLineModels() {
        lineModel1 = initLinearModel();
//        lineModel1.setTitle("Solicitaçoes no mes corrente");
        lineModel1.setLegendPosition("e");
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
//        yAxis.setMin(0);
//        yAxis.setMax(10);

//        lineModel2 = initCategoryModel();
//        lineModel2.setTitle("Category Chart");
//        lineModel2.setLegendPosition("e");
//        lineModel2.setShowPointLabels(true);
//        lineModel2.getAxes().put(AxisType.X, new CategoryAxis("Years"));
//        yAxis = lineModel2.getAxis(AxisType.Y);
//        yAxis.setLabel("Births");
//        yAxis.setMin(0);
//        yAxis.setMax(200);
    }
    
    private void createBarModels(){
        createBarModel();
    }
    
    private void createBarModel(){
        barModel = initBarModel();
        barModel.setLegendPosition("e");
        
        
    }

    private LineChartModel initLinearModel() {

//        solicitacoes = ejbFacade.findAll();
        solicitacoes = ejbFacade.findByCurrentMonth();

        LineChartModel model = new LineChartModel();

        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Solicitações");
        List<String> nomes = new ArrayList<String>();
        Map<String, Integer> map = new TreeMap<String, Integer>();

        if (solicitacoes != null && solicitacoes.size() > 0) {
            for (Solicitacoes solicitacao : solicitacoes) {
                nomes.add(DateManager.DateUtilToString("dd", solicitacao.getDataSolicitacao()));
            }

            for (String nome : nomes) {
                Integer count = map.get(nome);
                if (count == null) {
                    count = 0;
                }
                map.put(nome, count + 1);
            }

            //Agora, para exibir todos os nomes repetidos e quantas vezes se repetiram:
            for (String nome : map.keySet()) {
                /*System.out.printf("O nome %s se repetiu %s vezes.", nome, map.get(nome));
                 * System.out.println();*/
                series1.set(nome, map.get(nome));
//                System.out.println("Data: " + nome + " Valor: " + map.get(nome));
//                series1.setLabel(nome);
            }
        } else {
            series1.set("Sem ocorrências nesta data.", 100);
        }
        //Preenche a série do gráfico.
        model.addSeries(series1);
        //Preenche o título do gráfico.
//        model.setTitle("Qtd. Ocorrências x Regional - Mês de Julho");
        //Configurações do eixo X.
        model.getAxis(AxisType.X).setLabel("Dias");
        model.getAxis(AxisType.X).setTickAngle(-50);
        model.getAxis(AxisType.X).setMin(Integer.parseInt("1"));
        model.getAxis(AxisType.X).setMax(Integer.parseInt("31"));
        model.getAxis(AxisType.X).setMax(Integer.parseInt("31"));
        model.getAxis(AxisType.X).setTickFormat("%'d");
        //Configurações do eixo Y.
        model.getAxis(AxisType.Y).setLabel("Qtd. Solicitações");
//        lineModel.getAxis(AxisType.Y).setTickAngle(-50);
        model.getAxis(AxisType.Y).setMin(0);
        model.getAxis(AxisType.Y).setMax(solicitacoes.size() - 1);
        model.getAxis(AxisType.Y).setTickFormat("%'d");
        //Habilita a animação do gráfico.
        model.setAnimate(true);
        return model;
    }

//    private LineChartModel initCategoryModel() {
//        
//        atendimentos = ejbFacadeAte.findAll();
//        
//        LineChartModel model = new LineChartModel();
//
//        ChartSeries series1 = new ChartSeries();
//        series1.setLabel("atendimentos");
//        List<String> atend = new ArrayList<String>();
//        Map<String, Integer> map = new TreeMap<String, Integer>();
//              
//        ChartSeries csAtendimento = new ChartSeries();
//         if (atendimentos != null && atendimentos.size() > 0) {
//            for (Atendimentos at : atendimentos) {
//                atend.add(at.getDataAtendimento());
//            }
//
//            for (String nome : atend) {
//                Integer count = map.get(nome);
//                if (count == null) {
//                    count = 0;
//                }
//                map.put(nome, count + 1);
//            }
//
//            //Agora, para exibir todos os nomes repetidos e quantas vezes se repetiram:
//            for (String nome : map.keySet()) {
//                /*System.out.printf("O nome %s se repetiu %s vezes.", nome, map.get(nome));
//                 * System.out.println();*/
//                series1.set(nome, map.get(nome));
////                System.out.println("Data: " + nome + " Valor: " + map.get(nome));
////                series1.setLabel(nome);
//            }
//        } else {
//            series1.set("Sem ocorrências nesta data.", 100);
//        }
//
//        model.addSeries(series1);
//
//        return model;
//    }

    private BarChartModel initBarModel() {
         currentWeek = ejbFacade.findByCurrentWeek();
         
         BarChartModel model = new BarChartModel();
         List<String> dayWeek = new ArrayList<String>();
         day(dayWeek);
         Map<String,Integer> map = new TreeMap<String,Integer>();
         BarChartSeries series1 = new BarChartSeries();
         series1.setLabel("Ocorrência");
         
         if(currentWeek!=null && currentWeek.size() > 0){
                   
             
             for(String nome: currentWeek){
                 
                 Integer count = map.get(nome);
                 
                 if(count == null){
                     count = 0;
                 }
                 
                 map.put(nome, count + 1);
             }
             
             int i = 0;
             for(String nome : map.keySet()){
                series1.set(dayWeek.get(i)+"\n"+nome, map.get(nome));
                ++i;
                 
             }
         }else{
             series1.set("Sem ocorrencia nesta semana",100);
         }
         
        model.addSeries(series1);
        model.setTitle("Evolução das ocorrências na semana");
        model.getAxis(AxisType.X).setLabel("Dias");
        model.getAxis(AxisType.X).setTickAngle(-50);
        model.getAxis(AxisType.X).setTickFormat("%s");
        model.getAxis(AxisType.Y).setLabel("Ocorrencias");
        model.getAxis(AxisType.Y).setMin(0);
        model.getAxis(AxisType.Y).setMax(currentWeek.size() - 1);
        model.getAxis(AxisType.Y).setTickFormat("%d");
         
        return model;
         
    }

    private void day(List<String> dateW) {
        dateW.add("Domingo");
        dateW.add("Segunda");
        dateW.add("Terça");
        dateW.add("Quarta");
        dateW.add("Quinta");
        dateW.add("Sexta");
        dateW.add("Sábado"); 
    }

}