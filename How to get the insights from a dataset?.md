# How to get the insights from a dataset?

What's the insights of a dataset?

Look, when you process a dataset, it starts with a research or a business problem. E.g. When are sales highest? When are sales lowest?→ This is your research problem.

These derive from a business problem, e.g. how can we improve or stabilize sales.

The datasets you get are related to sales per period. So when you process those, you’re going to get data patterns that give answers to the research problems above.

That’s where insights start. You point out the period(s) of lowest and highest sales activity. Based on additional information your processing gave, eg if the sales slump/rise is related to a corresponding activity/season etc, you can give the client recommendations on what to do. That's the second stage of insights.

The third is showing impact of your recommendations.

You can report these through presentations (ideal), plotting, chart,  graph,.. sort of visualizations.

Data insights refer to the process of collecting, analyzing, and following up on information collected with your organization and its clients. The goal is simple: make better decisions. A good data management and analysis strategy help companies monitor the health of critical systems, streamline processes, and further develop productivity.

Four ways to pull bits of knowledge from data

1. Precisely display information in a data visualization platform

2. Identify the right patterns in data sets

3. Look at the correct time frames

4. Avoid measuring averages and totals

Good luck!

# Get an understanding of the dataset business at first!

Don’t just take a dataset and run off looking for insight.

Go talk to people. Get an understanding of the business and the problems it faces.

Figure out what data is relevant. Are you getting information that’s going to be useful?

Get the scoop on the data you’ve been given. Where did it come from? How was it collected? What do the fields mean? What are the data quality issues?

Make a plan for data analysis. Decide what kind of end product is valuable for the business. Know how your work will be evaluated and used.

If as an analyst you encounter a data set in a domain you're not familiar with, and you don't have the time or ability to meet with a domain expert, your only real alternative is Exploratory data analysis
(EDA). This is particularly the case when there is no clear question defined that you could turn into an, e.g. unsupervised regression or classification task. 

That said, I think EDA can yield some interesting graphics, but it's definitely limited compared to building some real-world knowledge and intuition up around the domain from which the data is coming. Firsthand knowledge is much better if you have the time to study.

“Extract insights” is too vague a goal. What’s the value of an insight? Is management willing to use your insights? You don’t want to put in a lot of work and have it ignored.

So, on insights. Get to know the business. Learn what’s valuable to your management. Connect the dots from what you do to the revenue and cost savings you support.

Don’t get nerd sniped: start with a clear objective and stick to it.

# Get into the work

A good way to make data more readable, without expertise is using graphs. If you want to make good visualization, you may perhaps consider exploring d3.js.

Another point which often goes unsung is, data science involves elements of storytelling. So, compose your story and narrate it well, either in writing or verbal communication.

Trend. Trend them all in different ways. Break them down. Run averages. Find the big things first, then small things.

<b>1</b>, I would start with exploratory analysis (EDA) to see how the data in its original format are like; e.g. correlations among them, any discernible pattern with the target variable;

<b>2</b>, Come up a mental model on what factors would affect the target and see if those factors would have a proxy in your data set. e.g. I want to predict how blood pressure is changed. Blood pressure would spike if i am stressed or when I am exercising. See if something in connection with these can be found in your features. In this case, you may want to find if some variable like Rest State or something similar in your data set. This should gives you an idea on how that feature(s) would be related to the target. Sure you can base your mental model on some well-documented literature or you just have an hunch. It doesn’t really matter where it comes from as long as you have a hypothesis to test;

<b>3</b>, Do whatever feature engineering you like that would help make your proxy closer to the ideal feature. There is no specific rule to follow and this is the ingenious part in the whole process;

<b>4</b>, Start running your set of features through different ML algos and metrics to see how it performs. I always like to set up a baseline before I move ahead to try out any fancy models. e.g. I would always run a linear regression model on original feature space without any transformation for real value target and a logistics regression for classification task to establish the baseline.

<b>5</b>, Repeat step 2–4 until you cannot squeeze anything more out to improve the result

<b>6</b>, Now it’s the critical step: what insights you want to draw from all these outputs. If you want something like what factor(s) have the highest impact on the target and why, then accuracy may not be the most important factor to determine which ML algo you will choose to optimize further. You may want something like linear/logistic regression and Decision Tree which gives user high level of interpretability.


# Example of data insights
What are some examples of getting insights from data?

Finding - Something that is apparent from the data

Insight - A conclusion drawn from a finding

Recommendation - An action taken/to be taken from the insight

F1 - Male shoppers contribute to higher chunk of sales over the weekend compared to females

I1 - Male shoppers tend to be free from work during weekends and hence majority of their shopping is done during the same time.

