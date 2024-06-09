# **Olist Store** e-commerce data analysis

### Final project data analysis with python

<u>Authors:</u> LoveCrush<br>
Module: Data analysis with python <br>
Class : 124221 <br>

## Project overview

This project focus on three main purpose, data analysis, data visualization, predictive model( in advanced ). All the data in this dataset was about brazil, all cities, states, locations,.. as the tittle saying. Olist store is sort of a e-comemrce plattform so popular in Brazil, (you can check it out for more infos).

E-commerce datasets usually contain vast amounts of information about products, customers, marketplaces and sales. Product discovery KPIs help e-commerce retailers understand how customers find their products and online marketplace, which then gives them the means to boost campaigns and increase online consumer traffic.

Note: Remember this dataset included 102425 rows × 20 columns and was merged and joined from other sub datasets, 

Order_id incredibly turns out order_detail_id or order_item_id, try not to get any misunderstanding of it here. And there is no one this dataset is also a customer and seller, they're two distinct set of beings.
<br>

This dataset contained data between 2016-09-4 -> 2018-09-03 (almost two years) <br>
And Each order has its corresponding customer

### All relevant content in this repo

- Merge Olist released raw .csv files from 2016-2018
- Analyize Olist store dataset
- Write document, report for this project
- References project in kaggle
- Visualization including plot, chart,
- Machine learning with predictive model


### Knowlegde requirements

- IPython: Jupiter notebook, Jupyter lab
- Python Lib for data analysis: Numpy, Pandas, Matplotlib
- Virtual Environment: conda, miniconda, enev
- Machine learning: Algorithm, Toolkit(sklearn)

## Merge Olist 9 sub dataset

You can find the orginal dataset in this link <a href='https://www.kaggle.com/datasets/olistbr/brazilian-ecommerce/data?select=product_category_name_translation.csv'>Brazil e-commerce Olist Store release.</a>

The original dataset at first was released as a archive of sub dataset including 9 sub datasets. Each sub data represent to a table in database and obviously it was optimized for relational database, you'll see some primary key and foreign key. If you want to go straightforward to analyze these 9 sub dataset, Yeah, go ahead. Sooner or latter you'll try to merge, join these 9 sub set into one. So the best solution for us is joining these sets into one at beginning. I've done all of it in my <u> data_merging </u> folder, You can check it if you want more info.The table below is what I've created from that.

I'm not say I've a best performance at merging this dataset.Apparently, This dataset was so prospective, I bet that you can explore it more and more. I'm just extract appropriate things in it absolutely stuffs I understand well, So just enjoy more and judge less.

### Data Description

- Row: 102425 records
- Columns: 20 variables

| S.No | Name              |                             | Description                                                         |
| ---- | ----------------- | --------------------------- | ------------------------------------------------------------------- |
| 1    | order_id          | No. unique val: 95420       | unique id for each order (32 fixed-size number)                     |
| 2    | customer_id       | No. unique cus: 95420       | unique id for each customer (32 fixed-size number)                  |
| 3    | product_id        | No. unique pro: 32327       | unique id for each product (32 fixed-size number)                   |
| 4    | quantity          | Range(1 - 20)               | the quantity for each product purchased                             |
| 5    | price             | Range()            | the purchase price for this product                                 |
| 6    | freight_value     | Range( )           | the cost needed to you order transferring                           |
| 7    | payment_type      |                             | Type of payment - credit_card/ debit_card/ boleto/ voucher          |
| 8    | order_status      |                             | Order status, eg: delivered/shipped/invoiced                        |
| 9    | rating            | 1 - 5 rating star           | Represent rating stars                                              |
| 10   | timestamp         |                             | order purchase time (local, day-month-year hour:min:sec AM/PM)      |
| 11   | product_width_cm  | Range( )               | width of product (in centimeter),                             |
| 12   | product_length_cm | Range( )               | length of product (in centimeter),                             |
| 13   | product_height_cm | Range( )               | height of product (in centimeter),                            |
| 14   | product_weight_g  | Range( )               | weight of product (in grams),                               |
| 15   | product_category  | No. unique cate: 71          | category under which product belongs                                |
| 16   | customer_city     | No. unique cus city: 27        | state where order is placed                                         |
| 17   | customer_state    | No. unique cus state: 27        | state where order is placed                                         |
| 18   | seller_id         | No. unique sel: 3022     | unique id for each seller (32 fixed-size number)                    |
| 19   | seller_city       | No. unique sel city: 23 | state where order is picked up                                      |
| 20   | seller_state      | No. unique sel state: 23 | state where order is picked up                                      |


