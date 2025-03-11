[TOC]

# What is Apache Kafka?

When it comes to data event streaming, Apache Kafka is the de facto standard. It is an open-source distributed system consisting of servers and clients. Apache Kafka is used primarily to build real-time data streaming pipelines.

Apache Kafka is used by thousands of the world's leading organizations for high-performance data pipelines, streaming analytics, data integration and many other vital applications.



## [What is event streaming?](https://kafka.apache.org/intro#intro_streaming)

Event streaming is the digital equivalent of the human body's central nervous system. It is the technological foundation for the 'always-on' world where businesses are increasingly software-defined and automated, and where the user of software is more software.

Technically speaking, event streaming is the practice of capturing data in real-time from event sources like databases, sensors, mobile devices, cloud services, and software applications in the form of streams of events; storing these event streams durably for later retrieval; manipulating, processing, and reacting to the event streams in real-time as well as retrospectively; and routing the event streams to different destination technologies as needed. Event streaming thus ensures a continuous flow and interpretation of data so that the right information is at the right place, at the right time.

## [What can I use event streaming for?](https://kafka.apache.org/intro#intro_usage)

Event streaming is applied to a [wide variety of use cases](https://kafka.apache.org/powered-by) across a plethora of industries and organizations. Its many examples include:

- To process payments and financial transactions in real-time, such as in stock exchanges, banks, and insurances.
- To track and monitor cars, trucks, fleets, and shipments in real-time, such as in logistics and the automotive industry.
- To continuously capture and analyze sensor data from IoT devices or other equipment, such as in factories and wind parks.
- To collect and immediately react to customer interactions and orders, such as in retail, the hotel and travel industry, and mobile applications.
- To monitor patients in hospital care and predict changes in condition to ensure timely treatment in emergencies.
- To connect, store, and make available data produced by different divisions of a company.
- To serve as the foundation for data platforms, event-driven architectures, and microservices.

## [Apache Kafka® is an event streaming platform. What does that mean?](https://kafka.apache.org/intro#intro_platform)

Kafka combines three key capabilities so you can implement [your use cases](https://kafka.apache.org/powered-by) for event streaming end-to-end with a single battle-tested solution:

1. To **publish** (write) and **subscribe to** (read) streams of events, including continuous import/export of your data from other systems.
2. To **store** streams of events durably and reliably for as long as you want.
3. To **process** streams of events as they occur or retrospectively.

And all this functionality is provided in a distributed, highly scalable, elastic, fault-tolerant, and secure manner. Kafka can be deployed on bare-metal hardware, virtual machines, and containers, and on-premises as well as in the cloud. You can choose between self-managing your Kafka environments and using fully managed services offered by a variety of vendors.

## [How does Kafka work in a nutshell?](https://kafka.apache.org/intro#intro_nutshell)

Kafka is a distributed system consisting of **servers** and **clients** that communicate via a high-performance [TCP network protocol](https://kafka.apache.org/protocol.html). It can be deployed on bare-metal hardware, virtual machines, and containers in on-premise as well as cloud environments.

**Servers**: Kafka is run as a cluster of one or more servers that can span multiple datacenters or cloud regions. Some of these servers form the storage layer, called the brokers. Other servers run [Kafka Connect](https://kafka.apache.org/documentation/#connect) to continuously import and export data as event streams to integrate Kafka with your existing systems such as relational databases as well as other Kafka clusters. To let you implement mission-critical use cases, a Kafka cluster is highly scalable and fault-tolerant: if any of its servers fails, the other servers will take over their work to ensure continuous operations without any data loss.

**Clients**: They allow you to write distributed applications and microservices that read, write, and process streams of events in parallel, at scale, and in a fault-tolerant manner even in the case of network problems or machine failures. Kafka ships with some such clients included, which are augmented by [dozens of clients](https://cwiki.apache.org/confluence/display/KAFKA/Clients) provided by the Kafka community: clients are available for Java and Scala including the higher-level [Kafka Streams](https://kafka.apache.org/documentation/streams/) library, for Go, Python, C/C++, and many other programming languages as well as REST APIs.

## [Main Concepts and Terminology](https://kafka.apache.org/intro#intro_concepts_and_terms)

An **event** records the fact that "something happened" in the world or in your business. It is also called record or message in the documentation. When you read or write data to Kafka, you do this in the form of events. Conceptually, an event has a key, value, timestamp, and optional metadata headers. Here's an example event:

- Event key: "Alice"
- Event value: "Made a payment of $200 to Bob"
- Event timestamp: "Jun. 25, 2020 at 2:06 p.m."

**Producers** are those client applications that publish (write) events to Kafka, and **consumers** are those that subscribe to (read and process) these events. In Kafka, producers and consumers are fully decoupled and agnostic of each other, which is a key design element to achieve the high scalability that Kafka is known for. For example, producers never need to wait for consumers. Kafka provides various [guarantees](https://kafka.apache.org/documentation/#semantics) such as the ability to process events exactly-once.

Events are organized and durably stored in **topics**. Very simplified, a topic is similar to a folder in a filesystem, and the events are the files in that folder. An example topic name could be "payments". Topics in Kafka are always multi-producer and multi-subscriber: a topic can have zero, one, or many producers that write events to it, as well as zero, one, or many consumers that subscribe to these events. Events in a topic can be read as often as needed—unlike traditional messaging systems, events are not deleted after consumption. Instead, you define for how long Kafka should retain your events through a per-topic configuration setting, after which old events will be discarded. Kafka's performance is effectively constant with respect to data size, so storing data for a long time is perfectly fine.

Topics are **partitioned**, meaning a topic is spread over a number of "buckets" located on different Kafka brokers. This distributed placement of your data is very important for scalability because it allows client applications to both read and write the data from/to many brokers at the same time. When a new event is published to a topic, it is actually appended to one of the topic's partitions. Events with the same event key (e.g., a customer or vehicle ID) are written to the same partition, and Kafka [guarantees](https://kafka.apache.org/documentation/#semantics) that any consumer of a given topic-partition will always read that partition's events in exactly the same order as they were written.

![img](https://kafka.apache.org/images/streams-and-tables-p1_p4.png)Figure: This example topic has four partitions P1–P4. Two different producer clients are publishing, independently from each other, new events to the topic by writing events over the network to the topic's partitions. Events with the same key (denoted by their color in the figure) are written to the same partition. Note that both producers can write to the same partition if appropriate.

To make your data fault-tolerant and highly-available, every topic can be **replicated**, even across geo-regions or datacenters, so that there are always multiple brokers that have a copy of the data just in case things go wrong, you want to do maintenance on the brokers, and so on. A common production setting is a replication factor of 3, i.e., there will always be three copies of your data. This replication is performed at the level of topic-partitions.

This primer should be sufficient for an introduction. The [Design](https://kafka.apache.org/documentation/#design) section of the documentation explains Kafka's various concepts in full detail, if you are interested.

## [Kafka APIs](https://kafka.apache.org/intro#intro_apis)

In addition to command line tooling for management and administration tasks, Kafka has five core APIs for Java and Scala:

- The [Admin API](https://kafka.apache.org/documentation.html#adminapi) to manage and inspect topics, brokers, and other Kafka objects.
- The [Producer API](https://kafka.apache.org/documentation.html#producerapi) to publish (write) a stream of events to one or more Kafka topics.
- The [Consumer API](https://kafka.apache.org/documentation.html#consumerapi) to subscribe to (read) one or more topics and to process the stream of events produced to them.
- The [Kafka Streams API](https://kafka.apache.org/documentation/streams) to implement stream processing applications and microservices. It provides higher-level functions to process event streams, including transformations, stateful operations like aggregations and joins, windowing, processing based on event-time, and more. Input is read from one or more topics in order to generate output to one or more topics, effectively transforming the input streams to output streams.
- The [Kafka Connect API](https://kafka.apache.org/documentation.html#connect) to build and run reusable data import/export connectors that consume (read) or produce (write) streams of events from and to external systems and applications so they can integrate with Kafka. For example, a connector to a relational database like PostgreSQL might capture every change to a set of tables. However, in practice, you typically don't need to implement your own connectors because the Kafka community already provides hundreds of ready-to-use connectors.



- ### What gave birth to Apache Kafka as a platform

- ### What the main components of Apache Kafka are

- ### What the Apache Kafka ecosystem is

# Part 1: Data Integration Challenges

**Context**

A typical organization has multiple sources of data with disparate data formats. Data integration involves combining data from these multiple sources into one unified view of their business.

A typical business collects data through a variety of applications, e.g., accounting, billing, CRM**,** websites, etc. Each of these applications have their own processes for data input and update. In order to get a unified view of their business, engineers have to develop bespoke integrations between these different applications.

These direct integrations can result in a complicated solution as shown below.

![Apache Kafka helps to solve many of the challenges associated with the integration of data from multiple different systems. This diagram shows how complex the flow of data can be when systems are not decoupled.](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2F15MPdLa9Vh84mmRt8stbU0%2Fb6c1edfc8d23b88e63a06f89c2b2e1af%2FWhat_is_Apache_Kafka_Part_1_-_Data_Integration_Challenges.png&w=3840&q=75)

Each integration comes with difficulties around

- **Protocol** – how the data is transported (TCP, HTTP, REST, FTP, JDBC…)
- **Data format** – how the data is parsed (Binary, CSV, JSON, Avro…)
- **Data schema & evolution** – how the data is shaped and may change

## Apache Kafka to the rescue



**Decoupling Different Data Systems**

Apache Kafka allows us to decouple data streams and systems.

With Apache Kafka as a data integration layer, data sources will publish their data to Apache Kafka and the target systems will source their data from Apache Kafka. This decouples source data streams and target systems allowing for a simplified data integration solution, as you can see in the diagram below.

![Apache Kafka provides an effective way for organisations to overcome data integration challenges by making it easy to decouple different systems](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2F36HRcNifBz55AUvkBs1p9x%2F31af23c93be2c7b0d1233a3f9f8797e5%2FWhat_is_Apache_Kafka_Part_1_-_Decoupling_Different_Data_Systems.png&w=3840&q=75)

## What is a data stream in Apache Kafka?

A data stream is typically thought of as a potentially unbounded sequence of data. The name streaming is used because we are interested in the data being accessible as soon as it is produced.

Each of the applications in an organization where data is created is a potential data stream creator. Data created as part of data streams are typically small. The data throughput to data streams is highly variable: some streams will receive tens of thousands of records per second, and some will receive one or two records per hour.

Apache Kafka is used to store these data streams (also called topics), which then allows systems to perform stream processing - an act of performing continual calculations on a potentially endless and constantly evolving source of data. Once the stream is processed and stored in Apache Kafka, it may be transferred to another system, e.g., a database.

![Apache Kafka allows for data from various different business applications and sources to flow into a real-time data pipeline that can process millions of events per second.](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2FZm4Nu6YFkYuZrBoALR2yw%2F4f2063a4c2d070d0cf0a9f56b1624e64%2FWhat_is_Apache_Kafka_Part_1_-_Use_Cases_and_Applications.png&w=3840&q=75)

## Examples of Data streams



The following are examples of some of data streams in real-world that companies process

- **Log Analysis**. Modern applications include tens to thousands of microservices - all of which constantly produce logs. These logs are full of information that can be mined for business intelligence, failure prediction, and debugging. The challenge then is how to process these large volumes of log data being produced in one place. Companies push log data into a data stream to perform stream processing.
- **Web Analytics**. Another common use for streaming data is web analytics. Modern web applications measure almost every user activity on their site, e.g., button clicks, page views. These actions add up fast. Stream processing allows companies to process data as it is generated and not hours later.

## Why should a company use Apache Kafka?



As soon as a company has real-time data streaming needs, a streaming platform must be put in place.

Apache Kafka is one of the most popular data streaming processing platforms in the industry today, being used by more than 80% of the Fortune 100 companies. Kafka provides a simple message queue interface on top of its append-only log-structured storage medium. It stores a log of events. Data is distributed to multiple nodes. Kafka is highly scalable and fault-tolerant to node loss.

Kafka has been deployed in sizes ranging from just one node to thousands of nodes. It is used extensively in production workloads in companies such as Netflix, Apple, Uber, Airbnb, in addition to LinkedIn. The creators of Kafka left LinkedIn to form their own company called Confluent to focus full-time on Kafka and its ecosystem. Apache Kafka is now an open-source project maintained by Confluent.

## Apache Kafka History



Kafka was created at LinkedIn to service internal stream processing requirements that could not be met with traditional message queueing systems. Its first version was released in January 2011. Kafka quickly gained popularity and since then became one of the most popular projects of the Apache Foundation.

These are organizations that are POWERED BY KAFKA

https://kafka.apache.org/powered-by

Apache Kafka OpenSource Version - Ecosystem 

https://kafka.apache.org/intro

![img](https://miro.medium.com/v2/resize:fit:1225/0*z3nQB8zQjQCRhrDG.png)

The project is now mainly maintained by Confluent, with help from other companies such as IBM, Yelp, Netflix and so on.

This is the Commercial offering from Confluent

https://docs.confluent.io/platform/current/get-started/platform.html

![../_images/confluentPlatform.png](https://docs.confluent.io/platform/current/_images/confluentPlatform.png)



There are more Commercial distributions available as well (Confluent Kafka is not the only commercial game in the town)

- Confluent: [Confluent Cloud](http://cnfl.io/ccloud) (SaaS, fully managed) and [Confluent Platform](http://cnfl.io/cplatform) (software download for self-managed/on-premise)
- Cloudera distribution - https://www.cloudera.com/products/open-source/apache-hadoop/apache-kafka.html
- EmblocSoft distribution and CPFA training - https://www.emblocsoft.com/pages/en/solutions/kafka/support/
- IBM Event Streams - https://www.ibm.com/cloud/event-streams - Apache Kafka on premise and the public cloud
- Strimzi - http://strimzi.io/ - Apache Kafka Operator for Kubernetes and Openshift. Downloads and Helm Chart - https://github.com/strimzi/strimzi-kafka-operator/releases/latest 
- TIBCO Messaging - Apache Kafka Distribution - https://www.tibco.com/products/apache-kafka Downloads - https://www.tibco.com/products/tibco-messaging/downloads



## APACHE KAFKA, CONFLUENT KAFKA, JAVA VERSIONS COMPATIBILITY



Below is an illustrative compatibility matrix showing which Confluent Platform releases bundle or align with specific Apache Kafka versions, along with the Java versions generally supported by those Kafka releases. Confluent Platform packages Apache Kafka plus additional components (Schema Registry, ksqlDB, etc.) but typically adheres closely to Kafka’s Java support requirements.

Note:

1. The minimum supported Java version for Kafka 2.0 and higher is Java 8, though many organizations now use Java 11 where supported.
2. Kafka 3.0+ still supports Java 8 at minimum, though Java 11 or higher is often recommended.
3. Confluent sometimes offers patch releases on slightly newer Kafka bug-fix branches, but in general the mapping below holds for major and minor versions.

| **Confluent Platform** | **Apache Kafka** | **Minimum Java** | **Recommended Java** |
| ---------------------- | ---------------- | ---------------- | -------------------- |
| 3.0.x (2016)           | 0.10.x           | Java 7           | Java 8               |
| 3.3.x (2017)           | 0.11.x           | Java 7           | Java 8               |
| 4.0.x (2017–2018)      | 1.0.x            | Java 8           | Java 8               |
| 4.1.x (2018)           | 1.1.x            | Java 8           | Java 8               |
| 5.0.x (2018)           | 2.0.x            | Java 8           | Java 8               |
| 5.1.x (2019)           | 2.1.x            | Java 8           | Java 8               |
| 5.2.x (2019)           | 2.2.x            | Java 8           | Java 8               |
| 5.3.x (2019)           | 2.3.x            | Java 8           | Java 8               |
| 5.4.x (2020)           | 2.4.x            | Java 8           | Java 8               |
| 5.5.x (2020)           | 2.5.x            | Java 8           | Java 8               |
| 6.0.x (2020–2021)      | 2.6.x            | Java 8           | Java 8 / 11          |
| 6.1.x (2021)           | 2.7.x            | Java 8           | Java 8 / 11          |
| 6.2.x (2021–2022)      | 2.8.x            | Java 8           | Java 8 / 11          |
| 7.0.x (late 2021)      | 3.0.x            | Java 8           | Java 8 / 11          |
| 7.1.x (2022)           | 3.1.x            | Java 8           | Java 8 / 11          |
| 7.2.x (2022)           | 3.2.x            | Java 8           | Java 8 / 11          |
| 7.3.x (2022–2023)      | 3.3.x            | Java 8           | Java 8 / 11          |
| 7.4.x (2023–2024)      | 3.4.x            | Java 8           | Java 11+             |
| 7.5.x (2024)           | 3.5.x            | Java 8           | Java 11+             |

### Notes & Best Practices

- **Exact Java Versions**: Kafka typically supports up to the latest minor version of Java 8 and Java 11. Many production deployments have started moving to Java 11 for Kafka 2.6 and newer (including the corresponding Confluent Platform versions) and are testing Java 17 as it matures in the Kafka ecosystem.
- **Minor & Patch Releases**: Each Confluent Platform release is based on a specific Apache Kafka major/minor version (e.g., 2.8.x) but may include updates from minor/patch branches. Check Confluent’s official documentation if you need a very specific Kafka patch version mapping.
- **Future Versions**: Kafka’s 3.x releases continue to maintain Java 8 as a minimum, but newer features and security enhancements may be tested more frequently on Java 11+. The Confluent Platform typically inherits the same Java baselines.

# <u>Full KAFKA Ecosystem</u> 

https://cwiki.apache.org/confluence/display/KAFKA/Ecosystem

## What are the use cases of Apache Kafka?

The use cases of Apache Kafka are many. These include stream processing for different business applications. Apache Kafka makes up the storage mechanism for some of the prominent stream processing frameworks, e.g., Apache Flink, Samza.

- Messaging systems
- Activity Tracking
- Gather metrics from many different locations, for example, IoT devices
- Application logs analysis
- De-coupling of system dependencies
- Integration with Big Data technologies like Spark, Flink, Storm, Hadoop.
- Event-sourcing store

You can find a list of use cases at https://kafka.apache.org/uses

## Where is Apache Kafka not a great fit?

Apache Kafka is a great fit for the use cases outlined above, but there are a few use cases when using Apache Kafka is either not possible or not recommended:

- **Proxying millions of clients** for mobile apps or IoT: the Kafka protocol is not made for that, but some proxies exist to bridge the gap.
- **A database with indexes:** Kafka is an event streaming log with no analytical capability built in and no complex query model.
- **An embedded real-time technology for IoT:** there are lower level and lighter alternatives to perform these use cases on embedded systems.
- **Work queues:** Kafka is made of topics, not queues (unlike RabbitMQ, ActiveMQ, SQS). Queues are meant to scale to millions of consumers and to delete messages once processed. In Kafka data is not deleted once processed and consumers cannot scale beyond the number of partitions in a topic.
- **Kafka as a blockchain**: Kafka topics present some characteristics of a blockchain, where data is appended in a log, and Kafka topics can be immutable, but lack some key properties of blockchains such as the cryptographic verification of the data, as well as full history preservation.

## How is Kafka concretely being used within the industry?

Apache Kafka is widely used in the industry. Some of the use cases are highlighted below.

One more time, Small List of companies that are using Kafka in Production - 

https://kafka.apache.org/powered-by

- **Uber** uses Kafka extensively in their real-time pricing pipeline. Kafka is the backbone through which a significant proportion of the events are communicated to the different stream processing calculations. The speed and flexibility of Kafka allows Uber to adjust their pricing models to the constantly evolving events in the real world (number of available drivers and their position, users and their position, weather event, other events), and bill users the right amount to manage offer and demand.
- **Netflix** has integrated Kafka as the core component of its data platform. They refer to it internally as their Keystone data pipeline. As part of Netflix's Keystone, Kafka handles billions of events a day. Just to give an idea about the huge amount of data that Kafka can handle, Netflix sends about 5 hundred billion events and 1.3 petabytes of data per day into Kafka.

Unknown to many, Kafka is at the core of lots of the services we enjoy on a daily basis from some of the world's largest tech companies such as Uber, Netflix, Airbnb, LinkedIn, Apple & Walmart.



# Part 2: Definition of Core Apache Kafka Concepts



Now that we've learned about Apache Kafka at a high level, let's dive in and learn how to use the tool. In this part, we will cover the basics of Kafka topics, producers, and consumers.

![Apache Kafka Components. An overview of the relationship between Kafka clusters, Kafka topics, Kafka producers and Kafka Consumers.](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2FQkJT6m1g757P2O8raCds9%2F86348e6428ae350bf1af6c521a153af6%2FProducer_-_Topic_-_Consumer.png&w=3840&q=75)

## What is a Kafka Topic?



Kafka topics organize related events. For example, we may have a topic called **logs,** which contains logs from an application. Topics are roughly analogous to SQL tables. However, unlike SQL tables, Kafka topics are not queryable. Instead, we must create Kafka producers and consumers to utilize the data. The data in the topics are stored in the key-value form in binary format.

**Kafka Topics**

Read more in [Kafka Topics, Partitions & Offsets page](https://learn.conduktor.io/kafka/kafka-topics/).

## What is a Kafka Producer?



Once a topic is created in Kafka, the next step is to send data into the topic. Applications that send data into a topic are known as Kafka producers. There are many ways to produce events to Kafka, but applications typically integrate with Kafka client libraries in languages like Java, Python, Go, as well as many other languages.

Note that Kafka producers are deployed outside Kafka and only interact with Apache Kafka by sending data directly into the Kafka topics.

**Kafka Producers**

Read more in [Kafka Producers](https://learn.conduktor.io/kafka/kafka-producers/).

## What is a Kafka Consumer?



Once a topic has been created and data produced into the topic, we can have applications that make use of the data stream. Applications that pull event data from one or more Kafka topics are known as Kafka consumers. There are many ways to consume events from Kafka, but applications typically integrate with Kafka client libraries in languages like Java, Python, Go, as well as many other languages. By default consumers only consume data that was produced after the consumer first connected to the topic.

Note that Kafka consumers are deployed outside Kafka and only interact with Apache Kafka by reading data directly from Kafka topics.

Read more in [Kafka Consumers](https://learn.conduktor.io/kafka/kafka-consumers/).

# Part 3: The Kafka Ecosystem



A number of additional tools and libraries have been developed for Kafka over the years to expand its functionality. In this section, we'll look at some of the most popular parts of the wider Kafka ecosystem.

## What is Kafka Streams?



Once we have produced data from external systems into Kafka, we may want to process them using stream processing applications. Stream processing applications make use of streaming data stores like Apache Kafka to provide real-time analytics.

For example, let's assume we are having a Kafka topic named `twitter_tweets` that is a data streaming of all tweets on Twitter. From this topic, we may want to:

- Filter only tweets that have over `10` likes or replies, to capture important tweets
- Count the number of tweets received for each hashtag every `1` minute
- Combine the two to get trending topics and hashtags in real-time!

![An illustrated example of how Apache Kafka and Kafka Streams can support stream processing applications for real-time analytics and other use cases.](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2F4b8gsdqsa7FUaToJDhXV3z%2F282c99832af414d02cf31ea70e8a7fb0%2FApache_Kafka___Kafka_Streams_-_Stream_Processing_Example.png&w=3840&q=75)

In order to perform topic-level transformation within Apache Kafka, we can use streaming libraries that are meant for this use case instead of writing very complicated producer & consumer code.

In that case, we can leverage the Kafka Streams library, which is a stream processing framework that is released alongside Apache Kafka. Alternatives you may have heard of for Kafka Streams are Apache Spark, or Apache Flink.

## What is Kafka Connect?

In order to get data into Apache Kafka, we have seen that we need to leverage Kafka producers. Over time, it has been noticed that many companies shared the same data source types (databases, systems, etc...) and so writing open-source standardized code could be helpful for the greater good. The same thinking goes for Kafka Consumers.

Kafka Connect is a tool that allows us to integrate popular systems with Kafka. It allows us to re-use existing components to source data into Kafka and sink data out from Kafka into other data stores.

Examples of popular Kafka Connectors include:

- **Kafka Connect Source Connectors (producers)**: Databases (through the Debezium connector), JDBC, Couchbase, GoldenGate, SAP HANA, Blockchain, Cassandra, DynamoDB, FTP, IOT, MongoDB, MQTT, RethinkDB, Salesforce, Solr, SQS, Twitter, etc…
- **Kafka Connect Sink Connectors (consumers):** S3, ElasticSearch, HDFS, JDBC, SAP HANA, DocumentDB, Cassandra, DynamoDB, HBase, MongoDB, Redis, Solr, Splunk, Twitter

![An overview of how Apache Kafka with Kafka Connect helps to stream data between sources and sinks.](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2F6Pn6OyroXP2NupnLeuri5q%2F6f42c56d3404ec820793684f290ff9ba%2FSource_Connector_-__Sink_Connector.png&w=3840&q=75)

## What is the Schema Registry?



The Schema Registry helps register data schemas in Apache Kafka and ensure that producers and consumers will be compatible with each other while evolving. It supports the Apache Avro, Protobuf and JSON-schema data formats.

**Data Schemas**

**Data schemas** define for your data the expected fields, their names, and value types

Without a schema registry, producers and consumers are at the risk of breaking when the data schema changes.

# Kafka Fundamentals

Learn how Kafka works, get a strong understanding of the different components

------

We have learned about data event streaming, Apache Kafka and its various components at a high level.

Now, we will dive in and learn how each part of Apache Kafka works.

![Apache Kafka clusters are made up of several core components. This diagrams shows the relationships between brokers, zookeeper, producers, consumers, source systems and target systems.](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2F6TdnM9oVflXLhWBSicN58s%2F1b13dd58a82f853dae39d07f72e0b9c2%2FKafka_Cluster__-_Fundamentals.png&w=3840&q=75)

Apache Kafka Components

In this section, we will learn all of the fundamentals and understand the various Apache Kafka components such as:

- **Kafka Topics**
- **Kafka Producers**
- **Kafka Consumers**
- **Kafka Consumer Groups and Consumer Offsets**
- **Kafka Brokers**
- **Kafka Topic Replication**
- **Zookeeper**
- **KRaft Mode**



# Kafka Topics

Kafka Topics, Partitions, and Offsets

------

## What is a Kafka Topic?



Similar to how databases have tables to organize and segment datasets, Kafka uses the concept of topics to organize related messages.

A topic is identified by its name. For example, we may have a topic called **logs** that may contain log messages from our application, and another topic called **purchases** that may contain purchase data from our application as it happens.

![A Kafka Cluster with 4 Topics shown in a diagram](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2F5mX4ebnraAdPJWgmbLunH%2F6b38d80143a0a47e2bec42381a6947ef%2FApache_Kafka_Cluster_with_4_topics.png&w=3840&q=75)

Kafka topics can contain any kind of message in any format, and the sequence of all these messages is called a data stream.

**Kafka Topics - Warning**

Unlike database tables, Kafka topics are not query-able. Instead, we have to create Kafka producers to send data to the topic and Kafka consumers to read the data from the topic in order.

Data in Kafka topics is deleted after one week by default (also called the default message retention period), and this value is configurable. This mechanism of deleting old data ensures a Kafka cluster does not run out of disk space by recycling topics over time.

## What are Kafka Partitions?



Topics are broken down into a number of partitions. A single topic may have more than one partition, it is common to see topics with 100 partitions.

The number of partitions of a topic is specified at the time of topic creation. Partitions are numbered starting from `0` to `N-1`, where `N` is the number of partitions. The figure below shows a topic with three partitions, with messages being appended to the end of each one.

![Kafka Topics are broken into partitions for improved fault tolerance. This diagram shows a Kafka Topic with 3 partitions and their respective offsets.](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2F3c2aet87FgzOy28vIeKLOD%2F040c18b3ae4b09e7dc1e545885b74966%2FKafka_Topics_1.png&w=3840&q=75)

Topic Partitions

The offset is an integer value that Kafka adds to each message as it is written into a partition. Each message in a given partition has a unique offset.

**Kafka Topics**

Kafka topics are **immutable**: once data is written to a partition, it cannot be changed

## Kafka Topic example



![Apache Kafka has many real world applications. This diagram shows how Apache Kafka can be used for fleet tracking in the transport industry.](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2F30ZTg09ZIeSl2IwQZKwV3K%2Ff9bc9796ddc8cbf69a8bd5ac8fef7acc%2FKafka_Topics_2.png&w=3840&q=75)

Using Apache Kafka for Fleet Tracking

A traffic company wants to track its fleet of trucks. Each truck is fitted with a GPS locator that reports its position to Kafka. We can create a topic named - **trucks_gps** to which the trucks publish their positions. Each truck may send a message to Kafka every 20 seconds, each message will contain the truck ID and the truck position (latitude and longitude). The topic may be split into a suitable number of partitions, say 10. There may be different consumers of the topic. For example, an application that displays truck locations on a dashboard or another application that sends notifications if an event of interest occurs.

## What are Kafka Offsets?



Apache Kafka offsets represent the position of a message within a Kafka Partition. Offset numbering for every partition starts at `0` and is incremented for each message sent to a specific Kafka partition. This means that Kafka offsets only have a meaning for a specific partition, e.g., offset 3 in partition 0 doesn’t represent the same data as offset 3 in partition 1.

**Kafka Offset Ordering**

If a topic has more than one partition, Kafka guarantees the order of messages within a partition, but there is no ordering of messages across partitions.

Even though we know that messages in Kafka topics are deleted over time (as seen above), the offsets are not re-used. They continually are incremented in a never-ending sequence.



# Kafka Producers

Kafka Producers, Message Keys, Message Offsets and Serializer

------

Once a topic has been created with Kafka, the next step is to send data into the topic. This is where Kafka Producers come in.

## Kafka Producers



Applications that send data into topics are known as Kafka producers. Applications typically integrate a Kafka client library to write to Apache Kafka. Excellent client libraries exist for almost [all programming languages](https://learn.conduktor.io/kafka/kafka-sdk-list/) that are popular today including Python, Java, Go, and others.

![Apache Kafka Producers send data into Kafka. These messages are then routed by the broker to the relevant topics and partitions.](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2F2iSkuKgRTQvHF9rrd3NyEu%2F3475e99cf672f679281c92882c6baca4%2FKafka_Producers_1.png&w=3840&q=75)



A Kafka producer sends messages to a topic, and messages are distributed to partitions according to a mechanism such as key hashing (more on it below).

For a message to be successfully written into a Kafka topic, a producer must specify a level of acknowledgment (acks). This subject will be introduced in depth in the [topic replication](https://learn.conduktor.io/kafka/kafka-topic-replication/) section.

## Message Keys



Each event message contains an optional key and a value.

In case the key (`key=null`) is not specified by the producer, messages are distributed evenly across partitions in a topic. This means messages are sent in a round-robin fashion (partition *p0* then *p1* then *p2*, etc... then back to *p0* and so on...).

**If a key is sent** (`key != null`)**, then all messages that share the same key will always be sent and stored in the same Kafka partition**. A key can be anything to identify a message - a string, numeric value, binary value, etc.

Kafka message keys are commonly used when there is a need for message ordering for all messages sharing the same field. For example, in the scenario of tracking trucks in a fleet, we want data from trucks to be in order at the individual truck level. In that case, we can choose the key to be `truck_id`. In the example shown below, the data from the truck with id *truck_id_123* will always go to partition *p0.*

![Apache Kafka Producer sending trucking fleet data into 2 Kafka Brokers. ](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2F4nCZ0Xun8V04DFJ1KFLIW9%2Feb63f93e34c0cc71744a44b715aeb0dc%2FKafka_Producers_2.png&w=3840&q=75)

Messages with Keys

You will learn about the process of key hashing (the process determining which key goes to which partition) at the bottom of this page.

## Kafka Message Anatomy



Kafka messages are created by the producer. A Kafka message consists of the following elements:

![Diagram showing how Kafka Producers structure a message created by the Apache Kafka Producer.](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2F2TuJ55uK20OUVLQgZ17yUU%2F9bb611597f4914e971d85e3938856968%2FKafka_Producers_3.png&w=3840&q=75)

Structure of a Kafka Message

- **Key**. Key is optional in the Kafka message and it can be null. A key may be a string, number, or any object and then the key is serialized into binary format.
- **Value**. The value represents the content of the message and can also be null. The value format is arbitrary and is then also serialized into binary format.
- **Compression Type**. Kafka messages may be compressed. The compression type can be specified as part of the message. Options are `none`, `gzip`, `lz4`, `snappy`, and `zstd`
- **Headers**. There can be a list of optional Kafka message headers in the form of key-value pairs. It is common to add headers to specify metadata about the message, especially for tracing.
- **Partition + Offset**. Once a message is sent into a Kafka topic, it receives a partition number and an offset id. The combination of topic+partition+offset uniquely identifies the message
- **Timestamp**. A timestamp is added either by the user or the system in the message.

## Kafka Message Serializers



In many programming languages, the key and value are represented as objects, which greatly increases the code readability. However, Kafka brokers expect byte arrays as keys and values of messages. The process of transforming the producer's programmatic representation of the object to binary is **called message serialization**.

As shown below, we have a message with an `Integer` key and a `String` value. Since the key is an integer, we have to use an `IntegerSerializer` to convert it into a byte array. For the value, since it is a string, we must leverage a `StringSerializer`.

![Message serialization diagram showing how Apache Kafka Producers integer and string serializers.](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2F4b0lmoeABfUigQ4w3CjmIw%2F7ecc37919a98945736dbc6e9b24594a4%2FKafka_Producers_4.png&w=3840&q=75)

Message Serialization

As part of the Java Client SDK for Apache Kafka, [several serializers already exist](https://github.com/a0x8o/kafka/tree/master/clients/src/main/java/org/apache/kafka/common/serialization), such as string (which supersedes JSON), integer, float. Other serializers may have to be written by the users, but commonly distributed Kafka serializers exist and are efficiently written for formats such as [JSON-Schema](https://github.com/confluentinc/schema-registry/blob/master/json-schema-serializer/src/main/java/io/confluent/kafka/serializers/json/KafkaJsonSchemaSerializer.java), [Apache Avro](https://github.com/confluentinc/schema-registry/blob/master/avro-serializer/src/main/java/io/confluent/kafka/serializers/KafkaAvroSerializer.java) and [Protobuf](https://github.com/confluentinc/schema-registry/blob/master/protobuf-serializer/src/main/java/io/confluent/kafka/serializers/protobuf/KafkaProtobufSerializer.java), thanks to the Confluent Schema Registry.

**Serialization Support**

If you are not using a JVM-based programming language for serialization and deserialization, ensure that your Kafka client library supports the data formats that you need!

## For the curious: Kafka Message Key Hashing



A Kafka partitioner is a code logic that takes a record and determines to which partition to send it into.

![Kafka Producers use default partitioning logic to assign Kafka Messages to the appropriate Apache Kafka Partition.](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2F7DKEYbg6kUcO2hQJftgGYD%2F743ed180180a9d08f135c4bbff28cb2a%2FKafka_Producers_5.png&w=3840&q=75)

Default Partitioner

In that effect, it is common for partitioners to leverage the Kafka message keys to route a message into a specific topic-partition. As a reminder, all messages with the same key will go to the same partition.

**Kafka Key Hashing**

**Key Hashing** is the process of determining the mapping of a key to a partition.

In the default Kafka partitioner, the keys are hashed using the **murmur2 algorithm,** with the formula below for the curious:



```
targetPartition = Math.abs(Utils.murmur2(keyBytes)) % (numPartitions - 1)
```

It is possible to override the default partitioner via the producer property `partitioner.class`, although it is not advisable unless you know what you are doing.



# Kafka Consumers

What is a Kafka consumer and what are message deserializers?

------

Once a topic has been created in Kafka and data has been placed in the topic, we can start to build applications that make use of this data stream. Applications that pull event data from one or more Kafka topics are known as Kafka Consumers.

------

## Kafka Consumers



Applications that read data from Kafka topics are known as consumers. Applications integrate a Kafka client library to read from Apache Kafka. Excellent client libraries exist for almost [all programming languages](https://learn.conduktor.io/kafka/kafka-sdk-list/) that are popular today including Python, Java, Go, and others.

Consumers can read from one or more partitions at a time in Apache Kafka, and data is read in order **within each partition** as shown below.

![Kafka consumers in this diagram are reading messages from various Apache Kafka Brokers and Topics.](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2F2rngiBRe1Db4fOU9vJjD92%2F919d7900945ad93db62e1d6b37699ad7%2FKafka_Consumers_1.png&w=3840&q=75)

Kafka Consumers

A consumer always reads data from a lower offset to a higher offset and cannot read data backwards (due to how Apache Kafka and clients are implemented).

If the consumer consumes data from more than one partition, the message order is not guaranteed across multiple partitions because they are consumed simultaneously, but the message read order is still guaranteed within each individual partition.

By default, Kafka consumers will only consume data that was produced after it first connected to Kafka. Which means that to read historical data in Kafka, one must specify it as an input to the command, as we will see in the practice section.

Kafka consumers are also known to implement a "pull model". This means that Kafka consumers must request data from Kafka brokers in order to get it (instead of having Kafka brokers continuously push data to consumers). This implementation was made so that consumers can control the speed at which the topics are being consumed.

------

## Kafka Message Deserializers



**Serialization & Deserialization**

Data being consumed must be deserialized in the same format it was serialized in.

As we have seen before, the data sent by the Kafka producers is [serialized](https://learn.conduktor.io/kafka/kafka-producers/). This means that the data received by the Kafka consumers must be correctly deserialized in order to be useful within your application. Data being consumed must be deserialized in the same format it was serialized in. For example:

- if the producer serialized a `String `using `StringSerializer`, the consumer must deserialize it using `StringDeserializer`
- if the producer serialized an `Integer` using `IntegerSerializer`, the consumer must deserialize it using `IntegerDeserializer`

![Kafka Consumers must use the same format for deserialization that was used by the producer when serializing the message. This daigram shows the deserialization process.](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2F6ZTT5N2bkfebM8gfWTLvCg%2F11ca8bd5ab3203d48d5b1494531cbc6b%2FKafka_Consumers_2.png&w=3840&q=75)

Deserialization

The serialization and deserialization format of a topic must not change during a topic lifecycle. If you intend to switch a topic data format (for example from JSON to Avro), it is considered best practice to create a new topic and migrate your applications to leverage that new topic.

**Poison Pills**

Messages sent to a Kafka topic that do not respect the agreed-upon serialization format are called poison pills. [They are not fun to deal with.](https://www.slideshare.net/ConfluentInc/streaming-apps-and-poison-pills-handle-the-unexpected-with-kafka-streams-loic-divad-xebia-france-kafka-summit-sf-2019)

Failure to correctly deserialize may cause crashes or inconsistent data being fed to the downstream processing applications. This can be tough to debug, so it is best to think about it as you're writing your code the first time.

# Kafka Consumer Groups & Offsets

What are Kafka consumer groups and consumer offsets?

------

We have seen that consumers can consume data from Kafka topics partitions individually, but for horizontal scalability purposes it is recommended to consume Kafka topics as a group.

------

## Kafka Consumer Groups



Consumers that are part of the same application and therefore performing the same "logical job" can be grouped together as a Kafka consumer group.

A topic usually consists of many partitions. These partitions are a unit of parallelism for Kafka consumers.

The benefit of leveraging a Kafka consumer group is that the consumers within the group will coordinate to split the work of reading from different partitions.

![Apache Kafka Consumer Group diagram showing how a consumer group reads messages from a Kafka topic with 5 partitions.](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2F4AFnzk6VE1HSnnJN1MGftu%2F76288b1d9df5a5ae281c4accf5f25ec1%2FConsumer_Group_reading_from_topic_with_5_partitions.png&w=3840&q=75)

## Kafka Consumer Group ID



In order for indicating to Kafka consumers that they are part of the same specific group , we must specify the consumer-side setting `group.id`.

Kafka Consumers automatically use a `GroupCoordinator` and a `ConsumerCoordinator` to assign consumers to a partition and ensure the load balancing is achieved across all consumers in the same group.

It is important to note that each topic partition is only assigned to one consumer within a consumer group, but a consumer from a consumer group can be assigned multiple partitions.

![Apache Kafka Consumer Group diagram showing how a consumer group reads messages from a Kafka topic with 5 partitions.](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2F4AFnzk6VE1HSnnJN1MGftu%2F76288b1d9df5a5ae281c4accf5f25ec1%2FConsumer_Group_reading_from_topic_with_5_partitions.png&w=3840&q=75)

In the example above, *Consumer 1* of consumer group *consumer-group-application-1* has been assigned *Partition 0* and *Partition 1*, whereas *Consumer 2* is assigned *Partition 2* and *Partition 3*, and finally *Consumer 3* is assigned *Partition 4*. Only *Consumer 1* receives messages from *Partition 0* and *Partition 1*, while only consumer *Consumer 2* receives messages from *Partition 2 and 3,* and only *Consumer 3* receives messages from *Partition 4*.

Each of your applications (that may be composed of many consumers) reading from Kafka topics must specify a different `group.id`. That means that multiple applications (consumer groups) can consume from the same topic at the same time:

![Diagram showing consumers within a consumer group reading messages from different topic partitions.](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2F2FCDtp8CP4DLE0m3SMnqNn%2Fa7414ad78bf8c61c57ea6de4bb314709%2FKafka_Consumer_Groups_1.png&w=3840&q=75)

Kafka Consumer Groups

If there are more consumers than the number of partitions of a topic, then some consumers will remain inactive as shown below. Usually, we have as many consumers in a consumer group as the number of partitions. If we want more consumers for higher throughput, we should create more partitions while creating the topic. Otherwise, some of the consumers may remain inactive.

![Diagram shows Consumer in a Kafka Consumer Group inactive when there are more consumers than partitions.](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2FWam1FbUec10Blz1V3YttV%2F7e08aa72e3b75cec686cec850e2ce51b%2FKafka_Consumer_Groups_2.png&w=3840&q=75)

More consumers than partitions

------

## Kafka Consumer Offsets



Kafka brokers use an internal topic named `__consumer_offsets` that keeps track of what messages a given **consumer group** last successfully processed.

As we know, each message in a Kafka topic has a partition ID and an offset ID attached to it.

Therefore, in order to "checkpoint" how far a consumer has been reading into a topic partition, the consumer will regularly **commit** the latest processed message, also known as **consumer offset**.

In the figure below, a consumer from the consumer group has consumed messages up to offset `4262`, so the consumer offset is set to `4262`.

![Diagram showing how Kafka Consumers from a Consumer Group read messages from the last committed consumer offset.](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2F4tMX1YrCV40XMKLZH1pHTE%2F26f0f5ba577d10da0dfff967b98fa69c%2FKafka_Consumer_Groups_3_2x.png&w=3840&q=75)

Consumer Offset

Most client libraries automatically commit offsets to Kafka for you on a periodic basis, and the responsible Kafka broker will ensure writing to the `__consumer_offsets` topic (therefore consumers do not write to that topic directly).

The process of committing offsets is not done for every message consumed (because this would be inefficient), and instead is a periodic process.

This also means that when a specific offset is committed, all previous messages that have a lower offset are also considered to be committed.

------

## Why use Consumer Offsets?



Offsets are critical for many applications. If a Kafka client crashes, a rebalance occurs and the latest committed offset help the remaining Kafka consumers know where to restart reading and processing messages.

In case a new consumer is added to a group, another consumer group rebalance happens and consumer offsets are yet again leveraged to notify consumers where to start reading data from.

Therefore consumer offsets must be committed regularly.

### Delivery semantics for consumers

By default, Java consumers automatically commit offsets (controlled by the `enable.auto.commit=true` property) every `auto.commit.interval.ms` (5 seconds by default) when `.poll()` is called.

Details of that mechanism are discussed in [Delivery Semantics for Consumers](https://learn.conduktor.io/kafka/delivery-semantics-for-kafka-consumers/).

A consumer may opt to commit offsets by itself (`enable.auto.commit=false`). Depending on when it chooses to commit offsets, there are delivery semantics available to the consumer. The three delivery semantics are explained below.

- At most once:
  - Offsets are committed as soon as the message is received.
  - If the processing goes wrong, the message will be lost (it won’t be read again).
- At least once (usually preferred):
  - Offsets are committed after the message is processed.
  - If the processing goes wrong, the message will be read again.
  - This can result in duplicate processing of messages. Therefore, it is best practice to make sure data processing is idempotent (i.e. processing the same message twice won't produce any undesirable effects
- Exactly once:
  - This can only be achieved for Kafka topic to Kafka topic workflows using the transactions API. The Kafka Streams API simplifies the usage of that API and enables exactly once using the setting `processing.guarantee=exactly_once_v2 `(`exactly_once` on Kafka < 2.5)
  - For Kafka topic to External System workflows, to *effectively* achieve exactly once, you must use an idempotent consumer.

In practice, at least once with idempotent processing is the most desirable and widely implemented mechanism for Kafka consumers.

# Kafka Brokers

What is a Kafka broker? How do we connect to Kafka brokers?

------

In the last lesson, we learned that a topic may have more than one partition. Each partition may live on different servers, also known as Kafka brokers.

## What is a Kafka Broker?



A single Kafka server is called a Kafka Broker. That Kafka broker is a program that runs on the Java Virtual Machine (Java version 11+) and usually a server that is meant to be a Kafka broker will solely run the necessary program and nothing else.

## What is Kafka Cluster?



An ensemble of Kafka brokers working together is called a Kafka cluster. Some clusters may contain just one broker or others may contain three or potentially hundreds of brokers. Companies like Netflix and Uber run hundreds or thousands of Kafka brokers to handle their data.

A broker in a cluster is identified by a unique numeric ID. In the figure below, the Kafka cluster is made up of three Kafka brokers.

![Diagram showing a Kafka cluster with multiple Kafka brokers.](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2F7sXJ04pZNvcVfjEliAOU4U%2F736b932d89604614dcde13316ff72c89%2FKafka_Brokers_1.png&w=3840&q=75)

Kafka Cluster

## Kafka Brokers and Topics



Kafka brokers store data in a directory on the server disk they run on. Each topic-partition receives its own sub-directory with the associated name of the topic. The advanced internals of how Kafka stores data is discussed in [Kafka Topics Internals: Segments and Indexes](https://learn.conduktor.io/kafka/kafka-topics-internals-segments-and-indexes/).

To achieve high throughput and scalability on topics, Kafka topics are partitioned. If there are multiple Kafka brokers in a cluster, then partitions for a given topic will be distributed among the brokers evenly, to achieve load balancing and scalability.

![3 Kafka Brokers with 2 Kafka Topics and topic partitions.](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2F36qFnXyQJLOdUjVYPLUH7G%2F1e6a16fa0b7f6c81921176722da66a9b%2FKafka_Brokers_2.png&w=3840&q=75)

Kafka Topic Partitions

In the diagram above, there are two topics illustrated - *Topic-A* has three partitions. They are distributed evenly among the three available brokers in the cluster. Alternatively, there may be fewer (or more) partitions of a topic than the number of brokers in the cluster. *Topic-B*, in our case, has two partitions only. In this case, *Broker 103* does not contain any partition of *Topic-B*.

There is no relationship between the broker ID and the partition ID - Kafka does a good job of distributing partitions evenly among the available brokers. In case the cluster becomes unbalanced due to an overload of a specific broker, it is possible for Kafka administrators to rebalance the cluster and move partitions.

Do not worry: one aspect that is discussed in [in the next page](https://learn.conduktor.io/kafka/kafka-topic-replication/) is around how partitions are placed on Kafka brokers when topics are replicated.

## How do clients connect to a Kafka Cluster (bootstrap server)?



A client that wants to send or receive messages from the Kafka cluster **may connect to any broker in the cluster.** Every broker in the cluster has metadata about all the other brokers and will help the client connect to them as well, and **therefore any broker in the cluster is also called a bootstrap server.**

The bootstrap server will return metadata to the client that consists of a list of all the brokers in the cluster. Then, when required, the client will know which exact broker to connect to to send or receive data, and accurately find which brokers contain the relevant topic-partition.

![Connecting to a Kafka Cluster (Bootstrap Server) diagram. Process for connecting to a Kafka broker within an Apache Kafka cluster.](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2Ft5iUM0ijzUFLEZGP2ugjF%2F3d26499dc1cd7fe03edbfe91b2b19289%2FKafka_Brokers_3.png&w=3840&q=75)

Connecting to a Kafka Cluster

In practice, it is common for the Kafka client to reference at least two bootstrap servers in its connection URL, in the case one of them not being available, the other one should still respond to the connection request. That means that Kafka clients (and developers / DevOps) do not need to be aware of every single hostname of every single broker in a Kafka cluster, but only to be aware and reference two or three in the connection string for clients.



# Kafka Topic Replication

What is Kafka topic replication?

------

**One of the main reasons for Kafka's popularity, is the resilience it offers in the face of broker failures.** Machines fail, and often we cannot predict when that is going to happen or prevent it. Kafka is designed with replication as a core feature to withstand these failures while maintaining uptime and data accuracy.

## Kafka Topic Replication Factor



**Kafka Replication**

Data Replication helps prevent data loss by writing the same data to more than one broker

In Kafka, replication means that data is written down not just to one broker, but many.

The replication factor is a topic setting and is specified at topic creation time.

- A replication factor of `1` means no replication. It is mostly used for development purposes and should be avoided in test and production Kafka clusters
- A replication factor of `3` is a commonly used replication factor as it provides the right balance between broker loss and replication overhead.

In the cluster below consisting of three brokers, the replication factor is `2`. When a message is written down into *Partition 0* of *Topic-A* in *Broker 101*, it is also written down into *Broker 102* because it has *Partition 0* as a replica.

![Diagram showing a default Apache Kafka Replication Factor of 2 distributing messages across 3 different Kafka Brokers.](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2F1tJeCfjCZpHjb0DTZ8RY4w%2F08ad00fc5cc78c935247b857504985bf%2FKafka_Topic_Replication_1.png&w=3840&q=75)

Kafka Topic Replication

Thanks to a replication factor of 2, we can withstand the failure of one broker. This means that if *Broker 102* failed, as you see below, *Broker 101 & 103* would still have the data.

![Diagram showing how Kafka Topic Replication provides resilience when a Kafka Broker fails.](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2F5zFkpuHGrShhUZJlQx6kkx%2F4218a689eb9ec7a1b996509c77916518%2FKafka_Topic_Replication_2.png&w=3840&q=75)

Kafka Broker Failure

## What are Kafka Partitions Leader and Replicas?



For a given topic-partition, one Kafka broker is designated by the cluster to be responsible for sending and receiving data to clients. That broker is known as the leader broker of that topic partition. Any other broker that is storing replicated data for that partition is referred to as a replica.

Therefore, each partition has one leader and multiple replicas.

## What are In-Sync Replicas (ISR)?



An ISR is a replica that is up to date with the leader broker for a partition. Any replica that is not up to date with the leader is out of sync.

![Kafka Topic Replication relies on leader selection and the creation of in-sync replicas (ISR). This diagram shows the Kafka replication process across 3 brokers.](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2F5P2nvNF3aHAsch8IenxLy9%2F654888cfcc006d4f10d2fa732329911f%2FKafka_Topic_Replication_3.png&w=3840&q=75)

Leaders & In-Sync Replicas

Here we have *Broker 101* as *Partition 0* leader and *Broker 102* as the leader of *Partition 1*. *Broker 102* is a replica for *Partition 0* and *Broker 103* is a replica for *Partition 1*. If the leader broker were to fail, one of the replicas will be elected as the new partition leader by an election.

## Kafka producers acks setting



Kafka producers only write data to the current leader broker for a partition.

Kafka producers must also specify a level of acknowledgment `acks` to specify if the message must be written to a minimum number of replicas before being considered a successful write.

**Default acks values in Kafka v3.0**

The default value of `acks` has changed with Kafka v3.0

- if using Kafka < v3.0, `acks=1`
- if using Kafka >= v3.0, `acks=all`



### acks=0



When `acks=0` producers consider messages as "written successfully" the moment the message was sent without waiting for the broker to accept it at all.

![Illustration of Kafka Producer acks Setting set to 0. This 'fire-and-forget' approach is only useful for scenarios where it is OK to potentially lose messages or data.](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2FSSa6dWceX7LtTjtVI92Bs%2Fabab84f7d8fd2429dfe9c99e4d29527f%2FAdv_Producer_Acks_DD_1.png&w=3840&q=75)

acks = 0

If the broker goes offline or an exception happens, we won’t know and will lose data. This is useful for data where it’s okay to potentially lose messages, such as metrics collection, and produces the highest throughput setting because the network overhead is minimized.

### acks = 1



When `acks=1` , producers consider messages as "written successfully" when the message was acknowledged by only the leader.

![Overview of process when the Kafka Producer acks Setting is set to 1. The message receipt is only acknowledged by the leader in the Kafka replication setup.](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2F2FXXu7gdxEpADV0SuixTCH%2F8cac72693d6cb459f45230ac59f73433%2FAdv_Producer_Acks_DD_2.png&w=3840&q=75)

acks = 1

Leader response is requested, but replication is not a guarantee as it happens in the background. If an ack is not received, the producer may retry the request. If the leader broker goes offline unexpectedly but replicas haven’t replicated the data yet, we have a data loss.

### acks = all



When `acks=all`, producers consider messages as "written successfully" when the message is accepted by all in-sync replicas (ISR).

![Diagram showing process when the Kafka producer acks setting is set to 'all'. The message is acknowledged by all in-sync replicas.](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2FYeG6HfAi9e8pWslz9rmQl%2Faaa8432f79c247d9fee37b4d7da598d0%2FAdv_Producer_Acks_DD_3.png&w=3840&q=75)

acks = all

The lead replica for a partition checks to see if there are enough in-sync replicas for safely writing the message (controlled by the broker setting `min.insync.replicas`). The request will be stored in a buffer until the leader observes that the follower replicas replicated the message, at which point a successful acknowledgement is sent back to the client.

The`min.insync.replicas` can be configured both at the topic and the broker-level. The data is considered committed when it is written to all in-sync replicas - `min.insync.replicas.` A value of 2 implies that at least 2 brokers that are ISR (including leader) must respond that they have the data.

If you would like to be sure that committed data is written to more than one replica, you need to set the minimum number of in-sync replicas to a higher value. If a topic has three replicas and you set `min.insync.replicas` to `2`, then you can only write to a partition in the topic if at least two out of the three replicas are in-sync. When all three replicas are in-sync, everything proceeds normally. This is also true if one of the replicas becomes unavailable. However, if two out of three replicas are not available, the brokers will no longer accept produce requests. Instead, producers that attempt to send data will receive `NotEnoughReplicasException`.

![Diagram showing how Kafka Topic Replication, ISR and Producer acks settings combine to provide robust message safety even when 2 out of 3 brokers fail.](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2F3hv820JRmEOuuMELP6molP%2F8d7e04853ae37999fee673dd8df8c63f%2FAdv_Producer_Acks_DD_4.png&w=3840&q=75)

Kafka Topic Replication, ISR & Message Safety

## Kafka Topic Durability & Availability



For a topic replication factor of 3, topic data durability can withstand the loss of 2 brokers. As a general rule, for a replication factor of `N`, you can permanently lose up to `N-1` brokers and still recover your data.

Regarding availability, it is a little bit more complicated... To illustrate, let's consider a replication factor of 3:

- Reads: As long as one partition is up and considered an ISR, the topic will be available for reads
- Writers:
  - `acks=0` & `acks=1` : as long as one partition is up and considered an ISR, the topic will be available for writes.
  - `acks=all`:
    - `min.insync.replicas=1` (default): the topic must have at least 1 partition up as an ISR (that includes the reader) and so we can tolerate two brokers being down
    - `min.insync.replicas=2`: the topic must have at least 2 ISR up, and therefore we can tolerate at most one broker being down (in the case of replication factor of 3), and we have the guarantee that for every write, the data will be at least written twice.
    - `min.insync.replicas=3`: this wouldn't make much sense for a corresponding replication factor of 3 and we couldn't tolerate any broker going down.
    - in summary, when `acks=all` with a `replication.factor=N` and `min.insync.replicas=M` we can tolerate `N-M` brokers going down for topic availability purposes

**Kafka Topic Replication Settings**

`acks=all` and `min.insync.replicas=2` is the most popular option for data durability and availability and allows you to withstand at most the loss of **one** Kafka broker

## Kafka Consumers Replicas Fetching



Kafka consumers read by default from the partition leader.

![Diagram showing how Kafka consumers typically read from the topic partition leader](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2F2b0vLZH7UkTZc2Ftd3T3vd%2F949e36af9d24bedcac0f3264e7395349%2FKafka_Topic_Partition_Leader__1_.png&w=3840&q=75)

But since Apache Kafka 2.4, it is possible to configure consumers to read from in-sync replicas instead (usually the closest).

Reading from the closest in-sync replicas (ISR) may improve the request latency, and also decrease network costs, because in most cloud environments cross-data centers network requests incur charges.

![Diagram showing the Kafka Consumers replica fetching process in Apache Kafka](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2FdgHCQOcUVdZZExnhJgn13%2F60fe19081b63251e60a54de65f68e1e8%2FKafka_Consumers_Replica_Fetching.png&w=3840&q=75)

## Preferred leader



The preferred leader is the designated leader broker for a partition at topic creation time (as opposed to being a replica).

**Leader Election**

The process of deciding which broker is a leader at topic creation time is called a preferred leader election.

When the preferred leader goes down, any partition that is an ISR (in-sync replica) is eligible to become a new leader (but not a preferred leader). Upon recovering the preferred leader broker and having its partition data back in sync, the preferred leader will regain leadership for that partition.

# Zookeeper with Kafka

What is the role of Zookeeper in a Kafka cluster?

------

**What is Zookeeper in Kafka?**

Zookeeper is used to track cluster state, membership, and leadership

**Zookeeper Being Eliminated from Kafka v4.x**

**Important**:

1. Kafka 0.x, 1.x & 2.x must use Zookeeper
2. Kafka 3.x can work without Zookeeper (KIP-500) but is not production ready yet
3. Kafka 4.x will not have Zookeeper

## What is Zookeeper in Kafka and what does Zookeeper do?

How do the Kafka brokers and clients keep track of all the Kafka brokers if there is more than one? The Kafka team decided to use Zookeeper for this purpose.

Zookeeper is used for metadata management in the Kafka world. For example:

- Zookeeper keeps track of which brokers are part of the Kafka cluster
- Zookeeper is used by Kafka brokers to determine which broker is the leader of a given partition and topic and perform leader elections
- Zookeeper stores configurations for topics and permissions
- Zookeeper sends notifications to Kafka in case of changes (e.g. new topic, broker dies, broker comes up, delete topics, etc.…)

**Consumer Offsets**

Zookeeper does NOT store consumer offsets with Kafka clients >= v0.10

A Zookeeper cluster is called an *ensemble*. It is recommended to operate the ensemble with an odd number of servers, e.g., 3, 5, 7, as a strict majority of ensemble members (a quorum) must be working in order for Zookeeper to respond to requests. Zookeeper has a leader to handle writes, the rest of the servers are followers to handle reads.

![alt text](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2F2t1FcWOUXQ8wWgdHkRPjfS%2Fdee8969043aeeb06548e427ea4a02c37%2FZookeeper_with_Kafka_1.png&w=3840&q=75)

Zookeeper in Kafka

## Should you use Zookeeper with Kafka brokers?



As long as Kafka without Zookeeper is not production ready, you must use Zookeeper in your production deployments for Apache Kafka.

## Should you use Zookeeper with Kafka clients?



Over time, the Kafka clients and CLI have been migrated to leverage the brokers as a connection endpoint instead of Zookeeper.

This means that:

- since Kafka 0.10, consumers store offset in Kafka and Zookeeper and must not connect to Zookeeper as the option is deprecated
- since Kafka 2.2, the `kafka-topics.sh` CLI command references Kafka brokers and not Zookeeper for topic management (creation, deletion, etc...) and the Zookeeper CLI argument is deprecated.
- All of the APIs and commands that were previously leveraging Zookeeper are migrated to use Kafka instead, so that when clusters are migrated to be without Zookeeper, the change is invisible to clients.
- Zookeeper is also less secure than Kafka, and therefore Zookeeper ports should only be opened to allow traffic from Kafka brokers, and not Kafka clients

**Therefore, to be a great modern-day Kafka developer, never ever use Zookeeper as a configuration in your Kafka clients, and other programs that connect to Kafka.**

# Kafka KRaft Mode

Apache Kafka without Zookeeper

------

The Kafka project undertook one of its greatest change with the introduction of [KIP-500](https://cwiki.apache.org/confluence/display/KAFKA/KIP-500%3A+Replace+ZooKeeper+with+a+Self-Managed+Metadata+Quorum) on August 1st 2019: the desire to remove Zookeeper as a dependency to running Apache Kafka.

## Why remove Zookeeper from Kafka?



Kafka scaling has hit a performance bottleneck with Zookeeper, which means Kafka has the following limitations with Zookeeper:

- Kafka clusters only support a limited number of partitions (up to 200,000)
- When a Kafka broker joins or leaves a cluster, a high number of leader election must happen which can overload Zookeeper and slow down the cluster temporarily
- Kafka clusters setup is difficult and depends on another component to setup
- Kafka cluster metadata is sometimes out-of-sync from Zookeeper
- Zookeeper security is lagging behind Kafka security

## Kafka KRaft Mode



It has been noted as part of KIP-500 that the metadata of Kafka itself is a log and that Kafka brokers should be able to consume that metadata log as an internal metadata topic. Kafka leverages itself!

Removing Zookeeper means that Kafka must still act as a quorum to perform controller election and therefore the Kafka brokers implement the [Raft protocol](https://cwiki.apache.org/confluence/display/KAFKA/KIP-595%3A+A+Raft+Protocol+for+the+Metadata+Quorum) thus giving the name KRaft to the new Kafka Metadata Quorum mode.

![Diagram showing the difference between Kafka with Zookeeper and Kafka in KRaft mode with Quorum Controller.](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2FwJyq0YBt5XYTusxreC0g6%2F9f985d68a1f0763a1f067c44ec2e9ea1%2FKafka_KRaft_Mode_1.png&w=3840&q=75)

Without Zookeeper, the following benefits are observed in Kafka:

- Ability to scale to millions of partitions, easier to maintain and set up
- Improved stability, easier to monitor, support, and administer
- Single process to start Kafka
- Single security model for the whole system
- Faster controller shutdown and recovery time

## More Kafka KRaft reading

Kafka KRaft was officially released as of Kafka version 3.3 and is now production ready. Read more on the [change here](https://cwiki.apache.org/confluence/display/KAFKA/KIP-833%3A+Mark+KRaft+as+Production+Ready).

A starting tutorial is included on this site for [Windows](https://learn.conduktor.io/kafka/how-to-install-apache-kafka-on-windows/), [Mac](https://learn.conduktor.io/kafka/how-to-install-apache-kafka-on-mac/) and [Linux](https://learn.conduktor.io/kafka/how-to-install-apache-kafka-on-linux/).

A good blog on the [Confluent blog](https://www.confluent.io/blog/kafka-without-zookeeper-a-sneak-peek/) describes the benefits of KRaft.

# Delivery Semantics for Kafka Consumers

Deep dive into delivery semantics available to Kafka consumers

------

A consumer reading from a Kafka partition may choose when to commit offsets. That strategy impacts the behaviors if messages are skipped or read twice upon a consumer restart. These behaviors are discussed on this page.

## At Most Once Delivery



In this case, offsets are committed as soon as a message batch is received after calling `poll()`. If the subsequent processing fails, the message will be lost. It will not be read again as the offsets of those messages have been committed already. This may be suitable for systems that can afford to lose data.

The sequence of steps is illustrated below.

![Diagram of Kafka Consumer Delivery Semantics set to At Most Once](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2F3HWZKKcNQLUiVaZBHOQKWt%2F422c797f8ee23205502b6ddc6e321e54%2FAdv_Delivery_Semantics_for_Consumers_1_2x.png&w=3840&q=75)

At Most Once

## At Least Once Delivery (usually preferred)



In at-least-once delivery, every event from the source system will reach its destination, but sometimes retries will cause duplicates. Here, offsets are committed after the message is processed. If the processing goes wrong, the message will be read again. This can result in duplicate processing of messages. This is suitable for consumers that cannot afford any data loss.

**Idempotent Processing**

Make sure your processing is idempotent (i.e. processing again the messages won’t impact your systems)

![Diagram showing Kafka Consumer Delivery Semantics set to At Least Once](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2F3X2ZPpl4wkTmvnly4e60cu%2F6d3b7404b93030bdfff9012f465ac560%2FAdv_Delivery_Semantics_for_Consumers_2_2x.png&w=3840&q=75)

## Exactly Once Delivery



Some applications require not just at-least-once semantics (meaning no data loss), but also exactly-once semantics. Each message is delivered exactly once. This may be achieved in certain situations if Kafka and the consumer application cooperate to make exactly-once semantics happen.

- This can only be achieved for Kafka topic to Kafka topic workflows using the transactions API. The Kafka Streams API simplifies the usage of that API and enables exactly once using the setting `processing.guarantee=exactly.once`
- For Kafka topic to External System workflows, to *effectively* achieve exactly once, you must use an idempotent consumer.

## Summary



- **At most once:** offsets are committed as soon as the message is received. If the processing goes wrong, the message will be lost (it won’t be read again).
- **At least once:** offsets are committed after the message is processed. If the processing goes wrong, the message will be read again. This can result in duplicate processing of messages. Make sure your processing is idempotent (i.e. processing again the messages won’t impact your systems)
- **Exactly once:** Can be achieved for Kafka => Kafka workflows using high-level Kafka Streams API, or the lower level Kafka Transactions API. For Kafka => Sink workflows, use an idempotent consumer.

**Bottom Line**

For most applications you should use **'At Least Once'** processing and ensure your transformations / processing are idempotent.

------

## Automatic Offset Committing Strategy



Using the Kafka Consumer Java API, offsets are committed regularly and automatically in order to enable at at-least once reading scenario.

You can get a refresher on [Consumer Offsets here](https://learn.conduktor.io/kafka/kafka-consumer-groups-and-consumer-offsets/).

By default, the property `enable.auto.commit=true` and therefore offsets are committed automatically with a frequency controlled by the config `auto.commit.interval.ms`.

The process of committing the offsets happens when:

- the `.poll()` function is called
- AND the time between two calls to `.poll()` is greater than the setting `auto.commit.interval.ms` (5 seconds by default).

![Diagram showing how Auto Offset Commit works in Kafka](https://learn.conduktor.io/kafka/_next/image/?url=https%3A%2F%2Fimages.ctfassets.net%2Fo12xgu4mepom%2F1sVF3z8TA4niosT0gBz56G%2Fa2fe6a4699985e961c7cd1307451b8d9%2FAuto_Offest_Committing.png&w=3840&q=75)

This means that to be in an "at-least-once" processing use case (the most desirable one), you need to ensure all the messages in your consumer code are successfully processed before performing another `.poll()` call (which is the case in the sample code defined above). If this is not the case, then offsets could be committed before the messages are actually processed, therefore resulting in an "at-most once" processing pattern, possibly resulting in message skipping (which is undesirable).

In that (rare) case, you must disable `enable.auto.commit`, and most likely most processing to a separate thread, and then from time to time call `.commitSync()` or `.commitAsync()`with the correct offsets manually.

This complicated use case is discussed in the [Kafka Consumer Documentation](https://kafka.apache.org/30/javadoc/org/apache/kafka/clients/consumer/KafkaConsumer.html) under the section "Automatic Offset Committing".



#pending confirm the kafka-connect is working fine

# APACHE KAFKA GETTING STARTED 

#### [ Step 1: Get Kafka](https://kafka.apache.org/quickstart#quickstart_download)

[Download](https://www.apache.org/dyn/closer.cgi?path=/kafka/3.9.0/kafka_2.13-3.9.0.tgz) the latest Kafka release and extract it:

```bash
$ tar -xzf kafka_2.13-3.9.0.tgz
$ cd kafka_2.13-3.9.0
```

#### [Step 2: Start the Kafka environment](https://kafka.apache.org/quickstart#quickstart_startserver)

NOTE: Your local environment must have Java 8+ installed.

Apache Kafka can be started using KRaft or ZooKeeper. To get started with either configuration follow one of the sections below but not both.

### <u>Kafka with KRaft</u>

Kafka can be run using KRaft mode using local scripts and downloaded files or the docker image. Follow one of the sections below but not both to start the kafka server.

###### Using downloaded files

Generate a Cluster UUID

```bash
$ KAFKA_CLUSTER_ID="$(bin/kafka-storage.sh random-uuid)"
```

Format Log Directories

```bash
$ bin/kafka-storage.sh format --standalone -t $KAFKA_CLUSTER_ID -c config/kraft/reconfig-server.properties
```

Start the Kafka Server

```bash
$ bin/kafka-server-start.sh config/kraft/reconfig-server.properties
```

Once the Kafka server has successfully launched, you will have a basic Kafka environment running and ready to use.

When running **Kafka in KRaft mode**, the **`kafka-storage.sh format`** command (sometimes referred to as **“format log directories”**) initializes or “formats” the Kafka data directories on disk before the broker starts up. Specifically, it does the following:

1. **Embeds the Cluster ID**:
   - The command takes your newly generated **cluster UUID** (from `kafka-storage.sh random-uuid`) and writes it into the local log directories.
   - This ensures the broker knows which cluster it belongs to, and that all brokers in that cluster share the same ID.
2. **Ensures a Fresh State**:
   - If the log directories have any old data (from a previous run or a different cluster), formatting either clears or reinitializes them so the broker starts cleanly under the new cluster ID.
   - Prevents potential conflicts or corruption from leftover data.
3. **Prepares for KRaft Metadata**:
   - In KRaft mode, Kafka uses an internal quorum (rather than ZooKeeper) to store metadata. The format step sets up the directory structure so the broker can store its log segments, snapshots, and metadata records in the correct place.

Without formatting, the broker’s log directories might not have the proper cluster ID or a consistent state for the new KRaft cluster. This step is **mandatory** for a brand-new cluster (and optional/careful for reconfiguration scenarios) to make sure each broker is properly initialized.

###### Using JVM Based Apache Kafka Docker Image

Get the Docker image:

```bash
$ docker pull apache/kafka:3.9.0
```

Start the Kafka Docker container:

```bash
$ docker run -p 9092:9092 apache/kafka:3.9.0
```

### Kafka with ZooKeeper</u>

Run the following commands in order to start all services in the correct order:

```bash
# Start the ZooKeeper service
$ bin/zookeeper-server-start.sh config/zookeeper.properties
```

Open another terminal session and run:

```bash
# Start the Kafka broker service
$ bin/kafka-server-start.sh config/server.properties
```

Once all services have successfully launched, you will have a basic Kafka environment running and ready to use.

#### [Step 3: Create a topic to store your events](https://kafka.apache.org/quickstart#quickstart_createtopic)

Kafka is a distributed *event streaming platform* that lets you read, write, store, and process [*events*](https://kafka.apache.org/documentation/#messages) (also called *records* or *messages* in the documentation) across many machines.

Example events are payment transactions, geolocation updates from mobile phones, shipping orders, sensor measurements from IoT devices or medical equipment, and much more. These events are organized and stored in [*topics*](https://kafka.apache.org/documentation/#intro_concepts_and_terms). Very simplified, a topic is similar to a folder in a filesystem, and the events are the files in that folder.

So before you can write your first events, you must create a topic. Open another terminal session and run:

#kafka-command (create-topic)

```bash
$ bin/kafka-topics.sh --create --topic quickstart-events --bootstrap-server localhost:9092
```

All of Kafka's command line tools have additional options: run the `kafka-topics.sh` command without any arguments to display usage information. For example, it can also show you [details such as the partition count](https://kafka.apache.org/documentation/#intro_concepts_and_terms) of the new topic:

#kafka-command (list-topics)

```bin/kafka-topics.sh --create --topic quickstart-events --bootstrap-server localhost:9092```

#kafka-command (describe-topic)

```bash
$ bin/kafka-topics.sh --describe --topic quickstart-events --bootstrap-server localhost:9092
Topic: quickstart-events        TopicId: NPmZHyhbR9y00wMglMH2sg PartitionCount: 1       ReplicationFactor: 1	Configs:
Topic: quickstart-events Partition: 0    Leader: 0   Replicas: 0 Isr: 0
```

#### [Step 4: Write some events into the topic](https://kafka.apache.org/quickstart#quickstart_send)

A Kafka client communicates with the Kafka brokers via the network for writing (or reading) events. Once received, the brokers will store the events in a durable and fault-tolerant manner for as long as you need—even forever.

Run the console producer client to write a few events into your topic. By default, each line you enter will result in a separate event being written to the topic.

```bash
$ bin/kafka-console-producer.sh --topic quickstart-events --bootstrap-server localhost:9092
>This is my first event
>This is my second event
```

You can stop the producer client with `Ctrl-C` at any time.

if you want to send with headers, key and values , AND paste the following data 

```shell
bin/kafka-console-producer.sh \
  --bootstrap-server localhost:9092 \
  --topic quickstart-events \
  --property parse.key=true \
  --property parse.headers=true \
  --property key.separator="|" \
  --property headers.delimiter=";" \
  --property headers.separator="," \
  --property headers.key.separator=":"
```

```shell
headerA:someval1,headerB:someotherval1;myKey1|Hello from line 1
headerA:someval2,headerB:someotherval2;myKey2|Hello from line 2
headerA:someval3,headerB:someotherval3;myKey3|Hello from line 3
headerA:someval4,headerB:someotherval4;myKey4|Hello from line 4
headerA:someval5,headerB:someotherval5;myKey5|Hello from line 5
headerA:someval6,headerB:someotherval6;myKey6|Hello from line 6
headerA:someval7,headerB:someotherval7;myKey7|Hello from line 7
headerA:someval8,headerB:someotherval8;myKey8|Hello from line 8
headerA:someval9,headerB:someotherval9;myKey9|Hello from line 9
headerA:someval10,headerB:someotherval10;myKey10|Hello from line 10
headerA:someval11,headerB:someotherval11;myKey11|Hello from line 11
headerA:someval12,headerB:someotherval12;myKey12|Hello from line 12
headerA:someval13,headerB:someotherval13;myKey13|Hello from line 13
headerA:someval14,headerB:someotherval14;myKey14|Hello from line 14
headerA:someval15,headerB:someotherval15;myKey15|Hello from line 15
headerA:someval16,headerB:someotherval16;myKey16|Hello from line 16
headerA:someval17,headerB:someotherval17;myKey17|Hello from line 17
headerA:someval18,headerB:someotherval18;myKey18|Hello from line 18
headerA:someval19,headerB:someotherval19;myKey19|Hello from line 19
headerA:someval20,headerB:someotherval20;myKey20|Hello from line 20
headerA:someval21,headerB:someotherval21;myKey21|Hello from line 21
headerA:someval22,headerB:someotherval22;myKey22|Hello from line 22
headerA:someval23,headerB:someotherval23;myKey23|Hello from line 23
headerA:someval24,headerB:someotherval24;myKey24|Hello from line 24
headerA:someval25,headerB:someotherval25;myKey25|Hello from line 25
headerA:someval26,headerB:someotherval26;myKey26|Hello from line 26
headerA:someval27,headerB:someotherval27;myKey27|Hello from line 27
headerA:someval28,headerB:someotherval28;myKey28|Hello from line 28
headerA:someval29,headerB:someotherval29;myKey29|Hello from line 29
headerA:someval30,headerB:someotherval30;myKey30|Hello from line 30
headerA:someval31,headerB:someotherval31;myKey31|Hello from line 31
headerA:someval32,headerB:someotherval32;myKey32|Hello from line 32
headerA:someval33,headerB:someotherval33;myKey33|Hello from line 33
headerA:someval34,headerB:someotherval34;myKey34|Hello from line 34
headerA:someval35,headerB:someotherval35;myKey35|Hello from line 35
headerA:someval36,headerB:someotherval36;myKey36|Hello from line 36
headerA:someval37,headerB:someotherval37;myKey37|Hello from line 37
headerA:someval38,headerB:someotherval38;myKey38|Hello from line 38
headerA:someval39,headerB:someotherval39;myKey39|Hello from line 39
headerA:someval40,headerB:someotherval40;myKey40|Hello from line 40
headerA:someval41,headerB:someotherval41;myKey41|Hello from line 41
headerA:someval42,headerB:someotherval42;myKey42|Hello from line 42
headerA:someval43,headerB:someotherval43;myKey43|Hello from line 43
headerA:someval44,headerB:someotherval44;myKey44|Hello from line 44
headerA:someval45,headerB:someotherval45;myKey45|Hello from line 45
headerA:someval46,headerB:someotherval46;myKey46|Hello from line 46
headerA:someval47,headerB:someotherval47;myKey47|Hello from line 47
headerA:someval48,headerB:someotherval48;myKey48|Hello from line 48
headerA:someval49,headerB:someotherval49;myKey49|Hello from line 49
headerA:someval50,headerB:someotherval50;myKey50|Hello from line 50

```

if you enter the wrong message you will get the error from the producer 

```shell
>asdf-asdf-asdf-asdfasdf

org.apache.kafka.common.KafkaException: No headers delimiter found on line number 296: 'asdf-asdf-asdf-asdfasdf'
	at kafka.tools.ConsoleProducer$LineMessageReader.kafka$tools$ConsoleProducer$LineMessageReader$$parse(ConsoleProducer.scala:438)
	at kafka.tools.ConsoleProducer$LineMessageReader$$anon$3.hasNext(ConsoleProducer.scala:405)
	at kafka.tools.ConsoleProducer$.loopReader(ConsoleProducer.scala:91)
	at kafka.tools.ConsoleProducer$.main(ConsoleProducer.scala:100)
	at kafka.tools.ConsoleProducer.main(ConsoleProducer.scala)
```



#### [Step 5: Read the events](https://kafka.apache.org/quickstart#quickstart_consume)

Open another terminal session and run the console consumer client to read the events you just created:

```bash
$ bin/kafka-console-consumer.sh --topic quickstart-events --from-beginning --bootstrap-server localhost:9092
This is my first event
This is my second event
```

You can stop the consumer client with `Ctrl-C` at any time.

if you want to consume with header, key and values 

```shell
bin/kafka-console-consumer.sh \
  --bootstrap-server localhost:9092 \
  --topic quickstart-events \
  --from-beginning \
  --property print.key=true \
  --property key.separator="|" \
  --property print.headers=true

```

Feel free to experiment: for example, switch back to your producer terminal (previous step) to write additional events, and see how the events immediately show up in your consumer terminal.

Consumer will show that it can handle the messages 

```shell
headerA:someval1,headerB:someotherval1;myKey1|Hello from line 1
headerA:someval2,headerB:someotherval2|myKey2|Hello from line 2
headerA:someval3,headerB:someotherval3|myKey3|Hello from line 3
headerA:someval4,headerB:someotherval4|myKey4|Hello from line 4
headerA:someval5,headerB:someotherval5|myKey5|Hello from line 5
headerA:someval6,headerB:someotherval6|myKey6|Hello from line 6
headerA:someval7,headerB:someotherval7|myKey7|Hello from line 7
headerA:someval8,headerB:someotherval8|myKey8|Hello from line 8
headerA:someval9,headerB:someotherval9|myKey9|Hello from line 9
headerA:someval10,headerB:someotherval10|myKey10|Hello from line 10
headerA:someval11,headerB:someotherval11|myKey11|Hello from line 11
headerA:someval12,headerB:someotherval12|myKey12|Hello from line 12
headerA:someval13,headerB:someotherval13|myKey13|Hello from line 13
headerA:someval14,headerB:someotherval14|myKey14|Hello from line 14
headerA:someval15,headerB:someotherval15|myKey15|Hello from line 15
headerA:someval16,headerB:someotherval16|myKey16|Hello from line 16
headerA:someval17,headerB:someotherval17|myKey17|Hello from line 17
headerA:someval18,headerB:someotherval18|myKey18|Hello from line 18
headerA:someval19,headerB:someotherval19|myKey19|Hello from line 19
headerA:someval20,headerB:someotherval20|myKey20|Hello from line 20
headerA:someval21,headerB:someotherval21|myKey21|Hello from line 21
headerA:someval22,headerB:someotherval22|myKey22|Hello from line 22
headerA:someval23,headerB:someotherval23|myKey23|Hello from line 23
headerA:someval24,headerB:someotherval24|myKey24|Hello from line 24
headerA:someval25,headerB:someotherval25|myKey25|Hello from line 25
headerA:someval26,headerB:someotherval26|myKey26|Hello from line 26
headerA:someval27,headerB:someotherval27|myKey27|Hello from line 27
headerA:someval28,headerB:someotherval28|myKey28|Hello from line 28
headerA:someval29,headerB:someotherval29|myKey29|Hello from line 29
headerA:someval30,headerB:someotherval30|myKey30|Hello from line 30
headerA:someval31,headerB:someotherval31|myKey31|Hello from line 31
headerA:someval32,headerB:someotherval32|myKey32|Hello from line 32
headerA:someval33,headerB:someotherval33|myKey33|Hello from line 33
headerA:someval34,headerB:someotherval34|myKey34|Hello from line 34
headerA:someval35,headerB:someotherval35|myKey35|Hello from line 35
headerA:someval36,headerB:someotherval36|myKey36|Hello from line 36
headerA:someval37,headerB:someotherval37|myKey37|Hello from line 37
headerA:someval38,headerB:someotherval38|myKey38|Hello from line 38
headerA:someval39,headerB:someotherval39|myKey39|Hello from line 39
headerA:someval40,headerB:someotherval40|myKey40|Hello from line 40
headerA:someval41,headerB:someotherval41|myKey41|Hello from line 41
headerA:someval42,headerB:someotherval42|myKey42|Hello from line 42
headerA:someval43,headerB:someotherval43|myKey43|Hello from line 43
headerA:someval44,headerB:someotherval44|myKey44|Hello from line 44
headerA:someval45,headerB:someotherval45|myKey45|Hello from line 45
headerA:someval46,headerB:someotherval46|myKey46|Hello from line 46
headerA:someval47,headerB:someotherval47|myKey47|Hello from line 47
headerA:someval48,headerB:someotherval48|myKey48|Hello from line 48
headerA:someval49,headerB:someotherval49|myKey49|Hello from line 49
```



Because events are durably stored in Kafka, they can be read as many times and by as many consumers as you want. You can easily verify this by opening yet another terminal session and re-running the previous command again.

----

Below is an example of how to start **two separate consumer groups** using the console consumer. Each consumer group can have multiple terminals (consumers) reading from the same topic. Here we’ll refer to them as:

1. **consumer-group1** (with consumer1, consumer2)
2. **consumer-group2** (with consumer3, consumer4)

In each group, offsets are tracked independently.

------

## Consumer Commands with Group Names

### Group 1 (consumer-group1)

Open **two** separate terminals for **consumer1** and **consumer2**. In each terminal, run:

```bash
bin/kafka-console-consumer.sh \
  --bootstrap-server localhost:9092 \
  --topic quickstart-events \
  --from-beginning \
  --group consumer-group1 \
  --property print.key=true \
  --property key.separator="|" \
  --property print.headers=true \
  --property print.offset=true \
  --property print.partition=true
```

- **`--group consumer-group1`**: Tells these consumers to belong to `consumer-group1`.
- **`print.key=true`** and **`print.headers=true`**: Show the key and headers in the output.
- **`--from-beginning`**: Reads all messages from the start of the topic on initial run (if they have no committed offset yet).

Since both consumers in group1 share the same group, Kafka will **split** the topic partitions among them. If you have multiple partitions, one consumer might get one or two partitions, and the other gets the remainder.

### Group 2 (consumer-group2)

Open **two more** terminals for **consumer3** and **consumer4**. In each terminal, run:

```bash
bin/kafka-console-consumer.sh \
  --bootstrap-server localhost:9092 \
  --topic quickstart-events \
  --from-beginning \
  --group consumer-group2 \
  --property print.key=true \
  --property key.separator="|" \
  --property print.headers=true \
  --property print.offset=true \
  --property print.partition=true
```

- **`--group consumer-group2`**: These belong to `consumer-group2`.
- They track their offsets independently of group1. Even if group1 has consumed some messages, group2 will read them again from the start (assuming it’s their first time reading).

------

## What You’ll See

1. **Group 1**: consumer1 and consumer2 share partitions. They have a combined offset for their group. Each message is read by only **one** consumer in that group (unless you have more partitions than consumers).
2. **Group 2**: consumer3 and consumer4 also split partitions, but they have their own offset management. They’ll see the same messages as group1, but at different offsets from group1’s perspective.

This setup lets you demonstrate how Kafka manages **consumer groups**:

- **Messages** are “fan-out” across different groups. Group1 doesn’t interfere with Group2’s offsets, so both groups receive the full stream of messages.
- **Within** each group, members share partitions so no message is duplicated among consumers in the same group.

------

## Reminder: Producer with Headers, Key, and Value

If you want to keep using the **headers + key + value** approach, remember to run your producer with the same properties described earlier:

```bash
bin/kafka-console-producer.sh \
  --bootstrap-server localhost:9092 \
  --topic quickstart-events \
  --property parse.key=true \
  --property parse.headers=true \
  --property key.separator="|" \
  --property headers.delimiter=";" \
  --property headers.separator="," \
  --property headers.key.separator=":"
```

And send lines like:

```
header1:val1,header2:val2;myKey|Hello from Kafka with headers
```

Those headers, keys, and values will then appear in both consumer groups (console outputs) because each group is reading the same topic.

Below is a quick walkthrough on how to **create a topic with 3 partitions** and then use the **Kafka console producer** and **console consumer** (with consumer groups) to **show message distribution** across partitions. We’ll also include **key-based** sending so that you can see how different keys map to different partitions.

------

## 1) Create a Topic with 3 Partitions

In your Docker/Kafka environment, open a terminal into one of the Kafka containers (e.g., `kafka1`) or run the CLI directly if you have Kafka installed locally. Then run:

```bash
kafka-topics.sh \
  --create \
  --bootstrap-server localhost:9092 \
  --topic demo-3-partitions \
  --replication-factor 3 \
  --partitions 3
```

This command creates a **3-partition** topic named `demo-3-partitions` with a replication factor of 3 (assuming you have a 3-broker cluster). If you only have 1 broker, set `--replication-factor 1` instead.

------

## 2) Producer Command (Key + Optional Headers)

Here’s a **minimal** console producer that sends **key** and **value**. We’ll also enable partition visibility by using different keys. If you want **headers** too, see the more advanced commands from before, but let’s keep it simpler to highlight partition usage.

```bash
bin/kafka-console-producer.sh \
  --bootstrap-server localhost:9092 \
  --topic demo-3-partitions \
  --property parse.key=true \
  --property key.separator="|"
```

- **`--property parse.key=true`**: Tells Kafka the input line will have a key and a value.
- **`--property key.separator="|"`**: Splits the key and value on the `|` character.

### Enter Messages

After running the producer, you’ll be prompted to type lines. Each line should be:

```
someKey|someValue
```

For instance, paste something like this (one message per line):

```
keyA|Hello from keyA
keyB|Hello from keyB
keyC|Hello from keyC
keyD|Hello from keyD
keyE|Hello from keyE
keyF|Hello from keyF
keyG|Hello from keyG
keyH|Hello from keyH
keyI|Hello from keyI
keyJ|Hello from keyJ
```

Kafka will **hash** each `keyX` to determine which partition (0, 1, or 2) that message goes to. You’ll see in the consumer step exactly which partition each message lands on.

------

## 3) Consumer Command with Partition & Key Printing

Now we’ll launch one or more consumers that read from `demo-3-partitions`. To **see** which partition each message arrives on, include:

- **`print.partition=true`**: prints the partition ID
- **`print.key=true`**: prints the message key
- **`key.separator="|"`**: inserts `|` between key and value in the output
- **`print.headers=true`**: optional if you’ve been producing headers (if not, you can omit it)

Below is a consumer command that also **joins** a named consumer group (so you can run multiple consumers in the same group). For example, call the group `group1`:

```bash
bin/kafka-console-consumer.sh \
  --bootstrap-server localhost:9092 \
  --topic demo-3-partitions \
  --group group1 \
  --from-beginning \
  --property print.key=true \
  --property key.separator="|" \
  --property print.partition=true \
  --property print.headers=true
```

You’ll see output lines similar to:

```
Partition:0  headers=[]  key=keyA| Hello from keyA
Partition:2  headers=[]  key=keyB| Hello from keyB
Partition:1  headers=[]  key=keyC| Hello from keyC
...
```

- **Partition**: Tells you which partition the message came from.
- **key=...**: Shows the key and value separated by `|`.
- **headers=[]**: No headers were sent in the simple example, so it’s empty.

------

## 4) Multiple Consumers in the Same Group

If you want to show **how the 3 partitions get distributed** among **two consumers** in the same group:

1. **Open two terminals** (or iTerm splits).
2. In **terminal 1**, run the same consumer command with `--group group1`.
3. In **terminal 2**, run the **exact** same command with `--group group1`.
4. Produce messages (or re-run `--from-beginning` to see distribution). You’ll notice one consumer gets some subset of partitions, and the other gets the remaining ones. They share the load within the same group.

For example, if you have **3** partitions and **2** consumers, typically:

- Consumer1 might get partition 0 + partition 2
- Consumer2 might get partition 1

(This can vary, but that’s a common split.)

------

## 5) Multiple Consumer Groups

If you also want to demonstrate that **consumer groups are independent**, create a **second** consumer group. For instance:

- **group1**: consumer1, consumer2
- **group2**: consumer3, consumer4

Each group can have multiple members, but group1 and group2 track offsets **independently**. If group1 has read up to offset 10, group2 can still read those messages from offset 0 if it hasn’t started consuming yet.

```bash
# group2 consumer:
bin/kafka-console-consumer.sh \
  --bootstrap-server localhost:9092 \
  --topic demo-3-partitions \
  --group group2 \
  --from-beginning \
  --property print.key=true \
  --property key.separator="|" \
  --property print.partition=true \
  --property print.headers=true
```

------

## 6) Summary

1. **Create a 3-partition topic**: `kafka-topics.sh --create --partitions 3 ...`
2. **Produce** with a key (using `parse.key=true`, `key.separator="|"`) so you can see partition distribution.
3. **Consume** with `print.partition=true` to verify which partition each message lands on.
4. **Run multiple consumers** in the same group to show how partitions are shared.
5. **(Optional)** Start another group to show independent offset tracking.

With these steps, you can visually demonstrate how **Kafka distributes messages across partitions** based on the key and how **consumers** divide partition ownership within a **consumer group**.





# <------------------------------------------------->

# 3-broker Kafka Cluster plus Zookeeper from downloaded binaries

Below is a step-by-step guide to run a **3-broker Kafka cluster** (with ZooKeeper) from **downloaded Apache Kafka binaries** (version 3.9.0) on your local machine. After starting the cluster, you’ll create a topic with **3 partitions** and a **replication factor** of **3** to fully utilize all brokers.

> **Note**: Kafka 3.9.0 still ships with ZooKeeper mode for backward compatibility, even though KRaft mode is another option. This guide focuses on the *traditional* ZooKeeper setup.



#pending ( make sure all commands for external (not with in docker are working and also replication , failover is working as well))

# 1) Download & Extract Kafka 3.9.0

1. Go to [Kafka Releases](https://kafka.apache.org/downloads) (or the [Apache mirrors](https://downloads.apache.org/kafka/3.9.0/)) and download the **binary** for Kafka 3.9.0 (Scala 2.13 or 3, whichever you prefer).

2. Extract the archive:

   ```bash
   tar -xzf kafka_2.13-3.9.0.tgz
   cd kafka_2.13-3.9.0
   ```

   You’ll see folders like 

   ```
   bin/
   ```

   , 

   ```
   config/
   ```

   , 

   ```
   libs/
   ```

   , etc.

------

# 2) Configure & Start ZooKeeper

Kafka in ZooKeeper mode requires you to **start ZooKeeper** first. A sample config is already in `config/zookeeper.properties`.

1. **Optional**: Verify `dataDir` in `config/zookeeper.properties` is a valid path.

2. Start ZooKeeper

   :

   ```bash
   bin/zookeeper-server-start.sh config/zookeeper.properties
   ```

   By default, it listens on 

   port 2181

   .

> **Tip**: In a real multi-broker setup, you might run a full ZooKeeper ensemble. For a local test, **one** ZooKeeper instance is enough.

------

# 3) Create Configs for 3 Brokers

We’ll make **3 separate Kafka server config files** for each broker. You can copy the default `config/server.properties` and tweak the following properties:

1. **broker.id** (unique integer per broker)
2. **listeners** and/or **port** (unique port per broker if on the same machine)
3. **log.dirs** (different directories so they don’t clash)
4. **zookeeper.connect** (host:2181)

## 3.1. `config/server-1.properties`

```properties
broker.id=1
listeners=PLAINTEXT://:9092
advertised.listeners=PLAINTEXT://localhost:9092
log.dirs=/tmp/kafka-logs-broker1
num.partitions=3
zookeeper.connect=localhost:2181
```

## 3.2. `config/server-2.properties`

```properties
broker.id=2
listeners=PLAINTEXT://:9093
advertised.listeners=PLAINTEXT://localhost:9093
log.dirs=/tmp/kafka-logs-broker2
num.partitions=3
zookeeper.connect=localhost:2181
```

## 3.3. `config/server-3.properties`

```properties
broker.id=3
listeners=PLAINTEXT://:9094
advertised.listeners=PLAINTEXT://localhost:9094
log.dirs=/tmp/kafka-logs-broker3
num.partitions=3
zookeeper.connect=localhost:2181
```

### Explanation of Key Properties

- **`broker.id`**: A **unique integer** identifier for each broker.
- **`listeners=PLAINTEXT://:909X`**: The broker listens on these ports (9092, 9093, 9094).
- **`advertised.listeners=PLAINTEXT://localhost:909X`**: Tells external clients to connect to `localhost:909X`.
- **`log.dirs`**: Path to store local data (log segments, offsets, etc.). Each broker must have its own directory.
- **`num.partitions=3`**: Default partition count for **new** topics (you can also override in topic creation).
- **`zookeeper.connect=localhost:2181`**: Points to the local ZooKeeper.

------

# 4) Start the 3 Brokers

Open **three separate terminals** (or run them in the background). In each, navigate to `kafka_2.13-3.9.0` and start one broker:

### 4.1. Broker 1

```bash
bin/kafka-server-start.sh config/server-1.properties
```

### 4.2. Broker 2

```bash
bin/kafka-server-start.sh config/server-2.properties
```

### 4.3. Broker 3

```bash
bin/kafka-server-start.sh config/server-3.properties
```

Wait a few seconds per broker to ensure each fully starts up. You’ll see log output mentioning it’s **“[KafkaServer id=1] started”** (etc.).

------

# 5) Create a Topic with 3 Partitions and Replication Factor 3

Now you can create a topic that uses all three brokers for replication and has multiple partitions. Use the **kafka-topics.sh** script pointing to **any** broker (1, 2, or 3) as the bootstrap server:

```bash
bin/kafka-topics.sh \
  --create \
  --bootstrap-server localhost:9092 \
  --replication-factor 3 \
  --partitions 3 \
  --topic my-replicated-topic
```

- **`--replication-factor 3`** means the topic’s data will be replicated across all three brokers.
- **`--partitions 3`** means the topic has 3 partitions.

If creation succeeds, you’ll see a short confirmation:

```
Created topic my-replicated-topic.
```

### Verify the Topic by listing the topics 

```sh
bin/kafka-topics.sh --bootstrap-server localhost:9092  --list                                                                  
__consumer_offsets
my-replicated-topic
quickstart-events

```



```bash
bin/kafka-topics.sh \
  --describe \
  --bootstrap-server localhost:9092 \
  --topic my-replicated-topic
```

It should show something like:

```
Topic: my-replicated-topic   PartitionCount: 3   ReplicationFactor: 3
    Partition: 0   Leader: 1  Replicas: 1,2,3   Isr: 1,2,3
    Partition: 1   Leader: 2  Replicas: 2,3,1   Isr: 2,3,1
    Partition: 2   Leader: 3  Replicas: 3,1,2   Isr: 3,1,2
```

Each partition has a **leader** broker, with all 3 as **replicas**. The **ISR** (in-sync replicas) should be `[1,2,3]`.



The output of `kafka-topics.sh --describe` provides important information about **partitions**, **leaders**, **replicas**, and **in-sync replicas (ISR)** for the specified topic. Let's break down the fields, particularly focusing on **`Elr`** and **`LastKnownElr`**.

------

## Breakdown of the Output

```plaintext
Topic: my-replicated-topic	TopicId: PruHlQPRRaOnHTUn8Rhw3A	PartitionCount: 3	ReplicationFactor: 3	Configs:
	Topic: my-replicated-topic	Partition: 0	Leader: 2	Replicas: 2,3,1	Isr: 2,3,1	Elr: N/A	LastKnownElr: N/A
	Topic: my-replicated-topic	Partition: 1	Leader: 3	Replicas: 3,1,2	Isr: 3,1,2	Elr: N/A	LastKnownElr: N/A
	Topic: my-replicated-topic	Partition: 2	Leader: 1	Replicas: 1,2,3	Isr: 1,2,3	Elr: N/A	LastKnownElr: N/A
```

### Field Explanation

1. **Topic**: `my-replicated-topic`

   - Name of the Kafka topic.

2. **TopicId**: `PruHlQPRRaOnHTUn8Rhw3A`

   - A **unique identifier** assigned to the topic.

3. **PartitionCount**: `3`

   - The topic has **3 partitions**.

4. **ReplicationFactor**: `3`

   - Each partition has **3 replicas** (across different brokers).

5. **Partition**: `{0,1,2}`

   - Each partition is listed separately.

6. **Leader**: `{2,3,1}` (varies per partition)

   - Each partition has a **leader broker** that handles read/write requests.

   - Example:

     ```
     Partition 0 -> Leader: 2
     Partition 1 -> Leader: 3
     Partition 2 -> Leader: 1
     ```

   - The leader **changes** if the current leader broker goes down.

7. **Replicas**: `{2,3,1}`, `{3,1,2}`, `{1,2,3}`

   - Lists all brokers that have a **replica** of the partition’s data.
   - **First broker** in the list is the leader.

8. **ISR (In-Sync Replicas)**: `{2,3,1}`, `{3,1,2}`, `{1,2,3}`

   - Lists the **replicas that are fully synced** with the leader.
   - If a broker **falls behind** (slow, crashed, etc.), it is removed from ISR.

9. **ELR (End Log Range)**: `N/A`

   - This field is relevant for **tiered storage** (Kafka KIP-405) but is **not applicable** in standard Kafka clusters.
   - Kafka typically maintains logs on local disk, but with **tiered storage**, logs can move to external storage (like S3, Google Cloud Storage).
   - **`Elr` (End Log Range)** shows **the oldest offset retained in local storage** before it is moved to tiered storage.
   - If **tiered storage** is **disabled**, you see `N/A` (Not Applicable).

10. **LastKnownElr (Last Known End Log Range)**: `N/A`

    - If **tiered storage is enabled**, this shows the **most recent** known **ELR offset** before Kafka potentially lost connection to external storage.
    - Since your Kafka setup is **not using tiered storage**, it remains `N/A`.

------

## Why Do `Elr` and `LastKnownElr` Show `N/A`?

Since Kafka **3.6.0**, the `--describe` output includes `Elr` and `LastKnownElr` fields to support **tiered storage** (logs moved to S3, GCS, etc.). However:

- If **tiered storage is disabled**, these fields **don’t apply** and show `N/A`.
- Your setup is using **local storage** (default Kafka behavior), so there is no concept of an "End Log Range."

To enable **tiered storage**, you would need to configure external storage via `log.tiered.enable=true` and related settings.

------

## Example: If Tiered Storage Was Enabled

If tiered storage was enabled and logs started aging out from local disk, you might see:

```plaintext
Topic: my-replicated-topic	Partition: 0	Leader: 2	Replicas: 2,3,1	Isr: 2,3,1	Elr: 10000	LastKnownElr: 9800
```

- **Elr = `10000`** → The oldest offset still present **on local disk**.
- **LastKnownElr = `9800`** → The last known ELR offset before losing external storage connectivity.

------

## TL;DR - Summary

| Field                      | Meaning                                                      |
| -------------------------- | ------------------------------------------------------------ |
| **Leader**                 | The broker currently handling read/write operations for this partition. |
| **Replicas**               | Brokers that have a copy of this partition’s data.           |
| **ISR (In-Sync Replicas)** | Replicas that are fully up-to-date with the leader.          |
| **Elr (End Log Range)**    | Only applies when **tiered storage** is enabled. Shows the earliest offset still on local disk. |
| **LastKnownElr**           | The most recent known ELR before Kafka lost connection to external storage (if tiered storage is enabled). |
| **N/A (Not Applicable)**   | If you’re **not** using tiered storage, `Elr` and `LastKnownElr` will always be `N/A`. |

For **standard Kafka clusters (no tiered storage)**, `Elr` and `LastKnownElr` can be **ignored**, as they do not impact normal Kafka operations.

------

# 6) Produce & Consume Messages

Now you have a **3-broker** local Kafka cluster plus ZooKeeper. Test it out:

## 6.1. Producer (Console)

```bash
bin/kafka-console-producer.sh \
  --broker-list localhost:9092 \
  --topic my-replicated-topic
```

Type some lines, press Enter after each. Ctrl+C to exit.

## 6.2. Consumer (Console)

```bash
bin/kafka-console-consumer.sh \
  --bootstrap-server localhost:9092 \
  --topic my-replicated-topic \
  --from-beginning
```

You’ll see the lines you typed in the producer. This confirms the cluster is up and replicating.

------

# 7) (Optional) Demonstrate Failover

To show **replication** in action:

1. Stop

    the broker leading a particular partition. For example, if partition 0’s leader is broker 1, stop broker 1:

   ```bash
   bin/kafka-server-stop.sh config/server-1.properties
   ```

2. **Continue** producing/consuming. Kafka will automatically elect a new leader for that partition among the remaining brokers (2 or 3).

3. Re-check

    topic details:

   ```bash
   bin/kafka-topics.sh --describe \
     --bootstrap-server localhost:9092 \
     --topic my-replicated-topic
   ```

   You’ll see a new leader for any partitions that broker 1 originally led. The cluster remains operational (albeit with one fewer in-sync replica) until you bring broker 1 back online.

------

## Summary

1. **Download** Kafka 3.9.0 & unpack it.
2. **Start ZooKeeper** (`zookeeper-server-start.sh config/zookeeper.properties`).
3. **Create** 3 separate server configs (`server-1.properties`, `server-2.properties`, `server-3.properties`), each with a unique `broker.id`, port, and log directory.
4. **Start each broker** in separate terminals.
5. **Create a topic** with `--replication-factor 3` and `--partitions 3`.
6. **Produce & consume** to verify the cluster.
7. (Optional) **Stop** a broker to demonstrate that Kafka seamlessly fails over to another broker for any partitions that were being led.

With that, you have a **3-broker Kafka cluster** with **3-partition, 3-replica** topics, all running **locally** from the official Apache Kafka **3.9.0** binaries.

# <------------------------------------------------->

# 3-broker Kafka Cluster plus Zookeeper from DOCKER BASED IMAGES

Below is an example of how to stand up a **3-broker Kafka cluster** (plus Zookeeper) **entirely from the command line** using **Docker** and a “downloaded” (official or vendor-provided) Kafka Docker image. In this example, we’ll use the **Bitnami** images for Kafka/Zookeeper, but the approach is similar if you’re using the official Apache images (just adapt environment variables and image names accordingly).

#pending ( make sure all commands for create topics, list topics and describe topics etc are in one place, no duplicates in rest of the document)

# 1) Create a kafka cluster with 3 kafka brokers, one zookeeper using docker compose

```shell

services:
  zookeeper:
    image: bitnami/zookeeper:latest
    container_name: zookeeper
    environment:
      - ALLOW_ANONYMOUS_LOGIN=yes
    ports:
      - "2181:2181"

  kafka1:
    image: bitnami/kafka:latest
    container_name: kafka1
    depends_on:
      - zookeeper
    ports:
      - "9092:9092"
    environment:
      - KAFKA_CFG_BROKER_ID=1
      - KAFKA_CFG_ZOOKEEPER_CONNECT=zookeeper:2181
      - ALLOW_PLAINTEXT_LISTENER=yes
      # INTERNAL for Docker containers, EXTERNAL for Host access
      - KAFKA_CFG_LISTENERS=INTERNAL://0.0.0.0:29092,EXTERNAL://0.0.0.0:9092
      - KAFKA_CFG_ADVERTISED_LISTENERS=INTERNAL://kafka1:29092,EXTERNAL://kafka1:9092
      - KAFKA_CFG_LISTENER_SECURITY_PROTOCOL_MAP=INTERNAL:PLAINTEXT,EXTERNAL:PLAINTEXT
      - KAFKA_CFG_INTER_BROKER_LISTENER_NAME=INTERNAL
      - KAFKA_CFG_AUTO_CREATE_TOPICS_ENABLE=true

  kafka2:
    image: bitnami/kafka:latest
    container_name: kafka2
    depends_on:
      - zookeeper
    ports:
      - "9093:9093"
    environment:
      - KAFKA_CFG_BROKER_ID=2
      - KAFKA_CFG_ZOOKEEPER_CONNECT=zookeeper:2181
      - ALLOW_PLAINTEXT_LISTENER=yes
      - KAFKA_CFG_LISTENERS=INTERNAL://0.0.0.0:29093,EXTERNAL://0.0.0.0:9093
      - KAFKA_CFG_ADVERTISED_LISTENERS=INTERNAL://kafka2:29093,EXTERNAL://kafka2:9093
      - KAFKA_CFG_LISTENER_SECURITY_PROTOCOL_MAP=INTERNAL:PLAINTEXT,EXTERNAL:PLAINTEXT
      - KAFKA_CFG_INTER_BROKER_LISTENER_NAME=INTERNAL
      - KAFKA_CFG_AUTO_CREATE_TOPICS_ENABLE=true

  kafka3:
    image: bitnami/kafka:latest
    container_name: kafka3
    depends_on:
      - zookeeper
    ports:
      - "9094:9094"
    environment:
      - KAFKA_CFG_BROKER_ID=3
      - KAFKA_CFG_ZOOKEEPER_CONNECT=zookeeper:2181
      - ALLOW_PLAINTEXT_LISTENER=yes
      - KAFKA_CFG_LISTENERS=INTERNAL://0.0.0.0:29094,EXTERNAL://0.0.0.0:9094
      - KAFKA_CFG_ADVERTISED_LISTENERS=INTERNAL://kafka3:29094,EXTERNAL://kafka3:9094
      - KAFKA_CFG_LISTENER_SECURITY_PROTOCOL_MAP=INTERNAL:PLAINTEXT,EXTERNAL:PLAINTEXT
      - KAFKA_CFG_INTER_BROKER_LISTENER_NAME=INTERNAL
      - KAFKA_CFG_AUTO_CREATE_TOPICS_ENABLE=true


```



------

Key environment variables:

![image-20250218154951718](./assets/image-20250218154951718.png)

------

# 2) Verify Your Cluster

Now you have 3 Kafka brokers (kafka1, kafka2, kafka3) plus Zookeeper (zookeeper). Each broker is listening:

- **Broker 1**: Host port 9092
- **Broker 2**: Host port 9093
- **Broker 3**: Host port 9094

Check they’re all running:

```bash
docker ps
```

You should see four containers: zookeeper, kafka1, kafka2, kafka3.



![image-20250218155045207](./assets/image-20250218155045207.png)

------

### **✅ Commands to Create a Kafka Topic with 3 Partitions and 3 Replication Factor**

Now that your **Docker Compose-based Kafka cluster** is working, follow these steps to create a topic and test failover.

------

## **1️⃣ Create the Topic with 3 Partitions and Replication Factor 3**

Run this command **from host against any broker** 

```bash
docker exec -it kafka1 kafka-topics.sh \
  --create \
  --bootstrap-server kafka1:29092 \
  --replication-factor 3 \
  --partitions 3 \
  --topic replicated-topic
```

Run this command **from host against the host only (using localhost ports)**

```sh
 <apache-kafka-home>bin/kafka-topics.sh \
	--create \
  --bootstrap-server localhost:9092 \
  --replication-factor 3 \
  --partitions 3 \
  --topic replicated-topic
```





✅ **What This Does:**

- **3 partitions** → Messages are split across partitions.
- **3 replication factor** → Each partition has **3 copies** (on different brokers).
- **Failover protection** → If one broker fails, the topic is still available.

------

## **2️⃣ Verify Topic Details**

Check topic metadata to ensure it was created correctly:

```bash
docker exec -it kafka1 kafka-topics.sh \
  --describe \
  --bootstrap-server kafka1:29092 \
  --topic replicated-topic
```

✅ **Expected Output Example:**

```
Topic: replicated-topic	PartitionCount: 3	ReplicationFactor: 3
	Partition: 0	Leader: 1	Replicas: 1,2,3	Isr: 1,2,3
	Partition: 1	Leader: 2	Replicas: 2,3,1	Isr: 2,3,1
	Partition: 2	Leader: 3	Replicas: 3,1,2	Isr: 3,1,2
```

Key fields:

- **Leader:** The broker handling reads/writes for each partition.
- **Replicas:** The list of brokers storing copies of this partition.
- **ISR (In-Sync Replicas):** Brokers fully synchronized with the leader.

------

## **3️⃣ Start Producing Messages**

Now, send messages to **any broker**.

```bash
docker exec -it kafka1 kafka-console-producer.sh \
  --broker-list kafka1:29092 \
  --topic replicated-topic
```

Type messages and hit **ENTER** after each:

```
Message 1
Message 2
Message 3
```

Press **Ctrl+C** to exit.

kafka-console-producer.bat ^
--broker-list kafka1:9092 ^
--topic replicated-topic-external

------

## **4️⃣ Start Consuming Messages**

To verify messages can be read from any broker, use:

```bash
docker exec -it kafka2 kafka-console-consumer.sh \
  --bootstrap-server kafka2:29093 \
  --topic replicated-topic \
  --from-beginning
```

✅ **You should see the messages sent from `kafka1`**.

Try running the consumer on **`kafka3`** too:

```bash
docker exec -it kafka3 kafka-console-consumer.sh \
  --bootstrap-server kafka3:29094 \
  --topic replicated-topic \
  --from-beginning
```

🚀 **Success!** Now you can read messages from any broker.



![image-20250218160122914](./assets/image-20250218160122914.png)

------

## **5️⃣ Simulate Broker Failure (Failover Scenario)**

Now, let's **simulate a failure** where `kafka1` (the leader) **goes down**.

### **❌ Step 1: Stop Kafka1**

```bash
docker stop kafka1
```

This **kills Kafka1**, making the cluster elect a **new leader** for affected partitions.

but the consumers running above on kafka2 and kafka3 keep running unaffected

once the kafka1 node goes down, the leader for partiion1 changes from 1 to 2 - this is called **partition rebalancing**

![image-20250218161637677](./assets/image-20250218161637677.png)

### **🔍 Step 2: Check New Leaders**

```bash
docker exec -it kafka2 kafka-topics.sh \
  --describe \
  --bootstrap-server kafka2:29093 \
  --topic replicated-topic
```

✅ **Expected Change**:

```
Partition: 0	Leader: 2	Replicas: 1,2,3	Isr: 2,3
Partition: 1	Leader: 3	Replicas: 2,3,1	Isr: 3,2
Partition: 2	Leader: 2	Replicas: 3,1,2	Isr: 2,3
```

- **New leader elected** for partitions originally led by **Kafka1**.
- **ISR (In-Sync Replicas)** **drops to 2** (`1,2` or `2,3`) because Kafka1 is **offline**.

### **🛠 Step 3: Continue Producing and Consuming**

Even though `kafka1` is down, you can still **produce and consume messages**:

#### **Produce from Kafka2**

```bash
docker exec -it kafka2 kafka-console-producer.sh \
  --broker-list kafka2:29093 \
  --topic replicated-topic
```

#### **Consume from Kafka3**

```bash
docker exec -it kafka3 kafka-console-consumer.sh \
  --bootstrap-server kafka3:29094 \
  --topic replicated-topic \
  --from-beginning
```

✅ **Messages still flow** → Proves failover is working.

------

## **6️⃣ Bring Kafka1 Back Online**

Restart Kafka1:

```bash
docker start kafka1
```

Kafka1 will **rejoin the cluster**, and you can verify its return by checking:

```bash
docker exec -it kafka1 kafka-topics.sh \
  --describe \
  --bootstrap-server kafka1:29092 \
  --topic replicated-topic
```

the followign image shows kafka1 is back in game , replicas and ISR are already updated.

![image-20250218164750752](./assets/image-20250218164750752.png)

✅ **ISR should now include all 3 brokers again**.

------

## **🚀 Final Summary**

| Step                                                 | Command                                                      |
| ---------------------------------------------------- | ------------------------------------------------------------ |
| **Create a topic with 3 partitions & 3 replication** | `docker exec -it kafka1 kafka-topics.sh --create --bootstrap-server kafka1:9092 --replication-factor 3 --partitions 3 --topic replicated-topic` |
| **Verify topic details**                             | `docker exec -it kafka1 kafka-topics.sh --describe --bootstrap-server kafka1:9092 --topic replicated-topic` |
| **Produce messages**                                 | `docker exec -it kafka1 kafka-console-producer.sh --broker-list kafka1:9092 --topic replicated-topic` |
| **Consume messages from any broker**                 | `docker exec -it kafka2 kafka-console-consumer.sh --bootstrap-server kafka2:9093 --topic replicated-topic --from-beginning` |
| **Simulate broker failure**                          | `docker stop kafka1`                                         |
| **Verify new leader election**                       | `docker exec -it kafka2 kafka-topics.sh --describe --bootstrap-server kafka2:9093 --topic replicated-topic` |
| **Produce and consume during failure**               | Produce from `kafka2`, consume from `kafka3`                 |
| **Restart broker after failure**                     | `docker start kafka1`                                        |

------

## **🎯 What You Learned**

✅ **Replication (3 copies of each partition).**
 ✅ **Failover (Kafka still works when a broker crashes).**
 ✅ **Leader election (New brokers take over automatically).**
 ✅ **Consumers and producers work across any broker.**

windows etc/hosts file changes 



![image-20250226150900723](./assets/image-20250226150900723.png)

------

## Notes & Caveats

#pending - make sure the brokers are accessible from the HOST and with in docker as well 

1. ### **✅ Analysis: Can You Connect to Kafka from Both Docker and Host?**

   Yes, this **Confluent Kafka cluster Docker Compose setup supports connections from both:**

   1. **Inside Docker (containers on the same network)**
   2. **Outside Docker (your host machine)**

   ------

   ### **🛠 How Does It Work?**

   This is achieved by **dual listeners**:

   1. Internal Listener (`INTERNAL://kafka:29092`)
      - Used by **Kafka itself and other containers** (like Schema Registry, Control Center).
      - Advertised inside Docker as `kafka1:29092`.
   2. External Listener (`EXTERNAL://localhost:9092`)
      - Used by **clients running on your host machine**.
      - Advertised as `localhost:9092`, which means **your local machine can directly connect**.

   ```yaml
       environment:
         KAFKA_LISTENERS: INTERNAL://0.0.0.0:29092,EXTERNAL://0.0.0.0:9092
         KAFKA_ADVERTISED_LISTENERS: INTERNAL://kafka:29092,EXTERNAL://localhost:9092
         KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: INTERNAL:PLAINTEXT,EXTERNAL:PLAINTEXT
         KAFKA_INTER_BROKER_LISTENER_NAME: INTERNAL
   ```

   ### **🛠 Breakdown of Key Settings**

   | **Property**                                    | **Description**                                              |
   | ----------------------------------------------- | ------------------------------------------------------------ |
   | **`KAFKA_LISTENERS`**                           | Defines where Kafka listens. `0.0.0.0` means "bind to all interfaces." |
   | **`KAFKA_ADVERTISED_LISTENERS`**                | Defines what Kafka advertises to clients.                    |
   | **`INTERNAL://kafka:29092`**                    | Internal container-to-container communication.               |
   | **`EXTERNAL://localhost:9092`**                 | External connection for host-based clients.                  |
   | **`KAFKA_LISTENER_SECURITY_PROTOCOL_MAP`**      | Maps listeners to `PLAINTEXT` security mode.                 |
   | **`KAFKA_INTER_BROKER_LISTENER_NAME=INTERNAL`** | Ensures brokers communicate over `INTERNAL://kafka:29092`.   |

   ------

   ### **📝 Confirming Connectivity**

   #### **✅ Inside Docker (Other Containers)**

   Run this from **any other container** (e.g., `schema-registry`):

   ```bash
   docker exec -it confluent-schema-registry kafka-topics --list --bootstrap-server kafka:29092
   ```

   🔹 **Expected Output**: List of topics.

   #### **✅ From Your Host Machine**

   Run this **on your local terminal (outside Docker)**:

   ```bash
   kafka-topics.sh --list --bootstrap-server localhost:9092
   ```

   🔹 **Expected Output**: List of topics.

   #### **✅ Check Advertised Listeners**

   To verify advertised listeners:

   ```bash
   docker exec -it confluent-kafka kafka-configs --describe --bootstrap-server kafka:29092 --entity-type brokers
   ```

   🔹 **Expected Output**:

   ```
   Brokers:
     Broker 1: INTERNAL://kafka:29092, EXTERNAL://localhost:9092
   ```

   ------

   ### **🚀 Conclusion**

   ✅ **Yes, this setup supports connections from both Docker and Host.**

   - **Docker containers connect via `kafka:29092` (internal network).**
   - **Your host machine connects via `localhost:9092` (external listener).**
   - **Proper listener mappings allow seamless dual-access.**

   💡 **You can use this setup for a local development environment!** 🚀

2. **Replication Factor**: We set `replication-factor=3` for topic creation to demonstrate a true 3-broker cluster. If any broker is down, the topic can still have an active leader.

3. **Production vs. Development**: This is great for local demos or dev. In production, you’d enable **security** (SASL, TLS), **override** various config files, consider volumes for persistent data, etc.

4. **KRaft vs. ZooKeeper**: This example uses **ZooKeeper**. If you want a fully **KRaft-based** cluster, you’d skip Zookeeper and set up the KRaft configs. The process is a bit different, typically requiring `kafka-storage.sh format` steps, etc. (Not needed in Apache kafka 3.x and Confluent Kafka 7.x, until they completely take out the Zookeeper, pretty much all installs in industry are running with Zookeeper, but it is on its way out for sure.)

## Summary

- **Create a network**: `docker network create kafka-network`
- **Run Zookeeper**: `docker run -d ... bitnami/zookeeper:latest`
- **Run each broker** with distinct ports and broker IDs.
- **Create a topic**, produce and consume messages from the cluster.

Using this approach, you get a **3-broker Kafka cluster** plus Zookeeper, launched **entirely from the command line** without Docker Compose. This is handy if you want precise control or prefer single container commands, though many people find Docker Compose easier for multi-container setups.

#### [Step 6: Import/export your data as streams of events with Kafka Connect](https://kafka.apache.org/quickstart#quickstart_kafkaconnect)

You probably have lots of data in existing systems like relational databases or traditional messaging systems, along with many applications that already use these systems. [Kafka Connect](https://kafka.apache.org/documentation/#connect) allows you to continuously ingest data from external systems into Kafka, and vice versa. It is an extensible tool that runs *connectors*, which implement the custom logic for interacting with an external system. It is thus very easy to integrate existing systems with Kafka. To make this process even easier, there are hundreds of such connectors readily available.

In this quickstart we'll see how to run Kafka Connect with simple connectors that import data from a file to a Kafka topic and export data from a Kafka topic to a file.

First, make sure to add `connect-file-3.9.0.jar` to the `plugin.path` property in the Connect worker's configuration. For the purpose of this quickstart we'll use a relative path and consider the connectors' package as an uber jar, which works when the quickstart commands are run from the installation directory. However, it's worth noting that for production deployments using absolute paths is always preferable. See [plugin.path](https://kafka.apache.org/documentation/#connectconfigs_plugin.path) for a detailed description of how to set this config.

Edit the `config/connect-standalone.properties` file, add or change the `plugin.path` configuration property match the following, and save the file:

```bash
$ echo "plugin.path=libs/connect-file-3.9.0.jar" >> config/connect-standalone.properties
```

Then, start by creating some seed data to test with:

```bash
$ echo -e "foo\nbar" > test.txt
```

Or on Windows:

```bash
$ echo foo > test.txt
$ echo bar >> test.txt
```

Next, we'll start two connectors running in *standalone* mode, which means they run in a single, local, dedicated process. We provide three configuration files as parameters. The first is always the configuration for the Kafka Connect process, containing common configuration such as the Kafka brokers to connect to and the serialization format for data. The remaining configuration files each specify a connector to create. These files include a unique connector name, the connector class to instantiate, and any other configuration required by the connector.

```bash
$ bin/connect-standalone.sh config/connect-standalone.properties config/connect-file-source.properties config/connect-file-sink.properties
```

These sample configuration files, included with Kafka, use the default local cluster configuration you started earlier and create two connectors: the first is a source connector that reads lines from an input file and produces each to a Kafka topic and the second is a sink connector that reads messages from a Kafka topic and produces each as a line in an output file.

During startup you'll see a number of log messages, including some indicating that the connectors are being instantiated. Once the Kafka Connect process has started, the source connector should start reading lines from `test.txt` and producing them to the topic `connect-test`, and the sink connector should start reading messages from the topic `connect-test` and write them to the file `test.sink.txt`. We can verify the data has been delivered through the entire pipeline by examining the contents of the output file:

```bash
$ more test.sink.txt
foo
bar
```

Note that the data is being stored in the Kafka topic `connect-test`, so we can also run a console consumer to see the data in the topic (or use custom consumer code to process it):

```bash
$ bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic connect-test --from-beginning
{"schema":{"type":"string","optional":false},"payload":"foo"}
{"schema":{"type":"string","optional":false},"payload":"bar"}
…
```

The connectors continue to process data, so we can add data to the file and see it move through the pipeline:

```bash
$ echo "Another line" >> test.txt
```

You should see the line appear in the console consumer output and in the sink file.

#### [Step 7: Process your events with Kafka Streams](https://kafka.apache.org/quickstart#quickstart_kafkastreams)

Once your data is stored in Kafka as events, you can process the data with the [Kafka Streams](https://kafka.apache.org/documentation/streams) client library for Java/Scala. It allows you to implement mission-critical real-time applications and microservices, where the input and/or output data is stored in Kafka topics. Kafka Streams combines the simplicity of writing and deploying standard Java and Scala applications on the client side with the benefits of Kafka's server-side cluster technology to make these applications highly scalable, elastic, fault-tolerant, and distributed. The library supports exactly-once processing, stateful operations and aggregations, windowing, joins, processing based on event-time, and much more.

To give you a first taste, here's how one would implement the popular `WordCount` algorithm:

```java
KStream<String, String> textLines = builder.stream("quickstart-events");

KTable<String, Long> wordCounts = textLines
            .flatMapValues(line -> Arrays.asList(line.toLowerCase().split(" ")))
            .groupBy((keyIgnored, word) -> word)
            .count();

wordCounts.toStream().to("output-topic", Produced.with(Serdes.String(), Serdes.Long()));
```

The [Kafka Streams demo](https://kafka.apache.org/documentation/streams/quickstart) and the [app development tutorial](https://kafka.apache.org/39/documentation/streams/tutorial) demonstrate how to code and run such a streaming application from start to finish.

#### [Step 8: Terminate the Kafka environment](https://kafka.apache.org/quickstart#quickstart_kafkaterminate)

Now that you reached the end of the quickstart, feel free to tear down the Kafka environment—or continue playing around.

1. Stop the producer and consumer clients with `Ctrl-C`, if you haven't done so already.
2. Stop the Kafka broker with `Ctrl-C`.
3. Lastly, if the Kafka with ZooKeeper section was followed, stop the ZooKeeper server with `Ctrl-C`.

If you also want to delete any data of your local Kafka environment including any events you have created along the way, run the command:

```bash
$ rm -rf /tmp/kafka-logs /tmp/zookeeper /tmp/kraft-combined-logs
```



### 1. Brief Summary once again

#### What is Kafka?

Kafka is a **distributed event streaming platform** used for building real-time data pipelines and event-driven applications. It is widely adopted for handling high-throughput, fault-tolerant, and scalable event processing.

Kafka Official Quickstart - https://kafka.apache.org/documentation/#quickstart

#### Why Use Kafka?

Kafka is useful for:

- **Message Queueing**: Works as a distributed, persistent message broker.
- **Event Streaming**: Handles large-scale real-time event processing.
- **Log Aggregation**: Captures and centralizes application logs.
- **Decoupling Microservices**: Enables asynchronous communication between services.
- **Real-time Analytics**: Processes data streams with Kafka Streams or ksqlDB.

#### Kafka Architecture

Kafka has four main components:

1. **Producer**
   - Sends messages (events) to Kafka topics.
   - Can be configured for **synchronous** or **asynchronous** delivery.
2. **Broker**
   - Kafka runs as a **cluster** of brokers, where each broker is responsible for storing partitions of topics.
   - Kafka is **fault-tolerant**, meaning if a broker fails, the data is not lost.
3. **Consumer**
   - Reads messages from Kafka topics.
   - Consumers subscribe to topics and are grouped into **Consumer Groups** to share the load.
4. **Zookeeper (or KRaft Mode)**
   - Manages metadata (in older versions).
   - Helps with leader election and service discovery.
   - **Kafka 3.0+ introduced KRaft mode**, removing Zookeeper dependency.

#### Core Kafka Concepts

- **Topics**: Channels where messages are published.
- **Partitions**: Topics are divided into partitions for scalability.
- **Replication**: Ensures data is duplicated across brokers for fault tolerance.
- **Offset**: The position of a message in a partition, tracked for consumers.

#### Kafka vs. Traditional Messaging Systems

| Feature        | Kafka                          | Traditional Message Queues (RabbitMQ, ActiveMQ) |
| -------------- | ------------------------------ | ----------------------------------------------- |
| Storage        | Persistent (logs retained)     | Message disappears after consumption            |
| Scalability    | Highly scalable (partitioning) | Limited scalability                             |
| Consumer Model | Pub-Sub & Consumer Groups      | Point-to-Point or Pub-Sub                       |
| Ordering       | Maintains order per partition  | Ordering can be tricky                          |

Here's a simple diagram illustrating **Kafka's Architecture**:

------

### Kafka Architecture Overview

```
              +----------------------+
              |      Producer(s)      |
              |  (Writes to Topics)   |
              +----------+-----------+
                         |
                         v
            +---------------------------+
            |         Kafka Cluster      |
            |  (Multiple Brokers)        |
            +---------------------------+
                         |
       ----------------------------------------
       |                |                     |
       v                v                     v
+-------------+  +-------------+  +-------------+
|  Partition  |  |  Partition  |  |  Partition  |
|     0       |  |     1       |  |     2       |
+-------------+  +-------------+  +-------------+
       |                |                     |
       v                v                     v
+-------------+  +-------------+  +-------------+
| Consumer A  |  | Consumer B  |  | Consumer C  |
| (Reads Data)|  | (Reads Data)|  | (Reads Data)|
+-------------+  +-------------+  +-------------+

                (Consumers grouped in a Consumer Group)
```

------

### Key Takeaways from the Diagram

1. **Producers** send messages to Kafka **Topics**.
2. Kafka distributes messages across **Partitions** (ensuring scalability).
3. Each **Broker** in the Kafka Cluster holds multiple **Partitions**.
4. **Consumers** in a **Consumer Group** consume messages in a distributed manner.
5. Kafka guarantees **message ordering within a partition** but not across partitions.



### Kafka vs ActiveMQ vs RabbitMQ Comparison

Let's compare **Kafka, ActiveMQ, and RabbitMQ** in terms of **messaging semantics**, **push vs pull**, and **Pub-Sub vs Point-to-Point models**.

------

## 1. Messaging Semantics (Exactly-Once, At-Least-Once, At-Most-Once)

| Feature                | **Kafka**                                           | **ActiveMQ**                                                | **RabbitMQ**                                                 |
| ---------------------- | --------------------------------------------------- | ----------------------------------------------------------- | ------------------------------------------------------------ |
| **At Most Once**       | ✅ (Best effort, no retries)                         | ✅                                                           | ✅                                                            |
| **At Least Once**      | ✅ (Default behavior)                                | ✅ (Default, via durable queues)                             | ✅ (Default, via acknowledgments)                             |
| **Exactly Once**       | ✅ (Requires idempotent producer and transactions)   | ✅ (XA transactions, JMS)                                    | ✅ (Using publisher confirms & transactional queues)          |
| **How it works?**      | Uses **offset commits** to track processing status. | Uses **JMS transactions**.                                  | Uses **message acknowledgments (ACKs)** & **publisher confirms**. |
| **Performance Impact** | **High performance** due to log-based architecture. | **Slower than Kafka** due to traditional message brokering. | **Fast but limited for large-scale event streaming.**        |

### Key Differences

- **Kafka’s Exactly-Once processing** is better for event streaming **(idempotency + transactions).**
- **ActiveMQ and RabbitMQ use traditional transactional messaging**, making them better suited for **small-scale reliable messaging.**
- **Kafka does not lose messages unless explicitly deleted** (offset-based processing).
- **RabbitMQ and ActiveMQ use message acknowledgments, which can slow down performance** when ensuring reliability.

------

## 2. Push vs Pull Model

| Feature                   | **Kafka** (Pull-Based)                  | **ActiveMQ** (Push-Based)                         | **RabbitMQ** (Push-Based)                            |
| ------------------------- | --------------------------------------- | ------------------------------------------------- | ---------------------------------------------------- |
| **Push vs Pull**          | **Pull-based** (Consumers poll brokers) | **Push-based** (Broker pushes to consumers)       | **Push-based** (Broker pushes messages to consumers) |
| **Backpressure Handling** | ✅ (Consumers control their read speed)  | ❌ (Slower consumers may get overloaded)           | ❌ (Push model may overwhelm slow consumers)          |
| **Message Ordering**      | ✅ (Order maintained within a partition) | ❌ (Message order not guaranteed across consumers) | ❌ (Order can break across multiple consumers)        |
| **Load Balancing**        | ✅ (Consumers are assigned partitions)   | ❌ (Load balancing is manual)                      | ✅ (Fair dispatching via work queues)                 |

### Key Differences

- **Kafka is pull-based**, allowing consumers to control their read speed (**prevents overload**).
- **ActiveMQ and RabbitMQ use push-based messaging**, which is good for **low-latency real-time messaging** but **can overwhelm consumers** if they are slow.
- **Kafka ensures strict ordering per partition**, while RabbitMQ and ActiveMQ **may not maintain order when multiple consumers are involved**.

------

## 3. Pub-Sub vs Point-to-Point Messaging

| Feature                  | **Kafka**                                            | **ActiveMQ**                                        | **RabbitMQ**                                         |
| ------------------------ | ---------------------------------------------------- | --------------------------------------------------- | ---------------------------------------------------- |
| **Pub-Sub Model**        | ✅ (Multiple consumer groups can read the same topic) | ✅ (Using topics)                                    | ✅ (Using exchanges with fanout mode)                 |
| **Point-to-Point Model** | ✅ (Consumer groups share partitions)                 | ✅ (Using queues)                                    | ✅ (Using direct queues)                              |
| **Scalability**          | ✅ **Highly scalable** (Partition-based)              | ❌ **Limited scalability** (Single queue processing) | ❌ **Limited scalability** (Slower with large queues) |
| **Message Retention**    | ✅ (Messages persist for days/weeks)                  | ❌ (Messages are deleted after consumption)          | ❌ (Messages are deleted after consumption)           |

### Key Differences

- **Kafka allows both Pub-Sub and Point-to-Point using consumer groups.**
- **RabbitMQ and ActiveMQ support Pub-Sub using topics and Point-to-Point using direct queues.**
- **Kafka messages persist even after consumption**, while **RabbitMQ and ActiveMQ delete messages once acknowledged.**
- **Kafka is more scalable due to partitions, while ActiveMQ and RabbitMQ struggle with large-scale workloads.**

------

## Final Summary: Which One to Use?

| Use Case                       | **Kafka**             | **ActiveMQ**                | **RabbitMQ**                |
| ------------------------------ | --------------------- | --------------------------- | --------------------------- |
| **Event Streaming & Logs**     | ✅ Best Choice         | ❌ Not Designed for It       | ❌ Not Designed for It       |
| **Microservices Messaging**    | ✅ Good                | ✅ Good                      | ✅ Best                      |
| **Real-Time Processing**       | ✅ Best Choice         | ❌ High Latency              | ❌ High Latency              |
| **Strict Ordering**            | ✅ (Within Partitions) | ❌ (Ordering Not Guaranteed) | ❌ (Ordering Not Guaranteed) |
| **High Throughput (Big Data)** | ✅ Best Choice         | ❌ Not Scalable              | ❌ Not Scalable              |
| **Traditional Queues**         | ❌ Not Ideal           | ✅ Best Choice               | ✅ Best Choice               |

### Conclusion

- **Use Kafka** if you need **high throughput, event-driven processing, and persistence**.
- **Use RabbitMQ** if you need **lightweight messaging for microservices**.
- **Use ActiveMQ** if you need **JMS-based enterprise messaging**.

------

### Component-Level Differences: Apache Kafka vs. Confluent Kafka

Apache Kafka and Confluent Kafka share the same **core Kafka engine**, but Confluent Kafka includes **enterprise-grade enhancements** and additional tools for ease of use, security, and monitoring.

------

## 1. Core Kafka Components (Same in Both)

| **Component**                 | **Apache Kafka**                        | **Confluent Kafka**    |
| ----------------------------- | --------------------------------------- | ---------------------- |
| **Brokers**                   | ✅ Handles message storage & replication | ✅ Same as Apache Kafka |
| **Topics & Partitions**       | ✅ Stores event logs                     | ✅ Same as Apache Kafka |
| **Producers & Consumers**     | ✅ Default Kafka API                     | ✅ Same as Apache Kafka |
| **Zookeeper (or KRaft mode)** | ✅ Manages metadata                      | ✅ Same as Apache Kafka |
| **Kafka Streams**             | ✅ Provides stream processing            | ✅ Same as Apache Kafka |

> **No difference** in the core Kafka engine, messaging semantics, or producer/consumer behavior.

------

## 2. Additional Components in Confluent Kafka

| **Component**             | **Apache Kafka**                      | **Confluent Kafka**                         |
| ------------------------- | ------------------------------------- | ------------------------------------------- |
| **Schema Registry**       | ❌ Not included                        | ✅ Manages Avro, JSON, Protobuf schemas      |
| **REST Proxy**            | ❌ Not included                        | ✅ Enables HTTP-based Kafka communication    |
| **Kafka Connect**         | ✅ Available but requires manual setup | ✅ Pre-configured with additional connectors |
| **ksqlDB**                | ❌ Not included                        | ✅ SQL-based stream processing               |
| **Control Center UI**     | ❌ Not included                        | ✅ Web UI for monitoring Kafka               |
| **Tiered Storage**        | ❌ Not included                        | ✅ Stores Kafka logs in cloud storage        |
| **Security & Governance** | ❌ Basic ACLs only                     | ✅ Enterprise-grade RBAC, audit logs         |
| **Enterprise Support**    | ❌ Community support                   | ✅ Paid support available                    |

### Key Takeaways

- **Apache Kafka** is **open-source** but requires **manual setup** for schema management, UI monitoring, and security.
- **Confluent Kafka** provides **ready-to-use tools** for easier **deployment, monitoring, and data governance**.

------

## 3. Architectural Comparison

### Apache Kafka (Minimal Setup)

- Requires **manual configuration** for connectors, schema handling, and monitoring.
- Uses **Zookeeper (or KRaft mode)** for metadata management.
- No built-in UI for monitoring. Although you could use tools available in the Kafka ecosystem (kafkacat, conduktor etc but mostly big organizations all use Confluent kafka distribution with Confluent's own Control Center, Schema registry components)

### Confluent Kafka (Enterprise Features)

- **Pre-configured** with Schema Registry, REST Proxy, and Kafka Connect.
- Provides **UI-based management** with **Confluent Control Center**.
- Supports **Hybrid Cloud & Tiered Storage** (can store Kafka logs in object storage).
- Includes **security features** (RBAC, Audit Logs, Advanced ACLs).

------

## 4. When to Use What?

| **Use Case**                         | **Apache Kafka**             | **Confluent Kafka**                 |
| ------------------------------------ | ---------------------------- | ----------------------------------- |
| **Basic Pub-Sub Messaging**          | ✅ Suitable                   | ✅ Suitable                          |
| **Microservices with Avro/Protobuf** | ❌ Manual setup               | ✅ Schema Registry simplifies this   |
| **Enterprise Monitoring & UI**       | ❌ Requires third-party tools | ✅ Control Center UI included        |
| **Cloud Deployment & SaaS**          | ❌ Limited options            | ✅ Managed Confluent Cloud available |
| **Security & RBAC**                  | ❌ Basic ACLs                 | ✅ Enterprise-grade controls         |
| **Tiered Storage (Cloud)**           | ❌ Not available              | ✅ Supports cloud-based storage      |

------

### Final Conclusion

- **Use Apache Kafka** if you are comfortable managing Kafka **manually** with **open-source tools**.
- **Use Confluent Kafka** if you need **enterprise security, monitoring, schema registry, and cloud integration**.

# Overall-plan

#pending (cleanup this setup)

- Apache Kafka getting started 
- Start a local setup
  - docker compose -f docker-compose-apache.yml docker-compose-apache.yml
- Make it a cluster
- then run that cluster with docker compose 
- then do some docker basics and docker compose basics 
- then run a consumer producer from command line 
  - show command line commands to create topics
  - check topics got created
  - then run command line producer and command line consumer - show message sending 
    - then run spring boot based producer and consumer in the mix to the same topic 
    - attach a rest endpoint to send the messages to producer 
    - show consumer groups concept to consume from beginning 
      - or from where you left 
    - show concepts like replication
    - show concepts like partitioning 
- bring down the local setup 
  - docker compose -f docker-compose-apache.yml down

### Docker Compose Setup for Apache Kafka and Confluent Kafka

Below, I'll provide two separate Docker Compose files:

1. Apache Kafka (Minimal Open-Source Setup)  - it was done above already in Apache Kafka Getting Started section.
2. Confluent Kafka (Enterprise Features Setup)

## Confluent Kafka (Enterprise Setup)

- Uses **Confluent Platform** (Kafka + Schema Registry + Control Center)
- Supports **Kafka Connect, REST Proxy, and Monitoring UI**
- **Ideal for production-like setups**

### `docker-compose-confluent.yml`

```yaml
services:
  zookeeper:
    image: confluentinc/cp-zookeeper:latest
    container_name: confluent-zookeeper
    environment:
      ZOOKEEPER_CLIENT_PORT: 2181
      ZOOKEEPER_TICK_TIME: 2000
    ports:
      - "2181:2181"

  kafka:
    image: confluentinc/cp-kafka:latest
    container_name: confluent-kafka
    depends_on:
      - zookeeper
    ports:
      - "9092:9092"
      - "29092:29092"
    environment:
      KAFKA_BROKER_ID: 1
      KAFKA_ZOOKEEPER_CONNECT: "zookeeper:2181"
      KAFKA_LISTENERS: INTERNAL://0.0.0.0:29092,EXTERNAL://0.0.0.0:9092
      KAFKA_ADVERTISED_LISTENERS: INTERNAL://kafka:29092,EXTERNAL://localhost:9092
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: INTERNAL:PLAINTEXT,EXTERNAL:PLAINTEXT
      KAFKA_INTER_BROKER_LISTENER_NAME: INTERNAL
      KAFKA_AUTO_CREATE_TOPICS_ENABLE: "true"

# ADD THESE FOR SINGLE-BROKER MODE:
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1
      KAFKA_DEFAULT_REPLICATION_FACTOR: 1
      KAFKA_TRANSACTION_STATE_LOG_REPLICATION_FACTOR: 1
      KAFKA_TRANSACTION_STATE_LOG_MIN_ISR: 1
  schema-registry:
    image: confluentinc/cp-schema-registry:latest
    container_name: confluent-schema-registry
    depends_on:
      - kafka
    ports:
      - "8081:8081"
    environment:
      SCHEMA_REGISTRY_KAFKASTORE_BOOTSTRAP_SERVERS: "PLAINTEXT://kafka:29092"
      SCHEMA_REGISTRY_HOST_NAME: "schema-registry"

  control-center:
    image: confluentinc/cp-enterprise-control-center:latest
    container_name: confluent-control-center
    depends_on:
      - kafka
      - schema-registry
    ports:
      - "9021:9021"
    environment:
      CONTROL_CENTER_BOOTSTRAP_SERVERS: "PLAINTEXT://kafka:29092"
      CONTROL_CENTER_SCHEMA_REGISTRY_URL: "http://schema-registry:8081"
```

### Key Features:

✅ Supports **Schema Registry** for Avro, JSON, Protobuf
 ✅ Includes **Confluent Control Center UI** for monitoring
 ✅ Prepares you for **Kafka Connect and REST Proxy**

------

## 🚀 How to Run the Setups

1. Apache Kafka (Basic Setup)

   ```sh
   docker-compose -f docker-compose-apache.yml up -d
   ```

2. **Confluent Kafka (Enterprise Setup)**

   ```sh
   docker-compose -f docker-compose-confluent.yml up -d
   ```

3. **Verify Running Containers**

   ```sh
   docker ps
   ```

4. **Test Kafka with CLI (For Both Setups)**

   - Create a topic:

     ```sh
     docker exec -it kafka kafka-topics.sh --create --topic test-topic --bootstrap-server localhost:9092
     ```

   - List topics:

     ```sh
     docker exec -it kafka kafka-topics.sh --list --bootstrap-server localhost:9092
     ```

   - Send a message:

     ```sh
     docker exec -it kafka kafka-console-producer.sh --topic test-topic --bootstrap-server localhost:9092
     ```

   - Consume messages:

     ```sh
     docker exec -it kafka kafka-console-consumer.sh --topic test-topic --bootstrap-server localhost:9092 --from-beginning
     ```

------

### 📌 Final Comparison:

| Feature              | **Apache Kafka** | **Confluent Kafka**        |
| -------------------- | ---------------- | -------------------------- |
| **Ease of Setup**    | ✅ Simple         | ❌ Requires More Config     |
| **Schema Registry**  | ❌ No             | ✅ Yes                      |
| **Kafka Connect**    | ❌ No             | ✅ Yes                      |
| **Monitoring UI**    | ❌ No             | ✅ Confluent Control Center |
| **Production Ready** | ❌ Limited        | ✅ Yes                      |

------

### 

------

### Spring Boot 3.4.2 API Endpoints for Sending and Receiving Kafka Messages

I'll provide separate REST API endpoints for **Apache Kafka** and **Confluent Kafka**.

------

## 1️⃣ Apache Kafka (Basic JSON Messaging)

- Sends and receives **plain JSON messages**.
- Uses **String-based serialization**.
- It uses Spring Kafka API - note the use ```KafkaTemplate``` for sending the messages and the use of ```KafkaListener``` for receiving the messages

### 1.1 Add Dependencies (`pom.xml`)

*(Already provided in previous steps)*

------

### 1.2 Configure `application.yml`

```yaml
spring:
  kafka:
    bootstrap-servers: localhost:9092
    producer:
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: org.apache.kafka.common.serialization.StringSerializer
    consumer:
      group-id: my-group
      key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
      value-deserializer: org.apache.kafka.common.serialization.StringDeserializer
      auto-offset-reset: earliest
```

------

### 1.3 Create Kafka Producer API (`KafkaProducerController.java`)

```java
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class KafkaProducerController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String topic, @RequestParam String message) {
        kafkaTemplate.send(topic, message);
        return "Message sent to topic: " + topic;
    }
}
```

------

### 1.4 Create Kafka Consumer (`KafkaConsumerService.java`)

```java
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "test-topic", groupId = "my-group")
    public void listen(ConsumerRecord<String, String> record) {
        System.out.println("Received Message: " + record.value());
    }
}
```

------

### 1.5 Test the Apache Kafka API

1. Start Kafka

   ```sh
   docker-compose -f docker-compose-apache.yml up -d
   ```

2. Run Spring Boot

   ```sh
   mvn spring-boot:run
   ```

3. Send a Message

   ```sh
   curl -X POST "http://localhost:8080/api/kafka/send?topic=test-topic&message=HelloKafka"
   ```

4. Check Console Output

   ```
   Received Message: HelloKafka
   ```

------



### if you want to use Native Java client API from Apache Kafka for sending and consuming the messages the code will look slightly different it uses `Consumer`   ```ConsumerRecord``` , ```Producer``` and ```ProducerRecord```



```java
package io.reactivestax.spring_with_native_kafkaapi;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class KafkaConsumerService {
    private final Consumer<String, String> consumer;

    public KafkaConsumerService() {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "my-group");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        this.consumer = new KafkaConsumer<>(props);
        this.consumer.subscribe(Collections.singleton("my-topic"));
    }

    @PostConstruct
    public void startConsumer() {
        new Thread(() -> {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, String> record : records) {
                    System.out.printf("Consumed from %s | partition=%d | offset=%d | key=%s | value=%s%n",
                            record.topic(), record.partition(), record.offset(), record.key(), record.value());
                }
                consumer.commitSync();
            }
        }).start();
    }
}

```



```java
package io.reactivestax.spring_with_native_kafkaapi;

import java.util.Properties;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private final Producer<String, String> producer;

    public KafkaProducerService() {
        // Configure Kafka Producer properties
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.ACKS_CONFIG, "all");

        // Create Kafka Producer
        this.producer = new KafkaProducer<>(props);
    }

    public void sendMessage(String topic, String key, String message) {
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, message);
        Future<RecordMetadata> future = producer.send(record, (metadata, exception) -> {
            if (exception == null) {
                System.out.printf("Sent to %s | partition=%d | offset=%d%n",
                        metadata.topic(), metadata.partition(), metadata.offset());
            } else {
                System.err.println("Error sending message: " + exception.getMessage());
            }
        });
    }
}

```

```java
package io.reactivestax.spring_with_native_kafkaapi;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
    private final KafkaProducerService producerService;

    public KafkaController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/publish")
    public String sendMessage(@RequestParam String topic, @RequestParam String key, @RequestParam String message) {
        producerService.sendMessage(topic, key, message);
        return "Message Sent!";
    }
}

```

```sh
curl -X POST "http://localhost:8080/kafka/publish?topic=my-topic&key=123&message=HeHelloKafka" 
```

```sh

2025-02-19T14:53:19.451-05:00  INFO 65407 --- [spring-with-native-kafkaapi] [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2025-02-19T14:53:19.451-05:00  INFO 65407 --- [spring-with-native-kafkaapi] [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2025-02-19T14:53:19.453-05:00  INFO 65407 --- [spring-with-native-kafkaapi] [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
Sent to my-topic | partition=0 | offset=0
Consumed from my-topic | partition=0 | offset=0 | key=123 | value=HeHelloKafka
Sent to my-topic | partition=0 | offset=1
Consumed from my-topic | partition=0 | offset=1 | key=123 | value=HeHelloKafka
Sent to my-topic | partition=0 | offset=2
Consumed from my-topic | partition=0 | offset=2 | key=123 | value=HeHelloKafka
Sent to my-topic | partition=0 | offset=3
Consumed from my-topic | partition=0 | offset=3 | key=123 | value=HeHelloKafka
Sent to my-topic | partition=0 | offset=4
Consumed from my-topic | partition=0 | offset=4 | key=123 | value=HeHelloKafka
Sent to my-topic | partition=0 | offset=5
Consumed from my-topic | partition=0 | offset=5 | key=123 | value=HeHelloKafka232352352356
```



## 2️⃣ Confluent Kafka (Avro Messaging with Schema Registry)

- Uses **Schema Registry** to serialize messages.
- Sends and receives **Avro objects**.

------

### 2.1 Configure `application.yml`

```yaml
spring:
  kafka:
    bootstrap-servers: localhost:9092
    schema-registry-url: http://localhost:8081
    producer:
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: io.confluent.kafka.serializers.KafkaAvroSerializer
    consumer:
      group-id: my-group
      key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
      value-deserializer: io.confluent.kafka.serializers.KafkaAvroDeserializer
      properties:
        specific.avro.reader: true
      auto-offset-reset: earliest
```

------

### 2.2 Create** Avro Schema (`src/main/avro/User.avsc`)**

```json
{
  "type": "record",
  "name": "User",
  "namespace": "com.example",
  "fields": [
    { "name": "id", "type": "int" },
    { "name": "name", "type": "string" }
  ]
}
```

Run:

```sh
mvn generate-sources
```

This generates `User.java` in `target/generated-sources`.

------

### 2.3 Create Kafka Producer API (`KafkaAvroProducerController.java`)

```java
import com.example.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class KafkaAvroProducerController {

    private final KafkaTemplate<String, User> kafkaTemplate;

    public KafkaAvroProducerController(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/send-avro")
    public String sendUser(@RequestParam String topic, @RequestParam int id, @RequestParam String name) {
        User user = new User(id, name);
        kafkaTemplate.send(topic, user);
        return "User sent to topic: " + topic;
    }
}
```

------

### 2.4 Create Kafka Avro Consumer (`KafkaAvroConsumerService.java`)

```java
import com.example.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaAvroConsumerService {

    @KafkaListener(topics = "user-topic", groupId = "my-group")
    public void listen(User user) {
        System.out.println("Received User: " + user);
    }
}
```

------

### 2.5 Test** the Confluent Kafka API**

1. Start Confluent Kafka

   ```sh
   docker-compose -f docker-compose-confluent.yml up -d
   ```

2. Run Spring Boot

   ```sh
   mvn spring-boot:run
   ```

3. Send an Avro Message

   ```sh
   curl -X POST "http://localhost:8080/api/kafka/send-avro?topic=user-topic&id=1&name=Robin"
   ```

4. Check Console Output

   ```
   Received User: User{id=1, name='Robin'}
   ```

------

## 🚀 Summary: Apache Kafka vs. Confluent Kafka API

| Feature                  | **Apache Kafka API** | **Confluent Kafka API**   |
| ------------------------ | -------------------- | ------------------------- |
| **Data Format**          | String (Plain JSON)  | Avro (Schema Registry)    |
| **Schema Management**    | ❌ No                 | ✅ Yes (Avro)              |
| **Performance**          | ✅ Fast               | ⚠️ Slightly higher latency |
| **Production Readiness** | ❌ Basic              | ✅ Enterprise-grade        |

------





### Securing Kafka, Using Kafka Streams, and Deploying Kafka on Kubernetes

We'll cover:

1. Securing Kafka using SSL/SASL
2. Using Kafka Streams for real-time processing
3. Deploying Kafka on Kubernetes

------

## 1️⃣ Securing Kafka using SSL/SASL

Kafka supports **encryption and authentication** via **SSL** (TLS) and **SASL** (Simple Authentication and Security Layer).

### 1.1 Generate SSL Certificates

Run the following commands to generate **self-signed certificates**:

```sh
mkdir kafka-ssl
cd kafka-ssl

# Generate CA key & certificate
openssl req -new -x509 -keyout ca-key -out ca-cert -days 365 -subj "/CN=Kafka-CA"

# Generate Kafka broker certificate
openssl req -new -keyout kafka-broker-key -out kafka-broker-req -subj "/CN=kafka-broker"
openssl x509 -req -CA ca-cert -CAkey ca-key -in kafka-broker-req -out kafka-broker-cert -days 365 -CAcreateserial
```

### 1.2 Update `docker-compose.yml` for SSL

Modify Kafka service:

```yaml
  kafka:
    image: bitnami/kafka:latest
    container_name: kafka-secure
    ports:
      - "9093:9093"
    environment:
      - KAFKA_CFG_LISTENERS=SSL://0.0.0.0:9093
      - KAFKA_CFG_ADVERTISED_LISTENERS=SSL://localhost:9093
      - KAFKA_CFG_SSL_KEYSTORE_LOCATION=/certs/kafka.keystore.jks
      - KAFKA_CFG_SSL_KEYSTORE_PASSWORD=changeit
      - KAFKA_CFG_SSL_TRUSTSTORE_LOCATION=/certs/kafka.truststore.jks
      - KAFKA_CFG_SSL_TRUSTSTORE_PASSWORD=changeit
    volumes:
      - ./kafka-ssl:/certs
```

> **Kafka is now secured over SSL.**

------

### 1.3 Configure** `application.yml` for Spring Boot**

```yaml
spring:
  kafka:
    bootstrap-servers: localhost:9093
    security:
      protocol: SSL
    properties:
      ssl:
        truststore-location: file:/certs/kafka.truststore.jks
        truststore-password: changeit
        keystore-location: file:/certs/kafka.keystore.jks
        keystore-password: changeit
```

> **Spring Boot will now communicate with Kafka securely over SSL.**

------

## 2️⃣ Kafka Streams for Real-Time Processing

Kafka Streams allows **real-time transformations** of data.

### 2.1 Add Kafka Streams Dependency (`pom.xml`)

```xml
<dependency>
    <groupId>org.apache.kafka</groupId>
    <artifactId>kafka-streams</artifactId>
</dependency>
```

------

### 2.2 Configure `application.yml`

```yaml
spring:
  kafka:
    streams:
      application-id: kafka-streams-app
      bootstrap-servers: localhost:9092
```

------

### 2.3 Create a Kafka Streams Processing Topology

```java
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class KafkaStreamsService {

    public KafkaStreamsService() {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "kafka-streams-app");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        StreamsBuilder builder = new StreamsBuilder();
        KStream<String, String> stream = builder.stream("input-topic");
        stream.mapValues(String::toUpperCase).to("output-topic");

        KafkaStreams streams = new KafkaStreams(builder.build(), props);
        streams.start();
    }
}
```

> This **reads messages from `input-topic`**, converts them to **uppercase**, and writes to `output-topic`.

------

### 2.4 Test Kafka Streams

1. Send data to **input-topic**:

   ```sh
   kafka-console-producer.sh --topic input-topic --bootstrap-server localhost:9092
   ```

   ```
   hello world
   ```

2. Consume data from **output-topic**:

   ```sh
   kafka-console-consumer.sh --topic output-topic --bootstrap-server localhost:9092 --from-beginning
   ```

   ```
   HELLO WORLD
   ```

> **Kafka Streams processes messages in real-time!**

------

## 3️⃣ Deploying Kafka on Kubernetes

Kafka **scales better** when deployed on **Kubernetes**.

### 3.1 Create a Kubernetes Deployment for Kafka

Create `kafka-deployment.yaml`:

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: kafka
spec:
  replicas: 1
  selector:
    matchLabels:
      app: kafka
  template:
    metadata:
      labels:
        app: kafka
    spec:
      containers:
        - name: kafka
          image: bitnami/kafka:latest
          ports:
            - containerPort: 9092
          env:
            - name: KAFKA_CFG_ZOOKEEPER_CONNECT
              value: "zookeeper:2181"
            - name: KAFKA_CFG_LISTENERS
              value: "PLAINTEXT://:9092"
            - name: KAFKA_CFG_ADVERTISED_LISTENERS
              value: "PLAINTEXT://kafka:9092"
```

> **This deploys Kafka as a single node in Kubernetes.**

------

### 3.2 Deploy Kafka to Kubernetes

1. Start Minikube:

   ```sh
   minikube start
   ```

2. Apply the Deployment:

   ```sh
   kubectl apply -f kafka-deployment.yaml
   ```

3. Verify Deployment:

   ```sh
   kubectl get pods
   ```

   ```
   NAME                      READY   STATUS    RESTARTS   AGE
   kafka-54cd8c7d88-8f29x    1/1     Running   0          5m
   ```

------

### 3.3 Expose Kafka as a Kubernetes Service

Create `kafka-service.yaml`:

```yaml
apiVersion: v1
kind: Service
metadata:
  name: kafka-service
spec:
  type: NodePort
  selector:
    app: kafka
  ports:
    - protocol: TCP
      port: 9092
      targetPort: 9092
```

Apply:

```sh
kubectl apply -f kafka-service.yaml
```

Find the Kafka service port:

```sh
kubectl get services
NAME            TYPE        CLUSTER-IP       EXTERNAL-IP   PORT(S)
kafka-service   NodePort    10.109.187.243   <none>        9092:31500/TCP
```

Now, Kafka is available at:

```sh
minikube service kafka-service --url
```

------

### 3.4 Configure Spring Boot to Use Kafka on Kubernetes

Modify `application.yml`:

```yaml
spring:
  kafka:
    bootstrap-servers: kafka-service:9092
```

> **Spring Boot is now connected to Kafka on Kubernetes!**

------

## 🚀 Final Summary

| Feature                        | **Implementation**                                           |
| ------------------------------ | ------------------------------------------------------------ |
| **Secure Kafka with SSL/SASL** | Kafka brokers use **SSL certificates** for encrypted communication. |
| **Kafka Streams Processing**   | Transforms real-time messages using **Kafka Streams API**.   |
| **Kafka on Kubernetes**        | Deploys **Kafka & Spring Boot in a scalable environment**.   |

------



- ## CLASS ASSIGNMENT

- Spring boot app  https://github.com/FullStackLabsCa/boca-spring-boot-app.git 

  - docker setup (dockerized the spring boot app using Dockerfile)https://github.com/FullStackLabsCa/bootcamp2024-material/blob/main/lecture-32-docker-tech.md#running-a-spring-boot-project-using-a-dockerfile
    - boca-spring-boot-app-instance/Dockerfile https://github.com/FullStackLabsCa/boca-spring-boot-app/blob/main/boca-spring-boot-app-instance/Dockerfile
    - docker compose setup https://github.com/FullStackLabsCa/boca-spring-boot-app/blob/main/boca-spring-boot-app-instance/docker-compose.yml
    - all docker commands from class and more are here 
      https://github.com/FullStackLabsCa/boca-spring-boot-app/blob/main/boca-spring-boot-app-instance/Docker-Commands.md

  - Make sure you are running this version of docker desktop 

  - ![image-20250226165359481](./assets/image-20250226165359481.png) then only you can run the following command without "-" between docker and compose

    ```sh
    docker compose -f filename up -d 
    ```

  - 

  - **Make sure you are able to run Kafka on MAC using docker using the following notes** 

  - **notes are here https://github.com/FullStackLabsCa/bootcamp2024-material/blob/main/lecture29-kafka-spring-boot.md#3-broker-kafka-cluster-plus-zookeeper-from-docker-based-images**

  - **use this apache cluster docker compose file** 
    **https://github.com/FullStackLabsCa/FullStackLabsCa-boca-kafka-springboot-app/blob/main/kafka-configs/apache-kafka/docker-compose-apache-cluster.yml**

- **Windows VM based setup**

  - **we are running windows VM using VMware Fusion software** 

  - **the MAIN GOAL is you have to use Windows as your development machine (yøu will write code in IntelliJ on windows and push it to Github) <u>DO NOT INSTALL DOCKER ON WINDOWS</u>** 

    - **you have to be able to run all kafka commands from windows   c:\users\vagrant\tools\apache-kafka**      

      - **to download the confluent kafka and apache kafka for accessing the bin/<all-commands>** 

        **https://kafka.apache.org/downloads**

      - **from DOS Prompt - then execute >>>> bin\windows\kafka-topics.bat --list --bootstrap-server kafka1:9092**

      - **from Git Bash - then execute >>>>>   bin/kafka-topics.sh --list --bootstrap-server kafka1:9092**

    - you will use postgreSQL , mySQL, Kafka server , RabbitMQ and ActiveMQ servers on Mac (being run with docker)

    - active life canada project should work on Windows , 

      - just run your project from windows , pointing the postgreSQL and activeMQ running MAC (running via docker-compose)

        

  

  to download the confluent kafka and apache kafka for accessing the bin/<all-commands> 

  https://www.confluent.io/installation/

  https://kafka.apache.org/downloads


  Run the entire stack for active-life canada project on windows
  chocolatey - 

  install java - download it from 
  https://adoptium.net/temurin/releases/?os=windows&arch=x64&package=jdk&version=17

  C:\Program Files\Java\Java17
  c:\Program Files(x86)\

  install bash for windows 
  https://git-scm.com/downloads

  setting up the path 

  always download zip files for tools as much as possible 
  coz it does not need any special permissions to unzip and run 

  https://notepad-plus-plus.org/downloads/v8.7.7/
  https://git-scm.com/downloa	ds/win
  	
  https://github.com/FullStackLabsCa/FullStackLabsCa-boca-kafka-springboot-app.git

  


  - java 
  - git-bash for windows	
  - intellij community edition for windows
  - kafka apache 
  - kafka confluent 
  - remember your c:\windows\system32\drivers\etc\hosts
  you give your ip <-> hostname mapping

