R1 - Targeting female shoppers with weekday coupons so as to balance out average daily revenue OR targeting male shoppers with weekend coupons so as to maximize their market basket size

F2 - Customers are not watching the entire video to its full length. THey are watching 90–95%

I2 - The parts they are not watching are the title roll and the end credits

R2 - Introduce ‘Skip Intro’ at the beginning of title rolls and ‘Watch Next’ at the beginning of end credits. Benchmark 90–95% watched content as completed and measure if customers move to the next video in the series

In both the above examples, Findings are the machine aspect. Machines can spit out numbers in a fraction of time. Interpreting those numbers and drawing Insights is the human aspect (which will soon be programmatic - courtesy AI). Recommendations is a huge spectrum with multiple iterations of individual or collective findings and insights to take actionable outcomes.

“Insight” is always a human, manual activity.

“Data science”, or “machine learning”, is then an attempt to automate a human “insight” process for a particular use case.

A “classical” example, already from before the current “data science” hype, is spam filtering: deciding whether a certain received email is spam or not.

An other “insight” example would be: classifying pictures (photos) into “photo of a car”, or “photo of a cat”, or “contains traffic signs”, or “none of the above”.


Hope that helps!

# Data analysis techniques

How can data analysis techniques be used to uncover valuable insights from a complex dataset?

Analyzing complex datasets to uncover meaningful insights is an increasingly important skill in today's data-driven world. With the right techniques and tools, analysts can extract key trends, patterns and relationships from large, multifaceted data sources. Here I'll walk through some best practices and provide examples of how different analysis methods can yield valuable findings.

### Cleaning and Preparing the Data

The first step is collecting and preparing the dataset. Real-world data is often messy, with inconsistencies, errors, missing values and outliers. Before analysis, we need to “clean” the data using techniques like:

- Removing duplicates - Identify and delete any duplicated data points
- Handling missing values - Impute, interpolate or remove missing values
- Identifying outliers - Use statistical methods to find data points that are abnormally far from others
- Data transformations - Log transform skewed data, normalize values, aggregate data points, etc.

Proper data prep removes noise and inaccuracies that could undermine later analysis. For a large retail company, this could involve cleaning inconsistently formatted customer records from various regional databases before analyzing demographics.

### Exploratory Data Analysis

Once data is clean, exploratory analysis helps us better understand its properties. The goal is to derive basic summary stats, relationships and trends. Useful methods include:

- Visualizations - Charts like histograms, scatter plots and heat maps to visualize data distributions, clusters and correlations
- Summary statistics - Metrics like mean, median, variance, quantiles to summarize data
- Segmentation - Divide data into meaningful segments or subgroups for easier analysis

For example, an exploratory analysis of website traffic data could surface insights like: most visitors come from a certain country, conversion rates are highest in the evening, page load times follow a bimodal distribution, etc. These findings guide more rigorous modeling later on.

### Statistical Modeling

We can apply various statistical models to quantify relationships within complex data:

- Regression analysis - Identify how independent variables influence a dependent variable
- Analysis of variance (ANOVA) - Test differences between group means
- Factor analysis - Reduce many variables into fewer underlying unobserved factors
- Cluster analysis - Detect groups of similar data points to segment observations
- Decision trees - Make predictions based on a series of binary rule-based decisions

For a grocery store chain, regression could reveal how much weather, nearby events and day of week drive customer traffic to each location. Cluster analysis may segment stores by their shopper demographics and purchasing patterns.

### Machine Learning

Machine learning algorithms uncover patterns and make predictions by learning from data without explicit programming. Common techniques include:

- <b>Classification</b> - Assign observations to categorical labels or classes
- <b>Neural networks</b> - Model complex nonlinear relationships between inputs and outputs
- <b>Decision forests</b> - Ensembles of decision trees avoid over-fitting and improve predictions
- <b>K-means clustering</b> - Partition observations into k clusters based on similarity
- <b>Anomaly detection</b> - Identify outliers that don't conform to normal patterns

For an e-commerce company, machine learning can drive product recommendations, forecast inventory demand, identify fraudulent transactions and more. The key is choosing the right algorithm for each problem.

### Data Mining

Data mining employs sophisticated techniques to search large datasets for statistically significant but previously unknown patterns and relationships. Methods include:

- <b>Association rule learning </b>- Discover interesting correlations between variables
- <b>Sequential pattern mining</b> - Identify sequences and trends over time
- <b>Text mining</b> - Extract useful facts from unstructured text data like surveys, emails, documents

For a healthcare provider, data mining patient records could reveal combinations of symptoms associated with different conditions, allowing earlier diagnosis. It can also inform treatment plans based on outcomes for patients with similar histories.

### Data Visualization

Visual representations make it easier to understand key aspects of complex data. Effective visualization provides clarity, drives insights and communicates findings. Strong visualization practices include:

