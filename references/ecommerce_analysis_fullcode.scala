// Predicting future sales:
// ------------------------

// Note: Predicting Sales Based on Hour, Day & Month
import org.apache.spark.ml.regression.LinearRegression
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.feature.Normalizer

val inputRdd = ePairRdd.map{ case(oid,cid,qt,cp,sp,ts,rating,pCat,pId,sp_type,oStat,pWt,pLen,pHt,pWidth,cCity,cState,sId,sCity,sState,sInstal) =>
      val ds_ts = ts.split(" ")
      val d_m_y = ds_ts(0).split("-")
      val hour = ds_ts(1).split(":")
      (sp.toFloat, hour(0).toInt,d_m_y(0).toInt,d_m_y(1).toInt) }.sortBy(_._1,false)
inputRdd.toDF("Sales","Hour","Day","Month").show

/*
+--------+----+---+-----+
|   Sales|Hour|Day|Month|
+--------+----+---+-----+
|13664.08|  15| 29|    9|
|13664.08|  15| 29|    9|
|13664.08|  15| 29|    9|
|13664.08|  15| 29|    9|
|13664.08|  15| 29|    9|
|13664.08|  15| 29|    9|
|13664.08|  15| 29|    9|
|13664.08|  15| 29|    9|
| 7274.88|  14| 15|    7|
| 7274.88|  14| 15|    7|
| 7274.88|  14| 15|    7|
| 7274.88|  14| 15|    7|
| 6929.31|  20| 12|    2|
| 6922.21|  18| 25|    7|
| 6726.66|  18| 24|    5|
| 6081.54|  11| 24|   11|
| 6081.54|  11| 24|   11|
| 6081.54|  11| 24|   11|
| 6081.54|  11| 24|   11|
| 6081.54|  11| 24|   11|
+--------+----+---+-----+
*/

inputRdd.count
/*
res29: Long = 116573
*/

val df = inputRdd.toDF("label","Hour","Day","Month")

val assembler1 = new VectorAssembler().
  setInputCols(Array("Hour","Day","Month")).
  setOutputCol("features").
  transform(df)
assembler1.show()

/*
+--------+----+---+-----+----------------+
|   label|Hour|Day|Month|        features|
+--------+----+---+-----+----------------+
|13664.08|  15| 29|    9| [15.0,29.0,9.0]|
|13664.08|  15| 29|    9| [15.0,29.0,9.0]|
|13664.08|  15| 29|    9| [15.0,29.0,9.0]|
|13664.08|  15| 29|    9| [15.0,29.0,9.0]|
|13664.08|  15| 29|    9| [15.0,29.0,9.0]|
|13664.08|  15| 29|    9| [15.0,29.0,9.0]|
|13664.08|  15| 29|    9| [15.0,29.0,9.0]|
|13664.08|  15| 29|    9| [15.0,29.0,9.0]|
| 7274.88|  14| 15|    7| [14.0,15.0,7.0]|
| 7274.88|  14| 15|    7| [14.0,15.0,7.0]|
| 7274.88|  14| 15|    7| [14.0,15.0,7.0]|
| 7274.88|  14| 15|    7| [14.0,15.0,7.0]|
| 6929.31|  20| 12|    2| [20.0,12.0,2.0]|
| 6922.21|  18| 25|    7| [18.0,25.0,7.0]|
| 6726.66|  18| 24|    5| [18.0,24.0,5.0]|
| 6081.54|  11| 24|   11|[11.0,24.0,11.0]|
| 6081.54|  11| 24|   11|[11.0,24.0,11.0]|
| 6081.54|  11| 24|   11|[11.0,24.0,11.0]|
| 6081.54|  11| 24|   11|[11.0,24.0,11.0]|
| 6081.54|  11| 24|   11|[11.0,24.0,11.0]|
+--------+----+---+-----+----------------+
*/

val normalizer = new Normalizer().
  setInputCol("features").
  setOutputCol("normFeatures").
  setP(2.0).
  transform(assembler1)
normalizer.show()

