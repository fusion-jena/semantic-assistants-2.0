# Semantic Assistants 2.0 - spring boot application

This spring boot application uses several NLP services for Named Entity Recognition tasks with two micro services.

The first micro service provides three GATE pipelines:

* [GATE ANNIE](https://github.com/GateNLP)
* [BiodivTagger](https://github.com/fusion-jena/BiodivTagger)
* [OrganismTagger](https://www.semanticsoftware.info/organism-tagger)

As a second microservice, a Python based application offers access to language models:

* [Huggingface Bert-base-NER](https://huggingface.co/dslim/bert-base-NER) extracting people, locations and organizations
* [SciSpacy with the en_core_sci_sm model](https://github.com/allenai/scispacy) recognizing biomedical data. 

## Demo

A demonstration is available: https://semsearch.fmi.uni-jena.de/SA2.0/swagger-ui.html

## Prerequisites

### JDK 11
Install Adopt Open JDK 11 (https://adoptopenjdk.net/)

### Maven
Install Maven from [Maven](https://maven.apache.org/install.html "Download Maven")

### Python

Python version 3.9

### GATE pipelines

Please download the BiodivTagger and the OrganismTagger from Zenodo: [![DOI](https://zenodo.org/badge/DOI/10.5281/zenodo.7441627.svg)](https://doi.org/10.5281/zenodo.7441627).

The GATE ANNIE pipeline is default pipeline available in the [GATE framework](https://github.com/GateNLP).


## Installation and running

run below commands in order:


```cd SA2.0/nlp```

```mvn spring-boot:run```

## Get started
It takes a little time until the application starts.

This project contains a Swagger API platform.

http://localhost:8080/swagger-ui.html#/

## Settings

go to the:

src/main/resources/application.properties

set the Annie, BioTagger and OrganismTagger location on your system

# PythonAPI

For using the Huggingface service, you need to run this app.

## Prerequisites

### Anaconda

Install Anaconda from [Anaconda](https://docs.conda.io/projects/conda/en/latest/user-guide/install/index.html "Download Python")


## Installation and running

run blow commands in order:

```cd SA2.0/pythonAPI```

```python -m venv myenv```

```.\myenv\Scripts\activate```

Linux: ```source myenv/bin/activate```

```pip install -r requirements.txt```

```python main.py```

## Semantic Assistants

Further information on the first version of the Semantic Assistants framwork can be obtained from the website of the Semantic Software Lab: https://www.semanticsoftware.info/semantic-assistants-architecture

## Changelog

03.12.2022 initial release 0.1

## License
Semantic Assistants 2.0 is distributed under the terms of the GNU LGPL v3.0. (https://www.gnu.org/licenses/lgpl-3.0.en.html) 