- <b>Choose appropriate chart types </b> - Use the right visuals for each data type and relationship
- <b>Highlight key points</b> - Emphasize important features, outliers, trends and takeaways
- <b>Provide context </b>- Labels, annotations and captions explain the data
- <b>Keep it simple</b> - Avoid excessive detail that obscures the main message
- <b>Consider aesthetics</b> - Use color, layout and other styling appropriately

For a media company, data visualizations could reveal insights like social media engagement trends, ad performance by geography, or user retention by app feature. Compelling visuals make the data more intuitive.

### Interpreting and Reporting Results

The final step is interpreting analysis results and reporting findings to drive informed business decisions. Best practices include:

- Consider biases and limitations - Account for limitations in the methodology, data, models or analytical assumptions
- Identify key drivers and predictors - Determine factors with the strongest statistical relationships to the outcome variable
- Summarize methodology - Provide enough methodological detail for audiences to assess credibility of results
- Highlight actionable insights - Emphasize findings that lead directly to practical business decisions
- Tailor to audience - Adapt the message based on stakeholders' knowledge and interests
- Translate data into recommendations - Provide specific, data-driven guidance to address business questions

For a retail chain, the analyst may report customer foot traffic predictors, personalized promotion responses, labor allocation inefficiencies and other bottom-line insights to operations executives and store managers.

The techniques discussed illustrate how thoughtfully applied data analysis unlocks treasure troves of actionable insights from even highly complex business datasets. With the powerful data mining tools now available, analysts must also be ethical and responsible to ensure findings are valid, rigorous and avoid bias. Used properly, data analysis drives smarter decisions and competitive advantage.

### In Summary and conclusion

- Proper data preparation with cleaning, transformations and quality checks provides the foundation for impactful analysis
- Exploratory analysis like visualizations and statistics sheds initial light on data properties, distributions and relationships
- Statistical modeling quantifies the strength of relationships and makes probabilistic predictions
- Machine learning algorithms identify complex patterns to drive real-world predictions and decisions
- Data mining reveals subtle, unexpected insights like hidden associations and sequential patterns
- Effective data visualization conveys key aspects of complex data to tell a clear story
- Thoughtful interpretation considers limitations and turns findings into actionable business recommendations

I hope these examples demonstrate how modern data analysis techniques can yield powerful insights from even very complex and multifaceted datasets. Let me know if you have any other questions! Please upvote this answer if you found it helpful.


# How to produce actionable insights 

How can a data scientist produce actionable insights from data analysis?

To create actionable insights, first understand your role as a researcher, an artist, a salesperson, and a business leader. Your ability to find insights will mean nothing if you don’t know how to extend them into the larger organization.

### 1. Start with a business question.

- If you find yourself in situations where people feel you are wasting their time telling them things they already know, then you're not solving a problem, you're just describing it. From my experience, even the most senior of executives can describe the problem, what they are paying the employees for is to solve them.

- So before starting any analysis, write down a hypothesis. Ask the intended recipient of the analysis "Do you actually care about the answer to this hypothesis?" If so, get to work. If not, the person will most likely appreciate you asking up front for their input and will help you re-frame the hypothesis in such a way that they care about the answer.

### 2. Understand the analytic models and approaches that are already producing business value with data science in other organizations.

- Existing models are powerful - and inspiring. They don’t have to be in your own vertical to help drive innovation (and data artistry as another commenter above has described it.)

- Be able to tell the stories of how value was generated with these models, as they will help you “sell” your approach to the stakeholders in an organization who you will need to implement them. You may be a data scientist, but you’re still in sales. Your pitch and value offering needs to be better than your competitors.

- Look for the business insight that precedes the application of the technology itself. Most of the time there is some human insight that a person - not an algorithm - identified in the business model that shaped the focus of the analytical work. It might be in terms of value to the customer or efficiency in the operational model. These human-generated insights are where the "7x value" tends to emerge. In other words, don’t start with the data to find value.

- Identify the friction points in the existing business model and identify ways to reduce them. Because every business has friction points, there is always a place to focus. Don’t let your competitors get there ahead of you.

### 3. Understand your company’s strategic business priorities - and align your work to them

- Implementation is where value is created. Not in the data science itself. Actions, not models are the bottom line.

- If you’re pulling a different direction than the leadership, you will likely never see value realized - even if you’ve uncovered something is actionable. If they’re not willing to make the operational/process/system changes to do something new and better, than you’ve accomplished nothing, which is an agonizing outcome.

- If possible, identify the specific KPIs that your work will impact and try to provide some estimation of ROI. Even a notional swag is better than a loose idea of “it will be better.” Imagine yourself on Shark Tank pitching your approach like its own investment opportunity. Be prepared to answer questions on how/why/where/ROI/investment etcetera.

