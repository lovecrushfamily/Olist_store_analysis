# Analyze, Visualize **Mercado Livre** e-commerce dataset

### Final project data analysis with python

<u>Authors:</u> LoveCrush<br>
Module: Data analysis with python <br>
Class : 124221 <br>

## Data overview

This project focus on three main purpose, data analysis, data visualization, predictive model( in advanced ). All the data in this dataset was about brazil, all cities, states, locations,.. And this  dataset was not clean at first, I need to drop some duplicated nonsense record, row and draw random value for quantity. payment installations, seem like those record was duplicated by hand with no deep modification So we obviously got some record with order_id and product_id look exactly the same, the e-commerce exchanges could never give you more than two bills if you buy the same product, the different should be on quantity, but it's not.
<br>
E-commerce datasets contain vast amounts of information about products, customers, marketplaces and sales. Product discovery KPIs help e-commerce retailers understand how customers find their products and online marketplace, which then gives them the means to boost campaigns and increase online consumer traffic.

Note: Remember this dataset included 97255 records and was merged and joined from other datasets, maybe like some shitty table in sql, I dunno <br> Order_id incredibly turns out order_detail_id or order_item_id, try not to get any misunderstanding of it here.
<br>And there is no one this dataset is also a customer and seller, they're two distinct set of beings.
<br>

This dataset contained data between 2016-09-4 -> 2018-09-03 (almost two years) <br>
And Each order has its corresponding customer

Remember: Analysis always plays along with visualization.

## Knowlegde requirements

- jupiter notebook
- numpy, pandas , matplotlib, csv

## Data Description

| S.No | Name                 |                             | Description                                                         |
| ---- | -------------------- | --------------------------- | ------------------------------------------------------------------- |
| 1    | order_id             | No. unique orders: 97254    | unique id for each order (32 fixed-size number)                     |
| 2    | customer_id          | No. unique cus: 97254       | unique id for each customer (32 fixed-size number)                  |
| 3    | quantity             |                             | 1-21  (maximum quantity)                                            |
| 4    | price_MRP            |                             | cost price, 0.85-6735 (price_maximum retail price)                  |
| 5    | payment              |                             | selling price, 0-13664.8  (brazililian real - R$)    code : BRL     |
| 6    | timestamp            |                             | order purchase time (local, day-month-year hour:min:sec AM/PM)      |
| 7    | rating               |                             | 1-5 (represent stars)                                               |
| 8    | product_category     | No.unique cate: 71          | category under which product belongs                                |
| 9    | product_id           | No. unique pro: 32327       | unique id for each product (32 fixed-size number)                   |
| 10   | payment_type         |                             | Type of payment - credit_card/ debit_card/ boleto/ voucher          |
| 11   | order_status         |                             | delivered/shipped/invoiced                                          |
| 12   | product_weight_g     |                             | weight of product (in grams), 0-40425                               |
| 13   | product_length_cm    |                             | length of product (in centimeter), 7-105                            |
| 14   | product_height_cm    |                             | height of product (in centimeter), 2-105                            |
| 15   | product_width_cm     |                             | width of product (in centimeter), 6-118                             |
| 16   | customer_state       | No. unique state: 27        | state where order is placed                                         |
| 17   | seller_id            | No. unique seller: 3022     | unique id for each seller (32 fixed-size number)                    |
| 18   | seller_state         | No. unique seller state: 23 | state where order is picked up                                      |
| 19   | payment_installments |                             | number of installments taken by customer to pay bill, 0-24 (months) |

## The state map with their full name

| Short name | Full Name           |
| ---------- | ------------------- |
| AC         | Acre                |
| AL         | Alagoas             |
| AM         | Amazonas            |
| AP         | Amapá               |
| BA         | Bahia               |
| CE         | Ceará               |
| DF         | Distrito Federal    |
| ES         | Espírito Santo      |
| GO         | Goiás               |
| MA         | Maranhão            |
| MG         | Minas Gerais        |
| MS         | Mato Grosso do Sul  |
| MT         | Mato Grosso         |
| PA         | Pará                |
| PB         | Paraíba             |
| PE         | Pernambuco          |
| PI         | Piauí               |
| PR         | Paraná              |
| RJ         | Rio de Janeiro      |
| RN         | Rio Grande do Norte |
| RO         | Rondônia            |
| RR         | Roraima             |
| RS         | Rio Grande do Sul   |
| SC         | Santa Catarina      |
| SE         | Sergipe             |
| SP         | São Paulo           |
| TO         | Tocantins           |

## Order status process

| Regular case  | Worst case     |
| ------------- | -------------- |
| -> purchase   | -> purchase    |
| -> processing | -> unavailable |
| -> approved   | -> cancelled   |
| -> invoiced   |                |
| -> shipped    |                |
| -> delivered  |                |

## Analysis Performed using Jupyter Notebook

### Questions:

1. <b>Customer Segmentation </b><br>
   Categorizing customers based on their spendings, <br>
   [Bar-graph]
2. <b>Monthly Trend Forecasting </b><br>Visualising the monthly trend of sales <br>
   [Bar-graph]
3. <b>Hourly Sales Analysis </b><br>Which hour has more no. of sales?<br>
   [Timeseries-Plot]
4. <b>Product Based Analysis </b><br>
   Which category product has sold more?<br>
   Which category product has more rating?<br>
   Which product has sold more?<br>
   Top 10 highest & least product rating?<br>
   Order Count for each rating <br>
   [Bar-graph]
   Monthly profit, revenue analysis
5. <b>Payment Preference </b><br>
   What are the most commonly used payment types?<br>
   Count of Orders With each No. of Payment Installments <br>
   [Pie-Chart]
6. <b>Potential Customer's Location </b><br>
   Where do most customers come from?<br>
   [Pie-chart]
7. <b>Seller Rating/ ranking </b><br>
   Which seller sold more?<br>
   Which seller got more rating?<br>
   [Bar-graph]
8. <b>Logistics based Optimization Insights </b><br>
   Which city buys heavy weight products and low weight products?<br>
   [Pie-chart]<br>
   How much products sold within seller state?<br>
   How many proucts are domestic sales(Sold within seller city itself)?, seller cities less than cus_cities
   du lieuj mua ban hang hoa cua seller va cus, se co nguoi ban, nguoi mua noi dia

   [Bar-graph]
Personal:

### Machine Learning Model:

9. <b>Predicting future sales </b><br>
   ML - Linear regression

### Visualization:

Total no. of Graphs & Plots: 19 <br>
Python Plots <br>







