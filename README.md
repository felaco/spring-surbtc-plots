# Surbtc-plots

Unofficial personal project aimed to create better plots that the used ones in [buda exchange](https://www.buda.com). The goal is to create plots where the user can define a custom time group for each candle in the candlestick plot and also draw several indicators useful for [Technical analysis](https://en.wikipedia.org/wiki/Technical_analysis).

The motivation for this project is because the current plots in buda exchange looks like this, when you change the default time grouping:
![surbtc-plots](https://i.imgur.com/YbA9Sfg.png)

whereas Tradingview looks like this:

![Tradingview-plot](https://i.imgur.com/aSWQXAK.png)

## Current state

Currently this project is in a very early state. The user can register, sign in, add and delete some indicators to the plot. The next step is to replace the front-end with a new and modern design using react and a new library for rendering plots called [react-stockcharts](https://github.com/rrag/react-stockcharts).

The front-end is very simple and functional, the plot is rendered with Highcharts. The backend is composed of two parts. First an application build in spring 5 that manages all the requests and the connection to a mongodb database. And other part build in python and flask that manages the data grouping of the transaction so it can be in a format friendly for plotting.

## Roadmap

 - Integrate react-stockcharts as the main plotting library
 - Replace the ui with a [react](https://reactjs.org/) based one
 - Integrate more indicators
 - Support TA drawings in the plots
 - Support other cryptocurrencies besides bitcoin. The data can be extracted from other exchanges and then be converted to a local currency based on forex data
 - Support forex data of fiat currencies with data extracted from [https://1forge.com/forex-data-api/pricing](https://1forge.com/forex-data-api/pricing) and from the [Central bank](http://www.bcentral.cl/)
 - Unfortunately there will not be any ipsa stock integration, since there is no free public data available
 - Oauth2 and jwt based log in.
- Better integration  with the python back-end in order to have ml (time series) predictions

## Usage in a local machine

Make sure you have the following prerequisites:

 - A [python](https://www.python.org/) runtime, an [anaconda](https://www.anaconda.com/download/) based is prefered and recomended
 - A [java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) runtime (do not use java 10, lombok does not support it yet)
 - [maven](https://maven.apache.org/)
 - [mongodb](https://www.mongodb.com/)
 - [git](https://git-scm.com/) (optional, you can download the repositories manually)

Create two folders in which to store the different projects for example:

    mkdir surbtc-ann surbtc-plots
clone the two repositories in their respective folders

    git clone https://gitlab.com/Facosta/surbtc-ann.git
    git clone https://gitlab.com/Facosta/spring-surbt-plots.git

Create a virtual environment and  install the dependencies from the python part back-end

    cd surbtc-ann
    conda create -n surbt-ann
    source activate surbtc-ann
    conda install --file conda_requirements.txt
    pip install -r pip_requirements.txt

execute the flask mini server

    python flask_api.py

create a user in the mongodb

    db.createUser(
	    {user : "user", pwd: "123456", roles:
		    [{role: "readWrite", db:"surbtc"}] 
		})
Finally configure the /resources/application.properties file and execute the project

    mvn spring-boot:run