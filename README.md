<div id="top"></div>

[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]

<br />
<div align="center">

  <h3 align="center">Arbitrage Scanner</h3>

  <p align="center">
    Your personal assistance for cryptocurrency arbitrage!
    <br />
    <br />
    <a href="http://arbitrage-scanner.s3-website-us-east-1.amazonaws.com/">View Demo</a>
    ·
    <a href="https://github.com/gummideepak/arbitrage-scan/issues">Report Bug</a>
    ·
    <a href="https://github.com/gummideepak/arbitrage-scan/issues">Request Feature</a>
  </p>
</div>


<!-- ABOUT THE PROJECT -->
## About The Project

[Demo](http://arbitrage-scanner.s3-website-us-east-1.amazonaws.com/) (Note: FTX Exchange is not working in the hosted version due to connectivity issues from a virtual machine. Sometimes the AWS demo wont work as its a free instance. Let me know if its down so I can reboot the instance.)

The web page contains the following
 - Prices of Cryptocurriencies
 - Any Available Arbitrage opportunities among integrated exhanges

List of Exchanges Integrated 
  <ol>
    <li><a href="https://www.coinbase.com/">Coinbase</a></li>
    <li><a href="https://www.binance.com/en">Binance</a></li>
    <li><a href="https://www.kraken.com/en-us/">Kraken</a></li>
    <li><a href="https://ftx.us/">FTX</a></li>
  </ol>



<p align="right">(<a href="#top">back to top</a>)</p>

## Built Using

* [Angular](https://angular.io/)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Angular Material](https://material.angular.io/)
* [Bootstrap](https://getbootstrap.com)
* [Swagger](https://swagger.io/)

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- GETTING STARTED -->
## Getting Started

Follow the steps below for setting up the project locally.

### Prerequisites
* [NPM](https://docs.npmjs.com/downloading-and-installing-node-js-and-npm)
* [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven](https://maven.apache.org/install.html))

### Clone the repo

```shell
git clone https://github.com/gummideepak/arbitrage-scan
```

### Building and Running the Web Project

Install the `npm` packages described in the `package.json` and verify that it works:
```shell
cd arbitrage-scan
cd arbitragescan-web
npm install
npm start
```

The `npm start` command builds (compiles TypeScript and copies assets) the application into `dist/`, watches for changes to the source files, and runs `lite-server` on port `4200`.

Shut it down manually with `Ctrl-C`.

### Building and Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.arbitragescan.arbitragescandemo.ArbitragescanApiApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
cd arbitrage-scan
cd arbitragescan-api
mvn spring-boot:run
```

## FAQ
**Question:** Are there any sub-optimal choices( or short cuts taken due to limited time ) in your implementation?

**Answer:** 
1. I think the UI is a little unfinished.
2. To create the exhange object I went ahed and created them manually in the ExchangeService.java. Ideally we should be using dependency injection or use a Factory Pattern to create the objects. I was in the middle of doing it but didnt have enough time to integrate it. I will focus to setup a live demo in the remaing time.
##
**Question:** Is any part of it over-designed?

**Answer:** Mabey I belive the backend desing was necessary to support easy extension to more exhanges. I also implemented a swagger so that we dont have to write the http requests in typescript instead use the auto genrated code from swagger codegen.
##
**Question:** If you have to scale your solution to 100 users/second traffic what changes would you make, if any?

**Answer:** As the data is not user specific we can to implement a cache system (ex: Redis) or even a simple in memory cache to increase the response time. The cache expire time would be less (5 seconds mabey? Just a guess) as prices are very volatile in nature.
##
**Question:** What are some other enhancements you would have made, if you had more time to do this implementation

**Answer:** 
1. I would make the application more daynamic in nature like fetching all the available tokens from a particular exhange. Currently there are only few currencies/tokens supported which are hardcoded in the API call. The API's support any token as of now but I went with a few popular tokens.
2. I also want to ask the user the amount of investment and calulate the profit percentage according to it.
3. Alerts - Notify the user when some certian condition is met like profit percentage or profit amount is larger than some threshold.
4. Instead of only doing it with 2 exchanges we can also perform the arbitrage analysis with 3 exhanges. (More than that would be expensive in terms of transaction fees)
5. We can later extend the application to detect any unusual amount of money being sold or bought indicating a pump and dump. 

I have lot other features in mind like providing links to exact buy/sell orders (time is key because of the volatile nature) or even doing that using a click of a button 

##






<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/othneildrew/Best-README-Template.svg?style=for-the-badge
[contributors-url]: https://github.com/gummideepak/arbitrage-scan/graphs/contributors
[issues-shield]: https://img.shields.io/github/issues/othneildrew/Best-README-Template.svg?style=for-the-badge
[issues-url]: https://github.com/gummideepak/arbitrage-scan/issues
[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=for-the-badge
[license-url]: https://github.com/gummideepak/arbitrage-scan/blob/main/LICENSE
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/gummideepak
