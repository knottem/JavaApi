# JavaApi

This is a simple Java project that uses the [FakeStoreApi](https://fakestoreapi.com) to get a list of products and the [OpenMeteoApi](https://open-meteo.com) to get the weather.
I just wrote it to get an idea of how to use the [Gson] library.

## Installation

Add a config.properties file to resources folder with the following content:

```properties
fakestoreapi.server = https://fakestoreapi.com/products/
weatherapi.server = https://api.open-meteo.com/v1/forecast?latitude=59.33&longitude=18.07&hourly=temperature_2m
```
or whichever server you want to use. The weather server is for stockholm.

## Dependencies
This code uses the following dependencies:
- [Gson](https://mvnrepository.com/artifact/com.google.code.gson/gson) - A Java library that can be used to convert Java Objects into their JSON representation. It can also be used to convert a JSON string to an equivalent Java object. Version 2.10.1
 
 