/*
+--------+----+---+-----+----------------+--------------------+
|   label|Hour|Day|Month|        features|        normFeatures|
+--------+----+---+-----+----------------+--------------------+
|13664.08|  15| 29|    9| [15.0,29.0,9.0]|[0.44290394651811...|
|13664.08|  15| 29|    9| [15.0,29.0,9.0]|[0.44290394651811...|
|13664.08|  15| 29|    9| [15.0,29.0,9.0]|[0.44290394651811...|
|13664.08|  15| 29|    9| [15.0,29.0,9.0]|[0.44290394651811...|
|13664.08|  15| 29|    9| [15.0,29.0,9.0]|[0.44290394651811...|
|13664.08|  15| 29|    9| [15.0,29.0,9.0]|[0.44290394651811...|
|13664.08|  15| 29|    9| [15.0,29.0,9.0]|[0.44290394651811...|
|13664.08|  15| 29|    9| [15.0,29.0,9.0]|[0.44290394651811...|
| 7274.88|  14| 15|    7| [14.0,15.0,7.0]|[0.64577184562021...|
| 7274.88|  14| 15|    7| [14.0,15.0,7.0]|[0.64577184562021...|
| 7274.88|  14| 15|    7| [14.0,15.0,7.0]|[0.64577184562021...|
| 7274.88|  14| 15|    7| [14.0,15.0,7.0]|[0.64577184562021...|
| 6929.31|  20| 12|    2| [20.0,12.0,2.0]|[0.85435765771676...|
| 6922.21|  18| 25|    7| [18.0,25.0,7.0]|[0.56978004404962...|
| 6726.66|  18| 24|    5| [18.0,24.0,5.0]|[0.59183635429928...|
| 6081.54|  11| 24|   11|[11.0,24.0,11.0]|[0.38460598070128...|
| 6081.54|  11| 24|   11|[11.0,24.0,11.0]|[0.38460598070128...|
| 6081.54|  11| 24|   11|[11.0,24.0,11.0]|[0.38460598070128...|
| 6081.54|  11| 24|   11|[11.0,24.0,11.0]|[0.38460598070128...|
| 6081.54|  11| 24|   11|[11.0,24.0,11.0]|[0.38460598070128...|
+--------+----+---+-----+----------------+--------------------+
*/

val Array(trainingData, testData) = normalizer.randomSplit(Array(0.70, 0.30))
trainingData.count
/*
Long = 81922
*/

testData.count
/*
Long = 34651
*/

val lr = new LinearRegression().
  setLabelCol("label").
  setFeaturesCol("normFeatures").
  setMaxIter(10).
  setRegParam(1.0).
  setElasticNetParam(1.0)

val lrModel = lr.fit(trainingData)

lrModel.
transform(testData).
select("features","label","prediction").
show()

/*
+----------------+------+------------------+
|        features| label|        prediction|
+----------------+------+------------------+
|  [20.0,5.0,5.0]|105.95|172.54876571676618|
|  [20.0,6.0,6.0]|105.95|172.97477934217812|
| [10.0,14.0,9.0]|105.96|174.94695419232792|
|  [21.0,3.0,1.0]|105.99|170.56329677228612|
| [11.0,31.0,7.0]|106.02| 172.2586847169489|
| [15.0,29.0,5.0]|106.02|  171.661097436566|
| [21.0,13.0,2.0]|106.02| 170.9172572137698|
|  [10.0,6.0,3.0]|106.03|172.69018221534373|
|  [8.0,16.0,6.0]|106.06| 173.4150760503963|
|  [11.0,7.0,3.0]|106.07|172.42800714769788|
|[14.0,30.0,11.0]|106.07|173.38683990123567|
| [21.0,12.0,6.0]|106.07|172.60212984586786|
|[23.0,26.0,11.0]|106.07|173.24749127118145|
|  [23.0,3.0,1.0]|106.08| 170.5210312172166|
|[11.0,29.0,11.0]| 106.1|173.58619736348862|
|[20.0,14.0,12.0]| 106.1| 174.7112125477511|
|[20.0,14.0,12.0]| 106.1| 174.7112125477511|
|[16.0,23.0,11.0]|106.11| 173.9145763553082|
| [16.0,26.0,7.0]|106.11| 172.4202413660314|
| [22.0,15.0,4.0]|106.15|171.63141300037034|
+----------------+------+------------------+
*/