### The state map with their full name

(*): top 6 most popular state in brazil <br>
Brasilia : Capital of brazil which located at Distrito Federal state

| Abbreviation name      | Full Name           |
| --------------- | ------------------- |
| AM              |(*) Amazonas (The most shared Amazon forest state)            |
| MG              |(*) Minas Gerais  (The state has the most unmistakable food)      |
| BA              |(*) Bahia  (The unique culture of brazil)             |
| RJ              |(*) Rio de Janeiro  (The most famous state in brazil)     |
| SP              |(*) São Paulo  (The richest state in Brazil)         |
| DF              |(*) Distrito Federal (state which the capital of brazil was located)   |
| AC              | Acre                |
| AL              | Alagoas             |
| AP              | Amapá               |
| CE              | Ceará               |
| ES              | Espírito Santo      |
| GO              | Goiás               |
| MA              | Maranhão            |
| MS              | Mato Grosso do Sul  |
| MT              | Mato Grosso         |
| PA              | Pará                |
| PB              | Paraíba             |
| PE              | Pernambuco          |
| PI              | Piauí               |
| PR              | Paraná              |
| RN              | Rio Grande do Norte |
| RO              | Rondônia            |
| RR              | Roraima             |
| RS              | Rio Grande do Sul   |
| SC              | Santa Catarina      |
| SE              | Sergipe             |
| TO              | Tocantins           |

### Order status process

This is what would happen to your order when you decide to purchase it on a e-commerce platform. I've divide it into two case. First, when you buy and have your product so you're in good case and you're order'll follow exactly these steps before delivered to your hand. Second, the worst case, when you buy a product but it's sold out or not available in your country and you have no choice but cancel you order, that's a worst case.

| Regular case  | Worst case     |
| ------------- | -------------- |
| -> purchase   | -> purchase    |
| -> processing | -> unavailable |
| -> approved   | -> cancelled   |
| -> invoiced   |                |
| -> shipped    |                |
| -> delivered  |                |

## Analyize Olist store dataset

In this part I dive into analyze this big dataset(for me). I've following the guideline I've made by looking for how  can I get the insight of a dataset. You can find that in "How to get the insights from a dataset?.md" in my documents folder. That file including a lot of problem when you want to get the insight of a dataset. I looking it on  Quora And let's say it help me alot.

These question below is what I've been created and answered by myself. As you can see, all of these is just at basic level.

### Questions:

1. #### Segmentation
   - Categorizing customers based on their spendings and seller based on their revenue
   - Top 5 category has the highest no. product versus others
   - Top 5 category has the highest rating in average
   - Average original price of products in each state
   - No. products in each state and no. product each state have
   - Potential customer and seller location (not done yet)
   
   [Bar-graph]
2. #### Time Series
   - Visualising the monthly trend of sales (not done yet)
   - No. domestic orders growth
   - Monthly revenue
   - Hourly sales (not done yet)
   
   [TimeSeries-Plot]

3. #### Geography Location
   - Which city buys heavy weight products and low weight products? (not yet)
   - Brazil map

   [Geography-map]

## Document

You can find a lots of my documents in the <u>Documents</u> folder. I've put all the related docs to this project in that, my report at universe, and the sample report, my self-made docs,...Just claim anything you want.

And the requirements.txt file,  that's a list library I've used in my project, not important so you can ignore it.


## References

To be able to get a deep understand on this project, I've collect and read kind of 5,6 sample trying to open my eyes.

These sample was put in the references folder, all of them was quantified by me, and honesty these guys made it was super strong.

These guys have my respect and a graceful thanks.(I've star for them already)

## Visualization

For more understand of my project you should go into the visualization and see my plot. I think this readme file is long enough so  I don't wanna put it here.


## Machine Learning Model:

9. <b>Predicting future sales </b><br>
   ML - Linear regression

### Visualization:

Total no. of Graphs & Plots: 19 <br>
Python Plots <br>







