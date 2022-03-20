
<%@page import="java.util.List"%>
<%@page import="org.bd.DB"%>
<%@page import="org.object.Finance"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/jsp.css" type="text/css" />
        <!-- 引入 ECharts 文件 -->
        <script src="js/echarts.js"></script>
        <script type="text/javascript"
                src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <title>报表</title>
    </head>
    <body id="reportpage" >
        <div id="report">
        <%
            // 获取报告数据
            List<Finance> list_finance = (List<Finance>) request.getAttribute("finance");
            out.println("<h1>" + list_finance.get(1).getCompany().getChineseName() + "</h1>");
            // Lecture de la liste et affichage
            out.println("<table border=\"1\">");
            out.println("<tr><th>Date</th><th>Liabilities</th>"
                    + "<th>Assets</th><th>Current_assets</th><th>Current_liabilities</th>"
                    + "<th>Inventories</th><th>Shareholders_equity</th><th>Profits_payable</th>"
                    + "<th>Short_loans</th><th>Long_loans</th><th>Net_profit</th>"
                    + "<th>Operating_profit</th><th>Operating_cost</th><th>Income_tax_paid</th>"
                    + "<th>AEADNGL</th><th>Selling_expenses</th><th>Business_tariff_and_annex</th>"
                    + "<th>CPDDP</th><th>NCFOA</th><th>Cash_from_borrow</th><th>CRAB</th><th>CPFAIALA</th>"
                    + "<th>DFAOGAPBA</th><th>Deferred_assets</th><th>SCOSE</th></tr>");
            for (Finance f : list_finance) {
                out.println("<tr><td>" + f.getDateF().toString() + "</td>"
                        + "<td>" + f.getLiabilities() + "</td>"
                        + "<td>" + f.getAssets() + "</td>"
                        + "<td>" + f.getCurrent_assets() + "</td>"
                        + "<td>" + f.getCurrent_liabilities() + "</td>"
                        + "<td>" + f.getInventories() + "</td>"
                        + "<td>" + f.getShareholders_equity() + "</td>"
                        + "<td>" + f.getProfits_payable() + "</td>"
                        + "<td>" + f.getShort_loans() + "</td>"
                        + "<td>" + f.getLong_loans() + "</td>"
                        + "<td>" + f.getNet_profit() + "</td>"
                        + "<td>" + f.getOperating_profit() + "</td>"
                        + "<td>" + f.getOperating_cost() + "</td>"
                        + "<td>" + f.getIncome_tax_paid() + "</td>"
                        + "<td>" + f.getAEADNGL() + "</td>"
                        + "<td>" + f.getSelling_expenses() + "</td>"
                        + "<td>" + f.getBusiness_tariff_and_annex() + "</td>"
                        + "<td>" + f.getCPDDP() + "</td>"
                        + "<td>" + f.getNCFOA() + "</td>"
                        + "<td>" + f.getCash_from_borrow() + "</td>"
                        + "<td>" + f.getCRAB() + "</td>"
                        + "<td>" + f.getCPFAIALA() + "</td>"
                        + "<td>" + f.getDFAOGAPBA() + "</td>"
                        + "<td>" + f.getDeferred_assets() + "</td>"
                        + "<td>" + f.getSCOSE() + "</td></tr>");
            }
            out.println("</table>");
        %> 
        </div>     
        
        <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
	<div id="opChart" style="width: 600px; height: 400px;"></div>
	<script type="text/javascript">
		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('opChart'));
		var url = '${pageContext.request.contextPath}/GetOperatingCostData?idC='+'<%= request.getAttribute("idC").toString()%>';
                console.log(url);
		$.getJSON(url).done(function(json) {
			// 2.获取数据
			operatingProfits = json.operatingProfits;//营业收入
                        operatingCosts = json.operatingCosts
			dates = json.dates;//月份
 
			// 3.更新图表myChart的数据
			var option = {
				title : {
					text : '营业情况趋势图'
				},
				tooltip : {},
				legend : {
					data : [ '营业收入','营业花费' ]
				},
				xAxis : {
                                        name : '时间',
					data : dates
				},
				yAxis : {
                                        name : '单位:万元'   
                                },
				series : [{
					name : '营业收入',
					type : 'line',
					data : operatingProfits},
                                        {
					name : '营业花费',
					type : 'line',
					data : operatingCosts}],
				toolbox : {
					show : true,
					feature : {
						mark : {
							show : true
						},
						dataView : {
							show : true,
							readOnly : false
						},
						magicType : {
							show : true,
							type : [ 'line','line' ]
						},
						restore : {
							show : true
						},
						saveAsImage : {
							show : true
						}
					}
				},
			}
			myChart.setOption(option);
		})
	</script>
        
        <!--<div id="pieChart" style="width: 300px; height: 400px;"></div>
	<script type="text/javascript">
		// 基于准备好的dom，初始化echarts实例
		var myChart1 = echarts.init(document.getElementById('pieChart'));
		var url = '${pageContext.request.contextPath}/GetAssetsData?idC='+'<%= request.getAttribute("idC").toString()%>';
                console.log(url);
		$.getJSON(url).done(function(json) {
			// 2.获取数据
			operatingProfits = json.operatingProfits;//营业收入
                        operatingCosts = json.operatingCosts
			dates = json.dates;//月份
 
			// 3.更新图表myChart的数据
			var option1 = {
                                backgroundColor: 'white',

                                title: {
                                    text: '',
                                    left: 'center',
                                    top: 20,
                                    textStyle: {
                                        color: '#ccc'
                                    }
                                },
                                tooltip : {
                                    trigger: 'item',
                                    formatter: "{a} <br/>{b} : {d}%"
                                },

                                visualMap: {
                                    show: false,
                                    min: 500,
                                    max: 600,
                                    inRange: {
                                        colorLightness: [0, 1]
                                    }
                                },
                                series : [
                                    {
                                        name:'',
                                        type:'pie',
                                        clockwise:'true',
                                        startAngle:'0',
                                        radius : '60%',
                                        center: ['50%', '50%'],
                                        data: operatingCosts}],
				toolbox : {
					show : true,
					feature : {
						mark : {
							show : true
						},
						dataView : {
							show : true,
							readOnly : false
						},
						magicType : {
							show : true,
							type : [ 'line','line' ]
						},
						restore : {
							show : true
						},
						saveAsImage : {
							show : true
						}
					}
				},
			}
			myChart1.setOption(option);
		
	</script>})-->
        
        <div id="recommend">
            
        </div>
        
        <div>${requestScope.avert}</div>
        <br/>
        <a id="welcome" href="WelcomePageCtrl?fct"> Return home </a>
    </body>
    </html>