val file = new java.io.PrintStream("BDA_Project\\ML_prediction.csv")
OutputRdd.collect.foreach ( file.println(_) )
file.close

println(s"Coefficients: ${lrModel.coefficients} Intercept: ${lrModel.intercept}")
/*
Coefficients: [0.0,0.0,10.526619961906] Intercept: 170.0676175974204
*/

val trainingSummary = lrModel.summary
println(s"numIterations: ${trainingSummary.totalIterations}")
/*
numIterations: 7
*/

println(s"objectiveHistory: [${trainingSummary.objectiveHistory.mkString(",")}]")
/*
objectiveHistory: [0.5,0.4999857123444021,0.49998078700776555,0.4999807204943856,0.49998071959616674,0.49998071958403695,0.4999807195838732]
*/

trainingSummary.residuals.show()

/*
+------------------+
|         residuals|
+------------------+
|-68.98695510785527|
|-65.35470481715404|
|-65.92483524657058|
|-69.33327530744057|
|-69.33327530744057|
|-67.45338025420673|
|-64.90675811733507|
|-65.08352466674066|
|-66.01313100352382|
|-66.01313100352382|
|-65.18625349662875|
|-65.94233475176031|
|-64.55443277310044|
| -66.3462012083869|
|-66.47142424649365|
|-70.18033253550936|
|-64.90917271502138|
|-66.10346868987196|
|-64.57329890851659|
|-67.32483144142094|
+------------------+
*/

println(s"RMSE: ${trainingSummary.rootMeanSquaredError}")
/*
RMSE: 274.30629592771396
*/

println(s"r2: ${trainingSummary.r2}")
/*
r2: 8.383535671985243E-5
*/


// Mannual Testing:

val test_df = sc.parallelize(Array( (238.61,21,4,8) )).toDF("label","Hour","Day","Month")

val test_assembler = new VectorAssembler().
  setInputCols(Array("Hour","Day","Month")).
  setOutputCol("features").
  transform(test_df)
test_assembler.show()

val test_normalizer = new Normalizer().
  setInputCol("features").
  setOutputCol("normFeatures").
  setP(2.0).
  transform(test_assembler)
test_normalizer.show()

lrModel.
transform(test_normalizer).
select("features","label","prediction").
show()

/*
+--------------+------+------------------+
|      features| label|        prediction|
+--------------+------+------------------+
|[21.0,4.0,8.0]|238.61|173.75705434750648|
+--------------+------+------------------+
*/




/*
Contents of Project:
--------------------

1. Customer Segmentation (Categorizing customers based on their spendings)
   [Bar-graph]

2. Monthly Trend Forecasting (Visualising the monthly trend of sales)
   [Bar-graph]

3. Which hour has more no. of sales? (Also avg qt & price for each hour)
   [Timeseries-Plot]

4. Do average (instead of sum) for monthly trend analysis
   [Bar-graph]

5. Which category product has sold more? 
   & Which category product has more rating (Category wise avg price,rating & Product wise avg price,rating)
   and
   Which product has sold more? 
   & Top 10 highest & least product rating?
   and
   Order Count for each rating
   [Bar-graph]

6. What are the most commonly used sp types? (avg price for each sp type)
   &
   Count of Orders With each No. of Payment Installments
   [Pie-Chart]

7. Where do most customers come from? (State wise & city wise avg sales) 
   [Pie-chart]

8. Which seller sold more? & Which seller got more rating? (avg price & rating for each seller)
   [Bar-graph]


Logistics Based:
----------------

9. Which city buys heavy weight products and low weight products? (City wise avg weight)
   [Pie-chart]

10. How much products sold within seller state? (if (seller state == customer state) then count++)
   & How much products sold outside his state?
   [Bar-graph]

Machine Learning Model:
-----------------------

11. Predicting future sales (ML - Linear regression)