### 4. Identify the stakeholders who can implement your models and insights and build relationships with them.

- They need you, and you need them.

- Make sure that you communicate to these organizational leaders in language that they understand. It isn’t data science they are interested in, but in the conceptual value of what you are doing. You must be able to create a narrative around the value you are generating so that THEY can sell it to their people.

- Your stakeholder is competing with other stakeholders for funding and attention. The better you are at framing the return, the impacted KPIs, models that are similar in other businesses, and the story of what your insight will do for your business, the better chance that vision will help your stakeholder sell it.

- When you show visual data models of your work to key stakeholders, simplify, simplify, simplify. It is intimidating to see data visualizations that you don’t understand. Find a way to demonstrate the data impact or relevance with something a 7th-grader can make sense of. Data scientists are notoriously poor at communicating their insights. If you make sure that you’re communicating well, your efforts will get the attention and focus they need to become actionable.

- Make sure you have a feel for and can explain the kinds of new things that will be required to implement your insights.

### 4. The fact that you’re already working to create something actionable rather than interesting is the right first step

- All data are interesting, and the most junior analyst can find interesting patterns and insights within them. The mind is a pattern generator. It’s what we do. What will distinguish your analytical work is a vision on how to bring those insights into strategic alignment with your organization and your ability to create a workable narrative around their value.

### 5. Avoid trying get across how hard you're working

- One of the biggest mistakes I see when mentoring junior analysts is that they want to convey how hard they are working, due to a lack of confidence. Part of this comes from formal schooling, where the assignments are dictated by the length of the assignment ("Write 1500 words...) instead of the value of the insight.

- So instead of putting together a 30-slide presentation telling me descriptive statistics for 300 attributes of your dataset, pick the few that are interesting and summarize them. Better yet, don't include them at all! I already assume you've done the leg work, so just tell me the answer to your hypothesis.

- If I'm interested in knowing more details, I'll ask, and will be comfortable with receiving more detail after the meeting or waiting during the meeting while you pull up your raw output.

- Note that neither of my answers are based on techniques; it's almost never the case that how you approach a problem from a technical perspective is the problem. The problem is a lack of focus on what the audience wants to know and how you are delivering the presentation.



# Data intergrity

- Data integrity is the hardest part. Even if you find the data you need, and you can clean it up, determining if it is accurate is the tough part. Every group swears their data is good. Sadly, they're rarely 100% right. Identifying the bad parts can be difficult and time consuming but as I've asked many CIOs, does it matter how fast you get the wrong answer?

# How to deal with customer?

My advice:

- I worked in technical sales once and know that two things are rare: time and money. So you as a salesperson want your customer to part with both. Why should he do you that favour? What do you offer? Or are you just another nuisance, wasting his time?

- Listen. Really listen to their problems. Let them talk. Take your time in answering. Try to think of a solution and explain your ideas to them. Do not give him a phony answer. Do not brag. As they say”lies have short legs”, your customer will find out and dump you.

- If you cannot offer a solution right away, go back and do some research and then contact the customer again. If you cannot help him, say so. He will be grateful for an honest answer. He will appreciate that you have taken the time to go into his problem. This time he will listen to you.

- That way you do not come across as overwhelming them with some stuff you want them to buy, but as a helpful, creative mind who happens to sell just the stuff that fixes their problems.

- When I followed this basic rule, I made good, repeated sales and even got recommended to other new customers.

- This sounds very simple and easy, but it is not. You would be surprised how many salespeople ignore this rule and fail, wondering why.

# Business Mind

In my opinion, you need to have a business mind when you do data analysis.

- One good example would be when you are analyzing survey data. Normally survey are conducted with specific reasons that are somewhat important to an organization (i.e. ask about opinions on new product, currently existing products; opinions on the whole company). Survey designers not only just ask their opinions but also collect respondents' demographic information. The reason is for conducting more detailed subgroup analyses (i.e. analyze differences across ages. gender, roles, and etc.). Those information are very important for the organizations when they are planning for the future.

- For example, in a financial management firm, if the analyst captured investment behavior differences between males and females, and presented the analysis result to business people, then they can plan different strategies in attracting male/female investors so that they can gather more clients to the firm.

- When analyzing these data, one of the important things (at least for me) is to capture the differences across different subgroups (cross tabulations) and organize them out in PowerPoint slides and make sure to comment on those differences so that when discussing with business people, they can capture the differences and apply to their business plannings.

- It is similar to analyzing non-survey data, one needs to have a question/goal in their analysis. Those questions usually come from business people. Analysts need to capture and understand why the question is asked and how having those information/data is going to affect the organization before the analysis.

